package UI;

import UI.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.JButton;
import ohha.Game;
import UI.Settings;

public class MenuKuuntelija implements ActionListener {
    private Settings setting;
    private JButton start;
    private JButton contin;
    private JButton settings;
    private JButton quit;
    private Menu menu;
    private boolean menuCreated;
    
    public MenuKuuntelija(Menu menu, Settings setting, JButton start, JButton continueSaved,
            JButton settings, JButton quit) {
        this.setting = setting;
        this.start = start;
        this.contin = continueSaved;
        this.settings = settings;
        this.quit = quit;
        this.menu = menu;
        this.menuCreated = false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            menu.dispose();
            Game peli = new Game(setting.getDifficulty());
            peli.run();
            peli.gameStart();            
        }else if (ae.getSource() == contin) {
            Game peli = new Game(setting.getDifficulty());            
            File save = new File("src/ohha/save.txt");
            try {
                Scanner lukija = new Scanner(save);
                peli.setLevel(Integer.parseInt(lukija.nextLine()));
                peli.run();
                peli.getPlayer().setStrength(Integer.parseInt(lukija.nextLine()));
                peli.getPlayer().setAttackSpeed(Integer.parseInt(lukija.nextLine()));
                peli.getPlayer().setDefence(Integer.parseInt(lukija.nextLine()));
                peli.getPlayer().setMaxHealth(Integer.parseInt(lukija.nextLine()));
                peli.getPlayer().gainExperiencePoints(Integer.parseInt(lukija.nextLine()));
                peli.getPlayer().gainSkillPoints(Integer.parseInt(lukija.nextLine()));
                while(lukija.hasNextLine()) {
                    peli.getPlayer().addSkill(peli.getSkillMap().get(lukija.nextLine()));
                }                
            }catch (Exception e) {
                e.printStackTrace();
            }
            menu.dispose();
            peli.gameStart();
        }else if (ae.getSource() == settings) {
            if (!menuCreated) {
                setting.run();
                menuCreated = true;   
            }else {
                setting.asetaNakyvaksi();
                setting.getFrame().setLocationRelativeTo(null);
            }
        }else if (ae.getSource() == quit) {
            System.exit(0);
        }
    }    
}
