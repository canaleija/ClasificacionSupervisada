/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import clasificadores.ClasificadorSupervisado;
import clasificadores.MinimaDistancia;
import herramientas.GeneradorDeInstancias;
import herramientas.Tokenizador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto Cruz Leija
 */
public class EscenarioDeClasificacion {
    
   private  ArrayList<ClasificadorSupervisado> clasificadores;
   private  ArrayList<Patron> instanciaEntrenamiento, bdOriginal;
   private  double[] rendimientos;

    public EscenarioDeClasificacion(ArrayList<ClasificadorSupervisado> clasificadores) {
        this.clasificadores = clasificadores;
        this.rendimientos = new double[clasificadores.size()];
    }

    public void ejecutaInstancia (int porcentaje){
       try {
           // abrir el archivo
           this.bdOriginal = Tokenizador.abrirFile();
           GeneradorDeInstancias ge = new GeneradorDeInstancias(this.bdOriginal);
           this.instanciaEntrenamiento = ge.filtraUniformente(porcentaje);
           // ejecutamos la prueba 
          
           // recorrer los diferentes clasificadores para entrenarlos 
           // entrenamiento y clasificación
           int iC = 0;
           for (ClasificadorSupervisado clasificador: this.clasificadores){
             clasificador.entrenar((ArrayList<Patron>) instanciaEntrenamiento.clone());
             clasificador.clasificaConjunto(bdOriginal);
             // calculamos el rendimiento 
             int acumulador = 0;
             for (Patron p: this.bdOriginal){
               if (p.verificaClasificacion()){
                acumulador++;
               }
             }
             double pCla = (acumulador*100)/this.bdOriginal.size();
             rendimientos[iC] = pCla;
             iC++;
           }
           // que cada uno de los clasificadores clasifique
                     
       } catch (IOException ex) {
           Logger.getLogger(EscenarioDeClasificacion.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    
    /**
     * @param instanciaEntrenamiento the instanciaEntrenamiento to set
     */
    public void setInstanciaEntrenamiento(ArrayList<Patron> instanciaEntrenamiento) {
        this.instanciaEntrenamiento = instanciaEntrenamiento;
    }

    /**
     * @param bdOriginal the bdOriginal to set
     */
    public void setBdOriginal(ArrayList<Patron> bdOriginal) {
        this.bdOriginal = bdOriginal;
    }

    /**
     * @return the rendimientos
     */
    public double[] getRendimientos() {
        return rendimientos;
    }
    
    

  
   
}
