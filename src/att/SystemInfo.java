package att;

/**
 * Clase de metadatos y atributos de información del software
 * Datos que definen el estado de Bintary Converter.
 * 
 * Encuentra la información básica, y la licencia de uso.
 * @author ESRG
 */
public class SystemInfo {

    // Versión del software. (Al cambiar de versión se recomienda agregar la versión antigua en un comentario.)
    // protected String versionSystem = "2.0 Java";
    //protected final String versionSystem = "2.1 Java";    
    protected final String versionSystem = "2.2 Java";  
    /**
     * Valor actual de la versión más reciente.
     * @return Versión actual del software.
     */ 
    public String versionSystem() {
        return versionSystem;
    }

    /**
       Número de referencia. (Al cambiar el número de referencia se recomienda agregar el
       antiguo número de referencia en un comentario.)
     */
    // protected String workSystem = "ob4.5es";
    //protected final String workSystem = "ob4.6es";   
    protected final String workSystem = "ob4.6es"; 
    /**
     * Valor actual del número de referencia más reciente.
     * @return Número de referencia actual del software.
     */ 
    public String workSystem() {
        return workSystem;
    }

    /**
     * Nombre de versión del software.
     */
    protected String nameVersionSystem = "Binverter";
    /**
     * Valor actual del nombre de versión.
     * @return Nombre de versión del software.
     */ 
    public String nameVersionSystem() {
        return nameVersionSystem;
    }

