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
     * Creates all monster skills.
     */
    public void createMonsterSkills() {
        createMonsterSkill("Stun", 0, 0, new StunEffect("images/stunImage.png"), 10000, "images/stunIcon.png", "images/stunIconUsable.png",
                "Stun: Stuns the enemy for 4 seconds (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Lower defence", 50, 0, new LowerDefenceEffect("images/LowerDefenceEffect.png"), 10000, "images/LowerDefenceUsed.png", "images/LowerDefenceUsable.png", 
                "Lower Defence: Deals 50 damage and lowers the enemy's defence to 1 and make's him unable to increase defence for 5 seconds (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Lower Attack Speed", 0, 0, new LowerAttackSpeedEffect("images/LowerSpeed.png"), 12000, "images/LowerSpeedN.png", "images/LowerSpeedU.png",
                "Lower Attack Speed: Lowers target's attack speed to 1 for 6 seconds (12s cooldown) [-1 skillpoint]");
        createMonsterSkill("HoT", 0, 400, new HealOverTimeEffect("images/Renew.png"), 15000, "images/RenewNU.png", "images/RenewU.png",
                "Renew: Heals for 400 every 4 seconds for 12 seconds (15s cooldown) [-1 skillpoint]");
        createMonsterSkill("Dmg and heal", 200, 200, new NoEffect(), 12000, "images/DmgAndHealN.png", "images/DmgAndHealU.png",
                "Weaken: Stuns the target for 1 second and permanently decreases target's max health by 200 and strength by 2 (12s cooldown) [-1 skillpoint]");
        createMonsterSkill("Remove Debuffs", 0, 100, new RemoveDebuffsEffect(), 10000, "images/removeDebuffsn.png", "images/removeDebuffsu.png",
                "Remove Debuffs: Removes all debuffs from the player and heals for 100 (10s cooldown) [-1 skillpoint]");
        createMonsterSkill("Heal", 0, 900, new NoEffect(), 8000, "images/HealN.png", "images/HealU.png",
                "Heal: Heals for 900 (8s cooldown) [-1 skillpoint]");
        createMonsterSkill("Hard hit", 500, 0, new NoEffect(), 6000, "images/HhitN.png", "images/HhitU.png",
                "Hard hit: Deals 500 damage (6s cooldown) [-1 skillpoint]");
        createMonsterSkill("Ultimate Defence", 0, 1000, new IncreaseDefenceEffect("images/UDef.png"), 15000, "images/UDefNU.png", "images/UDefU.png",
                "Ultimate Defence: Doubles defence for 6 seconds and heals for 1000 (15s cooldown) [-2 skillpoints]");
        createMonsterSkill("Ultimate Offence", 400, 0, new DamageOverTimeEffect("images/Pain.png"), 15000, "images/PainN.png", "images/PainU.png",
                "Ultimate Offence: Deals 400 damage and then 200 every 2 seconds for 8 seconds (15s cooldown) [-2 skillpoints]");
    }
    
    /**
     * Creates all player skills.
     */
    public void createSkills() {
        createSkill("Stun", 0, 0, new StunEffect("images/stunImage.png"), 10000, "images/stunIcon.png", "images/stunIconUsable.png",
                "Stun: Stuns the enemy for 4 seconds (10s cooldown) [-1 skillpoint]");
        createSkill("Lower defence", 50, 0, new LowerDefenceEffect("images/LowerDefenceEffect.png"), 10000, "images/LowerDefenceUsed.png", "images/LowerDefenceUsable.png", 
                "Lower Defence: Deals 50 damage and lowers the enemy's defence to 1 and make's him unable to increase defence for 5 seconds (10s cooldown) [-1 skillpoint]");
        createSkill("Lower Attack Speed", 0, 0, new LowerAttackSpeedEffect("images/LowerSpeed.png"), 12000, "images/LowerSpeedN.png", "images/LowerSpeedU.png",
                "Lower Attack Speed: Lowers target's attack speed to 1 for 6 seconds (12s cooldown) [-1 skillpoint]");
        createSkill("HoT", 0, 400, new HealOverTimeEffect("images/Renew.png"), 15000, "images/RenewNU.png", "images/RenewU.png",
                "Renew: Heals for 400 every 4 seconds for 12 seconds (15s cooldown) [-1 skillpoint]");
        createSkill("Weaken", 0, 0, new DecreaseStrengthAndHealth("images/stunImage.png"), 12000, "images/WeakenN.png", "images/WeakenU.png",
                "Weaken: Stuns the target for 1 second and permanently decreases target's max health by 200 and strength by 2 (12s cooldown) [-1 skillpoint]");
        createSkill("Remove Debuffs", 0, 100, new RemoveDebuffsEffect(), 10000, "images/removeDebuffsn.png", "images/removeDebuffsu.png",
                "Remove Debuffs: Removes all debuffs from the player and heals for 100 (10s cooldown) [-1 skillpoint]");
        createSkill("Heal", 0, 900, new NoEffect(), 8000, "images/HealN.png", "images/HealU.png",
                "Heal: Heals for 900 (8s cooldown) [-1 skillpoint]");
        createSkill("Hard hit", 500, 0, new NoEffect(), 6000, "images/HhitN.png", "images/HhitU.png",
                "Hard hit: Deals 500 damage (6s cooldown) [-1 skillpoint]");
        createSkill("Ultimate Defence", 0, 1000, new IncreaseDefenceEffect("images/UDef.png"), 15000, "images/UDefNU.png", "images/UDefU.png",
                "Ultimate Defence: Doubles defence for 6 seconds and heals for 1000 (15s cooldown) [-2 skillpoints]");
        createSkill("Ultimate Offence", 400, 0, new DamageOverTimeEffect("images/Pain.png"), 15000, "images/PainN.png", "images/PainU.png",
                "Ultimate Offence: Deals 400 damage and then 200 every 2 seconds for 8 seconds (15s cooldown) [-2 skillpoints]");
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
