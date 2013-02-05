package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 * A skilleffect that doubles the users defence for 5 seconds
 * @author 
 */
public class IncreaseDefence implements SkillEffect, ActionListener {
    private Timer timer;    
    private Character target;
    private int defence;
    private BufferedImage effectGraphic;
    private boolean effectActive;    
    private int effectNumber;
    
    public IncreaseDefence(String effectGraphicPath) {
        timer = new Timer(5000, this);
        effectActive = false;
        try {
            effectGraphic = ImageIO.read(new File(effectGraphicPath));
        }catch (Exception e) {
            System.out.println("efektiä ei löytynyt");
        }
    }
    
    @Override
    public boolean isActive() {
        return effectActive;
    }
    
    @Override
    public BufferedImage getEffectGraphic() {
        return this.effectGraphic;
    }

    @Override
    public void triggerEffect(Character target) {   
        this.target = target;
        defence = target.getTarget().getDefence();        
        target.getTarget().setDefence(defence*2);
        target.getTarget().addBuff(this);
        effectNumber = target.getTarget().getBuffs().size()-1;        
        this.effectActive = true;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {        
        target.getTarget().removeBuff(effectNumber);
        endEffect();
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
}
