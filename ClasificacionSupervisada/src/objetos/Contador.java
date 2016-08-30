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
public class Contador {
    
    private int cantidad;
    private String clase;

    public Contador(int cantidad, String clase) {
        this.cantidad = cantidad;
        this.clase = clase;
    }

    public Contador() {
        this.clase = null;
        this.cantidad = 0;
    }

    public void acumula(){
     this.cantidad++;
    }
    public int getCantidad() {
        return cantidad;
    }

    public String getClase() {
        return clase;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public boolean equals(Object obj) {
        Contador con = (Contador)obj;
       
          return this.clase.equals(con.getClase());
          }
    
    
    
    
    
}
