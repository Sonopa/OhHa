package ohha;

import maps.Map;
import Characters.Character;
import Characters.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Canvas for displaying graphics
 * @author 
 */
public class Canvas extends JPanel {
    private Map map;
    private Player player;
    
    public Canvas(Map map, Player player) {
        this.map = map;
        this.player = player;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        g2d.drawImage(map.getMapImage(), 0, 0, null);
        g2d.drawImage(map.getMonster().getImage(), 450, 300, null);
        g2d.drawImage(player.getImage(), 350, 300, null);
        g2d.drawString("" + player.getHealth(), 145, 50);
        g2d.drawString("" + map.getMonster().getHealth(), 600, 50);
        g2d.drawString("" + map.getMonster().getDefence(), 600, 70);
        drawSkillEffects(g2d, player, false);
        drawSkillEffects(g2d, map.getMonster(), true);
        drawSkillBar(g2d, player, 30, 140);
        drawSkillBar(g2d, map.getMonster(), 730, 140);
        drawHealthBar(g2d);
        drawMonsterHealthBar(g2d);
    }
    public void drawHealthBar(Graphics2D g2d) {
        Double healthPercentage = ((double)player.getHealth()/player.getMaxHealth())*100;
        int hp = healthPercentage.intValue();
        g2d.setColor(Color.RED);
        g2d.fillRect(100, 40, 200, 30);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(100, 40, hp*2, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawString("" + player.getHealth(), 197, 60);
    }
    
    public void drawMonsterHealthBar(Graphics2D g2d) {
        Double healthPercentage = ((double)map.getMonster().getHealth()/map.getMonster().getMaxHealth())*100;
        int hp = healthPercentage.intValue();
        g2d.setColor(Color.RED);
        g2d.fillRect(500, 40, 200, 30);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(500, 40, hp*2, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawString("" + map.getMonster().getHealth(), 603, 60);
    }
    
    public void changeMap(Map map, Player player) {
        this.map = map;
        this.player = player;
    }    
    
    public void drawSkillBar(Graphics2D g2d, Character character, int x, int y) {
        if (!character.getSkills().isEmpty()) {
            for (int i=0; i<character.getSkills().size(); i++) {
                if (character.getSkills().get(i).isUsed()) {
                    g2d.drawImage(character.getSkills().get(i).getSkillIconUsed(), x, y+40*i, null);
                }else {
                    g2d.drawImage(character.getSkills().get(i).getSkillIconUsable(), x, y+40*i, null);
                }
            }
        }
    }    
    
    public void drawSkillEffects(Graphics2D g2d, Character character, boolean isMonster) {
        int buffAmount = character.getBuffs().size();
        if (buffAmount > 0) {
            for (int i=0; i<character.getBuffs().size(); i++) {
                if (!isMonster) {
                    g2d.drawImage(character.getBuffs().get(i).getEffectGraphic(), 100+40*i, 480, null);
                }else {
                    g2d.drawImage(character.getBuffs().get(i).getEffectGraphic(), 500+40*i, 480, null);
                }
            }
        }
        int debuffAmount = character.getDebuffs().size();
        if (debuffAmount > 0) {
            for (int i=0; i<character.getDebuffs().size(); i++) {
                if (!isMonster) {
                    g2d.drawImage(character.getDebuffs().get(i).getEffectGraphic(), 100+40*i, 520, null);
                }else {
                    g2d.drawImage(character.getDebuffs().get(i).getEffectGraphic(), 500+40*i, 520, null);
                }
            }
        }               
    }
}
