package maps;

import Characters.Monster;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * A map represents a level in the game. Has background image and a monster.
 * @author 
 */
public class Map {
    private Monster monster;
    private String mapImg;
    private BufferedImage bg;
    
    public Map(String mapImagePath, Monster monster) {
        this.monster = monster;
        this.mapImg = mapImagePath;
    }
    
    public BufferedImage getMapImage() {
        try {
            bg = ImageIO.read(new File(mapImg));
        }catch (Exception e){
            System.out.println(e);
        }
        return bg;
    }
    
    public Monster getMonster() {
        return monster;
    }
}
