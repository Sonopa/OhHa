
package UI;

import Characters.skills.Skill;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * A custom button for SkillUI. Show's the image of the skill 
 */
public class SkillButton extends JButton {
    private ImageIcon skillImage;
    
    public SkillButton(String skillImagePath) {        
        skillImage = new ImageIcon(this.getClass().getClassLoader().getResource(skillImagePath));               
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(skillImage.getImage(), 0, 0, null);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(skillImage.getIconWidth(), skillImage.getIconHeight());
    }
}
