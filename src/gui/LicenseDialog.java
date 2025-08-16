package gui;

/**
 *
 * @author ESRG
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import att.SystemInfo;
import att.AppearanceSettings;

public class LicenseDialog extends JFrame {

    AppearanceSettings custom = new AppearanceSettings();
    SystemInfo info = new SystemInfo();

    public LicenseDialog() {
        setTitle("Bintary Converter");
        getContentPane().setBackground(custom.BackgroundColor());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        
        UIManager.put("Button.select", custom.HighlightColor());

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

        JLabel lblTitleLicense = new JLabel("Términos y condiciones");
        lblTitleLicense.setBounds(180, 25, 500, 35);
        lblTitleLicense.setForeground(custom.HighlightColor());
        lblTitleLicense.setFont(new java.awt.Font("Consolas", 1, 23));
        add(lblTitleLicense);
        
        JTextArea txtLicense = new JTextArea(info.licenceSystem());
        //txtLicense.setEditable(false);
        //txtLicense.setCaretColor(custom.BackgroundColor());
        txtLicense.setSelectionColor(custom.BackgroundColor());
        txtLicense.setSelectedTextColor(java.awt.Color.black);
        txtLicense.setForeground(custom.HighlightColor());
        txtLicense.setBackground(custom.BackgroundColor());
        txtLicense.setFont(new Font("Consolas", 1, 14));
        JScrollPane scrLicense = new JScrollPane(txtLicense);
        scrLicense.setBounds(10,70,510,242);
        //scrLicense.getVerticalScrollBar().setValue(0);
        scrLicense.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrLicense.setBorder(javax.swing.BorderFactory.createMatteBorder(1,0,1,0, custom.color()));        
        add(scrLicense);
        
        JButton bttnDispose = new javax.swing.JButton("Cerrar");
        bttnDispose.setBounds(20, 333, 166, 25);
        bttnDispose.setFont(new java.awt.Font("Consolas", 1, 13)); 
        bttnDispose.setBackground(custom.color());
        bttnDispose.setForeground(java.awt.Color.white);
        bttnDispose.setFocusable(false);
        bttnDispose.setBorder(BorderFactory.createLineBorder(custom.color()));
        bttnDispose.setCursor(Cursor.getPredefinedCursor(12));
        bttnDispose.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev){
                dispose();
            }
        });
        add(bttnDispose);
        
        JButton bttnCancel = new JButton("No acepto");
        bttnCancel.setBounds(188, 333, 166, 25);
        bttnCancel.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnCancel.setBackground(custom.BackgroundColor());
        bttnCancel.setForeground(custom.color());
        bttnCancel.setFocusable(false);
        bttnCancel.setCursor(Cursor.getPredefinedCursor(12));
        bttnCancel.addActionListener((ActionEvent ev) ->{
            javax.swing.JOptionPane.showMessageDialog(null, "Lo siento...\nNo soy yo, eres tú. :-p");
            System.exit(0);
        });
        bttnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color(), 1));
        add(bttnCancel);
    }
}
