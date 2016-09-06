/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;
import objetos.Contador;
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
        this.k = k;
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
       // verificar los k vecinos mas cercanos : clase resultado
       String resultado = verificarK();
       System.out.println();
               return resultado;
    }

    @Override
    public void clasificaConjunto(ArrayList<Patron> conjunto) {
       // aquí va la tarea
       // tip : ver el metodo MD (CLASIFICA CONJUNTO)
        // recorremos todo el conjunto 
        for (Patron p : conjunto){
            // obteniendo el resultado de clasifiacion
        String resultado = clasifica(p);
        // seteando el resultado
        p.setClaseRes(resultado);
        
        }
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

    private String verificarK() {
        // recorrer toda la lista de distancias 
        // contadores 
        ArrayList<Contador> contadores = new ArrayList<>();
        int x = 0;
        boolean encontrado = false;
        while (!encontrado && x < this.distancias.length-1){
        // acumular 
        String clase = this.distancias[x].getClase();
        int i = contadores.indexOf(new Contador(0, clase));
        if (i == -1){
        // creamos uno nuevo
        contadores.add(new Contador(1, clase));
        }else {
        // existe y lo vamos a acumular 
        contadores.get(i).acumula();
        }
        x++; 
        encontrado = siFueAlcanzadoK(contadores);
        }
        if (encontrado){
         return this.distancias[x-1].getClase();
        }else {
        return "Desconocida";
        }
        
        
       
    }

    private boolean siFueAlcanzadoK(ArrayList<Contador> contadores) {
       // recorrer la lista de contadores y en cuanto 
       // encuentre alguno que es igual a k regresamos un true
       for (Contador aux : contadores){
          if (aux.getCantidad()==this.k)
              return true;
       }
       return false;
    }
    
}
