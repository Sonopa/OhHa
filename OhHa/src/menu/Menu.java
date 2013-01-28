package menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Menu implements Runnable {
    private JFrame frame;
    private Settings setting;
    
    public Menu(Settings settings) {
        this.setting = settings;
    }

    @Override
    public void run() {
        frame = new JFrame("Game title");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);       
    }
    
    private void luoKomponentit(Container container) {
        frame.setLayout(new GridLayout(4,1));
        frame.setBackground(Color.BLACK);
        JButton start = new JButton("New Game");
        JButton continueSaved = new JButton("Continue");
        JButton settings = new JButton("Settings");
        JButton quit = new JButton("Quit");
        frame.add(start);
        frame.add(continueSaved);
        frame.add(settings);
        frame.add(quit);
        start.setBackground(Color.black);
        start.setForeground(Color.green);
        settings.setBackground(Color.black);
        settings.setForeground(Color.green);
        continueSaved.setBackground(Color.black);
        continueSaved.setForeground(Color.green);
        quit.setBackground(Color.black);
        quit.setForeground(Color.green);
        MenuKuuntelija kuuntelija = new MenuKuuntelija(this, setting, start, settings, quit);        
        
        start.addActionListener(kuuntelija);
        settings.addActionListener(kuuntelija);
        quit.addActionListener(kuuntelija);
    }
    
    public JFrame getFrame() {
        return frame;
    }   
    
    public void asetaNakymattomaksi() {
        frame.setVisible(false);
    }
    
    public void asetaNakyvaksi() {
        frame.setVisible(true);
    }    
}
