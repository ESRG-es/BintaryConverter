
package act;

/**
 *
 * @author ESRG
 */
public class BinaryConverter {
    
    /**
     * toBinary()
     * toDecimal()
     * toSignedBinary()
     * toSignedDecimal()
     */
    
    // Modelidad de conversión: 0 = null, 1 = Binario, 2 = Entero decimal.
    protected int modeConverter = 0;
    public void setModeConverter(int mode){
        this.modeConverter = mode;
    }
    public int getModeConverter(){
        return modeConverter;
    }
    
    // Conversión Entero a decimal.
    public String toBinary(Long whole){
        
        String binary = "";     
        int bit = 1;              
        boolean deleteCero = false;   
                
        while (whole > bit) {
            bit += bit;
            if(bit > whole){ 
               deleteCero = true; 
            }
        }
                
        do {
            if (whole >= bit) {
                whole -= bit;
                binary += "1";
            } else {
                binary += "0";
            }
            bit = bit / 2; 
        } while (bit != 0);
        
        if(deleteCero == true){
            binary = binary.substring(1,binary.length());
        }                                          
        
        return binary;
    }
}
