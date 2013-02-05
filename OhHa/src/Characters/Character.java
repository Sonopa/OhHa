package Characters;

import Characters.skills.Skill;
import Characters.skills.SkillEffect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;
/**
 * Represents a character and handles character's attributes, effects and hit cooldowns.
 *
 * @author 
 */
public abstract class Character implements ActionListener {
    /**
     * Attributes: maxHealth is the maximum health of the character, attackSpeed reduces the hit
     * cooldown timer, streangth increases hit's damage, defence reduces damage taken and stun's length,
     * health is the current health of the character.
     */
    protected int maxHealth, attackSpeed, strength, defence, health;
    private ArrayList<BufferedImage> charImages; //kuvat animaatioihin
    private boolean isDead;
    private Character target;
    private boolean isStunned;
    private Timer cooldownTimer; //lyöntinopeuden ajastin
    private boolean hitAvailable;
    private BufferedImage image; //hahmosta näytettävä kuva
    private boolean blocking;
    private ArrayList<SkillEffect> buffs;
    private ArrayList<SkillEffect> debuffs;
    
    public Character(int maxHealth, int attackSpeed, int strength, int defence, ArrayList<BufferedImage> hahmoKuvat) {
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
        cooldownTimer = new Timer(900-(30*this.attackSpeed), this);
        blocking = false;        
        buffs = new ArrayList<SkillEffect>();
        debuffs = new ArrayList<SkillEffect>();
    }
    
    /**
     * Reduces the health of the target by the given amount
     * @param dmg 
     */
    public void takeDamage(int dmg) {
        health -= (1.0-(1.666*defence)/100.0)*dmg;
        if (health <= 0) {
            health = 0;
            this.die();
        }
    }
    
    public void hit(Character target) {
        if (hitAvailable && !isStunned && !isDead) {
            this.setImage(1);
            target.takeDamage(this.getStrength()*10);
            hitAvailable = false;
            cooldownTimer.start();
        }
    }
        
    public boolean isStunned() {
        return isStunned;
    }
    public void die() {
        this.isDead = true;
    }
    
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
    }    
    public void setAttackSpeed(int speed) {
        this.attackSpeed = speed;
    }
    public void setDefence(int def) {
        this.defence = def;
    }
    public void setMaxHealth(int maxHp) {
        this.maxHealth = maxHp;
    }
    
    public void setTarget(Character target) {
        this.target = target;
    }
    
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
    
    public void setBlockState() {        
        if (!blocking && !isStunned) {   
            setDefence(defence*2);
            setImage(2);
            blocking = true;
        }
    }
    
    public void endBlockState() {
        if (blocking) {
            setDefence(defence/2);
            setImage(0);
            blocking = false;
        }
    }
    
    public boolean isDead() {
        return this.isDead;
    }
    
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
    
    public BufferedImage getImage() {
        return this.image;
    }
    
    public void setImage(int stateNumber) {
        this.image = charImages.get(stateNumber);
    }
    
    public void useSkill(Skill skill) {
        if (hitAvailable && !isStunned && !skill.isUsed() && !isDead) {
            skill.use(this, target);            
            hitAvailable = false; 
            cooldownTimer.start();
        }
    }     
    
    public void addBuff(SkillEffect effect) {        
        buffs.add(effect);        
    } 
    public void addDebuff(SkillEffect effect) {        
        debuffs.add(effect);
    } 
    public ArrayList<SkillEffect> getBuffs() {
        return buffs;
    }
    public ArrayList<SkillEffect> getDebuffs() {
        return debuffs;
    }
    public void removeBuff(int effectNumber) {        
        buffs.remove(effectNumber);       
        for (int i = effectNumber; i<this.getBuffs().size(); i++) {
            this.getBuffs().get(i).decreaseEffectNumber();
        }
    }
    public void removeDebuff(int effectNumber) {
        debuffs.remove(effectNumber);
        for (int i = effectNumber; i<this.getDebuffs().size(); i++) {
            this.getDebuffs().get(i).decreaseEffectNumber();
        }
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setImage(0);
        hitAvailable = true;
        cooldownTimer.stop();        
    }
    
    public abstract ArrayList<Skill> getSkills();
}
