package maps;

import Characters.Monster;
import Characters.skills.Skill;
import java.util.ArrayList;
import javax.swing.ImageIcon;

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
        this.createMap("images/map1.jpg", 0);
        this.createMap("images/map2.jpg", 1);
        this.createMap("images/map3.jpg", 2);
        this.createMap("images/map4.jpg", 3);
        this.createMap("images/map5.jpg", 4);
        this.createMap("images/map1.jpg", 5);
        this.createMap("images/map2.jpg", 6);
        this.createMap("images/map3.jpg", 7);
        this.createMap("images/map4.jpg", 8);
        this.createMap("images/map5.jpg", 9);
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
        this.createMonster("images/enemy10.png", "images/enemy11.png","images/enemy12.png", "images/enemy13.png", 0);        
        this.createMonster("images/enemy20.png", "images/enemy21.png","images/enemy22.png", "images/enemy23.png", 1);
        this.createMonster("images/enemy30.png", "images/enemy31.png","images/enemy32.png", "images/enemy33.png", 2);
        this.createMonster("images/enemy40.png", "images/enemy41.png","images/enemy42.png", "images/enemy43.png", 3);        
        this.createMonster("images/enemy50.png", "images/enemy51.png","images/enemy52.png", "images/enemy53.png", 4);        
        this.createMonster("images/enemy10.png", "images/enemy11.png","images/enemy12.png", "images/enemy13.png", 5);
        this.createMonster("images/enemy20.png", "images/enemy21.png","images/enemy22.png", "images/enemy23.png", 6);
        this.createMonster("images/enemy30.png", "images/enemy31.png","images/enemy32.png", "images/enemy33.png", 7);
        this.createMonster("images/enemy40.png", "images/enemy41.png","images/enemy42.png", "images/enemy43.png", 8);
        this.createMonster("images/enemy50.png", "images/enemy51.png","images/enemy52.png", "images/enemy53.png", 9);
    }
    
    /**
     * Creates and stores a monster with the given parameters
     * @param monsterNPath
     * @param monsterAPath
     * @param monsterBPath
     * @param level 
     */
    public void createMonster(String monsterNPath, String monsterAPath, String monsterA2Path, String monsterBPath, int level) {
        ArrayList<ImageIcon> animations = new ArrayList<ImageIcon>();
        try {
            ImageIcon normalState = new ImageIcon(this.getClass().getClassLoader().getResource(monsterNPath));
            ImageIcon attackState = new ImageIcon(this.getClass().getClassLoader().getResource(monsterAPath));
            ImageIcon attackState2 = new ImageIcon(this.getClass().getClassLoader().getResource(monsterA2Path));
            ImageIcon blockState = new ImageIcon(this.getClass().getClassLoader().getResource(monsterBPath));
            animations.add(normalState);            
            animations.add(attackState);
            animations.add(attackState2);
            animations.add(blockState);
        }catch (Exception e){}
        ArrayList<Skill> skillList = new ArrayList<Skill>();
        for (int i=0; i<=level; i++) {
            skillList.add(skills.get(i));
        }
        Monster monster = new Monster(300+200*level+50*(difficulty)*(level+1), 1+2*level+difficulty*(level+1), 1+2*level+difficulty*(level+1),
                1+2*level+difficulty*(level+1), animations, skillList);
        monsters.add(monster);
    }
    
    public ArrayList<Map> getMapList() {
        return this.maps;
    }   
}
