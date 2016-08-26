/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Distancias {
    
    private String clase;
    private double distancia;

    public Distancias() {
        this.clase = "";
        this.distancia = 0;
    }
    
    public Distancias(Distancias d){
      this.clase = d.getClase();
      this.distancia = d.getDistancia();
    
    }

    public Distancias(String clase, Patron p1, Patron p2) {
        this.clase = clase;
        this.distancia = herramientas.Herramientas.calculaDistanciaEcuclidiana(p1, p2);
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }
    
    
    
}
