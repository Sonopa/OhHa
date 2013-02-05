package Characters;

import Characters.skills.Skill;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * A subclass of character that represents the player. 
 * Handles player experience and skill points.
 * @author 
 */
public class Player extends Character {
    private HashMap<String, Skill> skills;
    private ArrayList<Skill> skillList;
    private int experiencePoints;
    private int skillPoints;
    
    
    public Player(int health, int attackSpeed, int strength, int defence, ArrayList<BufferedImage> hahmoKuvat) {
        super(health, attackSpeed, strength, defence, hahmoKuvat);
        skills = new HashMap<String, Skill>();
        experiencePoints = 0;
        skillPoints = 0;
        skillList = new ArrayList<Skill>();
    }
    
    public void addSkill(Skill skill) {
        skills.put(skill.getName(), skill);
        skillList.add(skill);        
    }
    public Skill getSkill(String name) {
        return skills.get(name);
    }
    
    /**
     * Return true if the player has a skill that has the given name
     * @param name
     * @return 
     */
    public boolean hasSkill(String name) {
        return skills.containsKey(name);
    }
    
    /**
     * Reduces the amount of skillpoints by x
     * @param x 
     */
    public void takeSkillPoints(int x) {
        skillPoints -= x;
    }
    
    /**
     * Returns a list of the players skills
     * @return 
     */
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
    
    public void gainSkillPoints(int points) {
        skillPoints += points;
    }    
    public int getSkillPoints() {
        return skillPoints;
    }   
    
    /**
     * Increases the players strength by 1 and takes 1 experience point
     */
    public void upStrength() {
        if (experiencePoints>0) {            
            strength++;
            experiencePoints--;
        }
    }
    /**
     * Increases the players attack speed by 1 and takes 1 experience point
     */
    public void upAttackSpeed() {
        if (experiencePoints>0) {            
            attackSpeed++;
            experiencePoints--;
        }
    }
    /**
     * Increases the players defence by 1 and takes 1 experience point
     */
    public void upDefence() {
        if (experiencePoints>0) {            
            defence++;
            experiencePoints--;
        }
    }
    
    /**
     * Increases the players maximum health by 1 and takes 1 experience point
     */
    public void upMaxHealth() {
        if (experiencePoints>0) {
            maxHealth += 100;
            experiencePoints--;
        }
    }
}
