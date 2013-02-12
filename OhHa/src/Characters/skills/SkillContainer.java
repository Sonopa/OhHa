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
    public void createMonsterSkills() {
        createMonsterSkill("Stun", 0, 0, new StunEffect("src/images/stunImage.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stun: Stuns the enemy for 4 seconds (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Lower defence", 50, 0, new LowerDefenceEffect("src/images/LowerDefenceEffect.png"), 10000, "src/images/LowerDefenceUsed.png", "src/images/LowerDefenceUsable.png", 
                "Lower Defence: Deals 50 damage and lowers the enemy's defence to 1 for 5 seconds and make's him unable to increase defence. (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Lower Strength", 10, 50, new StunEffect("src/images/stunImage.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Renew", 0, 400, new HealOverTimeEffect("src/images/Renew.png"), 15000, "src/images/RenewNU.png", "src/images/RenewU.png",
                "Renew: Heals for 400 every 4 seconds for 12 seconds (15s cooldown) [-1 skillpoint]");
        createMonsterSkill("Stun2", 10, 50, new StunEffect("src/images/stunImage.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Stun3", 10, 50, new StunEffect("src/images/stunImage.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Remove Debuffs", 0, 100, new RemoveDebuffsEffect(), 10000, "src/images/removeDebuffsn.png", "src/images/removeDebuffsu.png",
                "Remove Debuffs: Removes all debuffs from the player and heals for 100 (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Stun5", 10, 50, new StunEffect("src/images/stunImage.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createMonsterSkill("Ultimate Defence", 0, 1000, new IncreaseDefence("src/images/UDef.png"), 15000, "src/images/UDefNU.png", "src/images/UDefU.png",
                "Ultimate Defence: Doubles defence for 5 seconds and heals for 1000 (15s cooldown) [-2 skillpoints]");
        createMonsterSkill("Pain", 400, 0, new DamageOverTimeEffect("src/images/Pain.png"), 15000, "src/images/PainN.png", "src/images/PainU.png",
                "Pain: Deals 400 damage and then 200 every 2 seconds for 8 seconds (15s cooldown) [-2 skillpoints]");
    }
    
    /**
     * Creates all monster skills.
     */
    public void createSkills() {
        createSkill("Stun", 0, 0, new StunEffect("src/images/stunImage.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stun: Stuns the enemy for 4 seconds (10s cooldown) [-1 skillpoint]");
        createSkill("Lower defence", 50, 0, new LowerDefenceEffect("src/images/LowerDefenceEffect.png"), 10000, "src/images/LowerDefenceUsed.png", "src/images/LowerDefenceUsable.png", 
                "Lower Defence: Deals 50 damage and lowers the enemy's defence to 1 and make's him unable to increase defence for 5 seconds (10s cooldown) [-1 skillpoint]");
        createSkill("Lower Attack Speed", 0, 0, new LowerAttackSpeedEffect("src/images/LowerSpeed.png"), 12000, "src/images/LowerSpeedN.png", "src/images/LowerSpeedU.png",
                "Lower Attack Speed: Lowers target's attack speed to 1 for 6 seconds (12s cooldown) [-1 skillpoint]");
        createSkill("Renew", 0, 400, new HealOverTimeEffect("src/images/Renew.png"), 15000, "src/images/RenewNU.png", "src/images/RenewU.png",
                "Renew: Heals for 400 every 4 seconds for 12 seconds (15s cooldown) [-1 skillpoint]");
        createSkill("Stun2", 10, 50, new StunEffect("src/images/stunImage.png"), 10000, "src/images/stunIcon.png", "src/images/stunIconUsable.png",
                "Stuns the enemy for 3 seconds");
        createSkill("Remove Debuffs", 0, 100, new RemoveDebuffsEffect(), 10000, "src/images/removeDebuffsn.png", "src/images/removeDebuffsu.png",
                "Remove Debuffs: Removes all debuffs from the player and heals for 100 (10s cooldown) [-1 skillpoint]");
        createSkill("Heal", 0, 900, new NoEffect(), 8000, "src/images/HealN.png", "src/images/HealU.png",
                "Heal: Heals for 900 (8s cooldown) [-1 skillpoint]");
        createSkill("Hard hit", 500, 0, new NoEffect(), 6000, "src/images/HhitN.png", "src/images/HhitU.png",
                "Hard hit: Deals 500 damage (6s cooldown) [-1 skillpoint]");
        createSkill("Ultimate Defence", 0, 1000, new IncreaseDefence("src/images/UDef.png"), 15000, "src/images/UDefNU.png", "src/images/UDefU.png",
                "Ultimate Defence: Doubles defence for 6 seconds and heals for 1000 (15s cooldown) [-2 skillpoints]");
        createSkill("Pain", 400, 0, new DamageOverTimeEffect("src/images/Pain.png"), 15000, "src/images/PainN.png", "src/images/PainU.png",
                "Pain: Deals 400 damage and then 200 every 2 seconds for 8 seconds (15s cooldown) [-2 skillpoints]");
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
