/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionsupervisada;

import clasificadores.MinimaDistancia;
import herramientas.GeneradorDeInstanciasDeEntrenamiento;
import herramientas.Tokenizador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            // TODO code application logic here
            
            // MinimaDistancia md = new MinimaDistancia();
            // leer el archivo
            
            ArrayList<Patron> bd = Tokenizador.abrirFile();
           
            GeneradorDeInstanciasDeEntrenamiento ge = new GeneradorDeInstanciasDeEntrenamiento(bd);
            ArrayList<Patron> ce = ge.filtraUniformente(50);
            MinimaDistancia md = new MinimaDistancia();
            md.entrenar(ce);
            // todo A
            for (Patron p: bd){
             String resultado =  md.clasifica(p);
             System.out.println(resultado);
            }
            
            
            
            
            //String resutlado = md.clasifica(new Patron(new double[]{5,2,3.5,1}, "desconocido"));
        } catch (IOException ex) {
            Logger.getLogger(ClasificacionSupervisada.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
    }
    
}
