
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import ohha.Game;

public class SkillUIListener implements ActionListener {
    private Game game;
    private JButton skill1;
    private JButton skill2;
    private JButton skill3;
    private JButton skill4;
    private JButton skill5;
    private JButton skill6;
    private JButton skill7;
    private JButton skill8;
    private JButton skill9;
    private JButton skill10;
    private JButton contin;
    private JLabel points;
    
    public SkillUIListener(Game game, JButton skill1, JButton skill2, JButton skill3, JButton skill4, JButton skill5,
            JButton skill6, JButton skill7, JButton skill8, JButton skill9, JButton skill10, JButton contin, JLabel points) {
        this.skill1 = skill1;        
        this.skill2 = skill2;        
        this.skill3 = skill3;       
        this.skill4 = skill4;        
        this.skill5 = skill5;        
        this.skill6 = skill6;        
        this.skill7 = skill7;        
        this.skill8 = skill8;        
        this.skill9 = skill9;        
        this.skill10 = skill10;        
        this.contin = contin;
        this.game = game;
        this.points = points;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == skill1 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(0));    
            game.getPlayer().takeSkillPoints(1);
            skill1.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == skill2 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(1));  
            game.getPlayer().takeSkillPoints(1);
            skill2.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());            
        }
        else if (ae.getSource() == skill3 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(2)); 
            game.getPlayer().takeSkillPoints(1);
            skill3.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == skill4 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(3)); 
            game.getPlayer().takeSkillPoints(1);
            skill4.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == skill5 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(4)); 
            game.getPlayer().takeSkillPoints(1);
            skill5.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == skill6 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(5));   
            game.getPlayer().takeSkillPoints(1);
            skill6.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());            
        }
        else if (ae.getSource() == skill7 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(6));  
            game.getPlayer().takeSkillPoints(1);
            skill7.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == skill8 && game.getPlayer().getSkillPoints() >= 1) {
            game.getPlayer().addSkill(game.getSkills().get(7)); 
            game.getPlayer().takeSkillPoints(1);
            skill8.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == skill9 && game.getPlayer().getSkillPoints() >= 2) {
            game.getPlayer().addSkill(game.getSkills().get(8));  
            game.getPlayer().takeSkillPoints(2);
            skill9.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == skill10 && game.getPlayer().getSkillPoints() >= 2) {
            game.getPlayer().addSkill(game.getSkills().get(9)); 
            game.getPlayer().takeSkillPoints(2);
            skill10.setEnabled(false);
            points.setText("Skill points left: " + game.getPlayer().getSkillPoints());
        }
        else if (ae.getSource() == contin) {            
            game.nextLevel();
        }
    }
}
