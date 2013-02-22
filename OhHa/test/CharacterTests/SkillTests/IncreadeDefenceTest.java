
package CharacterTests.SkillTests;

import Characters.Monster;
import Characters.Player;
import Characters.skills.IncreaseDefenceEffect;
import Characters.skills.Skill;
import Characters.skills.SkillEffect;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IncreadeDefenceTest {
    Player player;
    Monster monster;
    SkillEffect incdef;
    
    public IncreadeDefenceTest() {
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
        incdef = new IncreaseDefenceEffect("");
        player.setTarget(monster);
        monster.setTarget(player);
    }  
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void defenceIncreased() {
        incdef.triggerEffect(player.getTarget());
        assertEquals(10, player.getDefence());
    }
    @Test
    public void addedToBuffList() {
        incdef.triggerEffect(player.getTarget());
        assertEquals(1, player.getBuffs().size());
    }
    @Test
    public void noIncreaseIfBlocking() {
        player.setBlockStateTest();
        incdef.triggerEffect(player);
        player.endBlockStateTest();
        assertEquals(player.getDefence(), 5);
    }
}
