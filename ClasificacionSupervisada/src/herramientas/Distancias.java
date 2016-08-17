/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Distancias {
    
    public static double calculaDistanciaEcuclidiana(Patron p1,Patron p2){
     double acum = 0;
     
     for (int x=0;x < p1.getVector().length;x++){
     acum+=Math.pow((p2.getVector()[x]-p1.getVector()[x]),2);
     
     }
     return Math.sqrt(acum);
    }
    
}
