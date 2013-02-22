
package Characters.skills;

import Characters.Character;
import javax.swing.ImageIcon;

/**
 * An effect for a skill 
 */
public interface SkillEffect {
    
    public void triggerEffect(Character target);   
    public ImageIcon getEffectGraphic();
    /**
     * Return true if the effect is active on the target
     * @return 
     */
    public boolean isActive();
    public void endEffect();
    /**
     * Decreases the effect's index number that stores the position of the effect on 
     * the debuff or buff lists
     */
    public void decreaseEffectNumber();    
    public String getType();
    /**
     * Removes the effect from the list of active debuffs or buffs
     */
    public void removeFromList();
}
