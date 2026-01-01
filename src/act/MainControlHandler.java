package act;

/**
 * Clase controladora encargada de la manipulación de estados y apariencia 
 * de los componentes en el panel de control principal.
 * Gestiona la visibilidad lógica (posicionamiento fuera de foco) y el 
 * refresco de estilos visuales basados en la configuración de apariencia y 
 * acciones de cierre.
 * @author ESRG
 */
import javax.swing.JFrame;

import att.AppearanceSettings;
import gui.MainControlPanel;

public class MainControlHandler extends JFrame {

    // Instancia de configuración y personalización del tema
    AppearanceSettings custom = new AppearanceSettings();

    /**
     * Desplaza los campos de entrada y control fuera del área visible de la interfaz.
     * Se utiliza para limpiar el escenario visual sin destruir los objetos,
     * situándolos en coordenadas negativas.
     */
    public void modeComponentsNULL() {
        MainControlPanel.txtInputData.setLocation(-1000, -1000);
        MainControlPanel.txtControl.setLocation(-1000, -1000);
    }

    /**
     * Restablece el estilo visual predeterminado de los botones principales.
     * Aplica el color base definido en {@link att.AppearanceSettings} al fondo 
     * y establece el texto en blanco para mantener el contraste.
     */
    public void modeComponentsButtonNULL() {
        // Estilo para el botón de inicio
        MainControlPanel.bttnStart.setBackground(custom.color());
        MainControlPanel.bttnStart.setForeground(java.awt.Color.white);

        // Estilo para el botón de conversión a binario
        MainControlPanel.bttnBinary.setBackground(custom.color());
        MainControlPanel.bttnBinary.setForeground(java.awt.Color.white);

        // Estilo para el botón de conversión a entero (Whole)
        MainControlPanel.bttnWhole.setBackground(custom.color());
        MainControlPanel.bttnWhole.setForeground(java.awt.Color.white);
    }
    
    /**
     * Cierra todas las ventanas (JFrame) abiertas por el usuario.
     * Fueza el cierre de todas las ventanas sin cerrar el programa.
     * Se recomienda abrir una interfaz gráfica después de la ejecución del método.
     */
    public void closeAllWindows(){
        java.awt.Frame[] todasLasVentanas = java.awt.Frame.getFrames();

        for (java.awt.Frame frame : todasLasVentanas) {
            if (frame instanceof JFrame && frame.isVisible()) {
                frame.dispose();
            }
        }
    }
}
