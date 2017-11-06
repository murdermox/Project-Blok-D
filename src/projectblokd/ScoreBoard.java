package projectblokd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ScoreBoard extends JPanel {

    private JTextField score = new JTextField();
    private int steps = 0;

    public ScoreBoard(int steps) {
        this.steps = steps;
        createComponents();
    }

    public void createComponents() {
        setSize(525, 100);
        this.setFocusable(false);
        JButton button = new JButton("Reset Level");
        button.addActionListener(new ButtonListener());
        score.setColumns(10);
        score.setText("" + steps);
        score.setEditable(false);
        score.setFocusable(false);
        add(button);
        add(score);
    }

    public void setSteps(int steps) {
        this.steps = steps;
        createComponents();
    }

    public void resetLevel() {
        steps = 0;
        Level.bullet = 0;
        Main.main.remove(Main.level);
        Main.main.remove(Main.scoreBoard);
        Main.main.dispose();
        Main.scoreBoard = new ScoreBoard(0);
        Main.level = new Level(Main.main);
        Main.level.newLevel();
        Main.createLevel();
    }    
    
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resetLevel(); 
        }
    }
}
