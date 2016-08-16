/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;
import objetos.Media;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MinimaDistancia implements ClasificadorSupervisado{

    private ArrayList<Patron> conjuntoEntrenamiento;
    private ArrayList<Media> medias;
        
    @Override
    public void entrenar(ArrayList<Patron> conjuntoEntrenamiento) {
       //calcular los vectores representativos
       // analizar, contar, acumualar
       this.medias = new ArrayList<>();
       Media primero = new Media(conjuntoEntrenamiento.get(0).getVector().length);
       primero.setClase(conjuntoEntrenamiento.get(0).getClase());
       primero.setAcumalador(0);
       this.medias.add(primero);
       // recorrer todos los elementos de mi conjunto de entrenamiento
       for(Patron patron:conjuntoEntrenamiento){
           // TODO: PASAR EL ELEMENTO QUE BUSCARÁ EN LA LISTA DE MEDIAS
         int indice = verifiqueExistenciaDeClase();
           if(indice==-1){
            // creamos la nueva media
            Media nuevaMedia = new Media(patron.getVector().clone(),patron.getClase());
            this.medias.add(nuevaMedia);
        }else{
        // acumulamos a la media existente
          acumularAMedia(indice,patron);
        }
       }
    }

    @Override
    public String clasifica(Patron patron) {
        return null;
    }

    private int verifiqueExistenciaDeClase() {
        return 0;
    }

    private void acumularAMedia(int indice, Patron patron) {
       // recorrer el arreglo para generar el acumulado
       for (int x=0; x < patron.getVector().length;x++){
        this.medias.get(indice).getVector()[x]+=patron.getVector()[x];
       }
       this.medias.get(indice).acumula();
    }
    
}
