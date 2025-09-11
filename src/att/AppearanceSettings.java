
package att;

/**
 *
 * @author ESRG
 */

import java.awt.Color;
import java.awt.Font;

public class AppearanceSettings {
           
    
    /**
     * Color principal.
     */
    public static int redColor = 28;
    public static int greenColor = 72;
    public static int blueColor = 67;
    
    // Color principal
    protected Color color = new Color(redColor,greenColor,blueColor);
    public Color color(){
        return color;
    }
    
    // Cambiar Color Principal.
    public void customColor(int red, int green, int blue){
        redColor = red;
        greenColor = green;
        blueColor = blue;
        color = new Color(redColor, greenColor, blueColor);
    }    
    
        
    /**
     * Color de selección.
     */
    public static int redSelection = 13;
    public static int greenSelection = 38;
    public static int blueSelection = 36;
    
    // Color de selección.
    protected Color selectionColor = new Color(redSelection,greenSelection,blueSelection);
    public Color SelectionColor(){
        return selectionColor;
    }
    
    // Cambiar Color de selección.
    public void customSelectionColor(int red, int green, int blue){
        redSelection = red;
        greenSelection = green;
        blueSelection = blue;
        selectionColor = new Color(redSelection,greenSelection,blueSelection);
    }
    
    
    
    /**
     * Color de fondo.
     */
    public static int redBackground = 238;
    public static int greenBackground = 238;
    public static int blueBackground = 238;
    
    // Color de fondo.
    protected Color BackgroundColor = new Color(redBackground,greenBackground,blueBackground);
    public Color BackgroundColor(){
        return BackgroundColor;
    }
    
    // Cambiar Color de fondo.
    public void customBackgroundColor(int red, int green, int blue){
        redBackground = red;
        greenBackground = green;
        blueBackground = blue;
        BackgroundColor = new Color(redBackground,greenBackground,blueBackground);
    }
    
    
    
    /**
     * Color de resaltado.
     */
    public static int redHighlight = 0;
    public static int blueHighlight = 0;
    public static int greenHighlight = 0;
    
    // Color de resaltado.
    protected Color highlightColor = new Color(redHighlight,blueHighlight,greenHighlight);
    public Color HighlightColor(){
        return highlightColor;
    }
    
    // Cambiar Color de resaltado.
    public void customHighlightColor(int red, int green, int blue){
        this.redHighlight = red;
        this.blueHighlight = green;
        this.greenHighlight = blue;
        highlightColor = new Color(redHighlight,blueHighlight,greenHighlight);
    }
    
    
}
