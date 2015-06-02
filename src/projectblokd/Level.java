package projectblokd;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Level extends JPanel {

    private LevelReader m = new LevelReader();
    private JFrame main;
    
    public Level(JFrame main) {
        this.main = main;
        addKeyListener(new PlayerListener());
        setFocusable(true);
    }
    
    public void paintComponent(Graphics g) {
       Item[][] maze = m.getMazeObjects();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
               g.setColor(maze[j][i].getColor());
               g.fillRect(maze[j][i].getX() * 40, maze[j][i].getY() * 40, 40, 40);
            }
        }
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
            Speler p = m.getPlayer();
            int oldX = p.getX();
            int oldY = p.getY();
            int x = oldX;
            int y = oldY;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    y -= 1;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 1;
                    break;
                case KeyEvent.VK_LEFT:
                    x -= 1;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 1;
                    break;
            }
            Item i = m.getItem(x, y);
            System.out.println(i);
            if (!(i instanceof Muur)) {
                i.setX(oldX);
                i.setY(oldY);
                p.setX(x);
                p.setY(y);
                main.repaint();
                m.updateMaze(x, y, oldX, oldY);
            }
        }       
    }
}