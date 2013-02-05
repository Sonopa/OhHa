
package Characters.skills;
import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;
/**
 * A skilleffect that heals the user for 400 every 4 seconds for 12 seconds
 * @author 
 */
public class HealOverTimeEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private Character target;    
    private BufferedImage effectGraphic;
    private boolean effectActive;
    private int tickCount;    
    private int effectNumber;
    
    public HealOverTimeEffect(String effectGraphicPath) {
        this.tickCount = 0;
        timer = new Timer(4000, this);
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
        tickCount++;
        this.target = target;
        target.getTarget().addBuff(this);   
        if (tickCount == 1) {            
            effectNumber = target.getTarget().getBuffs().size()-1;
        }
        this.effectActive = true;
        timer.start();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        target.getTarget().gainHealth(400);
        tickCount++;  
        if (tickCount == 3) {            
            target.getTarget().removeBuff(effectNumber);            
            endEffect();   
        }
    }

    @Override
    public void endEffect() {        
        this.effectActive = false;
        tickCount = 0;
        timer.stop();
    }
    
    @Override
    public void decreaseEffectNumber() {
        effectNumber--;
    }    
}
