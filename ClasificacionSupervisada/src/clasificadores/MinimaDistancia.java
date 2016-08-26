/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import herramientas.Herramientas;
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
         int indice = verifiqueExistenciaDeClase(patron.getClase());
           if(indice==-1){
            // creamos la nueva media
            Media nuevaMedia = new Media(patron.getVector().clone(),patron.getClase());
            this.medias.add(nuevaMedia);
        }else{
        // acumulamos a la media existente
          acumularAMedia(indice,patron);
        }
       }
       // calculamos las medias
       for(Media media: this.medias)
           media.divide();
     
    }

    @Override
    public String clasifica(Patron patron) {
        String nC="";
        if (this.medias.size()>0){
        double distM = Herramientas.calculaDistanciaEcuclidiana(patron, this.medias.get(0));
        nC =  this.medias.get(0).getClase();
        // recorrer todas las medias
         for (Media aux: this.medias){
         // comparar distancias 
         double distAux = Herramientas.calculaDistanciaEcuclidiana(patron,(Patron)aux);
         if(distAux<distM){
           distM = distAux;
           nC =  aux.getClase();
         }
         
         }
        }
              
        return nC;
    }

    private int verifiqueExistenciaDeClase(String clase) {
              
        // recorrer la lista de medias
        for (int x=0; x < this.medias.size();x++){
          if (clase.equals(this.medias.get(x).getClase())){
           return x;
          }
        }
        return -1;
    }

    private void acumularAMedia(int indice, Patron patron) {
       // recorrer el arreglo para generar el acumulado
       for (int x=0; x < patron.getVector().length;x++){
        this.medias.get(indice).getVector()[x]+=patron.getVector()[x];
       }
       this.medias.get(indice).acumula();
    }
    
    @Override
    public void clasificaConjunto(ArrayList<Patron> conjunto){
        // recorremos todo el conjunto 
        for (Patron p : conjunto){
            // obteniendo el resultado de clasifiacion
        String resultado = clasifica(p);
        // seteando el resultado
        p.setClaseRes(resultado);
        
        }
        
    }
}
