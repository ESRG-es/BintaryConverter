
package exe;

/**
 * Clase principal de Bintary Converter (MAIN)
 * Ejecuta la aplicación de Bintary Converter
 * Clase de ejecución.
 * 
 * @author ESRG
 */

// UTILIDADES Y FLUJO DE DATOS (JAVA.UTIL)
import java.util.Scanner;         // Para la entrada de datos a través de la consola

// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;        // Ventana principal del panel de control

// LÓGICA PROPIA DEL PROYECTO (PAQUETES att Y act)
import att.SystemInfo;            // Información de versión y sistema
import act.WindowLoader;          // Cargador de ventanas y diálogos secundarios

public class ApplicationLauncher extends JFrame{
    
    /**
     * Instancia de entrada de datos para consola. 
     */
    Scanner in = new Scanner(System.in);
    
    /**
     * Método principal.
     * Inicializa Bintary Converter desde su estado inicial y desde cero.
     */
    public static void main(String[] args){

        // Instancia de información de software.
        SystemInfo info = new SystemInfo();
        // Instancia de invocar nuevas ventanas.
        WindowLoader window = new WindowLoader();
        // Instancia para invocar a Bintary Converter en su modalidad de Consola/terminal. 
        CommandConsole commandBox = new CommandConsole();
        
        System.out.println("  ____  _       _                     ____                          _             ");
        System.out.println(" | __ )(_)_ __ | |_ __ _ _ __ _   _  / ___|___  _ ____   _____ _ __| |_ ___ _ __  ");
        System.out.println(" |  _ \\| | '_ \\| __/ _` | '__| | | || |   / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__| ");
        System.out.println(" | |_) | | | | | || (_| | |  | |_| || |__| (_) | | | \\ V /  __/ |  | ||  __/ |    ");
        System.out.println(" |____/|_|_| |_|\\__\\__,_|_|   \\__, | \\____\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_|    ");
        System.out.println("  Versión " + info.versionSystem() + "            |___/");
        System.out.println("  © 2025 - 2026 ESRG.es\n"); 
        
            
        window.guiMainControlPanel();
        commandBox.commandBox();

    }
    
    /**
     * Constructor de clase.
     * @see https://drive.google.com/file/d/1ik5OHkU2O_hsEY3QGo_A14iHmuVpzHYU/view?usp=sharing
     */
    public ApplicationLauncher(){   
         
    }
    
}
