
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
    
    /**
     * Modelidad de conversión: 
     * 0 = null
     * 1 = Binario
     * 2 = Entero decimal
     * 3 = Binario negativo
     * 4 = Decimal negativo
     **/
    
    protected int modeConverter = 0;
    public void setModeConverter(int mode){
        this.modeConverter = mode;
    }
    public int getModeConverter(){
        return modeConverter;
    }
    
    // Conversión Decimal a Binario.
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
    
    // Conversión Binario a Decimal.
    public Long toDecimal(String binary){ 
        
        Long whole = 0L; 
        int bit = 1; 
        
        for (int i = binary.length(); i <= binary.length() && i != 0; i--) {
            if(binary.substring(i-1,i).equals("1")){
                whole+=bit;
            } else if(binary.substring(i-1,i).equals("0")){}
            bit+=bit;
        }        
        
        return whole;
    }
}
