
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
        
        binary = binary + "\n   " + binary.length() + " bits.";
        
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
    
    // Conversión Decimal negativo a binario 
    public String toSignedBinary(Long whole){
        
        String binary = toBinary(whole); // Valor convertido a binario.
        String yranib = ""; // Valor invertido binario.
        String signedBinary = ""; // Valor completo negativo binario.
        int add = 1;
        int bits = 1; // Bits de valor completo negativo binario.
        
        // Definir bits 
        int bit = 1; // variable fuerte.
        while(bit < binary.length()){            
            bit+= bit;
            bits = bit;
        }
        bit = 1;
        do{
           if(bit > binary.length()){
               binary = "0" + binary;               
           }
           bit++;
        } while(bit <= bits);
        
       
        // Invertir conversión: 101 > 010
        for(int i = 0; i < binary.length(); i++){
            if(binary.substring(i,(i+1)).equals("1")){
                yranib+="0";
            } else if(binary.substring(i,(1+i)).equals("0")){
                yranib+="1";
            }                                
        }
        
        // Sumar + 1
        for (int i = yranib.length() - 1; i < yranib.length() && i > -1; i--) { 
             if(yranib.substring(i,(i+1)).equals("1") && add == 1){
                 signedBinary = "0" + signedBinary;
                 add = 1;
             } else if(yranib.substring(i,(i+1)).equals("1") && add == 0){
                 signedBinary = "1" + signedBinary;
                 add = 0;
             } else if(yranib.substring(i,(i+1)).equals("0") && add == 1){
                 signedBinary = "1" + signedBinary;
                 add = 0;
             } else if(yranib.substring(i,(i+1)).equals("0") && add == 0){
                 signedBinary = "0" + signedBinary;
                 add = 0;
             }      
             
        }
                
        signedBinary = signedBinary + "\n   " + bits + " bits.";                
            
        return signedBinary;
    }
}
