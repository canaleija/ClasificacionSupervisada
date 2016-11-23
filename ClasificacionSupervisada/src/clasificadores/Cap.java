/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;
import objetos.Clase;
import objetos.Instancias;
import objetos.Media;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Cap implements ClasificadorSupervisado{

    private ArrayList<Patron> conjuntoEntrenamiento;
    private Patron media;
    private double memoria[][];
    private ArrayList<Clase> clases;

    public Cap() {
        this.clases = new ArrayList<>();
        this.media = null;
        this.conjuntoEntrenamiento = null;
        
                
           
    }
    
    
    
    @Override
    public void entrenar(ArrayList<Patron> conjuntoEntrenamiento) {
       this.conjuntoEntrenamiento = conjuntoEntrenamiento;
       this.media = new Patron(conjuntoEntrenamiento.get(0).getVector().length);
       // necesito conocer el numero de clase para construir la memoria
       Instancias.bdOriginal = conjuntoEntrenamiento;
       Instancias.analizarBD();
       this.clases = (ArrayList<Clase>) Instancias.clases.clone();
       this.memoria = new double[this.clases.size()][this.media.getVector().length];
        
             
       // calcular la media
       for (Patron p: this.conjuntoEntrenamiento){
         double vectorP [] = p.getVector();
         // acumular en cada posicion
         for (int x=0; x < vectorP.length;x++){
          this.media.getVector()[x]+=vectorP[x];
         }
       }
       // vamos dividir entre el numero de patrones de entrenamiento
       for (int x=0; x < this.media.getVector().length;x++){
          this.media.getVector()[x]/=this.conjuntoEntrenamiento.size();
       }
       //trasladamos
       for (Patron p: this.conjuntoEntrenamiento){
         double vectorP [] = p.getVector();
         // acumular en cada posicion
         for (int x=0; x < vectorP.length;x++){
          this.media.getVector()[x]-=this.media.getVector()[x];
         }
       }
       
       // construimos la memoria con los trasladados
       for (Patron p: this.conjuntoEntrenamiento){
         double vectorP [] = p.getVector();
         String claseP = p.getClase();
         int ind = this.clases.indexOf(p);
         // acumular en el renglon ind de la memoria
         for (int x=0; x < vectorP.length;x++){
          this.memoria[ind][x]+=vectorP[x];
         }
       }
       
         
       
    System.out.println();
    }

    @Override
    public String clasifica(Patron patron) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clasificaConjunto(ArrayList<Patron> conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
