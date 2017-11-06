package projectblokd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import static projectblokd.Main.main;

public class Main extends JFrame {

    static ScoreBoard scoreBoard = new ScoreBoard(0);
    static JFrame main = new JFrame();
    static Level level = new Level(main);
    static LevelReader levelReader = new LevelReader();

    public static void main(String[] args) {
        createLevel(); 
        JOptionPane.showMessageDialog(null, "Welkom bij Mario Maze! \n\n"
                                            + "Wat is het doel van het spel?\n"
                                            + "Je speelt als Mario, je bent je broer Luigi kwijtgeraakt in een doolhof.\n"
                                            + "Zorg dat je in zo min mogelijk stappen bij Luigi terecht komt!\n\n"
                                            + "Hoe speel je dit spel: \n"
                                            + "Bewegen doe je met W A S D. \n\n"
                                            + "Je kan verschillende items oppakken:\n"
                                            + "De Bazooka: hiermee kan je muren kapot schiten als je op de spatiebalk drukt.\n"
                                            + "De Cheater: die zorgt ervoor dat het aantal stappen wat je hebt gezet verminderd wordt.\n"
                                            + "De Helper: de Helper laat het pad tot Luigi zien.\n"
                                            + "De Teleporter: die teleporteert je naar een random plek in de map, \n"
                                            + "het kan dus heel gunstig of juist heel slecht voor je aflopen. GEBRUIK OP EIGEN RISICO!\n"
                                            + "Om het spel te resetten druk je bovenin op de Reset-knop.\n\n"
                                            + "Veel speelplezier en succes! (Je kan dit venster afsluiten)");
    }
    
    public static void createLevel(){
        main.setLayout(new BorderLayout());
        main.setSize(506, 629);
        main.setTitle("Mario Maze");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
        scoreBoard.setPreferredSize(new Dimension(266, 100));
        scoreBoard.setBackground(Color.BLUE);
                      
        main.add(level, BorderLayout.CENTER);
        main.add(scoreBoard, BorderLayout.NORTH);

        main.setResizable(false);
        main.setVisible(true);
        level.requestFocus();
    }
}
