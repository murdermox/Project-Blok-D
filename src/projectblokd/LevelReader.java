package projectblokd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class LevelReader extends JPanel {

    Speler p;
    private int lengte = 25;
    private int breedte = 25;
    private String[][] maze = new String[lengte][breedte];
    private Scanner in;
    private int level = 1;
    private String levelString;
    private ImageIcon image = new ImageIcon(this.getClass().getResource("endscreen.jpg"));

    public LevelReader() {
        getLevel(level);
    }

    public void readLevel(String levelString) {
        try {
            in = new Scanner(new File(levelString));
            readFile();
            closeFile();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void getLevel(int level) {
        if (level == 1) {
            levelString = "src\\resources\\txt\\Level1.txt";
            readLevel(levelString);
        } else if (level == 2) {
            levelString = "src\\resources\\txt\\Level2.txt";
            readLevel(levelString);
        } else if (level == 3) {
            levelString = "src\\resources\\txt\\Level3.txt";
            readLevel(levelString);
        } else if (level == 4) {
            displayEnd();
        }
    }

    public void displayEnd() {
        JFrame end = new JFrame();
        end.setSize(506, 629);
        end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        end.setLocationRelativeTo(null);
        JLabel label = new JLabel(image);
        end.add(label);
        end.setResizable(false);
        end.setVisible(true);
    }

    public void setLevel(int level) {
        this.level = level;
        getLevel(level);
    }

    public String getItem(int x, int y) {
        return maze[x][y];
    }

    public void setPad(int x, int y) {
        maze[x][y] = "x";
    }
    
    public int getBreedte(){
        return breedte;
    }
    
    public int getLengte(){
        return lengte;
    }

    public void updateMaze(int x, int y, int oldX, int oldY) {
        maze[oldX][oldY] = "x";
        maze[x][y] = "p";
    }
    
    public void readFile() {
        for (int i = 0; i < lengte; i++) {
            String mapRij = in.next();
            for (int j = 0; j < breedte; j++) {
                String item = mapRij.substring(j, j + 1);
                maze[j][i] = item;
            }
        }
    }

    public void closeFile() {
        in.close();
    }

    public String[][] getMaze() {
        return maze;
    }

    public void setHelper(int x, int y) {
        maze[x][y] = "h";
    }

    public void setHelpPad(int x, int y) {
        maze[x][y] = "z";
    }
    
    public void setSpeler(int x, int y){
        maze[x][y] = "p";
    }
}
