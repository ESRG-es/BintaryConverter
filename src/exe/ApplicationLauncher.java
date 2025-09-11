
package exe;

/**
 *
 * @author ESRG
 */

import java.util.Scanner;
import javax.swing.JFrame;

import att.SystemInfo;
import act.WindowLoader;

public class ApplicationLauncher extends JFrame{
    
    /**
     * Estancias.
     */
    Scanner in = new Scanner(System.in);
    
    /**
     * Método principal.
     */
    public static void main(String[] args){
        SystemInfo info = new SystemInfo();
        
        System.out.println("\nBintary Converter [Versión " + info.versionSystem() + "]");
        System.out.println("© ESRG 2025\n");
        
        WindowLoader window = new WindowLoader();
        CommandConsole commandBox = new CommandConsole();
            
        window.guiMainControlPanel();
        commandBox.commandBox();

    }
    
    /**
     * Constructor de clase.
     */
    public ApplicationLauncher(){
        
    }
    
    
}
