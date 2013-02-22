package maps;

import Characters.Monster;
import javax.swing.ImageIcon;

/**
 * A map represents a level in the game. Has background image and a monster. 
 */
public class Map {
    private Monster monster;    
    private ImageIcon bg;
    
    public Map(String mapImagePath, Monster monster) {
        this.monster = monster;        
        bg = new ImageIcon(this.getClass().getClassLoader().getResource(mapImagePath));     
    }
    
    public ImageIcon getMapImage() {
        return bg;
    }
    
    public Monster getMonster() {
        return monster;
    }
}
