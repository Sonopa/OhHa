package maps;

import Characters.Monster;
import Characters.skills.Skill;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class LevelContainer {
    private ArrayList<Map> maps;
    private ArrayList<Monster> monsters;
    private ArrayList<Skill> skills;
    private int difficulty;
    
    /**
     * Creates and contains all maps and monsters.
     * @param skills
     * @param difficulty 
     */
    public LevelContainer(ArrayList<Skill> skills, int difficulty) {
        maps = new ArrayList<Map>();
        monsters = new ArrayList<Monster>();
        this.skills = skills;
        this.difficulty = difficulty;
    }
    
    /**
     * Creates all maps
     */
    public void createMaps() {
        this.createMap("src/images/tausta.jpg", 1);
        this.createMap("src/images/map2.jpg", 2);
        this.createMap("src/images/tausta33.jpg", 3);
        this.createMap("src/images/tausta.jpg", 4);
        this.createMap("src/images/map2.jpg", 5);
        this.createMap("src/images/tausta33.jpg", 6);
        this.createMap("src/images/tausta.jpg", 7);
        this.createMap("src/images/map2.jpg", 8);
        this.createMap("src/images/tausta33.jpg", 9);
        this.createMap("src/images/tausta.jpg", 10);     
    }
    
    /**
     * Creates a map with the given background image and level of monster
     * @param bgImagePath
     * @param level 
     */
    public void createMap(String bgImagePath, int level) {
        Map kentta = new Map(bgImagePath, monsters.get(level-1));
        maps.add(kentta);
    }
    
    /**
     * Creates all monsters
     */
    public void createMonsters() {
        this.createMonster("src/images/goblin.png", "src/images/goblina.png", "src/images/goblind.png", 1);        
        this.createMonster("src/images/vihu0.png", "src/images/vihu1.png", "src/images/vihu2.png", 2);
        this.createMonster("src/images/ukkon.png", "src/images/ukkol.png", "src/images/ukkop.png", 3);
        this.createMonster("src/images/vihu0.png", "src/images/vihu1.png", "src/images/vihu2.png", 4);        
        this.createMonster("src/images/goblin.png", "src/images/goblina.png", "src/images/goblind.png", 5);        
        this.createMonster("src/images/vihu0.png", "src/images/vihu1.png", "src/images/vihu2.png", 6);
        this.createMonster("src/images/ukkon.png", "src/images/ukkol.png", "src/images/ukkop.png", 7);
        this.createMonster("src/images/vihu0.png", "src/images/vihu1.png", "src/images/vihu2.png", 8);
        this.createMonster("src/images/ukkon.png", "src/images/ukkol.png", "src/images/ukkop.png", 9);
        this.createMonster("src/images/goblin.png", "src/images/goblina.png", "src/images/goblind.png", 10);
    }
    
    /**
     * Creates and stores a monster with the given parameters
     * @param monsterNPath
     * @param monsterAPath
     * @param monsterBPath
     * @param taso 
     */
    public void createMonster(String monsterNPath, String monsterAPath, String monsterBPath, int taso) {
        ArrayList<BufferedImage> animations = new ArrayList<BufferedImage>();
        try {
            BufferedImage normalState = ImageIO.read(new File(monsterNPath));
            BufferedImage attackState = ImageIO.read(new File(monsterAPath));
            BufferedImage blockState = ImageIO.read(new File(monsterBPath));
            animations.add(normalState);
            animations.add(attackState);
            animations.add(blockState);
        }catch (Exception e){}
        ArrayList<Skill> skillList = new ArrayList<Skill>();
        for (int i=0; i<taso; i++) {
            skillList.add(skills.get(i));
        }
        Monster monster = new Monster(500*taso+500*difficulty, 2*taso+2*difficulty, 2*taso+2*difficulty,
                2*taso+2*difficulty, animations, skillList);        
        monsters.add(monster);
    }
    
    public ArrayList<Map> getMapList() {
        return this.maps;
    }   
}
