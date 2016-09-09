/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionsupervisada;

import clasificadores.ClasificadorSupervisado;
import clasificadores.Knn;
import clasificadores.MinimaDistancia;
import herramientas.Tokenizador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.AmbienteDeClasificacion;
import objetos.EscenarioDeClasificacion;
import objetos.Instancias;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ClasificacionSupervisada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            ArrayList<ClasificadorSupervisado> clasificadores = new ArrayList<>();
            clasificadores.add(new Knn(4) );
            clasificadores.add(new MinimaDistancia() );
            
           // clasificadores.add(new MinimaDistancia() );
            
            EscenarioDeClasificacion e1 = new EscenarioDeClasificacion(clasificadores, 500, new EscenarioDeClasificacion.TiposInstancias[]{EscenarioDeClasificacion.TiposInstancias.N_POR_RANDOM_BD,EscenarioDeClasificacion.TiposInstancias.N_POR_RANDOM_CLASE},100, 100);
            e1.ejecutaEscenarioDeClasificacion();
            e1.graficarRendimientos();
        
//              ArrayList<Patron> bd = Tokenizador.abrirFile();
//              Instancias.bdOriginal = bd;
//              // generar las instancias de entrenamiento y clasificacion
//            
//            ArrayList<AmbienteDeClasificacion> ambientes = new ArrayList<>();
//            
//            ArrayList<Patron> ie = Instancias.nPorRandomBD(80);
//            ArrayList<Patron> ic = Instancias.nPorRandomClase(50);
//            ambientes.add(new AmbienteDeClasificacion(ie, ic));
//            System.out.println();
            
//            Knn knn = new Knn(6);
//            knn.entrenar(ce);
//            knn.clasifica(new Patron(new double[]{6.7,3.1,4.7,1.5},"Versicolor"));
//
            
//        ArrayList<ClasificadorSupervisado> clasificadores = new ArrayList<>();
//        clasificadores.add(new MinimaDistancia());
//        clasificadores.add(new MinimaDistancia());
//        EscenarioDeClasificacion ec1 = new EscenarioDeClasificacion(clasificadores);
//        ec1.ejecutaInstancia(2);
//        System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(ClasificacionSupervisada.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
}
