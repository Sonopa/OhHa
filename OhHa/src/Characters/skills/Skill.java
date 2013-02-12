
package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.Timer;
import UI.SkillButton;

/**
 * Represents a character's skill. When skill is used, a cooldowntimer is started and the skill's
 * effects are triggered. Skill is unusable again until the cooldowntimer has stopped. 
 */
public class Skill implements ActionListener {
    private String name;
    private int dmg;    
    private SkillEffect effect;
    private Timer cooldowntimer;
    private boolean used;
    private int healing;
    private BufferedImage skillIconUsed;  //taitojen ikonit UI:ta varten
    private BufferedImage skillIconUsable;
    private String tooltip;
    private JButton button;    
    
    public Skill(String name, int dmg, int healing, SkillEffect effect, int cooldown,
            String skillIconPathUsed, String skillIconPathUsable, String tooltip) {
        this.name = name;
        this.dmg = dmg;
        this.cooldowntimer = new Timer(cooldown, this);  
        this.used = false;
        this.effect = effect;
        this.healing = healing;
        try {
            skillIconUsed = ImageIO.read(new File(skillIconPathUsed));
        }catch (Exception e) {
            System.out.println("skillIconUsed ei löytynyt");
        }
        try {
            skillIconUsable = ImageIO.read(new File(skillIconPathUsable));
        }catch (Exception e) {
            System.out.println("skillIconUsable ei löytynyt");
        }
        this.tooltip = tooltip;
        this.button = new SkillButton(skillIconPathUsable);
        button.setToolTipText(tooltip);
    }   
    
    public BufferedImage getGraphic() {
        return this.effect.getEffectGraphic();
    }
    
    public BufferedImage getSkillIconUsed() {
        return skillIconUsed;
    }
    public BufferedImage getSkillIconUsable() {
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