    /**
       Licencia de uso y distribución.
     */ 
    protected String licenseSystem = "\nLicencia de Uso de Software\n"
            + "\n"
            + "1. Introducción\n"
            + "Este documento constituye la Licencia de Uso aplicable al software denominado\n"
            + "**Bintary Converter**, desarrollado y puesto a disposición por **ESRG**. \n"
            + "El propósito principal de este software es servir como herramienta de consulta \n"
            + "técnica y apoyo educativo, orientado a la comprensión de principios de conversión \n"
            + "numérica y procesos lógicos computacionales.\n"
            + "\n"
            + "La presente licencia regula expresamente las condiciones bajo las cuales se\n"
            + "permite el uso, modificación y distribución del software, así como las restricciones \n"
            + "impuestas sobre su utilización. El acceso al código fuente se concede \n"
            + "exclusivamente con fines de aprendizaje, análisis o investigación, y no implica en\n"
            + "ningún caso la cesión de derechos de autor, ni la autorización para su explotación \n"
            + "con fines comerciales o lucrativos.\n"
            + "\n"
            + "2. Permisos\n"
            + "2.1 Autorizaciones otorgadas\n"
            + "Se otorga al usuario una autorización **limitada, intransferible, revocable y no\n"
            + "exclusiva** para:\n"
            + "- Ejecutar el software en entornos personales, educativos o académicos no\n"
            + "  lucrativos.\n"
            + "- Estudiar, inspeccionar y analizar el código fuente con fines estrictamente\n"
            + "  didácticos o investigativos.\n"
            + "- Realizar modificaciones al código fuente única y exclusivamente para su uso\n"
            + "  personal o en contextos de formación no comercial, sin que dichas \n"
            + " modificaciones impliquen una alteración de la autoría original.\n"
            + "\n"
            + "2.2 Redistribución autorizada\n"
            + "Se permite la redistribución del software, incluyendo versiones modificadas,\n"
            + "siempre y cuando se cumplan simultáneamente las siguientes condiciones:\n"
            + "- Esta licencia debe incluirse **íntegra, sin alteraciones ni omisiones**, en\n"
            + "  cualquier copia o versión derivada del software.\n"
            + "- La autoría original del software debe ser reconocida de manera **explícita y\n"
            + "  visible**, indicando claramente que el programa fue creado por **ESRG**,\n"
            + "  tanto en la documentación como en la interfaz de cualquier versión modificada\n"
            + "  o redistribuida.\n"
            + "\n"
            + "Nota: Este software se distribuye como recurso pedagógico. Su finalidad no es\n"
            + "servir de plantilla para el desarrollo de soluciones industriales ni como base para\n"
            + "productos con fines comerciales.\n"
            + "\n"
            + "3. Restricciones\n"
            + "3.1 Usos prohibidos\n"
            + "Queda terminantemente prohibido el uso del software, total o parcialmente,\n"
            + "para:\n"
            + "- Actividades comerciales, empresariales, industriales o cualquier otra forma de\n"
            + "  explotación con ánimo de lucro, ya sea directa o indirectamente.\n"
            + "- Desarrollos que deriven en productos u ofertas de servicios, gratuitos o de pago,\n"
            + "  que incluyan o se basen en el presente software sin la autorización expresa y por\n"
            + "  escrito del autor.\n"
            + "\n"
            + "3.2 Interfaz gráfica de usuario (GUI)\n"
            + "Se prohíbe expresamente la reproducción, reutilización, imitación, modificación\n"
            + "o apropiación de la interfaz gráfica de usuario del software, incluyendo, pero sin\n"
            + "limitarse a:\n"
            + "- Diseño visual general.\n"
            + "- Distribución y disposición de elementos interactivos.\n"
            + "- Estilo, paleta de colores y símbolos gráficos.\n"
            + "- Cualquier aspecto que constituya la identidad visual del programa.\n"
            + "\n"
            + "3.3 Créditos, avisos y licencias\n"
            + "No está permitido en ningún caso:\n"
            + "- Remover, modificar, ocultar o desfigurar los créditos de autoría, avisos legales\n"
            + "  o información relativa a esta licencia, ya sea en el código fuente, interfaz o\n"
            + "  cualquier material documental asociado.\n"
            + "\n"
            + "3.4 Representación indebida\n"
            + "Se prohíbe:\n"
            + "- Atribuir la creación del software a una persona, grupo o entidad distinta a su\n"
            + "  autor original.\n"
            + "- Declarar o dar a entender, de forma directa o implícita, que el software fue\n"
            + "  desarrollado por terceros o apropiarse de su contenido como si fuese propio.\n"
            + "\n"
            + "4. Propiedad Intelectual\n"
            + "4.1 Titularidad de los derechos\n"
            + "El código fuente, el modelo lógico de conversión, así como el diseño de interacción\n"
            + "del usuario, son propiedad intelectual exclusiva de **ESRG**, quien retiene todos\n"
            + "los derechos morales y patrimoniales que la ley confiere al autor.\n"
            + "\n"
            + "4.2 Fundamentos técnicos\n"
            + "El desarrollo de este software se basa en principios matemáticos de conocimiento\n"
            + "general y de dominio público. No obstante, el código implementado, su estructura,\n"
            + "estilo y enfoque son fruto del trabajo original del autor, quien reconoce que\n"
            + "pueden existir soluciones similares desarrolladas de forma independiente, sin que\n"
            + "ello afecte la titularidad de su propia obra.\n"
            + "\n"
            + "4.3 No cesión de derechos\n"
            + "El acceso, descarga o uso del código fuente no debe interpretarse como una cesión\n"
            + "de derechos, ni como una autorización implícita para usos distintos a los que esta\n"
            + "licencia permite expresamente. Todos los derechos no conferidos de forma\n"
            + "explícita por esta licencia, se consideran reservados.\n"
            + "\n"
            + "5. Exención de Responsabilidad\n"
            + "5.1 Condición del software\n"
            + "El software se proporciona **“tal cual”**, sin ningún tipo de garantía, ya sea\n"
            + "expresa o implícita, incluyendo —pero no limitada a— garantías sobre:\n"
            + "- Funcionamiento continuo o ininterrumpido.\n"
            + "- Idoneidad para un propósito específico.\n"
            + "- Ausencia de errores, defectos o vulnerabilidades.\n"
            + "\n"
            + "5.2 Limitación de responsabilidad\n"
            + "Bajo ninguna circunstancia **ESRG** será responsable por daños directos,\n"
            + "indirectos, incidentales, especiales, punitivos o consecuenciales derivados del uso\n"
            + "o mal uso del software, incluyendo —pero no limitándose a—:\n"
            + "- Pérdida de datos.\n"
            + "- Interrupción de actividades.\n"
            + "- Fallas técnicas.\n"
            + "- Problemas derivados de modificaciones no autorizadas.\n"
            + "\n"
            + "6. Aceptación de los Términos\n"
            + "6.1 Condición de uso\n"
            + "El uso del software implica la aceptación **total, irrevocable e incondicional** de\n"
            + "los términos y condiciones establecidos en esta licencia. Esta aceptación se \n"
            + "extiende a cualquier forma de utilización, modificación o distribución del \n"
            + "programa.\n"
            + "\n"
            + "En caso de no estar de acuerdo con cualquiera de las disposiciones aquí contenidas,\n"
            + "el usuario deberá abstenerse de instalar, ejecutar, modificar o redistribuir este     \n"
            + "software, ya sea en su versión original o derivada.\n\n";
    /**
     * Términos y condiciones actuales. (Permisos de ESRG para sus cambio y distribución)
     * @return Licencia de uso y distribución.
     */
    public String licenceSystem() {
        return licenseSystem;
    }

}
