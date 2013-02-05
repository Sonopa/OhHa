
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import ohha.Game;

public class ExpUIListener implements ActionListener {
    private Game game;
    private JButton plusStrength;
    private JButton plusAttackSpeed;
    private JButton plusDefence;
    private JButton plusMaxHealth;
    private JButton continu;
    private JLabel points;
    private JLabel strengthLabel;
    private JLabel attackSpeedLabel;
    private JLabel defenceLabel;
    private JLabel healthLabel;
    
    public ExpUIListener(Game peli, JButton plusStr, JButton plusAtckSpd, JButton plusDef, JButton plusHp, JButton jatka,
            JLabel points, JLabel strLabel, JLabel atckSpdLabel, JLabel defLabel, JLabel hpLabel) {
        this.game = peli;
        this.plusStrength = plusStr;
        this.plusAttackSpeed = plusAtckSpd;
        this.plusDefence = plusDef;
        this.plusMaxHealth = plusHp;   
        this.continu = jatka;
        this.points = points;
        this.strengthLabel = strLabel;
        this.attackSpeedLabel = atckSpdLabel;
        this.defenceLabel = defLabel;
        this.healthLabel = hpLabel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == plusStrength) {             
            game.getPlayer().upStrength();
            strengthLabel.setText("Strength: " + game.getPlayer().getStrength());
            points.setText("Experience points left: " + game.getPlayer().getExperiencePoints());
            if (game.getPlayer().getStrength() >= 30) {
                plusStrength.setEnabled(false);
            }
        }
        else if (ae.getSource() == plusAttackSpeed) {
            game.getPlayer().upAttackSpeed();            
            attackSpeedLabel.setText("Attack speed: " + game.getPlayer().getAttackSpeed());
            points.setText("Experience points left: " + game.getPlayer().getExperiencePoints());
            if (game.getPlayer().getAttackSpeed() >= 30) {
                plusAttackSpeed.setEnabled(false);
            }
        }
        else if (ae.getSource() == plusDefence) {
            game.getPlayer().upDefence();
            defenceLabel.setText("Defence: " + game.getPlayer().getDefence());
            points.setText("Experience points left: " + game.getPlayer().getExperiencePoints());
            if (game.getPlayer().getDefence() >= 30) {
                plusDefence.setEnabled(false);
            }
        }
        else if (ae.getSource() == plusMaxHealth) {
            game.getPlayer().upMaxHealth();            
            healthLabel.setText("Maximum health: " + game.getPlayer().getMaxHealth());
            points.setText("Experience points left: " + game.getPlayer().getExperiencePoints());
            if (game.getPlayer().getMaxHealth() >= 6000) {
                plusMaxHealth.setEnabled(false);
            }
        }
        else if (ae.getSource() == continu) {
            if (game.getLevel()%2 == 1) {
                game.nextLevel();
            }else {
                game.skillUI();
            }
        }
    }    
}
