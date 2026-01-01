package gui;

/**
 * Clase de botón RGB (JFrame) para la personalización de color y 
 * caracteristicas del tema.
 * Los eventos son manipulados mediante ActionListener.
 * 
 * La clase no requiere parámetro alguno para ser invocada.

 * @author ESRG
 */
// COMPONENTES DE INTERFAZ GRÁFICA (SWING)

import javax.swing.JFrame;        // Ventana principal del panel de control
import javax.swing.ImageIcon;     // Para cargar el icono de la aplicación (bintary_icon)
import javax.swing.JLabel;        // Etiquetas de texto (títulos y nombres de tabla)
import javax.swing.JTextField;    // Campo de entrada de datos para el usuario
import javax.swing.JButton;       // Botones de navegación y ejecución
import javax.swing.JTextArea;     // Áreas de texto (Terminal y panel de entrada)
import javax.swing.UIManager;     // Para gestionar el "Look and Feel" y colores globales
import javax.swing.BorderFactory; // Para crear los bordes personalizados (MatteBorder)

// GESTIÓN DE EVENTOS Y ESCUCHADORES (AWT & SWING)
import java.awt.event.KeyAdapter;   // Adaptador para simplificar la escucha de teclado
import java.awt.event.KeyEvent;     // Objeto del evento de pulsación de tecla
import java.awt.event.ActionListener; // Detectar clics en botones y menús
import java.awt.event.ActionEvent;    // Objeto del evento de acción ejecutada

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT)
import java.awt.Cursor;           // Cambiar el puntero a tipo "Mano" (Hand Cursor)
import java.awt.Font;             // Definición de fuentes (Consolas, negritas, tamaños)
import java.awt.Color;            // Manejo de colores RGB para el tema

// LÓGICA PROPIA DEL PROYECTO (PAQUETES att Y act)
import att.AppearanceSettings;    // Configuración dinámica de colores y temas
import act.WindowLoader;          // Cargador de ventanas y diálogos secundarios
import act.MainControlHandler;    // Manejador para limpiar y restablecer la UI

public class AppearanceSettingsEditor extends JFrame {

    // Instancia de configuración y personalización del tema
    AppearanceSettings custom = new AppearanceSettings();

    // Instancia para la invocación de nuevas ventanas de interacción.
    WindowLoader window = new WindowLoader();
    
    // Instancia para la actividad de estado y apariencia del panel de control.
    MainControlHandler event = new MainControlHandler();

    /**
     * Contructor de la clase: Botón RGB
     * Inicializa los componentes de interacción; configuración y
     * visialización de de la interfaz gráfica. 
     */ 
    public AppearanceSettingsEditor() {
        setTitle("Bintary Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(custom.BackgroundColor());
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());

        // Configuración del color de selección de los botones, asociado con el tema de pérsonalización.
        UIManager.put("Button.select", custom.SelectionColor());

        setLayout(null);
        initComponents1();
    }

    /**
     * Inicializa los componentes de la interfaz, incluyendo campos de texto para RGB,
     * áreas de previsualización de color y botones de acción.
     * Implementa validaciones para asegurar que los valores ingresados estén 
     * dentro del rango permitido (0-255).
     */
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
        
        // Configuración y eventos asociados en el botón "Aplicar". Disponible para aplicar la mezcla
        // del color buscado.        
        bttnApply = new JButton("Aplicar");
        bttnApply.setBounds(50, 205, 175, 27);
        bttnApply.setBackground(custom.color());
        bttnApply.setFont(new Font("Consolas", 0, 14));
        bttnApply.setForeground(custom.BackgroundColor());
        // Establece el cursor de mano (HAND_CURSOR = 12)
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
                       
                        event.closeAllWindows();
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
        
        // Configuración y eventos asociados en el botón "Mezclar". Disponible para mezclar y previsualizar
        // el color buscado.
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
        
        // Configuración y eventos asociados en el botón "Restablecer tema". Disponible para restablecer
        // la selección y color predeterminado del sistema.
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
        
        // Configuración y eventos asociados en el botón "Cerrar". Disponible para cerrar
        // la ventana: Botón RGB (dispose) 
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
