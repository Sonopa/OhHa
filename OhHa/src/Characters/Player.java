
package Characters;

import Characters.skills.Skill;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Character {  
    private HashMap<String, Skill> skills;
    private ArrayList<Skill> skillList;
    private int experiencePoints;    
    
    public Player(int health, int attackSpeed, int strength, int defence, ArrayList<BufferedImage> hahmoKuvat) {
        super(health, attackSpeed, strength, defence, hahmoKuvat);
        skills = new HashMap<String, Skill>();
        experiencePoints = 0;
        skillList = new ArrayList<Skill>();
    }
    
    public void addSkill(Skill skill) {
        skills.put(skill.getName(), skill);
        skillList.add(skill);
    }
    public Skill getSkill(String name) {
        return skills.get(name);
    }
    
    @Override
    public ArrayList<Skill> getSkills() {
        return skillList;
    }
    
    public void gainExperiencePoints(int points) {
        experiencePoints += points;
    }
    
    public int getExperiencePoints() {
        return experiencePoints;
    }   
    
    public void upStrength() {
        if (experiencePoints>0) {
            this.gainStrength();
            experiencePoints--;
        }
    }
    public void upAttackSpeed() {
        if (experiencePoints>0) {
            this.gainAttackSpeed();
            experiencePoints--;
        }
    }
    public void upDefence() {
        if (experiencePoints>0) {
            this.gainDefence();
            experiencePoints--;
        }
    }
    public void upMaxHealth() {
        if (experiencePoints>0) {
            this.gainMaxHealth();
            experiencePoints--;
        }
    }
}
