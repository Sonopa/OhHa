
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class SettingsListener implements ActionListener {
    private Settings setting;
    private JRadioButton normal;
    private JRadioButton challenging;
    private JRadioButton hard;     
    private JButton exit;
    
    public SettingsListener(Settings setting, JRadioButton normal, JRadioButton chal, JRadioButton hard, JButton exit) {
        this.setting = setting;
        this.normal = normal;
        this.challenging = chal;
        this.hard = hard;
        this.exit = exit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == normal) {
            setting.setDifficulty(0);
        }else if (ae.getSource() == challenging) {            
            setting.setDifficulty(1);
        }else if (ae.getSource() == hard) {
            setting.setDifficulty(2);
        }else if (ae.getSource() == exit) {
            setting.asetaNakymattomaksi();
        }
    }
}
