/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public interface ClasificadorSupervisado {
    
    void entrenar(ArrayList<Patron> conjuntoEntrenamiento);
    String clasifica(Patron patron);
    
}
