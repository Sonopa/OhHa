
package ohha;

import UI.Settings;
import javax.swing.SwingUtilities;
import UI.Menu;

public class OhHa {

    public static void main(String[] args) {
        Settings settings = new Settings();
        Menu menu = new Menu(settings);
        SwingUtilities.invokeLater(menu);     
    }
}
