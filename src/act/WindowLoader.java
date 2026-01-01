package act;

/**
 * Clase encargada de la gestión y despliegue de las interfaces gráficas.
 * Actúa como un cargador centralizado (Loader) que inicializa, configura 
 * las dimensiones y posiciona las diferentes ventanas y diálogos del software.
 * 
 * @author ESRG
 */

// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;        // Ventana principal del panel de control

// LÓGICA PROPIA DEL PROYECTO (PAQUETE gui)
import gui.*;                     // Importación de todas las ventanas y paneles de la interfaz

public class WindowLoader extends JFrame{
    
    /**
     * Inicializa y despliega el Panel de Control Principal.
     * Configura la ventana con dimensiones fijas de 603x400 píxeles y 
     * la posiciona en el centro de la pantalla.
     */
    public void guiMainControlPanel(){
        MainControlPanel window = new MainControlPanel();
        window.setBounds(0,0,603,400);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    /**
     * Despliega el diálogo "Acerca de".
     * Muestra información resumida sobre el software en una ventana de 390x270 píxeles.
     */
    public void guiAboutDialog(){
        AboutDialog window = new AboutDialog();
        window.setSize(390,270);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    /**
     * Inicializa y muestra el diálogo de la Licencia de Uso.
     * Carga el texto legal completo definido en los atributos del sistema 
     * en una ventana de 550x420 píxeles.
     */
    public void guiLicenseDialog(){
        LicenseDialog window = new LicenseDialog();
        window.setSize(550,420);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    
    /**
     * Crea y muestra una ventana emergente de mensaje (Popup).
     * @param title El título que se mostrará en la barra superior de la ventana.
     * @param message El contenido del mensaje informativo o de alerta.
     */
    public void guiMessagePopup(String title, String message){
        MessagePopup window = new MessagePopup(title, message);
        window.setSize(330,155);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    /**
     * Despliega el editor de configuración de apariencia.
     * Permite al usuario modificar los valores RGB de la interfaz de forma interactiva.
     */
    public void guiAppearanceSettingsEditor(){
        AppearanceSettingsEditor window = new AppearanceSettingsEditor();
        window.setBounds(0, 0, 440, 300);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
    
    /**
     * Inicializa la ventana de resultados de conversión y su historial.
     * A diferencia de otras ventanas, esta permite el cambio de tamaño (resizable) 
     * para facilitar la lectura de procesos extensos.
     * @param history Cadena de texto que contiene el registro de las operaciones realizadas.
     */
    public void guiConversionResultWindow(String history){
        ConversionResultWindow window = new gui.ConversionResultWindow(history);
        window.setSize(603,400);
        window.setVisible(true);
        window.setResizable(true);
        window.setLocationRelativeTo(null);
    }
    
    /**
     * Despliega la ventana informativa sobre el Sistema Binario.
     * Carga el contenido educativo referente a la historia y funcionamiento del sistema base 2.
     */
    public void guiBinarySystemInfoWindow(){
        BinarySystemInfoWindow window = new BinarySystemInfoWindow();
        window.setSize(441,400);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }

}
