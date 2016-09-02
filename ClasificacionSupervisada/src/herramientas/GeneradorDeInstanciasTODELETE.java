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
public class GeneradorDeInstanciasTODELETE {
    
    private ArrayList<Patron> bd;
    private ArrayList<Clase> clases;
    private ArrayList<Patron> instanciaFinal;

    public GeneradorDeInstanciasTODELETE(ArrayList<Patron> bd) {
        this.clases = new ArrayList<>();
        this.instanciaFinal = new ArrayList<>();
        this.bd = bd;
        //analizarBD();
       
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

    
     
      
    
    
    
    
    
}
