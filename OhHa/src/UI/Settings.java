
package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 * A menu for changing game difficulty
 * @author Mertaset
 */
public class Settings implements Runnable {

    private JFrame frame;
    private int difficulty;
    
    public Settings() {
        this.difficulty = 1;
    }

    @Override
    public void run() {
        frame = new JFrame("Settings");
        frame.setPreferredSize(new Dimension(150, 250));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);        
    }
    
    private void luoKomponentit(Container container) {
        frame.setLayout(new GridLayout(2,1));
        frame.setBackground(Color.black);
        JRadioButton normal = new JRadioButton("Easy");
        JRadioButton challenging = new JRadioButton("Normal");
        JRadioButton hard = new JRadioButton("Hard");
        ButtonGroup ryhma = new ButtonGroup();
        ryhma.add(normal);
        ryhma.add(challenging);
        ryhma.add(hard);
        normal.setForeground(Color.green);
        challenging.setForeground(Color.green);
        hard.setForeground(Color.green);
        normal.setBackground(Color.black);
        challenging.setBackground(Color.black);
        hard.setBackground(Color.black);
        JLabel dif = new JLabel("Difficulty:");
        dif.setForeground(Color.green);
        frame.add(this.difficulty(dif, normal, challenging, hard));
        JButton exit = new JButton("Back");
        frame.add(exit);
        exit.setBackground(Color.black);
        exit.setForeground(Color.green);
        SettingsListener kuuntelija = new SettingsListener(this, normal, challenging, hard, exit);
        normal.addActionListener(kuuntelija);
        challenging.addActionListener(kuuntelija);
        hard.addActionListener(kuuntelija);
        exit.addActionListener(kuuntelija);
        normal.setSelected(true);
    }
    
    private JPanel difficulty(JLabel label, JRadioButton normal, JRadioButton challenging, JRadioButton hard) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.add(label);
        panel.add(normal);
        panel.add(challenging);
        panel.add(hard);        
        return panel;
    }
    
    public void setDifficulty(int difficulty13) {
        this.difficulty = difficulty13;
    }
    
    public int getDifficulty() {
        return this.difficulty;
    }
    
    public void asetaNakymattomaksi() {
        frame.setVisible(false);
    }
    
    public void asetaNakyvaksi() {
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
