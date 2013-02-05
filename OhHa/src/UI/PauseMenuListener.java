package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ohha.Game;

public class PauseMenuListener implements ActionListener {
    private Game game;
    private PauseMenu menu;
    private JButton contin;
    private JButton save;
    private JButton quit;
    private PauseMenu pauseMenu;    
    
    public PauseMenuListener(PauseMenu menu, Game game, JButton contin, JButton save, JButton quit) {
        this.game = game;
        this.menu = menu;
        this.contin = contin;  
        this.save = save;
        this.quit = quit;      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == contin) {
            game.unPause();
            menu.dispose();
        }else if (ae.getSource() == save) {
            game.saveGame();
        }else if (ae.getSource() == quit) {
            System.exit(0);
        }
    }    
}