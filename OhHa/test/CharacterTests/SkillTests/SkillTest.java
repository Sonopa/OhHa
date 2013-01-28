/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterTests.SkillTests;

import Characters.Monster;
import Characters.Player;
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

/**
 *
 * @author Mertaset
 */
public class SkillTest {
    Player player;
    Skill skill;
    Monster monster;
    
    public SkillTest() {
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
        SkillEffect effect = new StunEffect("");
        skill = new Skill("Skill", 100, 150, effect, 10000, "", "");
        player.addSkill(skill);
        player.setTarget(monster);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void playerHasSkill() {
        assertEquals(player.getSkill("Skill"), skill);
    }
    
    @Test
    public void skillDoesDamage() {        
        player.useSkill(skill);
        assertEquals(monster.getHealth(), 500-(1.0-(1.666*5)/100.0)*100, 1.0);
    }   
    
    @Test
    public void skillHeals() {
        player.takeDamage(200);
        player.useSkill(skill);
        assertEquals(player.getHealth(), 500-(1.0-(1.666*5)/100.0)*200+150, 1.0);
    }
    
    @Test
    public void skillEffectWorks() {
        player.useSkill(skill);
        assertEquals(monster.isStunned(), true);
    }
    
    @Test
    public void getsUsed() {
        player.useSkill(skill);
        assertEquals(skill.isUsed(), true);
    }
}
