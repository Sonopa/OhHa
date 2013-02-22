package CharacterTests;


import Characters.Player;
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
        player = new Player(500,5,5,5);        
    }
    
    @Test
    public void playerStrengthCorrect() {
        assertEquals(5, player.getStrength());
    }
    @Test
    public void playerAttackSpeedCorrect() {
        assertEquals(5, player.getAttackSpeed());
    }
    @Test
    public void playerMaxHealthCorrect() {
        assertEquals(500, player.getMaxHealth());
    }
    @Test
    public void playerHealthCorrect() {
        assertEquals(player.getMaxHealth(), player.getHealth());
    }
    @Test
    public void playerDefenceCorrect() {
        assertEquals(5, player.getDefence());
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
        assertEquals(700, player.getMaxHealth());
        assertEquals(0, player.getExperiencePoints());
    }
    
    @Test
    public void takingDamage() {       
        player.takeDamage(150);
        assertEquals(500-(150*(1.0-(1.666*5)/100.0)), player.getHealth(), 1.0); 
    }
    
    @Test
    public void takingEnoughDamageToDie() {
        player.takeDamage(600);
        assertEquals(player.isDead(), true);
    }
    
    @Test
    public void gainingHealth() {
        player.takeDamage(150);
        player.gainHealth(100);
        assertEquals(500-(1.0-(1.666*5)/100.0)*150+100, player.getHealth(), 1.0);
    }
    
    @Test
    public void gainingHealthOverMaxHealth() {        
        player.gainHealth(100);
        assertEquals(500, player.getHealth());
    }
    
    @Test
    public void settingBlockState() {
        player.setBlockStateTest();
        assertEquals(10, player.getDefence());
    }
    
    @Test
    public void endingBlockState() {
        player.setBlockStateTest();
        player.endBlockStateTest();
        assertEquals(5, player.getDefence());
    }
    
    @Test
    public void healthToFull() {
        player.takeDamage(400);
        player.healthToFull();
        assertEquals(500, player.getHealth());
    }  
    
    @Test
    public void stunWorks() {
        player.stun();        
        assertEquals(player.isStunned(), true);
    }  
    
    @After
    public void tearDown() {
    }        
}
