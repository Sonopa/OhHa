package Characters;

import Characters.skills.Skill;
import Characters.skills.SkillEffect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;
/**
 * Represents a character and handles character's attributes, effects and hit cooldowns.
 *
 * @author 
 */
public abstract class Character implements ActionListener {
    /**
     * Attributes: maxHealth is the maximum health of the character, attackSpeed reduces the hit
     * cooldowntimer delay, streangth increases hit's damage, defence reduces damage taken and stun's length,
     * health is the current health of the character.
     */
    protected int maxHealth, attackSpeed, strength, defence, health;
    private ArrayList<ImageIcon> charImages; //kuvat animaatioihin
    private boolean isDead;
    private Character target;
    private boolean isStunned;
    private Timer cooldownTimer; //lyöntinopeuden ajastin
    /**
     * True if hit is not on cooldown.
     */
    private boolean hitAvailable;
    private ImageIcon image; //hahmosta näytettävä kuva
    /**
     * True if character is blocking.
     */
    private boolean blocking;
    /**
    * A list of currently active buffs on the character.
    */
    private ArrayList<SkillEffect> buffs;
    /**
    * A list of currently active debuffs on the character.
    */
    private ArrayList<SkillEffect> debuffs;
    
    public Character(int maxHealth, int attackSpeed, int strength, int defence, ArrayList<ImageIcon> hahmoKuvat) {
        this.attackSpeed = attackSpeed;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defence = defence;
        this.charImages = hahmoKuvat;
        this.isDead = false;
        this.health = maxHealth;
        isStunned = false;
        hitAvailable = true;
        this.image = hahmoKuvat.get(0);
        cooldownTimer = new Timer(700-(22*this.attackSpeed), this);
        blocking = false;
        buffs = new ArrayList<SkillEffect>();        
        debuffs = new ArrayList<SkillEffect>();
    }    
    /**
     * A Constructor for testing
     * @param maxHealth
     * @param attackSpeed
     * @param strength
     * @param defence 
     */    
    public Character(int maxHealth, int attackSpeed, int strength, int defence) {
        this.attackSpeed = attackSpeed;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defence = defence;        
        this.isDead = false;
        this.health = maxHealth;
        isStunned = false;
        hitAvailable = true;        
        cooldownTimer = new Timer(700-(22*this.attackSpeed), this);
        blocking = false;
        buffs = new ArrayList<SkillEffect>();        
        debuffs = new ArrayList<SkillEffect>();
    }
    
    /**
     * Reduces the health of the character by the given amount
     * @param dmg 
     */
    public void takeDamage(int dmg) {
        health -= (1.0-(1.666*defence)/100.0)*dmg;
        if (health <= 0) {
            health = 0;
            this.die();
        }
    }
    
    /**
     * Target takes the calculated amount of damage
     * @param target 
     */
    public void hit(Character target) {
        if (hitAvailable && !isStunned && !isDead) {
            Random r = new Random();
            this.setImage(r.nextInt(2)+1);
            target.takeDamage(10+this.getStrength()*10);
            hitAvailable = false;
            cooldownTimer.start();
        }
    }
    public boolean isBlocking() {
        return blocking;
    }
        
    public boolean isStunned() {
        return isStunned;
    }
    /**
     * Set's attribute isDead to true
     */
    public void die() {
        this.isDead = true;
    }
    
    /**
     * Set's attribute isDead to false
     */
    public void revive() {
        this.isDead = false;
    }    
    
    public int getDefence() {
        return this.defence;
    }    
    public int getStrength() {
        return this.strength;
    }    
    public int getAttackSpeed() {
        return this.attackSpeed;
    }    
    public int getMaxHealth() {
        return this.maxHealth;
    }    
    public int getHealth() {
        return this.health;
    }    
    public Character getTarget() {
        return this.target;
    }
    
    public void setStrength(int str) {
        this.strength = str;
        if (this.strength < 1) {
            this.strength = 1;
        }
    }    
    public void setAttackSpeed(int speed) {
        this.attackSpeed = speed;
        if (this.attackSpeed < 1) {
            this.attackSpeed = 1;
        }
    }
    public void setDefence(int def) {
        this.defence = def;
        if (this.defence < 1) {
            this.defence = 1;
        }
    }
    public void setMaxHealth(int maxHp) {
        this.maxHealth = maxHp;
        if (this.maxHealth < 1) {
            this.maxHealth = 1;
        }
    }
    
