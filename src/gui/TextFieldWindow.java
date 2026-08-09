
package gui;

/**
 * Clase para la creación de ventana de un campo de texto flotante.
 * Muestra un campo de texto en una ventana flotante.
 * 
 *  Para crear una instancia de la clase, se debe usar el siguiente constructor:
 * `new TextFieldWindow();`
 *
 * @author ESRG
 */

// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;        // Clase base para la creación y gestión de la ventana.
import javax.swing.JMenu;        // Menús desplegables (Opciones, Temas, etc.)
import javax.swing.JMenuItem;    // Elementos individuales dentro de los menús
import javax.swing.JMenuBar;     // Barra superior que contiene los menús
import javax.swing.Action;
import javax.swing.BorderFactory; // Para crear los bordes personalizados (MatteBorder)
import javax.swing.ImageIcon;     // Para cargar el icono de la aplicación (bintary_icon)
import javax.swing.JScrollPane;   // Contenedor con barras de desplazamiento para la terminal
import javax.swing.JTextArea;     // Áreas de texto (Terminal y panel de entrada)

// GESTIÓN DE EVENTOS Y ESCUCHADORES
import java.awt.event.ActionListener;   // Detectar clics en botones y menús
import java.awt.event.ActionEvent;      // Objeto del evento de acción ejecutada

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT & SWING PLAF)
import java.awt.Color;       // Manejo de colores RGB para el tema
import java.awt.Cursor;      // Cambiar el puntero a tipo "Mano" (Hand Cursor)
import java.awt.Font;        // Definición de fuentes (Consolas, negritas, tamaños)

// LÓGICA PROPIA DEL PROYECTO (PAQUETE att)
import att.AppearanceSettings;    // Configuración dinámica de colores y temas


public class TextFieldWindow extends JFrame{
    
    // Instancia de configuración de personalización
    AppearanceSettings custom = new AppearanceSettings();
    
    /**
     * Constructor de la clase: Ventana flontante.
     * 
     * Inicializa las propiedades y configuración de visualización de la ventana.
     * Inicializa titulo y historial y resultados en el area de información.
     */ 
    public TextFieldWindow(){
        
        setTitle("Bintary Converter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        getContentPane().setBackground(custom.BackgroundColor());
        
        initComponents();
    }
    
    /**
     * Inicializa los componentes de interacción de la ventana flotante.
     * Configura el menú de interacción para la importación y exportación de ficheros .txt
     * Configura el área para el texto.
     */
    private void initComponents(){
        JMenuBar mnuBar = new JMenuBar();
        mnuBar.setBackground(custom.color());
        mnuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, custom.color()));
        mnuBar.setCursor(Cursor.getPredefinedCursor(12));
        setJMenuBar(mnuBar);

            // Submenú de temas: Contiene opciones de importar y exportar un fichero en formato .txt
            JMenu mnuFile = new JMenu("Archivo");
            mnuFile.setFont(new Font("Consolas", 0, 11));
            mnuFile.setForeground(custom.BackgroundColor());
            mnuBar.add(mnuFile);

                JMenuItem itmInput = new JMenuItem("Abrir                         ");
                itmInput.setForeground(custom.color());
                itmInput.setBackground(custom.BackgroundColor());
                itmInput.setFont(new Font("Consolas", 0, 11));
                itmInput.setCursor(Cursor.getPredefinedCursor(12));
                itmInput.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
                itmInput.addActionListener((ActionEvent ev) -> {
                    
                });
                //itmInput.setEnabled(false);            
                mnuFile.add(itmInput);

                JMenuItem itmOutput = new JMenuItem("Guardar");
                itmInput.setForeground(custom.color());
                itmOutput.setBackground(custom.BackgroundColor());
                itmOutput.setFont(new Font("Consolas", 0, 11));
                itmOutput.setCursor(Cursor.getPredefinedCursor(12));
                itmOutput.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
                itmOutput.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ev){
                        
                    }
                });
                //itmOutput.setEnabled(false);            
                mnuFile.add(itmOutput);

        JTextArea txtFieldText = new javax.swing.JTextArea();
        JScrollPane sclFieldText = new javax.swing.JScrollPane(txtFieldText);
        sclFieldText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        sclFieldText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sclFieldText.setBorder(javax.swing.BorderFactory.createMatteBorder(1,4,1,1, custom.color()));        
        txtFieldText.setBackground(custom.BackgroundColor());
        txtFieldText.setFont(new java.awt.Font("Consolas", 1, 14));
        txtFieldText.setForeground(custom.HighlightColor());
        txtFieldText.setSelectedTextColor(Color.WHITE);
        txtFieldText.setSelectionColor(custom.SelectionColor());
        txtFieldText.setCaretColor(custom.color());
        //txtFieldText.setEditable(false);
        add(sclFieldText);
    }
}
