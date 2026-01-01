package act;

/**
 * Clase encargada de realizar conversiones numéricas entre representaciones
 * decimales y binarias.
 *
 * El objetivo principal de esta clase es ofrecer métodos que permitan
 * transformar números de forma explícita, controlando manualmente cada paso del
 * proceso binario, incluyendo el manejo de números negativos mediante
 * complemento a dos.
 *
 * La clase no se encarga de interpretar signos directamente. Se asume que la
 * detección del signo negativo se realiza antes de invocar los métodos
 * correspondientes.
 *
 * Todas las conversiones se realizan sin utilizar métodos utilitarios estándar
 * del lenguaje, lo cual permite un mayor control del proceso y facilita el
 * aprendizaje del funcionamiento interno de las representaciones binarias.
 *
 * Responsabilidades de la clase: - Convertir números decimales positivos a
 * binario sin signo - Convertir binario sin signo a decimal positivo - Generar
 * representaciones binarias con signo para números negativos - Convertir
 * binario con signo (complemento a dos) a decimal negativo
 *
 * Responsabilidades que NO asume: - Validación de formato de entrada -
 * Interpretación del signo del número original - Manejo de errores de
 * conversión
 *
 * El uso correcto de los métodos depende del contexto en el que esta clase sea
 * utilizada.
 *
 * @author ESRG
 */
public class BinaryConverter {

    /**
     * Representa el modo lógico de conversión seleccionado.
     *
     * Este atributo puede ser utilizado por componentes externos para
     * determinar qué tipo de conversión debe ejecutarse.
     *
     * No influye directamente en la lógica interna de los métodos de
     * conversión, actuando únicamente como un indicador de estado.
     *
     * Valores esperados: 0 = Sin definir 1 = Conversión a binario 2 =
     * Conversión a decimal positivo 3 = Conversión a decimal negativo
     */
    protected int modeConverter = 0;

    /**
     * Establece el modo lógico de conversión.
     *
     * Este método no valida el valor recibido, por lo que se asume que el
     * llamador proporciona un valor coherente con los modos definidos.
     *
     * @param mode Modo de conversión a establecer
     */
    public void setModeConverter(int mode) {
        this.modeConverter = mode;
    }

    /**
     * Obtiene el modo lógico de conversión actual.
     *
     * El valor retornado representa únicamente el estado almacenado y no
     * implica que una conversión haya sido ejecutada.
     *
     * @return Modo de conversión actual
     */
    public int getModeConverter() {
        return modeConverter;
    }

    /**
     * Convierte un número decimal positivo a su representación binaria.
     *
     * El método construye la representación binaria determinando primero el bit
     * más significativo y luego evaluando cada potencia de dos hasta completar
     * la cadena binaria.
     *
     * Este método asume que el valor recibido es positivo. No se realiza
     * ninguna validación para valores negativos ni para valores nulos.
     *
     * Ejemplo conceptual: Valor de entrada: 10 Resultado: 1010
     *
     * @param whole Número decimal positivo a convertir
     * @return Cadena binaria sin signo equivalente
     */
    public String toBinary(Long whole) {

        String binary = "";
        int bit = 1;
        boolean deleteCero = false;

        // Determinar el bit más significativo necesario        
        while (whole > bit) {
            bit += bit;
            if (bit > whole) {
                deleteCero = true;
            }
        }
        
        // Construir la representación binaria
        do {
            if (whole >= bit) {
                whole -= bit;
                binary += "1";
            } else {
                binary += "0";
            }
            bit = bit / 2;
        } while (bit != 0);
        
        // Eliminar un cero inicial innecesario, si aplica
        if (deleteCero == true) {
            binary = binary.substring(1, binary.length());
        }

        return binary;
    }

    /**
     * Convierte una cadena binaria sin signo a su
     * valor decimal equivalente.
     *
     * Cada carácter de la cadena es interpretado
     * como un bit independiente, comenzando desde
     * el bit menos significativo.
     *
     * Este método no interpreta bits de signo ni
     * representaciones en complemento a dos.
     *
     * Ejemplo conceptual:
     * Valor de entrada: 1010
     * Resultado: 10
     *
     * @param binary Cadena binaria compuesta por '0' y '1'
     * @return Valor decimal equivalente
     */
    public Long toDecimal(String binary) {

        Long whole = 0L;
        int bit = 1;
        
        // Recorrer la cadena desde el final (LSB)
        for (int i = binary.length(); i <= binary.length() && i != 0; i--) {
            if (binary.substring(i - 1, i).equals("1")) {
                whole += bit;
            } else if (binary.substring(i - 1, i).equals("0")) {
            }
            bit += bit;
        }

        return whole;
    }

