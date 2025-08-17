
package cmd;

/**
 *
 * @author ESRG
 */

import java.util.Scanner;

import att.SystemInfo;
import act.WindowLoader;
import act.BinaryConverter;

public class CommandConsole {
    
    Scanner in = new Scanner(System.in);    
    SystemInfo info = new SystemInfo();
    WindowLoader window = new WindowLoader();
    BinaryConverter engine = new BinaryConverter();
    
    public void commandBox(){
        boolean keyRed = true;
        do {
            System.out.print(" > ");
            String valor =in.nextLine();
            
            commandBoxFinal(valor);
            
        } while(keyRed);
    }
    
    public void commandBoxFinal(String valor){
        if(valor.equalsIgnoreCase("init.bi")){
            
            try {
                System.out.print(" DECIMAL: ");
                String whole = in.nextLine();
                System.out.println(" └── " + engine.toBinary(Long.parseLong(whole)) + "\n");
                                
            } catch(NumberFormatException er){
                System.out.println("Ingrese un valor numérico entero. \n");
            }
            
            
        } else  if(valor.equalsIgnoreCase("init.int")){
            
            System.out.print("\n  Binario: ");
            String binario = in.nextLine();
            System.out.println(" : " + binario + "\n");
            
        } 
            
        if(valor.equalsIgnoreCase("info")){
            
            System.out.println(" Información");
            System.out.println("      Nombre:               Bintary Converter\n"
                    + "      Versión:              " + info.versionSystem() + "\n"
                    + "      Nombre de versión     " + info.nameVersionSystem() + "\n"
                    + "      Número de obra:       " + info.workSystem() + "\n"
                    + "      Desarrollado:         ESRG\n");
            
        } else if(valor.equalsIgnoreCase("license")){
            
            window.guiLicenseDialog();
            
        } else if(valor.equalsIgnoreCase("about")){
            
            System.out.println("Soporte y ayuda: esrg.es@gmail.com\n");
            
        } else if(valor.equalsIgnoreCase("command") || valor.equalsIgnoreCase("help")){
            
            System.out.println(" Comando de interacción");
            System.out.println("        init.bi     Conversión binaria.\n"
                    + "       init.int     Conversión Entero decimal.\n"
                    + "       init.bi-     Conversión binaria negativo.\n"
                    + "      init.int-     Conversión Entero decimal negativo.\n"
                    + "        license     Términos y condiciones.\n"
                    + "          about     Soporte y ayuda.\n"
                    + "           exit     Salir."
                    + "\n");
        } 
        
        if(valor.equalsIgnoreCase("exit")){
                            
            System.exit(0);
            
        } 
    }
}
