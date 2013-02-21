
package ohha;

import maps.LevelContainer;
import Characters.Monster;
import Characters.Player;
import Characters.Character;
import Characters.MonsterAI;
import Characters.skills.Skill;
import Characters.skills.SkillContainer;
import Characters.skills.SkillEffect;
import UI.ExperiencePointsUI;
import UI.Menu;
import UI.PauseMenu;
import UI.Settings;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import UI.SkillUI;
import maps.LevelContainer;

/**
 * The main class that contains all of the game's components. 
 */
public class Game extends JFrame implements Runnable, ActionListener {
    private JFrame frame;
    private LevelContainer levels;
    private int level;
    private Canvas canvas;
    private Player player;
    private Monster monster;
    private Listener listener;
    private Timer timer;
    private MonsterAI AI;
    private int difficulty;
    private ExperiencePointsUI expUI;
    private SkillContainer skills;
    private SkillUI skillUI;    
    
    public Game(int difficulty) {
        this.difficulty = difficulty;
        level = 0;
        skills = new SkillContainer();
        skills.createSkills();
        skills.createMonsterSkills();
        levels = new LevelContainer(skills.getMonsterSkills(), difficulty);
        timer = new Timer(20, this);
        
    }

    @Override
    public void run() {
        frame = new JFrame("Game title");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        gameLoad(frame.getContentPane());
        gameInit();
    }
    
    private void luoKuuntelija(Container container) {   
        listener = new Listener(canvas, player, levels.getMapList().get(level).getMonster(), this);        
        frame.addKeyListener(listener);
    }
 
    private void gameLoad(Container container) {
        levels.createMonsters();
        levels.createMaps();
        player = this.createPlayer();
        player.stun();
        listener = new Listener(canvas, player, monster, this);    
        frame.addKeyListener(listener);
        expUI = new ExperiencePointsUI(this);   
        skillUI = new SkillUI(skills.getSkillList(), this);
        canvas = new Canvas(levels.getMapList().get(level), player);
        container.add(canvas);
    }

    public void gameInit() {
        monster = levels.getMapList().get(level).getMonster();   
        monster.setTarget(player);
        player.setTarget(monster);
        player.updateAttackSpeed();
        AI = new MonsterAI(monster);
    }
    
    public void gameStart() {
        player.updateAttackSpeed();
        expUI.dispose();
        skillUI.dispose();
        timer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {}             
        player.unStun();
        player.healthToFull();
        AI.startAI();
    }
    
    private void gameStop() {
        AI.stopAI();
        player.stun();
        timer.stop();  
        removeEffects(player);
        removeEffects(monster);
    }
    
    public void nextLevel() {
        level++;
        canvas.changeMap(levels.getMapList().get(level), player); 
        gameInit();
        frame.repaint();
        gameStart();
    }
    
    public void restartLevel() {
        player.revive();
        AI.stopAI();
        player.stun();
        monster.healthToFull();
        player.healthToFull();
        removeEffects(player);
        removeEffects(monster);        
        player.unStun();
        AI.startAI();
    }
    
    public Player createPlayer() {        
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        try {
            BufferedImage normalState = ImageIO.read(new File("src/images/stickman0.png"));            
            BufferedImage attackState = ImageIO.read(new File("src/images/stickman1.png"));
            BufferedImage attackState2 = ImageIO.read(new File("src/images/stickman2.png"));
            BufferedImage blockState = ImageIO.read(new File("src/images/stickman3.png"));
            images.add(normalState);
            images.add(attackState);
            images.add(attackState2);
            images.add(blockState);
        }catch (Exception e){}
        player = new Player(500,2,2,2,images);
        return player;
    }
    
    public void skillUI() {
        expUI.dispose();
        skillUI.make();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (monster.isDead()) {
            if (level==9) {   
                timer.stop();
                this.removeAll();
                frame.dispose();
                Settings settings = new Settings();
                Menu menu = new Menu(settings);
                menu.run();                
                return;
            }
            player.gainExperiencePoints(6);
            if (level%2 == 0) {
                player.gainSkillPoints(1);
            }
            gameStop();
            expUI.make();
        }else if (player.isDead()) {            
            System.out.println("You died, restarting level");
            restartLevel();
        }
        frame.repaint();
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public ArrayList<Skill> getSkills() {
        return skills.getSkillList();
    }
    public HashMap<String, Skill> getSkillMap() {
        return skills.getSkillMap();
    }
    
    public ExperiencePointsUI getExpUI() {
        return this.expUI;
    }
    
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    
    public void removeEffects(Character character) {
        if (!character.getBuffs().isEmpty()) {            
            for (SkillEffect effect : character.getBuffs()) {
                effect.endEffect();
            }
            character.getBuffs().clear();
        }
        if (!character.getDebuffs().isEmpty()) {
            for (SkillEffect effect : character.getDebuffs()) {
                effect.endEffect();
            }
            character.getDebuffs().clear();
        }
        for (Skill skill : character.getSkills()) {
            if (skill.isUsed()) {
                skill.actionPerformed(null);
            }
        }
    }
    
    public void pause() {
        player.stun();
        AI.stopAI();
        timer.stop();
        PauseMenu pauseMenu = new PauseMenu(this);
        pauseMenu.make();
    }
    
    public void unPause() {
        timer.start();
        player.unStun();
        AI.startAI();
    }
    
    public void saveGame() {
        try {
            FileWriter writer = new FileWriter("src/ohha/save.txt");
            writer.write(difficulty + "\n");
            writer.write(level + "\n");
            writer.write(player.getStrength() + "\n");
            writer.write(player.getAttackSpeed() + "\n");
            writer.write(player.getDefence() + "\n");
            writer.write(player.getMaxHealth() + "\n");
            writer.write(player.getExperiencePoints() + "\n");
            writer.write(player.getSkillPoints() + "\n");
            for (Skill skill : player.getSkills()) {
                writer.write(skill.getName() + "\n");
            }
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
