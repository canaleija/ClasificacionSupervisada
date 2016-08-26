/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import objetos.Distancias;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Herramientas {
    
    public static double calculaDistanciaEcuclidiana(Patron p1,Patron p2){
     double acum = 0;
     
     for (int x=0;x < p1.getVector().length;x++){
     acum+=Math.pow((p2.getVector()[x]-p1.getVector()[x]),2);
     
     }
     return Math.sqrt(acum);
    }
    
    //// http://puntocomnoesunlenguaje.blogspot.mx/2012/12/java-quicksort.html
    public static void quicksort(Distancias A[], int izq, int der) {

  Distancias pivote= new Distancias(A[izq]); // tomamos primer elemento como pivote
  int i=izq; // i realiza la búsqueda de izquierda a derecha
  int j=der; // j realiza la búsqueda de derecha a izquierda
  Distancias aux;
 
  while(i<j){            // mientras no se crucen las búsquedas
     while(A[i].getDistancia()<=pivote.getDistancia() && i<j) i++; // busca elemento mayor que pivote
     while(A[j].getDistancia()>pivote.getDistancia()) j--;         // busca elemento menor que pivote
     if (i<j) {                      // si no se han cruzado                      
          //
         aux = new Distancias(A[i]);                  // los intercambia
         A[i]= new Distancias(A[j]);
         A[j]=aux;
     }
   }
   A[izq]= new Distancias(A[j]); // se coloca el pivote en su lugar de forma que tendremos
   A[j]= new Distancias(pivote); // los menores a su izquierda y los mayores a su derecha
   if(izq<j-1)
      quicksort(A,izq,j-1); // ordenamos subarray izquierdo
   if(j+1 <der)
      quicksort(A,j+1,der); // ordenamos subarray derecho
}
    
    
}
