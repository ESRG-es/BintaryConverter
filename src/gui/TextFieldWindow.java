
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
import javax.swing.BorderFactory; // Para crear los bordes personalizados (MatteBorder)
import javax.swing.ImageIcon;     // Para cargar el icono de la aplicación (bintary_icon)
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;   // Contenedor con barras de desplazamiento para la terminal
import javax.swing.JTextArea;     // Áreas de texto (Terminal y panel de entrada)
import javax.swing.LookAndFeel;
import javax.swing.UIManager;     // Para gestionar el "Look and Feel" y colores globales

// GESTIÓN DE EVENTOS Y ESCUCHADORES
import java.awt.event.ActionListener;   // Detectar clics en botones y menús
import java.awt.event.ActionEvent;      // Objeto del evento de acción ejecutada

import java.io.File;                    // 
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT & SWING PLAF)
import java.awt.Color;       // Manejo de colores RGB para el tema
import java.awt.Cursor;      // Cambiar el puntero a tipo "Mano" (Hand Cursor)
import java.awt.Font;        // Definición de fuentes (Consolas, negritas, tamaños)

// LÓGICA PROPIA DEL PROYECTO (PAQUETE att)
import att.AppearanceSettings;    // Configuración dinámica de colores y temas


public class TextFieldWindow extends JFrame implements ActionListener{
    
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
    private JTextArea txtFieldText;
    private JMenuItem itmInput, itmOutput;
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

                itmInput = new JMenuItem("Abrir                         ");
                itmInput.setForeground(custom.color());
                itmInput.setBackground(custom.BackgroundColor());
                itmInput.setFont(new Font("Consolas", 0, 11));
                itmInput.setCursor(Cursor.getPredefinedCursor(12));
                itmInput.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
                itmInput.addActionListener(this);
                //itmInput.setEnabled(false);            
                mnuFile.add(itmInput);

                itmOutput = new JMenuItem("Guardar");
                itmInput.setForeground(custom.color());
                itmOutput.setBackground(custom.BackgroundColor());
                itmOutput.setFont(new Font("Consolas", 0, 11));
                itmOutput.setCursor(Cursor.getPredefinedCursor(12));
                itmOutput.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
                itmOutput.addActionListener(this);
                //itmOutput.setEnabled(false);            
                mnuFile.add(itmOutput);

        txtFieldText = new javax.swing.JTextArea();
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

    @Override
    public void actionPerformed(ActionEvent ev){

        // Guarda el LookAndFeel actual y por estandar del sistema
        LookAndFeel lookAndFeelActual = UIManager.getLookAndFeel();
        // Cambia el LookandFeel estandar por el del sistema operativo.
        // Necesario para el Chooser (Gestor de archivos)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.print(e);
        }

        // Nuevo Chooser para cargar un fichro.
        JFileChooser chooser = new JFileChooser();
        // Titulo de la ventana del Chooser
        chooser.setDialogTitle("Explorador de archivos");
        // Añadir opción de filtrado de extensión. (Muestra al usuario que tipo de archivo de trabaja)
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos TXT", "txt"));

         // Configuración y cambio del icono de las ventanas de interacción de Gestor de Archivos (Chooser)
         // Creación de la Image para establecera en el Choosetr.
         java.awt.Image iconoChooser = new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage();
         UIManager.put("FileChooser.icon", new ImageIcon(iconoChooser));
        
        if(ev.getSource() == itmInput){
            // Retorna el resultado de la interacción con el chooser en un valor numérico.
            // Muestra el Chooser.
            int returnFile = chooser.showOpenDialog(TextFieldWindow.this);

            // Valida el valor retornado del Chooser.
            // El valor de entrada de la condición en la aprovación del Chooser.
            if(returnFile == JFileChooser.APPROVE_OPTION){
                File selectedFile = chooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                try {
                    String credential = Files.readString(java.nio.file.Paths.get(path));			
                    txtFieldText.setText(credential);
                } catch(IOException er){
                    System.out.println("Error : " + er + "\n");
                }
                
            }
            
        }

        if(ev.getSource() == itmOutput){        
            
            // Retorna el resultado de la interacción con el chooser en un valor numérico.
            // Muestra el Chooser.
            int returnFile = chooser.showSaveDialog(TextFieldWindow.this);

            // Valida el valor retornado del Chooser.
            // El valor de entrada de la condición en la aprovación del Chooser.
            if(returnFile == JFileChooser.APPROVE_OPTION){

                // Selección del fichero retornado desde el CHooser
                File selectedFile = chooser.getSelectedFile();
                // Aignación de la extensión del fichero. Por estandar es un Documento de texto (.txt)
                // Puede ser ajutada desde una configuración más avanzada desde la caja de comandos.
                selectedFile = new File(selectedFile + ".txt");
                
                // Creación del fichero con sus caracteristicas definidas. 
                try (FileWriter writer = new FileWriter((selectedFile))){
                    writer.write(txtFieldText.getText());
                    
                } catch (IOException e) {
                    System.err.print(e);
                }
            }
        }

        // REstablece el LookAndFeel del sistema operativo al estandar del sistema de Bintary..
            try {
                UIManager.setLookAndFeel(lookAndFeelActual);
            } catch(Exception er){
                System.err.println("Error " + er);
            }
    }
}
