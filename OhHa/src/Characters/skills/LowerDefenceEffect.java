package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class LowerDefenceEffect implements SkillEffect, ActionListener {
    private Timer timer;
    private int defence;
    private Character target;
    private BufferedImage effectGraphic;
    private boolean effectActive;
    
    public LowerDefenceEffect(String effectGraphicPath) {
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
        defence = target.getDefence();
        target.setDefence(1);
        this.effectActive = true;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        target.setDefence(defence);
        this.effectActive = false;
        timer.stop();
    }    
}

