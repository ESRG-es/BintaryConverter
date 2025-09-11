
package gui;

/**
 *
 * @author ESRG
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import att.AppearanceSettings;


public class MessagePopup extends JFrame{
    
    AppearanceSettings custom = new AppearanceSettings();
    
    String title, message;
    
    public MessagePopup(String title, String message){
        setTitle(title);
        getContentPane().setBackground(custom.BackgroundColor());
        setType(Type.UTILITY);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        UIManager.put("Button.select", custom.SelectionColor());
        
        this.title = title;
        this.message = message;
        
        setLayout(null);
            initComponents();            
    }
    
    private void initComponents(){
        javax.swing.JTextArea area = new  javax.swing.JTextArea("\n  " + message);
        area.setEditable(false);
        area.setBounds(0,0,314,112);
        area.setBorder(javax.swing.BorderFactory.createLineBorder(custom.SelectionColor(), 2));
        area.setSelectedTextColor(custom.HighlightColor());
        area.setSelectionColor(custom.BackgroundColor());
        area.setCaretColor(custom.BackgroundColor());
        area.setForeground(custom.HighlightColor());
        area.setBackground(custom.BackgroundColor());
        area.setCursor(Cursor.getPredefinedCursor(0));
        area.setFont(new java.awt.Font("Courier New", 1, 12));            
        add(area);

        JButton bttnDispose = new javax.swing.JButton("Cerrar");
        bttnDispose.setBounds(10,80,294,20);
        bttnDispose.setBackground(custom.color());
        bttnDispose.setForeground(custom.BackgroundColor());
        bttnDispose.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color()));     
        bttnDispose.setFocusable(false);
        bttnDispose.setFont(new java.awt.Font("Courier New", 1, 12));
        bttnDispose.setCursor(Cursor.getPredefinedCursor(12));
        bttnDispose.addActionListener((ActionEvent ev) -> {
            dispose();
        });
        area.add(bttnDispose);
    }
}
