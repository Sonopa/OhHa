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
        this.createMap("src/images/map1.jpg", 0);
        this.createMap("src/images/map2.jpg", 1);
        this.createMap("src/images/map3.jpg", 2);
        this.createMap("src/images/map4.jpg", 3);
        this.createMap("src/images/map5.jpg", 4);
        this.createMap("src/images/map1.jpg", 5);
        this.createMap("src/images/map2.jpg", 6);
        this.createMap("src/images/map3.jpg", 7);
        this.createMap("src/images/map4.jpg", 8);
        this.createMap("src/images/map5.jpg", 9);     
    }
    
    /**
     * Creates a map with the given background image and level of monster
     * @param bgImagePath
     * @param level 
     */
    public void createMap(String bgImagePath, int level) {
        Map kentta = new Map(bgImagePath, monsters.get(level));
        maps.add(kentta);
    }
    
    /**
     * Creates all monsters
     */
    public void createMonsters() {
        this.createMonster("src/images/enemy10.png", "src/images/enemy11.png","src/images/enemy12.png", "src/images/enemy13.png", 0);        
        this.createMonster("src/images/enemy20.png", "src/images/enemy21.png","src/images/enemy22.png", "src/images/enemy23.png", 1);
        this.createMonster("src/images/enemy30.png", "src/images/enemy31.png","src/images/enemy32.png", "src/images/enemy33.png", 2);
        this.createMonster("src/images/enemy40.png", "src/images/enemy41.png","src/images/enemy42.png", "src/images/enemy43.png", 3);        
        this.createMonster("src/images/enemy50.png", "src/images/enemy51.png","src/images/enemy52.png", "src/images/enemy53.png", 4);        
        this.createMonster("src/images/enemy10.png", "src/images/enemy11.png","src/images/enemy12.png", "src/images/enemy13.png", 5);
        this.createMonster("src/images/enemy20.png", "src/images/enemy21.png","src/images/enemy22.png", "src/images/enemy23.png", 6);
        this.createMonster("src/images/enemy30.png", "src/images/enemy31.png","src/images/enemy32.png", "src/images/enemy33.png", 7);
        this.createMonster("src/images/enemy40.png", "src/images/enemy41.png","src/images/enemy42.png", "src/images/enemy43.png", 8);
        this.createMonster("src/images/enemy50.png", "src/images/enemy51.png","src/images/enemy52.png", "src/images/enemy53.png", 9);
    }
    
    /**
     * Creates and stores a monster with the given parameters
     * @param monsterNPath
     * @param monsterAPath
     * @param monsterBPath
     * @param level 
     */
    public void createMonster(String monsterNPath, String monsterAPath, String monsterA2Path, String monsterBPath, int level) {
        ArrayList<BufferedImage> animations = new ArrayList<BufferedImage>();
        try {
            BufferedImage normalState = ImageIO.read(new File(monsterNPath));
            BufferedImage attackState = ImageIO.read(new File(monsterAPath));
            BufferedImage attackState2 = ImageIO.read(new File(monsterA2Path));
            BufferedImage blockState = ImageIO.read(new File(monsterBPath));
            animations.add(normalState);            
            animations.add(attackState);
            animations.add(attackState2);
            animations.add(blockState);
        }catch (Exception e){}
        ArrayList<Skill> skillList = new ArrayList<Skill>();
        for (int i=0; i<=level; i++) {
            skillList.add(skills.get(i));
        }
        Monster monster = new Monster(200+200*level+50*(difficulty)*(level+1), 1+2*level+difficulty*(level+1), 1+2*level+difficulty*(level+1),
                1+2*level+difficulty*(level+1), animations, skillList);
        monsters.add(monster);
    }
    
    public ArrayList<Map> getMapList() {
        return this.maps;
    }   
}
