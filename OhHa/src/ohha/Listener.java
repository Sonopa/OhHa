package ohha;

import Characters.Monster;
import Characters.Player;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    private Player player;
    private Monster monster;
    private Game game;
    
    public Listener (Component component, Player player, Monster monster, Game game) {
        this.player = player;
        this.monster = monster;
        this.game = game;
    }    

    @Override
    public void keyTyped(KeyEvent ke) {        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {            
            player.hit(player.getTarget());
        }
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setBlockState();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_1) {
            if (player.getSkills().size() >= 1) {
                player.useSkill(player.getSkills().get(0));
            }            
        }
        else if (ke.getKeyCode() == KeyEvent.VK_2) {
            if (player.getSkills().size() >= 2) {
                player.useSkill(player.getSkills().get(1));
            }            
        }
        else if (ke.getKeyCode() == KeyEvent.VK_3) {
            if (player.getSkills().size() >= 3) {
                player.useSkill(player.getSkills().get(2));
            }            
        }
        else if (ke.getKeyCode() == KeyEvent.VK_4) {
            if (player.getSkills().size() >= 4) {
                player.useSkill(player.getSkills().get(3));
            }
        }
        else if (ke.getKeyCode() == KeyEvent.VK_5) {
            if (player.getSkills().size() >= 5) {
                player.useSkill(player.getSkills().get(4));
            }            
        }
        else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            game.pause();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setImage(0);
            player.endBlockState();
        }
    }    
}

