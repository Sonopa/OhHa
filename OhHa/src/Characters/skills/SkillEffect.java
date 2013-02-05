
package Characters.skills;

import Characters.Character;
import java.awt.image.BufferedImage;

/**
 * An effect for a skill
 * @author 
 */
public interface SkillEffect {
    
    public void triggerEffect(Character target);   
    public BufferedImage getEffectGraphic();
    public boolean isActive();
    public void endEffect();
    public void decreaseEffectNumber();    
}
