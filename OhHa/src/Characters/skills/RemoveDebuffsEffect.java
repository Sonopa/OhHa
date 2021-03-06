
package Characters.skills;

import Characters.Character;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Removes all active debuffs from the user. Doesn't trigger hit cooldown. 
 */
public class RemoveDebuffsEffect implements SkillEffect {    
    private Character target;  

    @Override
    public void triggerEffect(Character target) {  
        ArrayList<SkillEffect> toBeRemoved = new ArrayList<SkillEffect>();
        for (SkillEffect effect : target.getTarget().getDebuffs()) {
            effect.endEffect();
            toBeRemoved.add(effect);
        }
        for (SkillEffect effect : toBeRemoved) {
            effect.removeFromList();
        }
    }
    
    @Override
    public ImageIcon getEffectGraphic() {
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
        return "remove debuffs";
    }
    
    @Override
    public void removeFromList() {        
    }    
}
