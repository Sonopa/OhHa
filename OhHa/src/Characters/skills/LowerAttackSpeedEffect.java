package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * A skilleffect that lowers target's attack speed to 1 for 6 seconds. 
 */
public class LowerAttackSpeedEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private int attackSpeed;
    private Character target;
    private ImageIcon effectGraphic;
    private boolean effectActive;
    private int effectNumber;
    
    public LowerAttackSpeedEffect(String effectGraphicPath) {
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

    /**
     * Set's target's attack speed to 1, starts the timer and add the debuff to target's debuff list
     * @param target 
     */
    @Override
    public void triggerEffect(Character target) {
        this.target = target;        
        attackSpeed = target.getAttackSpeed();
        target.setAttackSpeed(1);
        target.updateAttackSpeed();        
        target.addDebuff(this);
        effectNumber = target.getDebuffs().size()-1;
        this.effectActive = true;
        timer.start();
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
        target.setAttackSpeed(attackSpeed);
        target.updateAttackSpeed();    
        this.effectActive = false;
        timer.stop();
    }    

    @Override
    public String getType() {
        return "attackSpeed";
    }
    
    @Override
    public void removeFromList() {
        target.removeDebuff(effectNumber);
    }
}
