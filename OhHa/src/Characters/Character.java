
package Characters;

import Characters.skills.Skill;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;

public abstract class Character implements ActionListener {
    private int maxHealth, attackSpeed, strength, defence, health;
    private ArrayList<BufferedImage> charImages; //kuvat animaatioihin
    private boolean isDead;
    private Character target;
    private boolean isStunned;
    private Timer cooldownTimer; //lyöntinopeuden ajastin    
    private boolean hitAvailable; 
    private BufferedImage image; //hahmosta näytettävä kuva
    private boolean blocking;
    private Skill lastSkillUsed;
    private boolean skillUsed;
    
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
        cooldownTimer = new Timer(960-(30*this.attackSpeed), this);
        blocking = false;
        skillUsed = false;
    }
    
    public void takeDamage(int dmg) {
        health -= (1.0-(2.0*defence)/100.0)*dmg;
        if (health <= 0) {
            health = 0;
            this.die();
        }
    }
    
    public void hit(Character target) {
        if (hitAvailable && !isStunned && !isDead) {
            this.setImage(1);
            this.getTarget().takeDamage(this.getStrength()*10);
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
    
    public void setAttributes(int health, int attackSpeed, int strength, int defence) {
        this.maxHealth = health;
        this.attackSpeed = attackSpeed;
        this.strength = strength;
        this.defence = defence;
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
        if (!blocking) {
            setDefence(defence*2);
            blocking = true;
        }
    }
    
    public void endBlockState() {
        if (blocking) {
            setDefence(defence/2);
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
        this.setImage(0);
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
            lastSkillUsed = skill;
            hitAvailable = false;
            skillUsed = true;
            cooldownTimer.start();
        }
    }
    
    public boolean skillUsed() {
        return skillUsed;
    }   
    
    public Skill getLastSkillUsed() {
        return lastSkillUsed;
    }
    
    public void gainStrength() {
        strength++;
    }
    public void gainAttackSpeed() {
        attackSpeed++;
    }
    public void gainDefence() {
        defence++;
    }
    public void gainMaxHealth() {
        maxHealth += 50;
    }
    
    public void setDefence(int defence) {
        this.defence = defence;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setImage(0);
        hitAvailable = true;
        cooldownTimer.stop();        
    }
    
    public abstract ArrayList<Skill> getSkills();
}
