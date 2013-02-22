
package Characters;

import Characters.skills.Skill;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * A subclass of character that represent the game's monster 
 */
public class Monster extends Character implements ActionListener {
    private ArrayList<Skill> skills;         
    
    public Monster(int health, int attackSpeed, int strength, int defence, ArrayList<ImageIcon> hahmoKuvat, ArrayList<Skill> skills) {
        super(health, attackSpeed, strength, defence, hahmoKuvat);        
        this.skills = skills;        
    }  
    public Monster(int health, int attackSpeed, int strength, int defence, ArrayList<Skill> skills) {
        super(health, attackSpeed, strength, defence);        
        this.skills = skills;        
    } 
    
    @Override
    public ArrayList<Skill> getSkills() {
        return this.skills;
    }   
}
