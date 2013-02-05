
package UI;

import Characters.Player;
import Characters.skills.Skill;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import ohha.Game;

/**
 * A user interface for choosing skills.
 * @author Mertaset
 */
public class SkillUI extends JPanel {    
    private JFrame frame;
    private ArrayList<Skill> skills;
    private Game game;
    
    public SkillUI (ArrayList<Skill> skills, Game game) {
        this.skills = skills;
        this.game = game;
    }
    
    public void make() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 120));
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
        JLabel points = new JLabel("Skill points left: " + game.getPlayer().getSkillPoints(), SwingConstants.CENTER);
        points.setOpaque(true);
        points.setBackground(Color.BLACK);
        points.setForeground(Color.GREEN);
        points.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
        frame.add(points);
        JButton skill1 = skills.get(0).getButton();
        JButton skill2 = skills.get(1).getButton();
        JButton skill3 = skills.get(2).getButton();
        JButton skill4 = skills.get(3).getButton();
        JButton skill5 = skills.get(4).getButton();
        JButton skill6 = skills.get(5).getButton();
        JButton skill7 = skills.get(6).getButton();
        JButton skill8 = skills.get(7).getButton();
        JButton skill9 = skills.get(8).getButton();
        JButton skill10 = skills.get(9).getButton();
        frame.add(SkillList(skills, skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9,
                skill10));
        JButton contin = new JButton("Continue");
        contin.setBackground(Color.BLACK);
        contin.setForeground(Color.GREEN);
        contin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));        
        frame.add(contin);
        SkillUIListener listener = new SkillUIListener(game, skill1, skill2, skill3, skill4, skill5, 
                skill6, skill7, skill8, skill9, skill10, contin, points);
        skill1.addActionListener(listener);
        skill2.addActionListener(listener);
        skill3.addActionListener(listener);
        skill4.addActionListener(listener);
        skill5.addActionListener(listener);
        skill6.addActionListener(listener);
        skill7.addActionListener(listener);
        skill8.addActionListener(listener);
        skill9.addActionListener(listener);
        skill10.addActionListener(listener);
        contin.addActionListener(listener);
    }
    
    private JPanel SkillList(ArrayList<Skill> skills, JButton skill1, JButton skill2, JButton skill3,
            JButton skill4, JButton skill5, JButton skill6, JButton skill7, JButton skill8, JButton skill9,
            JButton skill10) {
        JPanel panel = new JPanel(new GridLayout(1,10)); 
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.GREEN));
        panel.add(skill1);
        panel.add(skill2);
        panel.add(skill3);
        panel.add(skill4);
        panel.add(skill5);
        panel.add(skill6);
        panel.add(skill7);
        panel.add(skill8);
        panel.add(skill9);
        panel.add(skill10);        
        return panel;
    }    
    
    public void dispose() {
        if (frame != null) {
            frame.dispose();
        }
    }
}
