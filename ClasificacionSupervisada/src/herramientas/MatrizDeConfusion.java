/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import java.util.LinkedList;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MatrizDeConfusion {
    
    private ArrayList<Patron> instancias;
    private double[] efectivadad;
    private double[] porcClase;
    private double rendimientoGral;
    private int[][] matrizConfusion;

    public MatrizDeConfusion(ArrayList<Patron> instancias) {
       this.instancias = instancias;
       this.rendimientoGral = 0;
       determinarNumeroClases();
    
    }

    private void determinarNumeroClases() {
         int nC;
       ArrayList<String> clases = new ArrayList<>();
       // calcular el numero de clases 
       // recorrer todas las instancias 
       for (Patron patron: this.instancias){
           // validar si existe en la coleccion de clases 
           if (!clases.contains(patron.getClase())){
             clases.add(patron.getClase());
           }
       }
         nC = clases.size();
       // cuando ya se tenga el numero de clases 
        this.efectivadad = new double[nC];
        this.porcClase = new double[nC];
        this.matrizConfusion = new int[nC][nC];
        
        // vamos a calcular la matriz de confusión 
        int r,c;
        for (Patron patron: this.instancias){
           r = clases.indexOf(patron.getClase());
           c = clases.indexOf(patron.getClaseRes());
           this.matrizConfusion[r][c]++;
        }
        
        System.out.println();
        
        int[] aux1 = new int[nC];
        int[] aux2 = new int[nC];
        int y;        
        for(int x=0;x<nC;x++)
        {                    
            for(y=0;y<nC;y++)
            {
                aux1[x]+=matrizConfusion[x][y];
                aux2[x]+=matrizConfusion[y][x];
            }            
        }
        
        for(int x=0;x<nC;x++)
        {
            efectivadad[x] = (matrizConfusion[x][x]*100)/aux1[x];
            porcClase[x] = (aux2[x]*100)/instancias.size();            
        }
        
        System.out.println();
        
        
    }
    
    
    
    
    
}
