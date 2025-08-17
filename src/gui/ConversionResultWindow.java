
package gui;

/**
 *
 * @author ESRG
 */

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

import att.AppearanceSettings;

public class ConversionResultWindow extends JFrame{
    
    AppearanceSettings custom = new AppearanceSettings();
    
    private String history;
    
    public ConversionResultWindow(String history){
        
        setTitle("Bintary Converter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        getContentPane().setBackground(custom.BackgroundColor());
        
        this.history = history;
           
            initComponents();
    }
    
    private void initComponents(){
        JTextArea txtOutput = new javax.swing.JTextArea(history);
        JScrollPane srlOutput = new javax.swing.JScrollPane(txtOutput);
        srlOutput.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        srlOutput.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        srlOutput.setBorder(javax.swing.BorderFactory.createMatteBorder(1,4,1,1, custom.color()));        
        txtOutput.setBackground(custom.BackgroundColor());
        txtOutput.setFont(new java.awt.Font("Consolas", 1, 12));
        txtOutput.setForeground(custom.HighlightColor());
        txtOutput.setSelectedTextColor(Color.WHITE);
        txtOutput.setSelectionColor(custom.SelectionColor());
        txtOutput.setCaretColor(custom.BackgroundColor());
        txtOutput.setEditable(false);
        add(srlOutput);
    }
}
