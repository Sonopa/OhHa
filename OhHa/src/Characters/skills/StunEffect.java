
package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 * A skilleffect that makes the target unable to hit or use skills for 4 seconds
 * @author 
 */
public class StunEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private Character target;
    private BufferedImage effectGraphic;
    private boolean effectActive;   
    private int effectNumber;
    
    public StunEffect(String effectGraphicPath) {
        effectActive = false;
        try {
            effectGraphic = ImageIO.read(new File(effectGraphicPath));
        }catch (Exception e) {
            System.out.println("efektiä ei löytynyt");
        }
        Double time = (1.0-(2.0*target.getDefence())/100.0)*4000;
        timer = new Timer(time.intValue(), this);
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
        target.removeDebuff(effectNumber);
    }

    @Override
    public BufferedImage getEffectGraphic() {
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
}
