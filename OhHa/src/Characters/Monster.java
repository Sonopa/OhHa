
package Characters;

import Characters.skills.Skill;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Monster extends Character implements ActionListener {
    private ArrayList<Skill> skills;
         
    
    public Monster(int health, int attackSpeed, int strength, int defence, ArrayList<BufferedImage> hahmoKuvat, ArrayList<Skill> skills) {
        super(health, attackSpeed, strength, defence, hahmoKuvat);        
        this.skills = skills;
    }
    
    @Override
    public ArrayList<Skill> getSkills() {
        return this.skills;
    }   
}
