
package CharacterTests.SkillTests;

import Characters.Monster;
import Characters.Player;
import Characters.skills.DecreaseStrengthAndHealth;
import Characters.skills.IncreaseDefenceEffect;
import Characters.skills.Skill;
import Characters.skills.SkillEffect;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 */
public class DecreaseHealthAndStengthTest {
    Player player;
    Monster monster;
    SkillEffect eff; 
    
    public DecreaseHealthAndStengthTest() {
    }       
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {                   
        player = new Player(500,5,5,5);
        monster = new Monster(500, 5, 5, 5, new ArrayList<Skill>());
        eff = new DecreaseStrengthAndHealth("");
        player.setTarget(monster);
        monster.setTarget(player);
    } 
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void MaxHealthDecreased() {
        eff.triggerEffect(monster);
        assertEquals(monster.getMaxHealth(), 300);
    }
    
    @Test
    public void StrengthDecreased() {
        eff.triggerEffect(monster);
        assertEquals(monster.getStrength(), 3);
    }
    
    @Test
    public void isStunned() {
        eff.triggerEffect(monster);
        assertEquals(monster.isStunned(), true);
    }
}
