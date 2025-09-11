package act;

/**
 *
 * @author ESRG
 */
import javax.swing.JFrame;

import att.AppearanceSettings;
import gui.MainControlPanel;

public class MainControlHandler extends JFrame {

    AppearanceSettings custom = new AppearanceSettings();

    public void modeComponentsNULL() {
        MainControlPanel.txtInputData.setLocation(-1000, -1000);
        MainControlPanel.txtControl.setLocation(-1000, -1000);
    }

    public void modeComponentsButtonNULL() {
        MainControlPanel.bttnStart.setBackground(custom.color());
        MainControlPanel.bttnStart.setForeground(java.awt.Color.white);

        MainControlPanel.bttnBinary.setBackground(custom.color());
        MainControlPanel.bttnBinary.setForeground(java.awt.Color.white);

        MainControlPanel.bttnWhole.setBackground(custom.color());
        MainControlPanel.bttnWhole.setForeground(java.awt.Color.white);
    }
}
