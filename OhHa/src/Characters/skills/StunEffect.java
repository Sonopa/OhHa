
package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class StunEffect implements SkillEffect, ActionListener {
    private Timer timer; //ajastin efektin pituudelle
    private Character target;
    private BufferedImage effectGraphic;
    private boolean effectActive;
    
    public StunEffect(String effectGraphicPath) {
        effectActive = false;
        try {
            effectGraphic = ImageIO.read(new File(effectGraphicPath));
        }catch (Exception e) {
            System.out.println("efektiä ei löytynyt");
        }
    }

    @Override
    public void triggerEffect(Character target) {
        this.target = target;        
        Double time = (1.0-(2.0*target.getDefence())/100.0)*3000; //defencellä vaikutusta efektin pituuteen
        timer = new Timer(time.intValue(), this);
        target.stun();
        effectActive = true;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        target.unStun();
        effectActive = false;
        timer.stop();
    }

    @Override
    public BufferedImage getEffectGraphic() {
        return this.effectGraphic;
    }

    @Override
    public boolean isActive() {
        return effectActive;
    }
}
