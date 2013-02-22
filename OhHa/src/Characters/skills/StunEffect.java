
package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * A skilleffect that makes the target unable to hit or use skills for 4 seconds
 * @author 
 */
public class StunEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private Character target;
    private ImageIcon effectGraphic;
    private boolean effectActive;   
    private int effectNumber;
    
    public StunEffect(String effectGraphicPath) {
        effectActive = false;
        effectGraphic = new ImageIcon(this.getClass().getClassLoader().getResource(effectGraphicPath));  
        timer = new Timer(4000, this);
    }

    /**
     * Target is stunned, the stun timer is started and the effect is added to the target's debuff list
     * @param target 
     */
    @Override
    public void triggerEffect(Character target) {  
        this.target = target;       
        target.stun();
        target.addDebuff(this);
        effectNumber = target.getDebuffs().size()-1;
        effectActive = true;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        endEffect();
        removeFromList();
    }

    @Override
    public ImageIcon getEffectGraphic() {
        return this.effectGraphic;
    }

    @Override
    public boolean isActive() {
        return effectActive;
    }

    @Override
    public void endEffect() {
        target.unStun();        
        effectActive = false;
        timer.stop();
    }   
    
    @Override
    public void decreaseEffectNumber() {
        effectNumber--;
    }   

    @Override
    public String getType() {
        return "stun";
    }

    @Override
    public void removeFromList() {
        target.removeDebuff(effectNumber);
    }
}
