
package gui;

/**
 * Clase para la creación de ventana de salida de conversón flotante.
 * Muestra el historial de resultados de conversión en una ventana flotante.
 * 
 *  Para crear una instancia de la clase, se debe usar el siguiente constructor:
 * `new ConversionResultWindow(String history);`
 *
 * @author ESRG
 */

// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;        // Clase base para la creación y gestión de la ventana.
import javax.swing.ImageIcon;     // Para cargar el icono de la aplicación (bintary_icon)
import javax.swing.JScrollPane;   // Contenedor con barras de desplazamiento para la terminal
import javax.swing.JTextArea;     // Áreas de texto (Terminal y panel de entrada)

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT & SWING PLAF)
import java.awt.Color;       // Manejo de colores RGB para el tema

// LÓGICA PROPIA DEL PROYECTO (PAQUETE att)
import att.AppearanceSettings;    // Configuración dinámica de colores y temas


public class ConversionResultWindow extends JFrame{
    
    // Instancia de configuración de personalización
    AppearanceSettings custom = new AppearanceSettings();
    
    // Argumentos de información para el historial de conversiones.
    private String history;
    
    /**
     * Constructor de la clase: Ventana flontante.
     * 
     * Inicializa las propiedades y configuración de visualización de la ventana.
     * Inicializa titulo y historial y resultados en el area de información.
     * 
     * @param history Historial de conversión.
     */ 
    public ConversionResultWindow(String history){
        
        setTitle("Bintary Converter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        getContentPane().setBackground(custom.BackgroundColor());
        
        this.history = history;
           
            initComponents();
    }
    
    /**
     * Inicializa los componentes de interacción de la ventana flotante.
     * Configura el área de texto donde se despliega el historial.
     */
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
