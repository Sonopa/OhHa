
package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import ohha.Game;

/**
 * A user interface for distributing experience points into attributes
 * @author 
 */
public class ExperiencePointsUI extends JPanel {
    private Game game;
    private JFrame frame;
    
    public ExperiencePointsUI(Game game) {
        this.game = game;  
    }
    
    public void make() {
        frame = new JFrame("Place your experience points");
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);        
        luoKomponentit(frame.getContentPane());
        frame.setUndecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);        
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);        
    }
    
    private void luoKomponentit(Container container) {
        frame.setLayout(new GridLayout(3,1));        
        JLabel points = new JLabel("Experience points left: " + game.getPlayer().getExperiencePoints(), SwingConstants.CENTER);        
        frame.add(points);
        points.setForeground(Color.GREEN);
        points.setOpaque(true);
        points.setBackground(Color.BLACK); 
        points.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
        JLabel strengthLabel = new JLabel("Strength:  " + game.getPlayer().getStrength());
        strengthLabel.setForeground(Color.GREEN);
        JButton plusStr = new JButton("+");
        plusStr.setForeground(Color.GREEN);
        plusStr.setBackground(Color.BLACK); 
        JLabel attackSpdLabel = new JLabel("Attack speed:  " + game.getPlayer().getAttackSpeed());
        attackSpdLabel.setForeground(Color.GREEN);
        JButton plusAttackSpeed = new JButton("+"); 
        plusAttackSpeed.setForeground(Color.GREEN);
        plusAttackSpeed.setBackground(Color.BLACK); 
        JLabel defenceLabel = new JLabel("Defence:  " + game.getPlayer().getDefence());
        defenceLabel.setForeground(Color.GREEN);
        JButton plusDefence = new JButton("+"); 
        plusDefence.setForeground(Color.GREEN);
        plusDefence.setBackground(Color.BLACK); 
        JLabel healthLabel = new JLabel("Max health:  " + game.getPlayer().getMaxHealth());
        healthLabel.setForeground(Color.GREEN);
        JButton plusHealth = new JButton("+");
        plusHealth.setForeground(Color.GREEN);
        plusHealth.setBackground(Color.BLACK); 
        frame.add(choosePoints(plusStr, plusAttackSpeed, plusDefence, plusHealth, strengthLabel, attackSpdLabel,
                defenceLabel, healthLabel));
        JButton jatka = new JButton("Continue");
        jatka.setForeground(Color.GREEN);
        jatka.setBackground(Color.BLACK); 
        jatka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
        frame.add(jatka);
        ExpUIListener kuuntelija = new ExpUIListener(game, plusStr, plusAttackSpeed, plusDefence, plusHealth, jatka, points, strengthLabel, attackSpdLabel,
                defenceLabel, healthLabel);
        plusStr.addActionListener(kuuntelija);
        plusAttackSpeed.addActionListener(kuuntelija);
        plusDefence.addActionListener(kuuntelija);
        plusHealth.addActionListener(kuuntelija);
        jatka.addActionListener(kuuntelija);
        if (game.getPlayer().getStrength() >= 30) {
                plusStr.setEnabled(false);
        }
        if (game.getPlayer().getDefence() >= 30) {
                plusDefence.setEnabled(false);
        }
        if (game.getPlayer().getAttackSpeed() >= 30) {
                plusAttackSpeed.setEnabled(false);
        }
        if (game.getPlayer().getMaxHealth() >= 5000) {
                plusHealth.setEnabled(false);
        }
    }
    
    private JPanel choosePoints(JButton str, JButton spd, JButton def, JButton hp, JLabel strL, JLabel spdL, JLabel defL,
            JLabel hpL) {
        JPanel panel = new JPanel(new GridLayout(4,2)); 
        panel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.GREEN));
        panel.setBackground(Color.BLACK);        
        panel.add(strL);
        panel.add(str);
        panel.add(spdL);
        panel.add(spd);
        panel.add(defL);
        panel.add(def);
        panel.add(hpL);
        panel.add(hp);
        return panel;
    }
    
    public void dispose() {
        if (frame != null) {
            frame.dispose();
        }
    }    
}
