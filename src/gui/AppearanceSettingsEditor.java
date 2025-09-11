package gui;

/**
 *
 * @author ESRG
 */
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;

import att.AppearanceSettings;
import act.WindowLoader;

public class AppearanceSettingsEditor extends JFrame {

    AppearanceSettings custom = new AppearanceSettings();
    WindowLoader window = new WindowLoader();

    public AppearanceSettingsEditor() {
        setTitle("Bintary Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(custom.BackgroundColor());
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());

        UIManager.put("Button.select", custom.SelectionColor());

        setLayout(null);
        initComponents1();
    }

    protected JButton bttnApply;
    private void initComponents1() {
        
        JTextArea area0 = new JTextArea();
        area0.setBounds(0, 0, 40, 261);
        area0.setEditable(false);
        area0.setCaretColor(custom.color());
        area0.setBackground(custom.color());
        add(area0);        

        JLabel lbl_title = new JLabel("Personalizar");
        lbl_title.setBounds(50, 30, 500, 30);
        lbl_title.setForeground(custom.color());
        lbl_title.setFont(new Font("Consolas", 1, 30));
        add(lbl_title);
        
            JLabel lbl_red = new JLabel("R");
            lbl_red.setBounds(50, 75, 35, 30);
            lbl_red.setForeground(new Color(10,10,10));
            lbl_red.setFont(new Font("Consolas", 0, 12));
            add(lbl_red);
            
                JTextField fld_red = new JTextField("" + custom.redColor);
                fld_red.setBounds(75, 75, 150, 25);        
                //fld_red.setCursor(Cursor.getPredefinedCursor(12));
                fld_red.setFont(new Font("Consolas", 0, 12));        
                fld_red.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (new Color(200,0,0))));
                fld_red.setBackground(custom.BackgroundColor());
                fld_red.setSelectionColor(custom.SelectionColor());
                fld_red.setSelectedTextColor(custom.BackgroundColor());
                fld_red.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {     
                        bttnApply.setEnabled(false);
                    }
                });
                fld_red.setHorizontalAlignment(JTextField.CENTER);
                add(fld_red);
                
            JLabel lbl_green = new JLabel("G");
            lbl_green.setBounds(50, 105, 35, 30);
            lbl_green.setForeground(new Color(10,10,10));
            lbl_green.setFont(new Font("Consolas", 0, 12));
            add(lbl_green);
            
                JTextField fld_green = new JTextField("" + custom.greenColor);
                fld_green.setBounds(75, 105, 150, 25);        
                //fld_green.setCursor(Cursor.getPredefinedCursor(12));
                fld_green.setFont(new Font("Consolas", 0, 12));        
                fld_green.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (new Color(0,200,0))));
                fld_green.setBackground(custom.BackgroundColor());
                fld_green.setSelectionColor(custom.SelectionColor());
                fld_green.setSelectedTextColor(custom.BackgroundColor());
                fld_green.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {     
                        bttnApply.setEnabled(false);
                    }
                });
                fld_green.setHorizontalAlignment(JTextField.CENTER);
                add(fld_green);
                
            JLabel lbl_blue = new JLabel("B");
            lbl_blue.setBounds(50, 135, 35, 30);
            lbl_blue.setForeground(new Color(10,10,10));
            lbl_blue.setFont(new Font("Consolas", 0, 12));
            add(lbl_blue);
            
                JTextField fld_blue = new JTextField("" + custom.blueColor);
                fld_blue.setBounds(75, 135, 150, 25);        
                //fld_blue.setCursor(Cursor.getPredefinedCursor(12));
                fld_blue.setFont(new Font("Consolas", 0, 12));        
                fld_blue.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (new Color(0,0,200))));
                fld_blue.setBackground(custom.BackgroundColor());
                fld_blue.setSelectionColor(custom.SelectionColor());
                fld_blue.setSelectedTextColor(custom.BackgroundColor());
                fld_blue.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {     
                        bttnApply.setEnabled(false);
                    }
                });
                fld_blue.setHorizontalAlignment(JTextField.CENTER);
                add(fld_blue);
                
        bttnApply = new JButton("Aplicar");
        bttnApply.setBounds(50, 205, 175, 27);
        bttnApply.setBackground(custom.color());
        bttnApply.setFont(new Font("Consolas", 0, 14));
        bttnApply.setForeground(custom.BackgroundColor());
        bttnApply.setCursor(Cursor.getPredefinedCursor(12));
        bttnApply.setBorder(BorderFactory.createLineBorder(custom.color()));
        bttnApply.setEnabled(false);
        bttnApply.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent ev){              
                try {                                            
                        int red  = Integer.parseInt(fld_red.getText().trim());
                        int green =  Integer.parseInt(fld_green.getText().trim());
                        int blue =    Integer.parseInt(fld_blue.getText().trim());
                        
                        custom.customColor(red, green, blue);
                        custom.customSelectionColor(red, green, blue);
                        custom.customBackgroundColor(238, 238, 238);
                        custom.customHighlightColor(0, 0, 0);
                       
                        dispose();
                        window.guiMainControlPanel();
                                           
                } catch (NumberFormatException e) {
                    window.guiMessagePopup("Sin retornar",
                            "Ingrese solo valores numéricos.");
                }
            }
        });
        bttnApply.setFocusable(false);
        add(bttnApply);
        
        JTextArea area1 = new JTextArea();
        area1.setBounds(243, 80, 150, 75);
        area1.setEditable(false);
        area1.setCaretColor(custom.color());
        area1.setBackground(custom.color());
        area1.setCursor(Cursor.getPredefinedCursor(1));
        add(area1);
        
        JButton bttnPaint = new JButton("Mezclar");
        bttnPaint.setBounds(50, 175, 175, 27);
        bttnPaint.setBackground(custom.BackgroundColor());
        bttnPaint.setFont(new Font("Consolas", 0, 14));
        bttnPaint.setCursor(Cursor.getPredefinedCursor(12));
        bttnPaint.setForeground(custom.color());
        bttnPaint.setBorder(BorderFactory.createLineBorder(custom.color()));
        bttnPaint.addActionListener((ActionEvent ev) -> {
            
                try {
                    if (Integer.parseInt(fld_red.getText().trim()) < 256 && Integer.parseInt(fld_red.getText().trim()) >= 0
                            && Integer.parseInt(fld_green.getText().trim()) < 256 && Integer.parseInt(fld_green.getText().trim()) >= 0
                            && Integer.parseInt(fld_blue.getText().trim()) < 256 && Integer.parseInt(fld_blue.getText().trim()) >= 0) {

                        int red = Integer.parseInt(fld_red.getText().trim());
                        int green = Integer.parseInt(fld_green.getText().trim());
                        int blue = Integer.parseInt(fld_blue.getText().trim());

                        area1.setBackground(new Color(red,green,blue));

                        bttnApply.setEnabled(true);
                    } else {
                        window.guiMessagePopup("Valor no permitido",
                                "Cantidad máxima: 255\n  Cantidad mínima: 0");
                        bttnApply.setEnabled(false);
                    }

                } catch (NumberFormatException e) {
                    window.guiMessagePopup("Sin retornar",
                            "Ingrese solo valores numéricos.");
                    bttnApply.setEnabled(false);
                }
            
        });
        bttnPaint.setFocusable(false);
        add(bttnPaint);
        
        JButton bttnRestart = new JButton("Restablecer tema");
        bttnRestart.setBounds(230, 175, 175, 27);
        bttnRestart.setBackground(custom.BackgroundColor());
        bttnRestart.setFont(new Font("Consolas", 0, 14));
        bttnRestart.setForeground(custom.color());
        bttnRestart.setBorder(BorderFactory.createLineBorder(custom.color()));
        bttnRestart.setCursor(Cursor.getPredefinedCursor(12));
        bttnRestart.addActionListener((ActionEvent ev) -> {
            //custom.number_theme(1);
            custom.customColor(28, 72, 67);
            custom.customSelectionColor(13, 38, 36);
            dispose();
            window.guiAppearanceSettingsEditor();
        });
        bttnRestart.setFocusable(false);
        add(bttnRestart);
        
        JButton bttnCancel = new JButton("Cancelar");
        bttnCancel.setBounds(230, 205, 175, 27);
        bttnCancel.setBackground(custom.color());
        bttnCancel.setFont(new Font("Consolas", 0, 14));
        bttnCancel.setForeground(custom.BackgroundColor());
        bttnCancel.setBorder(BorderFactory.createLineBorder(custom.color()));
        bttnCancel.setCursor(Cursor.getPredefinedCursor(12));
        bttnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                dispose();
                window.guiMainControlPanel();
            }
        });
        bttnCancel.setFocusable(false);
        add(bttnCancel);
    }
}
