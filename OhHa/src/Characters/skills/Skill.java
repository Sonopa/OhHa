
package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import UI.SkillButton;
import javax.swing.ImageIcon;

/**
 * Represents a character's skill. When skill is used, a cooldowntimer is started and the skill's
 * effects are triggered. Skill is unusable again until the cooldowntimer has stopped. 
 */
public class Skill implements ActionListener {
    private String name;
    /**
     * Amount of damage the skill deal to the target
     */
    private int dmg;
    /**
     * The main effect for the skill
     */
    private SkillEffect effect;    
    private Timer cooldowntimer;
    private boolean used;
    /**
     * Amount that the user is healed when the skill is used
     */
    private int healing;
    private ImageIcon skillIconUsed;  //taitojen ikonit UI:ta varten
    private ImageIcon skillIconUsable;
    /**
     * A description of the skill for the SkillUI
     */
    private String tooltip;
    /*
     * SkillButton for SkillUI
     */
    private JButton button;    
    
    public Skill(String name, int dmg, int healing, SkillEffect effect, int cooldown,
            String skillIconPathUsed, String skillIconPathUsable, String tooltip) {
        this.name = name;
        this.dmg = dmg;
        this.cooldowntimer = new Timer(cooldown, this);  
        this.used = false;
        this.effect = effect;
        this.healing = healing;        
        skillIconUsed = new ImageIcon(this.getClass().getClassLoader().getResource(skillIconPathUsed));        
        skillIconUsable = new ImageIcon(this.getClass().getClassLoader().getResource(skillIconPathUsable));        
        this.tooltip = tooltip;
        this.button = new SkillButton(skillIconPathUsable);
        button.setToolTipText(tooltip);
    }   
    
    public ImageIcon getGraphic() {
        return this.effect.getEffectGraphic();
    }
    
    public ImageIcon getSkillIconUsed() {
        return skillIconUsed;
    }
    public ImageIcon getSkillIconUsable() {
        return skillIconUsable;
    }
    
    public int getDmg() {
        return this.dmg;
    }
        
    public SkillEffect getEffect() {
        return this.effect;
    }
    
    /**
     * If skill is usable, effects are triggered and cooldowntimer is started 
     * @param user
     * @param target 
     */
    public void use(Character user, Character target) {
        if (used==false) {
            used = true;
            target.takeDamage(dmg);
            user.gainHealth(healing);
            effect.triggerEffect(target);
            cooldowntimer.start();
        }
    }
    
    public boolean isUsed() {
        return used;
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        used = false;
        cooldowntimer.stop();
    }   
    
    public String getName() {
        return this.name;
    }
    
    public JButton getButton() {
        return this.button;
    }
}
