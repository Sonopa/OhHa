
package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 * A skilleffect that stun the target for 1 second and permanenlty decreases the target's 
 * max health by 200 and strength by 2.
 * 
 */
public class DecreaseStrengthAndHealth implements ActionListener, SkillEffect {
    private BufferedImage effectGraphic;
    private Timer timer;
    private boolean effectActive;
    private int effectNumber;
    private Character target;
    
    public DecreaseStrengthAndHealth(String effectGraphicPath) {
        effectActive = false;
        try {
            effectGraphic = ImageIO.read(new File(effectGraphicPath));
        }catch (Exception e) {
            System.out.println("efektiä ei löytynyt");
        }
        this.timer = new Timer(1000, this);
    }    

    @Override
    public void triggerEffect(Character target) {
        this.target = target;
        target.setMaxHealth(target.getMaxHealth()-200);
        if (target.getHealth() > target.getMaxHealth()) {
            target.healthToFull();
        }
        target.setStrength(target.getStrength()-2);
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
    public BufferedImage getEffectGraphic() {
        return effectGraphic;
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
        return "stun, strength and health";
    }

    @Override
    public void removeFromList() {
        target.removeDebuff(effectNumber);
    }
}
