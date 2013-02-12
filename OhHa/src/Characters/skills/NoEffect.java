package Characters.skills;

import Characters.Character;
import java.awt.image.BufferedImage;

/**
 * A skilleffect for skills that have no effect. Does nothing 
 */
public class NoEffect implements SkillEffect {    

    @Override
    public void triggerEffect(Character target) {        
    }
    
    @Override
    public BufferedImage getEffectGraphic() {
        return null;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void endEffect() {        
    }

    @Override
    public void decreaseEffectNumber() {        
    }

    @Override
    public String getType() {
        return "";
    }
    
    @Override
    public void removeFromList() {        
    }    
}
