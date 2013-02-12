
package CharacterTests.SkillTests;

import Characters.Monster;
import Characters.Player;
import Characters.skills.IncreaseDefence;
import Characters.skills.LowerDefenceEffect;
import Characters.skills.RemoveDebuffsEffect;
import Characters.skills.Skill;
import Characters.skills.SkillEffect;
import Characters.skills.StunEffect;
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

public class RemoveDebuffsTest {
    Player player;
    Monster monster;
    SkillEffect remDB;
    SkillEffect lowerDef;
    SkillEffect stun;
    
    public RemoveDebuffsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        try {
            BufferedImage normalState = ImageIO.read(new File("src/images/orcn.png"));
            BufferedImage attackState = ImageIO.read(new File("src/images/orca.png"));
            BufferedImage blockState = ImageIO.read(new File("src/images/orcd.png"));
            images.add(normalState);
            images.add(attackState);
            images.add(blockState);
        }catch (Exception e){}        
        player = new Player(500,5,5,5,images);      
        monster = new Monster(500,5,5,5,images, new ArrayList<Skill>());
        remDB = new RemoveDebuffsEffect();
        player.setTarget(monster);
        monster.setTarget(player);
        lowerDef = new LowerDefenceEffect("");
        stun = new StunEffect("");
    }  
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void areDebuffsOnList() {
        lowerDef.triggerEffect(player);
        stun.triggerEffect(player);
        assertEquals(2, player.getDebuffs().size());
    }
    
    @Test
    public void DebuffsRemoved() {
        lowerDef.triggerEffect(player);
        stun.triggerEffect(player);
        remDB.triggerEffect(monster);
        assertEquals(0, player.getDebuffs().size());
    }
    
}
