/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

/**
 *
 * @author Michelita
 */
public class Compra {
    
    private long idProducto;
    private long idTarjeta;
    private int tipo;
    private int numRegistro;
    
    public Compra(long idProducto, long idTarjeta, int tipo, int numRegistro){
        this.idProducto= idProducto;
        this.idTarjeta=idTarjeta;
        this.tipo=tipo;
        this.numRegistro=numRegistro;
    }
    
    public long getIdProducto() {
        return idProducto;
    }

    
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    
    public long getIdTarjeta() {
        return idTarjeta;
    }

    
    public void setIdTarjeta(long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    
    public int getTipo() {
        return tipo;
    }

    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    
    public int getNumRegistro() {
        return numRegistro;
    }
    
    public void setNumRegistro(int numRegistro){
        this.numRegistro= numRegistro;
    }
}
