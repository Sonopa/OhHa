
import Characters.Player;
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

public class CharacterTest {
    Player player;
    
    public CharacterTest() {
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
    }
    
    @Test
    public void playerGainsExperience() {
        player.gainExperiencePoints(5);
        assertEquals(5, player.getExperiencePoints());
    }
    
    @Test
    public void addingStrength() {
        player.gainExperiencePoints(2);
        player.upStrength();
        player.upStrength();
        assertEquals(7, player.getStrength());
        assertEquals(0, player.getExperiencePoints());
    }
    
    @Test
    public void addingAttackSpeed() {
        player.gainExperiencePoints(2);
        player.upAttackSpeed();
        player.upAttackSpeed();
        assertEquals(7, player.getAttackSpeed());
        assertEquals(0, player.getExperiencePoints());
    }
    
    @Test
    public void addingDefence() {
        player.gainExperiencePoints(2);
        player.upDefence();
        player.upDefence();
        assertEquals(7, player.getDefence());
        assertEquals(0, player.getExperiencePoints());
    }
    
    @Test
    public void addingMaxHealth() {        
        player.gainExperiencePoints(2);
        player.upMaxHealth();
        player.upMaxHealth();
        assertEquals(600, player.getMaxHealth());
        assertEquals(0, player.getExperiencePoints());
    }
    
    @Test
    public void takingDamage() {       
        player.takeDamage(150);
        assertEquals(500-(150*(1.0-(2.0*5)/100.0)), player.getHealth(), 0.1); 
    }
    
    @Test
    public void gainingHealth() {
        player.takeDamage(150);
        player.gainHealth(100);
        assertEquals(500-(150*(1.0-(2.0*5)/100.0))+100, player.getHealth(), 0.1);
    }
    
    @Test
    public void gainingHealthOverMaxHealth() {        
        player.gainHealth(100);
        assertEquals(500, player.getHealth());
    }
    
    @Test
    public void settingBlockState() {
        player.setBlockState();
        assertEquals(10, player.getDefence());
    }
    
    @Test
    public void endingBlockState() {
        player.setBlockState();
        player.endBlockState();
        assertEquals(5, player.getDefence());
    }
    
    @Test
    public void healthToFull() {
        player.takeDamage(400);
        player.healthToFull();
        assertEquals(500, player.getHealth());
    }  
    
    @After
    public void tearDown() {
    }        
}
