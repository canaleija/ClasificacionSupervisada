/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import clasificadores.ClasificadorSupervisado;
import clasificadores.MinimaDistancia;
import graficacion.Grafica;
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
    
      // crear las ambientes de clasificacion en base a noAmbientes y tipoInstancias
      this.ambientesClasificacion = creaAmbientesDeClasificacion(noAmbientes,tipoInstancias,n0,n1);
        this.rendimientos = inicializarRendimientos();
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
   

    public void ejecutaEscenarioDeClasificacion (){
      
        // ejecutar todos los n ambientes de clasificación 
        
        for (int x=0; x<this.ambientesClasificacion.size();x++){
            // ciclo para obtener los rendimientos de cada ambiente 
             // recorrer los diferentes clasificadores para entrenarlos 
           // entrenamiento y clasificación
           int iC = 0;
         
           for (ClasificadorSupervisado clasificador: this.clasificadores){
             clasificador.entrenar((ArrayList<Patron>) this.ambientesClasificacion.get(x).getiEntrenamiento().clone());
             clasificador.clasificaConjunto(this.ambientesClasificacion.get(x).getiClasificacion());
            
             // calculamos el rendimiento 
             int acumulador = 0;
             for (Patron p: this.ambientesClasificacion.get(x).getiClasificacion()){
               if (p.verificaClasificacion()){
                acumulador++;
               }
             }
             double pCla = (acumulador*100)/this.ambientesClasificacion.get(x).getiClasificacion().size();
             this.rendimientos.get(iC)[x] = pCla;
             iC++;
           }
                  
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

 private ArrayList<Double[]> inicializarRendimientos() {
    ArrayList<Double[]>  rendimientos = new  ArrayList<>();
     for (int x=0; x < this.clasificadores.size();x++){
       rendimientos.add(new Double[this.ambientesClasificacion.size()]);
     }
         
         return rendimientos;
    }

   public void graficarRendimientos(){
 
    Grafica grafica = new Grafica("Rendimientos","%","Ambiente");
    for (int x=0; x < this.rendimientos.size();x++){
        grafica.agregarSerie(this.rendimientos.get(x),this.clasificadores.get(x).getClass().getName()+"-"+x);
    }
    grafica.creaYmuestraGrafica();
   }
  
   
}
