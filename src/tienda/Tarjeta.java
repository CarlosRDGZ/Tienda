/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

/**
 *
 * @author Daniel
 */
public class Tarjeta {
    
    private String apPaterno;
    private String apMaterno;
    private String nombre;
    private long idTarjeta;
    private int puntos;
    private int numeroDeRegistro;

    /**
     * @return the apPaterno
     */
    Tarjeta ()
    {}
   
    public Tarjeta(String apPaterno, String apMaterno, String nombre,
        long idTarjeta, int puntos, int numeroDeRegistro)
    {
        this.apMaterno = apMaterno;
        this.apPaterno = apPaterno;
        this.nombre = nombre;
        this.idTarjeta = idTarjeta;
        this.puntos = puntos;
        this.numeroDeRegistro = numeroDeRegistro;
    }
    
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * @param apPaterno the apPaterno to set
     */
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    /**
     * @return the apMaterno
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * @param apMaterno the apMaterno to set
     */
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
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
     * @return the idTarjeta
     */
    public Long getIdTarjeta() {
        return idTarjeta;
    }

    /**
     * @param idTarjeta the idTarjeta to set
     */
    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the numeroDeRegistro
     */
    public int getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    /**
     * @param numeroDeRegistro the numeroDeRegistro to set
     */
    public void setNumeroDeRegistro(int numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }
}
