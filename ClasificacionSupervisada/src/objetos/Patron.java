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
public class Patron {
    
    // arreglo de doubles para crear como tal el patron
    private double[] vector;
    private String clase;

    // constructor por defecto
    public Patron(int n) {
        this.vector = new double[n];
        this.clase = "Desconocida";
    }
    public Patron(int n,String clase){
        this.vector = new double[n];
        this.clase = clase;
    }

    public Patron(double[] vector, String clase) {
        this.vector = vector;
        this.clase = clase;
    }

    public Patron(Patron patron) {
        this.vector = patron.getVector().clone();
        this.clase = patron.getClase();
    }
    
    

    /**
     * @return the vector
     */
    public double[] getVector() {
        return vector;
    }

    /**
     * @param vector the vector to set
     */
    public void setVector(double[] vector) {
        this.vector = vector;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
       String aux="[";
       for (int x=0; x < this.vector.length;x++){
         aux+=this.vector[x]+",";
       
       }
       aux+="]= "+this.clase;
        
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
