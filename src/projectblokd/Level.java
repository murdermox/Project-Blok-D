package projectblokd;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class Level extends JPanel {

    public static int level = 1;
    private LevelReader lr = new LevelReader();
    private JFrame main;
    public int staps;
    private int lengte = lr.getLengte();
    private int breedte = lr.getBreedte();
    public static int bullet = 0;
    private String richting;
    private Speler p;
    private boolean path[][] = new boolean[lengte][breedte];
    private boolean einde = false;
    private boolean isKortstePad[][] = new boolean[lengte][breedte];

    public Level(JFrame main) {
        this.main = main;
        addKeyListener(new PlayerListener());
        setFocusable(true);
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < lengte; i++) {
            for (int j = 0; j < breedte; j++) {
                String item;
                item = lr.getItem(j, i);
                if (item.equals("w")) {
                    Muur w = new Muur(j, i);
                    g.drawImage(w.setImage(), j * 20, i * 20, this);
                } else if (item.equals("x")) {
                    Pad p = new Pad(j, i);
                    g.drawImage(p.setImage(), j * 20, i * 20, this);
                } else if (item.equals("h")) {
                    Helper h = new Helper(j, i);
                    g.drawImage(h.setImage(), j * 20, i * 20, this);
                } else if (item.equals("b")) {
                    Bazooka b = new Bazooka(j, i);
                    g.drawImage(b.setImage(), j * 20, i * 20, this);
                } else if (item.equals("p")) {
                    p = new Speler(j, i);
                    g.drawImage(p.setImage(), j * 20, i * 20, this);
                } else if (item.equals("c")) {
                    Cheater c = new Cheater(j, i);
                    g.drawImage(c.setImage(), j * 20, i * 20, this);
                } else if (item.equals("v")) {
                    Vriend v = new Vriend(j, i);
                    g.drawImage(v.setImage(), j * 20, i * 20, this);
                } else if (item.equals("z")) {
                    HelperPad hp = new HelperPad(j, i);
                    g.drawImage(hp.setImage(), j * 20, i * 20, this);
                } else if (item.equals("t")) {
                    Teleporter t = new Teleporter(j, i);
                    g.drawImage(t.setImage(), j * 20, i * 20, this);
                }
            }
        }
    }

    public void newLevel() {
        lr.setLevel(level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBullet() {
        return bullet;
    }

    class PlayerListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int oldX = p.getX();
            int oldY = p.getY();
            int x = oldX;
            int y = oldY;

            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    y -= 1;
                    richting = "noord";
                    break;
                case KeyEvent.VK_D:
                    x += 1;
                    richting = "oost";
                    break;
                case KeyEvent.VK_A:
                    x -= 1;
                    richting = "west";
                    break;
                case KeyEvent.VK_S:
                    y += 1;
                    richting = "zuid";
                    break;
                case KeyEvent.VK_SPACE:
                    if (bullet > 0) {
                        fireBullet();
                        moveBullet(richting);
                    } else {
                        JOptionPane.showMessageDialog(null, "U heeft geen kogels meer!");
                    }
                    break;
            }

            String i = lr.getItem(x, y);
            if (!i.equals("w")) {
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_D) {
                    staps += 1;
                }
                switch (richting) {
                    case "noord":
                        p.setY(y - 1);
                        break;
                    case "oost":
                        p.setX(x + 1);
                        break;
                    case "west":
                        p.setX(x - 1);
                        break;
                    case "zuid":
                        p.setY(y + 1);
                        break;
                }
                lr.updateMaze(x, y, oldX, oldY);
                main.repaint();
            }
            if (i.equals("v")) {
                staps = 0;
                Main.scoreBoard.setSteps(staps);
                level += 1;
                int levelString = level - 1;
                newLevel();
                resetHelper();
                JOptionPane.showMessageDialog(null, "Gefeliciteerd, Je hebt level " + levelString + " uitgespeeld!");
            }
            if (i.equals("c")) {
                cheaterStappen();
            }
            if (i.equals("b")) {
                addBullet();
                JOptionPane.showMessageDialog(null, "Je hebt een bazooka opgepakt, je hebt " + bullet + " kogels!");
                int positieX = p.getX();
                int positieY = p.getY();
                p = new Speler(positieX, positieY);
            }
            if (i.equals("h")) {
                findPath(x, y);
                JOptionPane.showMessageDialog(null, "Je hebt een helper opgepakt! De helper wijst je de weg naar je vriend!");
            }
            if (i.equals("t")) {
                teleport();
                JOptionPane.showMessageDialog(null, "Je bent geteleporteerd naar een random plek!");
            }
            Main.scoreBoard.setSteps(staps);
        }
    }

    public void cheaterStappen() {
        Random rand = new Random();
        int random = rand.nextInt(30) + 1;
        if ((staps - random) > 0) {
            staps = staps - random;
            JOptionPane.showMessageDialog(null, "Je hebt een cheater opgepakt, er zijn " + random + " stappen afgegaan!");
        } else {
            staps = 0;
        }
    }

    public void addBullet() {
        bullet += 2;
    }

    public void fireBullet() {
        bullet--;
    }

    private void moveBullet(String richting) {
        if (bullet == 0) {
            int positieX = p.getX();
            int positieY = p.getY();
            p = new Speler(positieX, positieY);
        }
        int x = p.getX();
        int y = p.getY();
        String i = lr.getItem(x, y);

        if (richting.equals("noord")) {
            for (int j = 0; j < 5; j++) {

                if (i.equals("x") || i.equals("v") || i.equals("h") || i.equals("c") || i.equals("b") || i.equals("t") || i.equals("p")) {
                    y--;
                }
                i = lr.getItem(x, y);
            }
            if (i.equals("w")) {
                if (x == 0 || y == 0 || x == 24 || y == 24) {
                    return;
                } else {
                    lr.setPad(x, y);
                    lr.repaint();
                }
            }
        }
        if (richting.equals("zuid")) {
            for (int j = 0; j < 5; j++) {

                if (i.equals("x") || i.equals("v") || i.equals("h") || i.equals("c") || i.equals("b") || i.equals("t") || i.equals("p")) {
                    y++;
                }
                i = lr.getItem(x, y);
            }
            if (i.equals("w")) {
                if (x == 0 || y == 0 || x == 24 || y == 24) {
                    return;
                } else {
                    lr.setPad(x, y);
                    lr.repaint();
                }
            }
        }

        if (richting.equals("oost")) {
            for (int j = 0; j < 5; j++) {

                if (i.equals("x") || i.equals("v") || i.equals("h") || i.equals("c") || i.equals("b") || i.equals("t") || i.equals("p")) {
                    x++;
                }
                i = lr.getItem(x, y);
            }
            if (i.equals("w")) {
                if (x == 0 || y == 0 || x == 24 || y == 24) {
                    return;
                } else {
                    lr.setPad(x, y);
                    lr.repaint();
                }
            }
        }
        if (richting.equals("west")) {
            for (int j = 0; j < 5; j++) {

                if (i.equals("x") || i.equals("v") || i.equals("h") || i.equals("c") || i.equals("b") || i.equals("t") || i.equals("p")) {
                    x--;
                }
                i = lr.getItem(x, y);
            }
            if (i.equals("w")) {
                if (x == 0 || y == 0 || x == lengte - 1 || y == breedte - 1) {
                    return;
                } else {
                    lr.setPad(x, y);
                    lr.repaint();
                }
            }
        }
    }

    public void findPath(int x, int y) {
        int q = p.getX();
        int w = p.getY();
        while (!einde) {
            if (lr.getItem(x, y).equals("v")) {
                einde = true;
                return;
            }
            if (lr.getItem(x, y).equals("w")) {
                isKortstePad[x][y] = false;
                return;
            }
            if (path[x][y]) {
                isKortstePad[x][y] = false;
                return;
            }

            path[x][y] = true;
            isKortstePad[x][y] = true;

            findPath(x + 1, y);
            findPath(x, y + 1);

            findPath(x - 1, y);
            findPath(x, y - 1);

            isKortstePad[x][y] = true;
        }
        if (isKortstePad[x][y]) {
            lr.setHelpPad(x, y);
        }
        
        switch (richting) {
            case "noord":
                lr.setSpeler(q, w + 1);
                break;
            case "oost":
                lr.setSpeler(q - 1, w);
                break;
            case "west":
                lr.setSpeler(q + 1, w);
                break;
            case "zuid":
                lr.setSpeler(q, w - 1);
                break;
        }
                
    }

    public void resetHelper() {
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 25; x++) {
                isKortstePad[x][y] = false;
                path[x][y] = false;
            }
        }
        einde = false;
    }

    public void teleport() {
        int oldX = p.getX();
        int oldY = p.getY();
        Random rand = new Random();
        int x = rand.nextInt(24);
        int y = rand.nextInt(24);
        String i = lr.getItem(x, y);

        if (i.equals("w") || i.equals("v") || i.equals("b") || i.equals("c") || i.equals("h")) {
            teleport();
        } else {
            if (richting.equals("noord")) {
                lr.updateMaze(x, y, oldX, oldY + 1);
                p = new Speler(x, y);
                main.repaint();
            } else if (richting.equals("oost")) {
                lr.updateMaze(x, y, oldX - 1, oldY);
                p = new Speler(x, y);
                main.repaint();
            } else if (richting.equals("zuid")) {
                lr.updateMaze(x, y, oldX, oldY - 1);
                p = new Speler(x, y);
                main.repaint();
            } else if (richting.equals("west")) {
                lr.updateMaze(x, y, oldX + 1, oldY);
                p = new Speler(x, y);
                main.repaint();
            }
        }
    }
}