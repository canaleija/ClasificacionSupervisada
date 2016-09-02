/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AmbienteDeClasificacion {
    // instancias de entranamiento 
    private ArrayList<Patron> iEntrenamiento;
    private ArrayList<Patron> iClasificacion;
    //public static ArrayList<Patron> bd;

    public AmbienteDeClasificacion(ArrayList<Patron> iEntrenamiento, ArrayList<Patron> iClasificacion) {
        this.iEntrenamiento = iEntrenamiento;
        this.iClasificacion = iClasificacion;
    }

    /**
     * @return the iEntrenamiento
     */
    public ArrayList<Patron> getiEntrenamiento() {
        return iEntrenamiento;
    }

    /**
     * @param iEntrenamiento the iEntrenamiento to set
     */
    public void setiEntrenamiento(ArrayList<Patron> iEntrenamiento) {
        this.iEntrenamiento = iEntrenamiento;
    }

    /**
     * @return the iClasificacion
     */
    public ArrayList<Patron> getiClasificacion() {
        return iClasificacion;
    }

    /**
     * @param iClasificacion the iClasificacion to set
     */
    public void setiClasificacion(ArrayList<Patron> iClasificacion) {
        this.iClasificacion = iClasificacion;
    }
    
    
    
    
    

  
    
    
    
    
}
