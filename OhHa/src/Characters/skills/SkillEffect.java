
package Characters.skills;

import Characters.Character;
import java.awt.image.BufferedImage;

public interface SkillEffect {
    
    public void triggerEffect(Character target);   
    public BufferedImage getEffectGraphic();
    public boolean isActive();
}
