/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterTests.SkillTests;

import Characters.Monster;
import Characters.Player;
import Characters.skills.IncreaseDefence;
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

/**
 *
 * @author Mertaset
 */
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
        monster = new Monster(500, 5, 5, 5, images, new ArrayList<Skill>());
        incdef = new IncreaseDefence("");
        player.setTarget(monster);
        monster.setTarget(player);
    }  
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void isDefenceIncreased() {
        incdef.triggerEffect(player.getTarget());
        assertEquals(10, player.getDefence());
    }
    @Test
    public void addedToBuffList() {
        incdef.triggerEffect(player.getTarget());
        assertEquals(1, player.getBuffs().size());
    }    
}
