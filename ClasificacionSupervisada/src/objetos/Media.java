/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Media extends Patron{
    private int acumalador;
    public Media(int n) {
        super(n);
        this.acumalador = 1;
    }
    public Media(int n,String clase){
      super(n,clase);
      this.acumalador = 1;
    }

    public Media(double[] vector, String clase) {
       super(vector,clase);
       this.acumalador = 1;
    }
    public void acumula(){
        this.setAcumalador(this.getAcumalador() + 1);
    }
    
    public void divide(){
      for (int x=0; x< super.getVector().length;x++){
      super.getVector()[x] /=this.acumalador;
      }
    }

    /**
     * @return the acumalador
     */
    public int getAcumalador() {
        return acumalador;
    }

    /**
     * @param acumalador the acumalador to set
     */
    public void setAcumalador(int acumalador) {
        this.acumalador = acumalador;
    }
    
    
}
