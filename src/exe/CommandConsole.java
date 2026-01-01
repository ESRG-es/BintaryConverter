package exe;

/**
 * Clase principal de consola.
 * Bintary Converter en su modalidad de comandos: instancia de consola/terminal.
 * 
 * La clase no requiere parámetro alguno para ser invocada.
 * 
 * @author ESRG
 */

// UTILIDADES Y FLUJO DE DATOS (JAVA.UTIL)
import java.util.Scanner;         // Para la entrada de datos a través de la consola

// LÓGICA PROPIA DEL PROYECTO (PAQUETES att Y act)
import att.SystemInfo;            // Información de versión y sistema
import att.BinaryInfo;            // Información y metadatos sobre procesos binarios
import act.WindowLoader;          // Cargador de ventanas y diálogos secundarios
import act.BinaryConverter;       // Motor de conversión matemática

public class CommandConsole {

    // Instancia de entrada de datos para consola.    
    Scanner in = new Scanner(System.in);

    // Instancia de informaciòn del software
    SystemInfo info = new SystemInfo();

    // Instancia para invocar nuevas vetanas de interacción. 
    WindowLoader window = new WindowLoader();

    // Instancia para la conversión del sistema binario.    
    BinaryConverter engine = new BinaryConverter();

    // Instancia para la información del sistema binario.
    BinaryInfo binaryInfo = new BinaryInfo();

    /**
     *´Ejecución del software. Entrada de datos y selección de comando* 
     */ 
    public void commandBox() {
        boolean keyRed = true;
        do {
            System.out.print(" > ");
            String valor = in.nextLine();

            commandBoxFinal(valor);

        } while (keyRed);
    }

    /**
     * Menú de comandos. Selección del tipo de comando
     *      Comandos de interacción: init.bi   Convertir de Decimal/Decimal Negativo a Binario
     *                               init.int  Convertir de Binario a Decimal
     *                              -init.int  Convertir de Binario a decimal negativo
     *                             binaryInfo  Información del sistema binario
     *                                command  Lista de comandos
     *                                   info  Información del software
     *                                license  Términos y condiciones de uso
     *                                  about  Soporte y ayuda
     *                                   exit  salir del software                                                     
     * 
     * @param valor Comando de interacción     
     * @throws NumberFormatException Al ingresar una cadena de caracteres diferente a números.
     *  
     */ 
    public void commandBoxFinal(String valor) {

        // Convertir de Decimal/Decimal Negativo a Binario
        if (valor.equalsIgnoreCase("init.bi")) {

            try {
                System.out.print(" DECIMAL: ");
                String whole = in.nextLine().trim();
                String result;
                if(whole.substring(0,1).equals("-")){
                    result = engine.toSignedBinary(Long.parseLong(whole.substring(1,whole.length())));                    
                } else {
                    result = engine.toBinary(Long.parseLong(whole));                    
                }   
                System.out.println(" └── " + result + "\n     └── " + result.length() + " bits.\n");

            } catch (NumberFormatException er) {
                System.out.println("Ingrese un valor numérico entero. \n");
            }

        // Convertir de Binario a Decimal
        } else if (valor.equalsIgnoreCase("init.int")) {

            try {
                System.out.print(" BINARIO: ");
                String binary = in.nextLine().trim();
                Long result;
                if (binary.length() <= 32) {
                    for (int i = 1; i <= binary.length() && i != 0; i++) {
                        if (binary.substring(i - 1, i).equals("1") || binary.substring(i - 1, i).equals("0")) {

                            if (i == binary.length()) {
                                result = engine.toDecimal(binary);
                                System.out.println(" └── " + result + "\n     └── " + result.toString().length() + " bits.\n");
                                i = binary.length() * 10;
                            }
                        } else {
                            System.out.println("Ingrese un valor binario. \n");
                            i = binary.length() * 10;
                        }
                    }

                } else {
                    System.out.println("Máximo 32 digitos binarios. \n");
                }

            } catch (NumberFormatException er) {
                System.out.println("Ingrese un valor binario. \n");
            }

        // Convertir de Binaro a decimal negativo
        }  else if (valor.equalsIgnoreCase("-init.int")) {
            
            try {
                System.out.print(" BINARIO: ");
                String binary = in.nextLine().trim();
                String result;
                if (binary.length() <= 32) {
                    for (int i = 1; i <= binary.length() && i != 0; i++) {
                        if (binary.substring(i - 1, i).equals("1") || binary.substring(i - 1, i).equals("0")) {

                            if (i == binary.length()) {
                                result = engine.toSignedDecimal(binary);
                                System.out.println(" └── " + result + "\n     └── " + binary.length() + " bits.\n");
                                i = binary.length() * 10;
                            }
                        } else {
                            System.out.println("Ingrese un valor binario. \n");
                            i = binary.length() * 10;
                        }
                    }

                } else {
                    System.out.println("Máximo 32 digitos binarios. \n");
                }

            } catch (NumberFormatException er) {
                System.out.println("Ingrese un valor binario. \n");
            }
        }
        
        // Acerca de información del sistema binario.
        if (valor.equalsIgnoreCase("binaryInfo")) {

            System.out.println(" Sistema de binario");
            System.out.println(binaryInfo.definicionUso + "\n");

        } 

        // Información del software
        if (valor.equalsIgnoreCase("info")) {

            System.out.println(" Información");
            System.out.println("      Nombre:               Bintary Converter\n"
                    + "      Versión:              " + info.versionSystem() + "\n"
                    + "      Nombre de versión     " + info.nameVersionSystem() + "\n"
                    + "      Número de obra:       " + info.workSystem() + "\n"
                    + "      Desarrollado:         ESRG\n");

        // Términos y condiciones de uso
        } else if (valor.equalsIgnoreCase("license")) {

            window.guiLicenseDialog();

        // Acerca del desarrollador
        } else if (valor.equalsIgnoreCase("about")) {

            System.out.println("Soporte y ayuda: esrg.es@gmail.com\n");

        // Lista de comandos
        } else if (valor.equalsIgnoreCase("command") || valor.equalsIgnoreCase("help")) {

            System.out.println(" Comando de interacción");
            System.out.println("        init.bi     Conversión binaria.\n"
                    + "       init.int     Conversión Entero decimal.\n"
                    + "      -init.int     Conversión Entero decimal negativo.\n"
                    + "     binaryInfo     Información del sistema binario.\n"
                    + "        command     Lista de comandos."
                    + "           info     Informacipon de software.\n"
                    + "        license     Términos y condiciones.\n"
                    + "          about     Soporte y ayuda.\n"
                    + "           exit     Salir."
                    + "\n");
        }

        // Cerrar el software (System.exit(0))
        if (valor.equalsIgnoreCase("exit")) {

            System.exit(0);

        }
    }
}
