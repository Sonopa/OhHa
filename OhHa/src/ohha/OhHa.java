
package ohha;

import javax.swing.SwingUtilities;
import menu.Menu;
import menu.Settings;

public class OhHa {

    public static void main(String[] args) {
        Settings settings = new Settings();
        Menu menu = new Menu(settings);
        SwingUtilities.invokeLater(menu);     
    }
}
