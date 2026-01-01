
package att;

/**
 * Clase de recursos de atributos estéticos para la personalización de interfaces.
 * Centraliza la paleta de colores institucional del software, permitiendo 
 * la gestión de temas (principal, selección, fondo y resaltado) mediante 
 * el modelo de color RGB.
 * 
 * @author ESRG
 */

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT)
import java.awt.Color;            // Manejo de colores RGB para el tema
import java.awt.Font;             // Definición de fuentes (Consolas, negritas, tamaños)

public class AppearanceSettings {
           
    
    /* Valores RGB estáticos para el color principal. 
     * Se mantienen públicos para permitir acceso directo si es necesario.
     */
    public static int redColor = 28;
    public static int greenColor = 72;
    public static int blueColor = 67;
    
    /** Instancia del color principal basada en los valores RGB actuales. */
    protected Color color = new Color(redColor,greenColor,blueColor);

    /**
     * Obtiene el objeto Color representativo del tema principal.
     * @return Color actual del sistema.
     */
    public Color color(){
        return color;
    }
    
    /**
     * Actualiza el color principal del sistema de forma dinámica.
     * @param red Componente rojo (0-255).
     * @param green Componente verde (0-255).
     * @param blue Componente azul (0-255).
     */
    public void customColor(int red, int green, int blue){
        redColor = red;
        greenColor = green;
        blueColor = blue;
        color = new Color(redColor, greenColor, blueColor);
    }    
    

        
    /** Valores RGB estáticos para el color de selección. */
    public static int redSelection = 13;
    public static int greenSelection = 38;
    public static int blueSelection = 36;
    
    /** Instancia del color utilizado para elementos seleccionados o activos. */
    protected Color selectionColor = new Color(redSelection,greenSelection,blueSelection);

    /**
     * Obtiene el color definido para las selecciones en la interfaz.
     * @return Color actual de selección.
     */
    public Color SelectionColor(){
        return selectionColor;
    }
    
    /**
     * Modifica el color de selección de la interfaz.
     * @param red Canal rojo.
     * @param green Canal verde.
     * @param blue Canal azul.
     */
    public void customSelectionColor(int red, int green, int blue){
        redSelection = red;
        greenSelection = green;
        blueSelection = blue;
        selectionColor = new Color(redSelection,greenSelection,blueSelection);
    }
    


    /** Valores RGB estáticos para el color de fondo. */
    public static int redBackground = 238;
    public static int greenBackground = 238;
    public static int blueBackground = 238;
    
    /** Instancia del color de fondo predeterminado para paneles y ventanas. */
    protected Color BackgroundColor = new Color(redBackground,greenBackground,blueBackground);

    /**
     * Obtiene el color de fondo actual.
     * @return Color actual de fondo.
     */
    public Color BackgroundColor(){
        return BackgroundColor;
    }
    
    /**
     * Establece un nuevo color de fondo para los componentes de la aplicación.
     * @param red Canal rojo.
     * @param green Canal verde.
     * @param blue Canal azul.
     */
    public void customBackgroundColor(int red, int green, int blue){
        redBackground = red;
        greenBackground = green;
        blueBackground = blue;
        BackgroundColor = new Color(redBackground,greenBackground,blueBackground);
    }
    
    
    
    /** Valores RGB estáticos para el color de resaltado. */
    public static int redHighlight = 0;
    public static int blueHighlight = 0;
    public static int greenHighlight = 0;
    
    /** Instancia del color de resaltado (usualmente negro por defecto). */
    protected Color highlightColor = new Color(redHighlight,blueHighlight,greenHighlight);

    /**
     * Obtiene el color de resaltado (Highlight) definido.
     * @return Color actual de resaltado
     */
    public Color HighlightColor(){
        return highlightColor;
    }
    
    /**
     * Actualiza el color de resaltado. 
     * Se ha corregido la asignación de canales para asegurar la integridad del color.
     * @param red Canal rojo.
     * @param green Canal verde.
     * @param blue Canal azul.
     */
    public void customHighlightColor(int red, int green, int blue){
        this.redHighlight = red;
        this.blueHighlight = green;
        this.greenHighlight = blue;
        highlightColor = new Color(redHighlight,blueHighlight,greenHighlight);
    }
    
    
}
