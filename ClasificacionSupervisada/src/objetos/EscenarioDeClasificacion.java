/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import clasificadores.ClasificadorSupervisado;
import clasificadores.MinimaDistancia;
import herramientas.GeneradorDeInstanciasTODELETE;
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

   
   

   
    
    public enum TiposInstancias {N_POR_RANDOM_BD,N_POR_RANDOM_CLASE}
    
   private  ArrayList<ClasificadorSupervisado> clasificadores;
   private  ArrayList<AmbienteDeClasificacion> ambientesClasificacion;
   private  ArrayList<Patron> bdOriginal;
   private  ArrayList<Double[]> rendimientos;

    public EscenarioDeClasificacion(ArrayList<ClasificadorSupervisado> clasificadores, ArrayList<AmbienteDeClasificacion> ambientesClasificacion, ArrayList<Patron> bdOriginal, ArrayList<Double[]> rendimientos) {
        this.clasificadores = clasificadores;
        this.ambientesClasificacion = ambientesClasificacion;
        this.bdOriginal = bdOriginal;
        this.rendimientos = rendimientos;
    }
    
    public EscenarioDeClasificacion(ArrayList<ClasificadorSupervisado> clasificadores, int noAmbientes,TiposInstancias[] tipoInstancias,int n0,int n1) throws IOException{
      this.clasificadores = clasificadores;
      this.bdOriginal = Tokenizador.abrirFile();
      this.rendimientos = new ArrayList<>();
      // crear las ambientes de clasificacion en base a noAmbientes y tipoInstancias
      this.ambientesClasificacion = creaAmbientesDeClasificacion(noAmbientes,tipoInstancias,n0,n1);
    }

    
     private ArrayList<AmbienteDeClasificacion> creaAmbientesDeClasificacion(int noAmbientes, TiposInstancias[] tipoInstancias, int n0,int n1) {
        // arreglo de ambientes
        ArrayList<AmbienteDeClasificacion> aux = new ArrayList<>();
       
       // en cada iteración tengo que crear un ambiente completo 
       for (int x = 0; x < noAmbientes; x++ ){
        // crear las instancias de entrenamiento y clasificacion
        ArrayList<Patron> iEntrenamiento = creaInstancia(tipoInstancias[0],n0);
        ArrayList<Patron> iClasificacion = creaInstancia(tipoInstancias[1],n1);
        // instanciamos el ambiente de clasificacion
        AmbienteDeClasificacion auxAmbiente = new AmbienteDeClasificacion(iEntrenamiento, iClasificacion);
        // agregamos 
        aux.add(auxAmbiente);
       }
       
       return aux;
    }
   

    public void ejecutaEscenarioDeClasificacion (int porcentaje){
       try {
           // abrir el archivo
           this.bdOriginal = Tokenizador.abrirFile();
           GeneradorDeInstanciasTODELETE ge = new GeneradorDeInstanciasTODELETE(this.bdOriginal);
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
    
   
     private ArrayList<Patron> creaInstancia(TiposInstancias tipoInstancia,int n) {
        ArrayList<Patron> aux;
        // mandamos la bd original
        Instancias.bdOriginal = this.bdOriginal;
        switch (tipoInstancia){
        
            case N_POR_RANDOM_BD: {
                aux = Instancias.nPorRandomBD(n);
                break;}
            case N_POR_RANDOM_CLASE:{
                aux = Instancias.nPorRandomClase(n);
                break;}
            default:{
            
            aux = null;
                    }
        
            
        }
        return aux;
    }


  
   
}
