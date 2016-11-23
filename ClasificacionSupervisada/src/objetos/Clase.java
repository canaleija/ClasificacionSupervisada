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
public class Clase {
    
    private String nombre;
    private int numeroDeElementos;

    public Clase() {
        this.nombre = "Desconocida";
        this.numeroDeElementos = 0;
        
        
    }

    public Clase(String nombre, int numeroDeElementos) {
        this.nombre = nombre;
        this.numeroDeElementos = numeroDeElementos;
    }

    public void agregaElemento(){
     this.numeroDeElementos++;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numeroDeElementos
     */
    public int getNumeroDeElementos() {
        return numeroDeElementos;
    }

    /**
     * @param numeroDeElementos the numeroDeElementos to set
     */
    public void setNumeroDeElementos(int numeroDeElementos) {
        this.numeroDeElementos = numeroDeElementos;
    }

    @Override
    public boolean equals(Object obj) {
        Clase clase = (Clase)obj;
        if (this.nombre.equals(clase.getNombre())){
        return true;
        }else {
        return false;
        }
        
    }
    
    
    
    
    
    
    
    
}
