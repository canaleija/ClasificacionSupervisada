/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;
import objetos.Distancias;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Knn implements ClasificadorSupervisado{

    private ArrayList<Patron> conjuntoEntrenamiento;
    private Distancias[] distancias;
    private int k;

    public Knn(int k) {
        this.conjuntoEntrenamiento = null;
        this.distancias = null;
    }
    
    
    
    
    
    @Override
    public void entrenar(ArrayList<Patron> conjuntoEntrenamiento) {
       // consideramos el conjunto de entrenamiento
        this.conjuntoEntrenamiento = conjuntoEntrenamiento;
       // inicializando el arreglo de distancias que en su momento será ordenado 
       this.distancias = new Distancias[this.conjuntoEntrenamiento.size()];
    }

    @Override
    public String clasifica(Patron patron) {
       // consideramos el patron
       // calcular distancias entre patron y conjunto de entrenamiento 
       calculaDistancias(patron);
       // ordenamos las distancias 
       herramientas.Herramientas.quicksort(distancias,0,distancias.length-1);
       System.out.println();
               return null;
    }

    @Override
    public void clasificaConjunto(ArrayList<Patron> conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void calculaDistancias(Patron patron) {
           // recorrer el conjunto de entrenamiento y calcular las distancias
           int x=0;
           for (Patron p: this.conjuntoEntrenamiento){
           
               this.distancias[x] = new Distancias(p.getClase(), p, patron);
               
               x++;  
           }
           System.out.println();
    }
    
}
