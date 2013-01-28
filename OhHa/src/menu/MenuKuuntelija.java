package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ohha.Game;

public class MenuKuuntelija implements ActionListener {
    private Settings setting;
    private JButton start;
    private JButton settings;
    private JButton quit;
    private Menu menu;
    private boolean menuCreated;
    
    public MenuKuuntelija(Menu menu, Settings setting, JButton start, JButton settings, JButton quit) {
        this.setting = setting;
        this.start = start;
        this.settings = settings;
        this.quit = quit;
        this.menu = menu;
        this.menuCreated = false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            Game peli = new Game();            
            menu.asetaNakymattomaksi();
        }else if (ae.getSource() == settings) {
                     
        }else if (ae.getSource() == quit) {
            System.exit(0);
        }
    }    
}