    public void setTarget(Character target) {
        this.target = target;
    }
    
    /**
     * Increases the character's health by the given amount, or if it exceeds maxHealth
     * set's health to maxHealth
     * @param healthAmount 
     */
    public void gainHealth(int healthAmount) {
        if(this.health + healthAmount <= maxHealth) {
            this.health += healthAmount;
        }else if (this.health+healthAmount > maxHealth) {
            this.health = maxHealth;
        }
    }
    
    public void healthToFull() {
        health = maxHealth;
    }
    
    /**
     * Doubles the character's defence
     */
    public void setBlockState() {        
        if (!blocking && !isStunned) {   
            setDefence(defence*2);
            setImage(3);
            blocking = true;
        }
    }
    public void setBlockStateTest() {        
        if (!blocking && !isStunned) {   
            setDefence(defence*2);            
            blocking = true;
        }
    }
    
    /**
     * Set's character's defence back to normal after blocking
     */
    public void endBlockState() {
        if (blocking) {
            setDefence(defence/2);
            setImage(0);
            blocking = false;
        }
    }
    /**
     * Block state without image for testing
     */
    public void endBlockStateTest() {
        if (blocking) {
            setDefence(defence/2);            
            blocking = false;
        }
    }
    
    public boolean isDead() {
        return this.isDead;
    }
    
    /**
     * Character is stunned and can't hit or use skills
     */
    public void stun() {
        isStunned = true;
    }
    public void unStun() {
        isStunned = false;
        if (!blocking) {
            this.setImage(0);
        }
    }    
    
    public boolean isHitAvailable() {
        return this.hitAvailable;
    }
    
    public ImageIcon getImage() {
        return this.image;
    }
    
    public void setImage(int stateNumber) {
        this.image = charImages.get(stateNumber);
    }
    
    /**
     * Uses the given skill and start the cooldowntimer. If skill type is remove debuffs
     * cooldowntimer is not started.
     * @param skill 
     */
    public void useSkill(Skill skill) {
        if (skill.getEffect().getType().equals("remove debuffs")) {
            skill.use(this, target);  
        }
        else if (hitAvailable && !isStunned && !skill.isUsed() && !isDead) {
            skill.use(this, target);            
            hitAvailable = false; 
            cooldownTimer.start();
        }
    }     
    
    /**
     * Adds a skilleffect to the list of active buffs
     * @param effect 
     */
    public void addBuff(SkillEffect effect) {        
        buffs.add(effect);        
    } 
    /**
     * Adds a skilleffect to the list of active debuffs
     * @param effect 
     */
    public void addDebuff(SkillEffect effect) {        
        debuffs.add(effect);
    } 
    public ArrayList<SkillEffect> getBuffs() {
        return buffs;
    }
    public ArrayList<SkillEffect> getDebuffs() {
        return debuffs;
    }
    /**
     * Removes a skilleffect from the list of active buffs and reduces the effect number
     * of the effects that are behind it on the list
     * @param effect 
     */
    public void removeBuff(int effectNumber) {        
        buffs.remove(effectNumber);       
        for (int i = effectNumber; i<this.getBuffs().size(); i++) {
            this.getBuffs().get(i).decreaseEffectNumber();
        }
    }
    /**
     * Removes a skilleffect from the list of active debuffs and reduces the effect number
     * of the effects that are behind it on the list
     * @param effect 
     */
    public void removeDebuff(int effectNumber) {
        debuffs.remove(effectNumber);
        for (int i = effectNumber; i<this.getDebuffs().size(); i++) {
            this.getDebuffs().get(i).decreaseEffectNumber();
        }
    }    
    
    /**
     * Updates the delay of the cooldowntimer if attackSpeed has changed
     */
    public void updateAttackSpeed() {        
        cooldownTimer.setInitialDelay(900-(30*this.attackSpeed));
        cooldownTimer.restart();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setImage(0);
        hitAvailable = true;
        cooldownTimer.stop();        
    }
    
    public abstract ArrayList<Skill> getSkills();
}
