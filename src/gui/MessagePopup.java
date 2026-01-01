
package gui;

/**
 * Clase que crea un mensaje emergente (JFrame) personalizada para mostrar
 * un mensaje personalizado y su cierre mediante un botón.
 * 
 * Para crear una instancia de la clase, se debe usar el siguiente constructor:
 * `new MessagePopup(String title, String message);`
 * 
 * @author ESRG
 */
// COMPONENTES BÁSICOS DE VENTANAS Y CONTROLES (SWING)
import javax.swing.JFrame;       // Clase base para la creación y gestión de la ventana principal.
import javax.swing.JButton;      // Componente para botones interactivos (ej. "Conversión", "Inicio").
import javax.swing.UIManager;    // Gestor de la apariencia global para aplicar temas y colores personalizados.

// DISEÑO Y EXPERIENCIA DE USUARIO (AWT)
import java.awt.Cursor;          // Permite cambiar la forma del puntero (ej. cursor de mano sobre botones).

// GESTIÓN DE INTERACCIONES Y EVENTOS
import java.awt.event.ActionEvent; // Objeto que captura la información de una acción (como pulsar una tecla o un clic).

// CLASES DE PERSONALIZACIÓN DEL SISTEMA (PAQUETE att)
import att.AppearanceSettings;   // Clase encargada de la lógica de colores, temas y estética visual del sistema.


public class MessagePopup extends JFrame{
    
    // Instancia de configuración de personalización
    AppearanceSettings custom = new AppearanceSettings();
    
    // Argumentos de información para la ventana emergente
    String title, message;
    
    /**
     * Constructor de la clase: Mensaje emergente.
     * 
     * Inicializa las propiedades y configuración de visualización de la ventana emergente.
     * Inicializa titulo y descripción de la ventana emergente.
     * 
     * @param title Titulo del mensaje emergente
     * @param message Descripción del mensaje emergente
     */ 
    public MessagePopup(String title, String message){
        setTitle(title);
        getContentPane().setBackground(custom.BackgroundColor());
        setType(Type.UTILITY);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // Configuración del color de selección para los botones de interacción, asociado
        // con el tema de personalización.
        UIManager.put("Button.select", custom.SelectionColor());
        
        this.title = title;
        this.message = message;
        
        setLayout(null);
            initComponents();            
    }
    
    /**
     * inicializa los componentes de interacción de la ventana emergente:
     * Area de descripción para el mensaje y botón para el cierre de ventana 
     */
    private void initComponents(){

        // Area de descripción e información de la ventana emergente.
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

        // Configuración y eventos asociados en el botón "Cerrar". Disponible para cerrar
        // la ventana emergente (dispose) 
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