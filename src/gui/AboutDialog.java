package gui;

/**
 * Clase panel de información de software (JFrame). Encuentra información como:
 * Versión, nombre de versión, número de obra, desarrollador y soporte.
 * 
 * Los eventos son manipulados mediante ActionListener.
 * 
 * La clase no requiere parámetro alguno para ser invocada.
 * 
 * @author ESRG
 */
// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;        // Ventana principal del panel de control
import javax.swing.JButton;       // Botones de navegación y ejecución
import javax.swing.JLabel;        // Etiquetas de texto (títulos y nombres de tabla)
import javax.swing.UIManager;     // Para gestionar el "Look and Feel" y colores globales
import javax.swing.ImageIcon;     // Para cargar el icono de la aplicación (bintary_icon)

// GESTIÓN DE EVENTOS Y ESCUCHADORES (AWT)
import java.awt.event.ActionListener; // Detectar clics en botones y menús
import java.awt.event.ActionEvent;    // Objeto del evento de acción ejecutada

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT)
import java.awt.Cursor;           // Cambiar el puntero a tipo "Mano" (Hand Cursor)

// LÓGICA PROPIA DEL PROYECTO (PAQUETES att Y act)
import att.SystemInfo;            // Información de versión y sistema
import act.WindowLoader;          // Cargador de ventanas y diálogos secundarios
import att.AppearanceSettings;    // Configuración dinámica de colores y temas

public class AboutDialog extends JFrame {

    // Instancia de configuración y personalización del tema
    AppearanceSettings custom = new AppearanceSettings();

    // Instancia para la información del sistema completo.
    SystemInfo info = new SystemInfo();

    // Instancia para la invocación de nuevas ventanas de interacción.
    WindowLoader window = new WindowLoader();    

    /**
     * Constructor de la clase: Panel de información del software.
     * Inicializa la configuración y propiedades de la interfaz gráfica y sus
     * componentes de interacción.
     */ 
    public AboutDialog() {

        setTitle("Bintary Converter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(custom.BackgroundColor());
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        
        // Configuración para personalizar el color de selección de los botones.
        UIManager.put("Button.select", custom.SelectionColor());

        setLayout(null);
        initComponents();
    }

    /**
     * inicializa los componentes de interacción de la ventana de información de software:
     * Etiquetas de descripción de información del software.
     */
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

        // Configuración y eventos asociados en el botón "Cerrar". Disponible para cerrar
        // la ventana de información (dispose) 
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

        // Configuración y eventos asociados en el botón "Licencia de uso". Disponible para abrir
        // la ventana de términos y condiciones 
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
