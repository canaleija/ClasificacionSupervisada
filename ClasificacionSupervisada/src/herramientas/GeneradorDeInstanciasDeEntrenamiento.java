/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import objetos.Clase;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneradorDeInstanciasDeEntrenamiento {
    
    private ArrayList<Patron> bd;
    private ArrayList<Clase> clases;
    private ArrayList<Patron> instanciaFinal;

    public GeneradorDeInstanciasDeEntrenamiento(ArrayList<Patron> bd) {
        this.clases = new ArrayList<>();
        this.instanciaFinal = new ArrayList<>();
        this.bd = bd;
        analizarBD();
        System.out.println();
    }
    
    public ArrayList<Patron> filtraUniformente (int porcentaje){
       
        if (porcentaje < 100){
            // agregar elementos de todas las clases 
            for (int x=0; x < this.clases.size();x++){
             int numE = this.clases.get(x).getNumeroDeElementos()*porcentaje/100;
             int contador = 0;
             int i = 0;
             while(contador<numE){
                // recorrer la BD
                if (this.bd.get(i).getClase().equals(this.clases.get(x).getNombre())){
                this.instanciaFinal.add(new Patron(this.bd.get(i)));
                contador++;
            
                }
                i++;
                
             }
            }
        
        }else {
        return (ArrayList<Patron>)this.bd.clone();
        }
    return this.instanciaFinal ;
    }

    private void analizarBD() {
     //verficar todos elementos de la BD
     if (this.bd.size()>0){
       this.clases.add(new Clase(this.bd.get(0).getClase(), 1));
      // se va recorriendo toda la BD
      for (int x=1; x < this.bd.size();x++ ){
         // verifica si ya existe 
         Clase aux = new Clase(this.bd.get(x).getClase(),0);
         if (this.clases.contains(aux)){
          int i = this.clases.indexOf(aux);
          this.clases.get(i).agregaElemento();
         }else {
         // agregamos la nueva clase 
         this.clases.add(new Clase(this.bd.get(x).getClase(), 1));
         }
      }
     } 
     
      
    }
    
    
    
    
}