    /**
     * Genera la representación binaria con signo de un número
     * que previamente fue identificado como negativo.
     *
     * El método asume que el signo negativo ya fue procesado
     * externamente. El valor recibido corresponde únicamente
     * a la magnitud positiva del número original.
     *
     * Para generar la representación negativa, se aplica
     * el proceso de complemento a dos:
     * - Ajuste de la longitud binaria
     * - Inversión de bits
     * - Suma de una unidad
     *
     * Ejemplo de flujo conceptual:
     * Número original: -6
     * Magnitud enviada al método: 6
     * Resultado: representación binaria con signo de -6
     *
     * @param whole Magnitud positiva del número original
     * @return Representación binaria con signo
     */
    public String toSignedBinary(Long whole) {

        String binary = toBinary(whole);
        String yranib = "";
        String signedBinary = "";
        int add = 1;
        int bits = 1;

        // Determinar la cantidad de bits necesarios 
        int bit = 1; // variable fuerte.
        while (bit < binary.length()) {
            bit += bit;
            bits = bit;
        }
        
        // Ajustar la longitud del binario para incluir bit de signo
        bit = 1;
        do {
            if (bit > binary.length()) {
                binary = "0" + binary;
            }
            bit++;
        } while (bit <= bits);

        // Invertir los bits para el complemento a dos
        for (int i = 0; i < binary.length(); i++) {
            if (binary.substring(i, (i + 1)).equals("1")) {
                yranib += "0";
            } else if (binary.substring(i, (1 + i)).equals("0")) {
                yranib += "1";
            }
        }

        // Sumar una unidad al valor invertido
        for (int i = yranib.length() - 1; i < yranib.length() && i > -1; i--) {
            if (yranib.substring(i, (i + 1)).equals("1") && add == 1) {
                signedBinary = "0" + signedBinary;
                add = 1;
            } else if (yranib.substring(i, (i + 1)).equals("1") && add == 0) {
                signedBinary = "1" + signedBinary;
                add = 0;
            } else if (yranib.substring(i, (i + 1)).equals("0") && add == 1) {
                signedBinary = "1" + signedBinary;
                add = 0;
            } else if (yranib.substring(i, (i + 1)).equals("0") && add == 0) {
                signedBinary = "0" + signedBinary;
                add = 0;
            }

        }

        return signedBinary;
    }

    /**
     * Convierte una representación binaria con signo,
     * expresada en complemento a dos, a su valor
     * decimal negativo correspondiente.
     *
     * El método asume que la cadena recibida representa
     * un número negativo válido en complemento a dos.
     * No se realizan validaciones adicionales sobre
     * el formato o la longitud de la cadena.
     *
     * Ejemplo conceptual:
     * Valor de entrada: representación binaria de -6
     * Resultado: -6
     *
     * @param binary Cadena binaria con signo
     * @return Valor decimal negativo en formato de cadena
     */
    public String toSignedDecimal(String binary) {

        String yranib = "";
        String binaryPlus = "";
        int add = 1;

        // Invertir los bits
        for (int i = 0; i < binary.length(); i++) {
            if (binary.substring(i, (i + 1)).equals("1")) {
                yranib += "0";
            } else if (binary.substring(i, (1 + i)).equals("0")) {
                yranib += "1";
            }
        }

        // Sumar una unidad al valor invertido
        for (int i = yranib.length() - 1; i < yranib.length() && i > -1; i--) {
            if (yranib.substring(i, (i + 1)).equals("1") && add == 1) {
                binaryPlus = "0" + binaryPlus;
                add = 1;
            } else if (yranib.substring(i, (i + 1)).equals("1") && add == 0) {
                binaryPlus = "1" + binaryPlus;
                add = 0;
            } else if (yranib.substring(i, (i + 1)).equals("0") && add == 1) {
                binaryPlus = "1" + binaryPlus;
                add = 0;
            } else if (yranib.substring(i, (i + 1)).equals("0") && add == 0) {
                binaryPlus = "0" + binaryPlus;
                add = 0;
            }

        }

        // Conversión a decimal entero negativo
        String decimal = "-" + toDecimal(binaryPlus);

        return decimal;
    }
}
