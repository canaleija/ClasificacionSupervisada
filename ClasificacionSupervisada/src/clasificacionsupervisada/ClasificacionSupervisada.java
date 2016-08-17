/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionsupervisada;

import clasificadores.MinimaDistancia;
import java.util.ArrayList;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ClasificacionSupervisada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       MinimaDistancia md = new MinimaDistancia();
       ArrayList<Patron> ce = new ArrayList<>(); 
      
       ce.add(new Patron(new double[]{5,2,3.5,1}, "Versicolor"));
       ce.add(new Patron(new double[]{5.1,3.5,1.4,0.2}, "Setosa"));
       
       ce.add(new Patron(new double[]{4.7,3.2,1.3,0.2}, "Setosa"));
          
       
       ce.add(new Patron(new double[]{5.9,3.0,4.2,1.5}, "Versicolor"));
       ce.add(new Patron(new double[]{4.9,3.0,1.4,0.2}, "Setosa"));
       ce.add(new Patron(new double[]{6,2.2,4,1}, "Versicolor"));

        md.entrenar(ce);
        
       String resutlado = md.clasifica(new Patron(new double[]{5,2,3.5,1}, "desconocido"));
       
       System.out.println();
    }
    
}
