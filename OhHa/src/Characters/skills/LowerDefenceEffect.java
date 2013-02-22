package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * A skilleffect that lowers target's defence to 1 for 5 seconds. If another defence altering effect
 * is already active on the target, does not trigger effect
 */
public class LowerDefenceEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private int defence;
    private Character target;
    private ImageIcon effectGraphic;
    private boolean effectActive;    
    private int effectNumber;
    
    public LowerDefenceEffect(String effectGraphicPath) {
        timer = new Timer(5000, this);
        effectActive = false;
        effectGraphic = new ImageIcon(this.getClass().getClassLoader().getResource(effectGraphicPath));         
    }
    
    @Override
    public boolean isActive() {
        return effectActive;
    }
    
    @Override
    public ImageIcon getEffectGraphic() {
        return this.effectGraphic;
    }

    /**
     * Set's target's defence to 1, starts the timer and add the debuff to target's debuff list
     * @param target 
     */
    @Override
    public void triggerEffect(Character target) {
        this.target = target;
        boolean defenceEffectActive = false;
        for (SkillEffect effect : target.getBuffs()) {
            if (effect.getType().equals(this.getType())) {
                defenceEffectActive = true;
            }
        }
        if (target.isBlocking()) {
            defenceEffectActive = true;
        }
        if (!defenceEffectActive) {
            defence = target.getDefence();
            target.setDefence(1);
            target.addDebuff(this);
            effectNumber = target.getDebuffs().size()-1;
            this.effectActive = true;
            timer.start();
        }        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        endEffect();
        removeFromList();
    }    
    
    @Override
    public void decreaseEffectNumber() {
        effectNumber--;
    }

    @Override
    public void endEffect() {
        target.setDefence(defence);        
        this.effectActive = false;
        timer.stop();
    }    

    @Override
    public String getType() {
        return "defence";
    }
    
    @Override
    public void removeFromList() {
        target.removeDebuff(effectNumber);
    }
}

