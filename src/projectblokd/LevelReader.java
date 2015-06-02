package projectblokd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LevelReader extends JPanel {

    Speler p;

    private String[][] maze = new String[][]{
        {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
        {"w", "b", "w", "w", "x", "x", "x", "x", "w", "w", "w", "p", "w"},
        {"w", "x", "w", "w", "x", "w", "w", "x", "x", "x", "w", "x", "w"},
        {"w", "x", "w", "w", "x", "h", "w", "w", "w", "x", "w", "x", "w"},
        {"w", "x", "x", "x", "w", "w", "w", "x", "w", "x", "x", "x", "w"},
        {"w", "x", "w", "x", "x", "x", "x", "x", "x", "x", "w", "x", "w"},
        {"w", "x", "w", "w", "w", "w", "w", "w", "w", "x", "w", "x", "w"},
        {"w", "x", "w", "w", "x", "x", "x", "x", "w", "x", "w", "x", "w"},
        {"w", "x", "w", "w", "x", "w", "w", "x", "w", "x", "w", "x", "w"},
        {"w", "x", "w", "c", "x", "w", "w", "x", "w", "x", "w", "x", "w"},
        {"w", "x", "w", "w", "x", "w", "w", "x", "w", "x", "w", "x", "w"},
        {"w", "x", "x", "x", "x", "x", "w", "x", "w", "x", "x", "x", "w"},
        {"w", "w", "w", "w", "w", "w", "w", "v", "w", "w", "w", "w", "w"},};

    private Item[][] mazeObjects;

    public LevelReader() {
        mazeObjects = new Item[13][13];

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (maze[j][i].equals("w")) {
                    Muur w = new Muur(j, i);
                    mazeObjects[j][i] = w;
                } else if (maze[j][i].equals("x")) {
                    Pad p = new Pad(j, i);
                    mazeObjects[j][i] = p;
                } else if (maze[j][i].equals("h")) {
                    Helper h = new Helper(j, i);
                    mazeObjects[j][i] = h;
                } else if (maze[j][i].equals("b")) {
                    Bazooka b = new Bazooka(j, i);
                    mazeObjects[j][i] = b;
                } else if (maze[j][i].equals("p")) {
                    p = new Speler(j, i);
                    mazeObjects[j][i] = p;
                } else if (maze[j][i].equals("c")) {
                    Cheater c = new Cheater(j, i);
                    mazeObjects[j][i] = c;
                } else if (maze[j][i].equals("v")) {
                    Vriend v = new Vriend(j, i);
                    mazeObjects[j][i] = v;
                }
            }
        }
    }

    public Item[][] getMazeObjects() {
        return mazeObjects;
    }

    public Item getItem(int x, int y) {
        return mazeObjects[x][y];
    }

    public void updateMaze(int x, int y, int oldX, int oldY) {
        mazeObjects[x][y] = p;
        mazeObjects[oldX][oldY] = new Pad(oldX, oldY);
    }

    public Speler getPlayer() {
        return p;
    }
}
