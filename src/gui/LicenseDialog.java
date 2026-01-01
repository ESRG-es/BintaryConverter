package gui;

/**
 * Clase para la licencia de uso y distribución (JFrame) personalizada para mostrar
 * los términos y condiciones, aceptar y rechazar las condiciones de uso.
 * Los eventos son manipulados mediante ActionListener.
 * 
 * La clase no requiere parámetro alguno para ser invocada.
 * 
 * @author ESRG
 */

// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;        // Clase base para la creación y gestión de la ventana.
import javax.swing.JLabel;        // Etiquetas de texto (títulos y nombres de tabla)
import javax.swing.JTextArea;     // Áreas de texto (Terminal y panel de entrada)
import javax.swing.JScrollPane;   // Contenedor con barras de desplazamiento para la terminal
import javax.swing.JButton;       // Botones de navegación y ejecución
import javax.swing.BorderFactory; // Para crear los bordes personalizados (MatteBorder)
import javax.swing.UIManager;     // Para gestionar el "Look and Feel" y colores globales
import javax.swing.ImageIcon;     // Para cargar el icono de la aplicación (bintary_icon)

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT)
import java.awt.Font;             // Definición de fuentes (Consolas, negritas, tamaños)
import java.awt.Cursor;           // Cambiar el puntero a tipo "Mano" (Hand Cursor)

// GESTIÓN DE EVENTOS Y ESCUCHADORES (AWT)
import java.awt.event.ActionEvent;  // Objeto del evento de acción ejecutada
import java.awt.event.ActionListener; // Detectar clics en botones y menús

// LÓGICA PROPIA DEL PROYECTO (PAQUETE att)
import att.SystemInfo;            // Información de versión y sistema
import att.AppearanceSettings;    // Configuración dinámica de colores y temas


public class LicenseDialog extends JFrame {

    // Instancia de configuración de personalización
    AppearanceSettings custom = new AppearanceSettings();

    // Instancia de información para el contenido de los términos y condiciones.
    SystemInfo info = new SystemInfo();

    /**
     * Contructor de la clase: Licencia de uso de Bintary Converter
     * Inicializa la configuración y propiedades de la ventana.
     * Inicializa los métodos para la contrucción de componentes de interacción.     
     */ 
    public LicenseDialog() {
        setTitle("Bintary Converter");
        getContentPane().setBackground(custom.BackgroundColor());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        
        // Configuración del color de selección para los botones de interacción, asociado
        // con el tema de personalización.
        UIManager.put("Button.select", custom.HighlightColor());

        setLayout(null);
        initComponents();
    }

    /**
     * inicializa los componentes de interacción de la ventana de licencia de uso.
     * Area de descripción y botones de aceptar y rechazar licencia.
     */ 
    private void initComponents() {

        // Titulos y detalles de ventana.
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
        
        // Area de informaicón: Licencia de uso (Términos y condiciones)
        JTextArea txtLicense = new JTextArea(info.licenceSystem());
        txtLicense.setEditable(false);
        txtLicense.setCaretColor(custom.BackgroundColor());
        txtLicense.setSelectionColor(custom.BackgroundColor());
        txtLicense.setSelectedTextColor(java.awt.Color.black);
        txtLicense.setForeground(custom.HighlightColor());
        txtLicense.setBackground(custom.BackgroundColor());
        txtLicense.setFont(new Font("Times New Roman", 1, 14));
        JScrollPane scrLicense = new JScrollPane(txtLicense);
        scrLicense.setBounds(10,70,510,242);
        //scrLicense.getVerticalScrollBar().setValue(0);
        scrLicense.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrLicense.setBorder(javax.swing.BorderFactory.createMatteBorder(1,0,1,0, custom.color()));        
        add(scrLicense);
        
        // Configuración y eventos asociados en el botón "Cerrar". Disponible para cerrar
        // la ventana de licencia (dispose) 
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
        
        // Configuración y eventos asociados en el botón "No acepto". Disponible para cerrar
        // el software definitivamente (System.exit(0)) 
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
