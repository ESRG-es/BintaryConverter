
package gui;

/**
 * Clase de información y acerca del Sistema binario (JFrame).
 * 
 * La clase no requiere parámetro alguno para ser invocada.
 * 
 * @author ESRG
 */

// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;        // Ventana principal del panel de control
import javax.swing.ImageIcon;     // Para cargar el icono de la aplicación (bintary_icon)
import javax.swing.JLabel;        // Etiquetas de texto (títulos y nombres de tabla)
import javax.swing.JTextArea;     // Áreas de texto (Terminal y panel de entrada)
import javax.swing.JScrollPane;   // Contenedor con barras de desplazamiento para la terminal
import javax.swing.JButton;       // Botones de navegación y ejecución

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT)
import java.awt.Dimension;        // Definición de dimensiones de componentes
import java.awt.Font;             // Definición de fuentes (Consolas, negritas, tamaños)
import java.awt.Color;            // Manejo de colores RGB para el tema

// LÓGICA PROPIA DEL PROYECTO (PAQUETE att)
import att.AppearanceSettings;    // Configuración dinámica de colores y temas
import att.BinaryInfo;            // Información y metadatos sobre procesos binarios

public class BinarySystemInfoWindow extends JFrame{
    
    // Instancia de configuración de personalización
    AppearanceSettings custom = new AppearanceSettings();
    
    /** Constructor de la clase en Java: Ventana de información del sistema binario.
     * inicializa la configuración y propiedades para la visualización de la interfaz de usuario.
     * Inicializa el campo de información con su respectiva información.
     */ 
    public BinarySystemInfoWindow(){
        setTitle("Bintary Converter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(custom.BackgroundColor());
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        
        setLayout(null);
            initComponents();
    }
    
    /**
     * inicializa los componentes de interacción de la ventana información del sistema binario
     * Titulo area y etiquetas de descripción e información..
     */ 
    private void initComponents(){
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

        JLabel lblTitleLicense = new JLabel("Sistema binario");
        lblTitleLicense.setBounds(180, 25, 500, 35);
        lblTitleLicense.setForeground(custom.HighlightColor());
        lblTitleLicense.setFont(new java.awt.Font("Consolas", 1, 23));
        add(lblTitleLicense);
        
        JTextArea txtInfo = new JTextArea(BinaryInfo.definicionUso);
        txtInfo.setEditable(false);
        txtInfo.setCaretColor(custom.BackgroundColor());
        txtInfo.setSelectionColor(custom.BackgroundColor());
        txtInfo.setSelectedTextColor(java.awt.Color.black);
        txtInfo.setForeground(custom.HighlightColor());
        txtInfo.setBackground(custom.BackgroundColor());
        txtInfo.setFont(new Font("Consolas", 0, 13));

        JScrollPane scrInfo = new JScrollPane(txtInfo);
        scrInfo.setBounds(10,70,415,275);
        // Determina la configuración de visualización de la barra de desplazamiento Vertical del componente
        // del area de información
        scrInfo.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {            
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(150,150,150);
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0)); // Tamaño 0x0
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });
        scrInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(0,4,0,0, custom.color()));        
        add(scrInfo);
        
        
            JLabel lbl_title1 = new JLabel("DEFINCIÓN Y USO");
            lbl_title1.setBounds(8, 10, 500, 30);
            lbl_title1.setForeground(custom.HighlightColor());
            lbl_title1.setFont(new java.awt.Font("Consolas", 1, 16));
            txtInfo.add(lbl_title1);
            
            JLabel lbl_title2 = new JLabel("BREVE HISTORIA");
            lbl_title2.setBounds(8, 138, 500, 30);
            lbl_title2.setForeground(custom.HighlightColor());
            lbl_title2.setFont(new java.awt.Font("Consolas", 1, 16));
            txtInfo.add(lbl_title2);
            
            JLabel lbl_title3 = new JLabel("RAZÓN DE SU CREACIÓN");
            lbl_title3.setBounds(8, 346, 500, 30);
            lbl_title3.setForeground(custom.HighlightColor());
            lbl_title3.setFont(new java.awt.Font("Consolas", 1, 16));
            txtInfo.add(lbl_title3);
           
            JLabel lbl_title4 = new JLabel("APLICACIÓN Y USO ACTUAL");
            lbl_title4.setBounds(8, 442, 500, 30);
            lbl_title4.setForeground(custom.HighlightColor());
            lbl_title4.setFont(new java.awt.Font("Consolas", 1, 16));
            txtInfo.add(lbl_title4);
        
    }
}
