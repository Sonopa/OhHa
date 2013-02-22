package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * A skilleffect that doubles the users defence for 5 seconds. 
 */
public class IncreaseDefenceEffect implements SkillEffect, ActionListener {
    private Timer timer;    
    private Character target;
    private int defence;
    private ImageIcon effectGraphic;
    private boolean effectActive;
    private int effectNumber;
    
    public IncreaseDefenceEffect(String effectGraphicPath) {
        timer = new Timer(6000, this);
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

    @Override
    public void triggerEffect(Character target) {
        this.target = target;
        boolean defenceEffectActive = false;
        for (SkillEffect effect : target.getTarget().getDebuffs()) {
            if (effect.getType().equals(this.getType())) {
                defenceEffectActive = true;
            }
        }
        if (target.isBlocking()) {
            defenceEffectActive = true;
        }
        if (!defenceEffectActive) {
            defence = target.getTarget().getDefence();        
            target.getTarget().setDefence(defence*2);
            target.getTarget().addBuff(this);
            effectNumber = target.getTarget().getBuffs().size()-1;        
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
    public void endEffect() {
        target.getTarget().setDefence(defence);        
        this.effectActive = false;
        timer.stop();
    }    
    
    @Override
    public void decreaseEffectNumber() {
        effectNumber--;
    }

    @Override
    public String getType() {
        return "defence";
    }
    
    @Override
    public void removeFromList() {
        target.getTarget().removeBuff(effectNumber);
    }
}
