
package Characters.skills;

import Characters.Character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Skill implements ActionListener {
    private String name;
    private int dmg;    
    private SkillEffect effect;
    private Timer cooldowntimer;
    private boolean used;
    private int healing;
    private BufferedImage skillIconUsed;    //taitojen ikonit UI:ta varten
    private BufferedImage skillIconUsable;
    
    public Skill(String name, int dmg, int healing, SkillEffect effect, int cooldown,
            String skillIconPathUsed, String skillIconPathUsable) {
        this.name = name;
        this.dmg = dmg;
        this.cooldowntimer = new Timer(cooldown, this);  
        this.used = false;
        this.effect = effect;
        this.healing = healing;
        try {
            skillIconUsed = ImageIO.read(new File(skillIconPathUsed));
        }catch (Exception e) {
            System.out.println("skillIconUsed ei löytynyt");
        }
        try {
            skillIconUsable = ImageIO.read(new File(skillIconPathUsable));
        }catch (Exception e) {
            System.out.println("skillIconUsable ei löytynyt");
        }        
    }
    
    public BufferedImage getGraphic() {
        return this.effect.getEffectGraphic();
    }
    
    public BufferedImage getSkillIconUsed() {
        return skillIconUsed;
    }
    public BufferedImage getSkillIconUsable() {
        return skillIconUsable;
    }
    
    public int getDmg() {
        return this.dmg;
    }
        
    public SkillEffect getEffect() {
        return this.effect;
    }
    
    public void use(Character user, Character target) {
        if (used==false) {
            used = true;
            target.takeDamage(dmg);
            user.gainHealth(healing);
            effect.triggerEffect(target);
            cooldowntimer.start();
        }
    }
    
    public boolean isUsed() {
        return used;
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        used = false;
        cooldowntimer.stop();
    }   
    
    public String getName() {
        return this.name;
    }
}
