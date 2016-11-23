/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Instancias {
    
    public static ArrayList<Patron> bdOriginal;
    public static ArrayList<Clase> clases;
    
    public static ArrayList<Patron> nPorRandomBD (int n){
        ArrayList<Patron> auxI = new ArrayList<>();
        // el numero de elementos en base a un porcentaje 
        int numI = n * bdOriginal.size() / 100;
        // obtener de BDOriginal los numI de instancias 
        Random ran = new Random();
        for (int x = 0; x < numI;x++){
          // agregando una instancia nueva de patron utitilzando una instancia aleatoria de la bdOriginal
            auxI.add(new Patron(bdOriginal.get(ran.nextInt(bdOriginal.size()))));
        
        }
       return auxI; 
    }
   public static ArrayList<Patron>  nPorRandomClase (int n ){
         ArrayList<Patron> auxI = new ArrayList<>();
      analizarBD();
      Random ran = new Random();
      // agregar los elementos por clase
      for (int x=0; x < clases.size();x++){
       int numI = n * clases.get(x).getNumeroDeElementos() / 100;
         int contador = 0;
         String clase = clases.get(x).getNombre();
         while(contador<numI){
          // verificar que la posicion aleatoria nos otorge
          // una instancia de la clase X 
          int pos = ran.nextInt(bdOriginal.size());
          if (clase.equals(bdOriginal.get(pos).getClase())){
          // agregar a la nueva coleccion 
          auxI.add(new Patron(bdOriginal.get(pos)));
          contador++;
          }
          
         }
         
      }
    return auxI;
   }
    public static void analizarBD() {
       
        clases = new ArrayList<>();
    
     //verficar todos elementos de la BD
     if (bdOriginal.size()>0){
       clases.add(new Clase(bdOriginal.get(0).getClase(), 1));
      // se va recorriendo toda la BD
      for (int x=1; x < bdOriginal.size();x++ ){
         // verifica si ya existe 
         Clase aux = new Clase(bdOriginal.get(x).getClase(),0);
         if (clases.contains(aux)){
          int i = clases.indexOf(aux);
          clases.get(i).agregaElemento();
         }else {
         // agregamos la nueva clase 
         clases.add(new Clase(bdOriginal.get(x).getClase(), 1));
         }
      }
     } 
    }
}
