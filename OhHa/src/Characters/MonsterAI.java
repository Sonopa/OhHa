package Characters;

import Characters.Monster;
import Characters.skills.Skill;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class MonsterAI implements ActionListener {
    private Monster monster;
    private Random random;
    private Timer timer;    
    
    public MonsterAI(Monster monster) {
        this.monster = monster;
        this.random = new Random();
        this.timer = new Timer(960-30*monster.getAttackSpeed(), this);
    }
    
    public void startAI() {        
        timer.start();
    }
    
    public void stopAI() {
        timer.stop();
    }
    
    public void hitOrUseSkill() {        
        int hitOrSkill = random.nextInt(2);
        if (hitOrSkill == 0) {
            monster.hit(monster.getTarget());
        }else if (hitOrSkill == 1) {
            useRandomSkill();
        }
    }
    
    public void useRandomSkill() {        
        Skill skill = monster.getSkills().get(random.nextInt(monster.getSkills().size()));
        if (!skill.isUsed()) {
            monster.useSkill(skill);
        }else {
            hitOrUseSkill();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.hitOrUseSkill();
    }
}
