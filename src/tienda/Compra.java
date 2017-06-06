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
    
    private String idProducto;
    private String idTarjeta;
    private int tipo;
    private String fecha;
    private String hora;
    private int numRegistro;
    
    public Compra(){}

    public Compra(String idProducto, String idTarjeta, int tipo, String fecha, String hora, int numRegistro) {
        this.idProducto = idProducto;
        this.idTarjeta = idTarjeta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.numRegistro = numRegistro;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getIdTarjeta() {
        return idTarjeta;
    }

    public int getTipo() {
        return tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdTarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }
}
