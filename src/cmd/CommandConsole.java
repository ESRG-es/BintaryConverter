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

    public void commandBox() {
        boolean keyRed = true;
        do {
            System.out.print(" > ");
            String valor = in.nextLine();

            commandBoxFinal(valor);

        } while (keyRed);
    }

    public void commandBoxFinal(String valor) {
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

        if (valor.equalsIgnoreCase("info")) {

            System.out.println(" Información");
            System.out.println("      Nombre:               Bintary Converter\n"
                    + "      Versión:              " + info.versionSystem() + "\n"
                    + "      Nombre de versión     " + info.nameVersionSystem() + "\n"
                    + "      Número de obra:       " + info.workSystem() + "\n"
                    + "      Desarrollado:         ESRG\n");

        } else if (valor.equalsIgnoreCase("license")) {

            window.guiLicenseDialog();

        } else if (valor.equalsIgnoreCase("about")) {

            System.out.println("Soporte y ayuda: esrg.es@gmail.com\n");

        } else if (valor.equalsIgnoreCase("command") || valor.equalsIgnoreCase("help")) {

            System.out.println(" Comando de interacción");
            System.out.println("        init.bi     Conversión binaria.\n"
                    + "       init.int     Conversión Entero decimal.\n"
                    + "      -init.int     Conversión Entero decimal negativo.\n"
                    + "        license     Términos y condiciones.\n"
                    + "          about     Soporte y ayuda.\n"
                    + "           exit     Salir."
                    + "\n");
        }

        if (valor.equalsIgnoreCase("exit")) {

            System.exit(0);

        }
    }
}
