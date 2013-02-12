package Characters.skills;
import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;
/**
 * A skilleffect that deals 200 damage every 2 seconds for 8 seconds 
 */
public class DamageOverTimeEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private Character target;    
    private BufferedImage effectGraphic;
    private boolean effectActive;
    private int tickCount;
    private int effectNumber;
    
    public DamageOverTimeEffect(String effectGraphicPath) {
        this.tickCount = 0;
        timer = new Timer(2000, this);
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
        target.addDebuff(this);
        if (tickCount == 0) {
            effectNumber = target.getDebuffs().size()-1;
        }
        this.effectActive = true;
        timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        target.takeDamage(200);
        tickCount++;
        System.out.println(tickCount);
        if (tickCount == 4) { 
            endEffect();   
            removeFromList();
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

    @Override
    public String getType() {
        return "dot";
    }
    
    @Override
    public void removeFromList() {
        target.removeDebuff(effectNumber);   
    }
}
