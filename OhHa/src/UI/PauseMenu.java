package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import ohha.Game;

public class PauseMenu extends JPanel {
    private JFrame frame;
    private Game game;
    
    /**
     * A menu that is shown when the game is paused. Gives the options to continue game, save game
     * or to quit game.
     * @param game 
     */
    public PauseMenu(Game game) {
        this.game = game;
    }
    
    public void make() {
        frame = new JFrame("Paused");
        frame.setPreferredSize(new Dimension(150, 250));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
        
        luoKomponentit(frame.getContentPane());
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); 
        frame.requestFocus();
    }
    
    public void dispose() {
        frame.dispose();
    }
    
    private void luoKomponentit(Container container) {
        frame.setLayout(new GridLayout(3,1));
        frame.setBackground(Color.BLACK);
        JButton contin = new JButton("Continue");
        JButton save = new JButton("Save Game");        
        JButton quit = new JButton("Quit");
        frame.add(contin);
        frame.add(save);        
        frame.add(quit);
        contin.setBackground(Color.black);
        contin.setForeground(Color.green);        
        save.setBackground(Color.black);
        save.setForeground(Color.green);
        quit.setBackground(Color.black);
        quit.setForeground(Color.green);
        PauseMenuListener listener = new PauseMenuListener(this, game, contin, save, quit);       
        contin.addActionListener(listener);
        save.addActionListener(listener);
        quit.addActionListener(listener);
    }
}
