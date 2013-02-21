
package UI;

import Characters.skills.Skill;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * A custom button for SkillUI. Show's the image of the skill 
 */
public class SkillButton extends JButton {
    private BufferedImage skillImage;
    
    public SkillButton(String skillImagePath) {
        try {
            skillImage = ImageIO.read(new File(skillImagePath));
        } catch (Exception e) {
            System.out.println("Skill kuva ei löydy");
        }        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(skillImage, 0, 0, null);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(skillImage.getWidth(), skillImage.getHeight());
    }
}
