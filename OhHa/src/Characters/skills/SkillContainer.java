package Characters.skills;

import Characters.Monster;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Creates and contains all monster and player skills
 * @author 
 */
public class SkillContainer {
    private ArrayList<Skill> PlayerSkills;
    private HashMap<String, Skill> skillMap;
    private ArrayList<Skill> MonsterSkills;
    private Monster monster;
    
    public SkillContainer() {
        this.PlayerSkills = new ArrayList<Skill>();
        this.MonsterSkills = new ArrayList<Skill>();  
        this.skillMap = new HashMap<String, Skill>();
    }
    
    /**
     * Creates and stores a skill for the player with the given parameters
     * @param name
     * @param dmg
     * @param healing
     * @param effect
     * @param cooldown
     * @param skillIconPathUsed
     * @param skillIconPathUsable
     * @param tooltip 
     */
    public void createSkill(String name, int dmg, int healing, SkillEffect effect, int cooldown,
            String skillIconPathUsed, String skillIconPathUsable, String tooltip) {
        Skill skill = new Skill(name, dmg, healing, effect, cooldown,
            skillIconPathUsed, skillIconPathUsable, tooltip);
        PlayerSkills.add(skill);
        skillMap.put(name, skill);
    }
    /**
     * Creates and stores a skill for monsters with the given parameters
     * @param name
     * @param dmg
     * @param healing
     * @param effect
     * @param cooldown
     * @param skillIconPathUsed
     * @param skillIconPathUsable
     * @param tooltip 
     */
    public void createMonsterSkill(String name, int dmg, int healing, SkillEffect effect, int cooldown,
            String skillIconPathUsed, String skillIconPathUsable, String tooltip) {
        Skill skill = new Skill(name, dmg, healing, effect, cooldown,
            skillIconPathUsed, skillIconPathUsable, tooltip);
        MonsterSkills.add(skill);
    }
    
    /**
     * Creates all player skills.
     */
    public void createSkills() {
        createMonsterSkill("Stun", 0, 0, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stun: Stuns the enemy for 4 seconds (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Lower defence", 50, 0, new LowerDefenceEffect("src/images/LowerDefenceEffect.png"), 10000, "src/images/LowerDefenceUsed.png", "src/images/LowerDefenceUsable.png", 
                "Lower Defence: Deals 50 damage and lowers the enemy's defence to 1 for 5 seconds (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Lower Strength", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Renew", 0, 400, new HealOverTimeEffect("src/images/Renew.png"), 15000, "src/images/RenewNU.png", "src/images/RenewU.png",
                "Renew: Heals for 400 every 4 seconds for 12 seconds (15s cooldown) [-1 skillpoint]");
        createMonsterSkill("Stun2", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Stun3", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Stun4", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Stun5", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Ultimate Defence", 0, 1000, new IncreaseDefence("src/images/UDef.png"), 15000, "src/images/UDefNU.png", "src/images/UDefU.png",
                "Ultimate Defence: Doubles defence for 5 seconds and heals for 1000 (15s cooldown) [-2 skillpoints]");
        createMonsterSkill("Stun7", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stun: Stuns the enemy for 3 seconds. Cooldown: 10s");
    }
    
    /**
     * Creates all monster skills.
     */
    public void createMonsterSkills() {
        createSkill("Stun", 0, 0, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stun: Stuns the enemy for 4 seconds (10s cooldown) [-1 skillpoint]");
        createSkill("Lower defence", 50, 0, new LowerDefenceEffect("src/images/LowerDefenceEffect.png"), 10000, "src/images/LowerDefenceUsed.png", "src/images/LowerDefenceUsable.png", 
                "Lower Defence: Deals 50 damage and lowers the enemy's defence to 1 for 5 seconds (10s cooldown) [-1 skillpoint]");
        createSkill("Lower Strength", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createSkill("Renew", 0, 400, new HealOverTimeEffect("src/images/Renew.png"), 15000, "src/images/RenewNU.png", "src/images/RenewU.png",
                "Renew: Heals for 400 every 4 seconds for 12 seconds (15s cooldown) [-1 skillpoint]");
        createSkill("Stun2", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createSkill("Stun3", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createSkill("Stun4", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createSkill("Stun5", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createSkill("Ultimate Defence", 0, 1000, new IncreaseDefence("src/images/UDef.png"), 15000, "src/images/UDefNU.png", "src/images/UDefU.png",
                "Ultimate Defence: Doubles defence for 5 seconds and heals for 1000 (15s cooldown) [-2 skillpoints]");
        createSkill("Stun7", 10, 50, new StunEffect("src/images/star.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stun: Stuns the enemy for 3 seconds. Cooldown: 10s");
    }
    
    public ArrayList<Skill> getSkillList() {
        return PlayerSkills;
    }
    public HashMap<String, Skill> getSkillMap() {
        return skillMap;
    }
    
    public ArrayList<Skill> getMonsterSkills() {
        return MonsterSkills;
    }
}
