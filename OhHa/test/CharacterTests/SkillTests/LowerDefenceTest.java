/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterTests.SkillTests;

import Characters.Monster;
import Characters.Player;
import Characters.skills.IncreaseDefenceEffect;
import Characters.skills.LowerDefenceEffect;
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

public class LowerDefenceTest {
    Monster monster;
    Player player;
    SkillEffect lowerDef;
    public LowerDefenceTest() {
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
        lowerDef = new LowerDefenceEffect("");
        player.setTarget(monster);
        monster.setTarget(player);
    }  
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void isDefenceLowered() {
        lowerDef.triggerEffect(player.getTarget());
        assertEquals(1, monster.getDefence());
    }
    @Test
    public void addedToMonsterDebuffList() {
        lowerDef.triggerEffect(player.getTarget());
        assertEquals(1, monster.getDebuffs().size());
    } 
    @Test
    public void noDecreaseIfBlocking() {
        player.setBlockStateTest();
        lowerDef.triggerEffect(player);        
        assertEquals(player.getDefence(), 10);
    }
}
