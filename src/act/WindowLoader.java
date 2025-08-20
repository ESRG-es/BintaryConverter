package act;

/**
 *
 * @author ESRG
 */

import javax.swing.JFrame;

import gui.*;

public class WindowLoader extends JFrame{
    
    public void guiMainControlPanel(){
        MainControlPanel window = new MainControlPanel();
        window.setBounds(0,0,603,400);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public void guiAboutDialog(){
        AboutDialog window = new AboutDialog();
        window.setSize(390,270);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public void guiLicenseDialog(){
        LicenseDialog window = new LicenseDialog();
        window.setSize(550,420);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public void guiMessagePopup(String title, String message){
        MessagePopup window = new MessagePopup(title, message);
        window.setSize(330,155);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public void guiAppearanceSettingsEditor(){
        AppearanceSettingsEditor window = new AppearanceSettingsEditor();
        window.setBounds(0, 0, 440, 300);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
    
    public void guiConversionResultWindow(String history){
        ConversionResultWindow window = new gui.ConversionResultWindow(history);
        window.setSize(603,400);
        window.setVisible(true);
        window.setResizable(true);
        window.setLocationRelativeTo(null);
    }

}
