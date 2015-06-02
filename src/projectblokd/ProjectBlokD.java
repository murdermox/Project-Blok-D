package projectblokd;

import javax.swing.JFrame;

public class ProjectBlokD {

    public static void main(String[] args) {
        JFrame main = new JFrame();
        main.setSize(525, 525);
        main.setTitle("Maze Game");
        
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
        main.add(new Level(main));
        main.setResizable(false);
        main.setVisible(true);
        
    }

}
