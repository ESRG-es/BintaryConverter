package gui;

/**
 *
 * @author ESRG
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

import att.SystemInfo;
import act.WindowLoader;
import att.AppearanceSettings;

public class AboutDialog extends JFrame {

    AppearanceSettings custom = new AppearanceSettings();
    SystemInfo info = new SystemInfo();
    WindowLoader window = new WindowLoader();    

    public AboutDialog() {

        setTitle("Bintary Converter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(custom.BackgroundColor());
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        
        UIManager.put("Button.select", custom.SelectionColor());

        setLayout(null);
        initComponents();
    }

    private void initComponents() {
 
        JLabel lblTitle1 = new JLabel("Converter");
        lblTitle1.setBounds(20, 11, 500, 20);
        lblTitle1.setFont(new java.awt.Font("Consolas", 1, 14));
        lblTitle1.setForeground(custom.color());
        add(lblTitle1);
        JLabel lblTitle2 = new JLabel("Bintary");
        lblTitle2.setBounds(20, 28, 500, 35);
        lblTitle2.setFont(new java.awt.Font("Consolas", 1, 33));
        lblTitle2.setForeground(custom.color());
        add(lblTitle2);

        JLabel lblTitleInfo = new JLabel("Información");
        lblTitleInfo.setBounds(180, 25, 500, 35);
        lblTitleInfo.setFont(new java.awt.Font("Consolas", 1, 23));
        lblTitleInfo.setForeground(custom.HighlightColor());
        add(lblTitleInfo);

        JLabel lblVersion = new JLabel("Versión                  " + info.versionSystem());
        lblVersion.setBounds(20, 70, 500, 20);
        lblVersion.setFont(new java.awt.Font("Consolas", 1, 13));
        lblVersion.setForeground(custom.HighlightColor());
        add(lblVersion);
        
        JLabel lblVesionName = new JLabel("Nombre de versión        " + info.nameVersionSystem());
        lblVesionName.setBounds(20, 85, 500, 20);
        lblVesionName.setFont(new java.awt.Font("Consolas", 1, 13));
        lblVesionName.setForeground(custom.HighlightColor());
        add(lblVesionName);

        JLabel lblWork = new JLabel("Número de obra           " + info.workSystem());
        lblWork.setBounds(20, 100, 500, 20);
        lblWork.setFont(new java.awt.Font("Consolas", 1, 13));
        lblWork.setForeground(custom.HighlightColor());
        add(lblWork);

        JLabel lblCreatedBy = new JLabel("Desarrollado por         ESRG");
        lblCreatedBy.setBounds(20, 115, 500, 20);
        lblCreatedBy.setFont(new java.awt.Font("Consolas", 1, 13));
        lblCreatedBy.setForeground(custom.HighlightColor());
        add(lblCreatedBy);

        JLabel lblSupport = new JLabel("Soporte y ayuda          esrg.es@gmail.com");
        lblSupport.setBounds(20, 130, 500, 20);
        lblSupport.setFont(new java.awt.Font("Consolas", 1, 13));
        lblSupport.setForeground(custom.HighlightColor());
        add(lblSupport);

        JButton bttnDispose = new javax.swing.JButton("Cerrar");
        bttnDispose.setBounds(20, 185, 166, 25);
        bttnDispose.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnDispose.setBackground(custom.color());
        bttnDispose.setForeground(custom.BackgroundColor());
        bttnDispose.setFocusable(false);
        bttnDispose.setCursor(Cursor.getPredefinedCursor(12));
        bttnDispose.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color()));
        bttnDispose.addActionListener((ActionEvent ev) -> {
            dispose();
        });
        add(bttnDispose);

        JButton bttnLicense = new JButton("Licencia de uso");
        bttnLicense.setBounds(188, 185, 166, 25);
        bttnLicense.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnLicense.setBackground(custom.BackgroundColor());
        bttnLicense.setCursor(Cursor.getPredefinedCursor((12)));
        bttnLicense.setFocusable(false);
        bttnLicense.setForeground(custom.color());
        bttnLicense.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev){
                window.guiLicenseDialog();
            }
        });
        bttnLicense.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color()));
        add(bttnLicense);
    }
}
