/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificacionsupervisada;

import clasificadores.ClasificadorSupervisado;
import clasificadores.MinimaDistancia;
import java.util.ArrayList;
import objetos.EscenarioDeClasificacion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ClasificacionSupervisada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<ClasificadorSupervisado> clasificadores = new ArrayList<>();
        clasificadores.add(new MinimaDistancia());
        clasificadores.add(new MinimaDistancia());
        EscenarioDeClasificacion ec1 = new EscenarioDeClasificacion(clasificadores);
        ec1.ejecutaInstancia(2);
        System.out.println();
        
    }
    
}
