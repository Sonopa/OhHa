package Characters.skills;
import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class HealOverTimeEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private Character target;
    private BufferedImage effectGraphic;
    private boolean effectActive;
    private int tickCount;
    
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
        this.effectActive = true;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        target.getTarget().gainHealth(400);
        tickCount++;        
        if(tickCount == 3) {
            this.effectActive = false;
            timer.stop();
        }
    }   
}
