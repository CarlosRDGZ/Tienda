/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraFile extends Archivo<Compra> {
    private final int RECORD_SIZE = 49;

    public CompraFile(String nombreArchivo) {
        super(nombreArchivo);
    }
    
    

    @Override
    public void eliminar() {
        try {
            archivo.setLength(archivo.length()-RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(CompraFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int numeroDeRegistros() {
        try { 
            return (int) (archivo.length() / RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(CompraFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    @Override
    public Compra leerRegistro(int numRegistro)
    {
        try
        {
            archivo.seek(numRegistro*RECORD_SIZE);
            
            byte[] bIDProd = new byte[8];
            archivo.read(bIDProd);
            String idProd = new String(bIDProd);
            
            byte[] bIDTarjeta = new byte[8];
            archivo.read(bIDTarjeta);
            String idTarjeta = new String(bIDTarjeta);
            
            byte[] bTipo = new byte[8];
            archivo.read(bTipo);
            String tipo = new String(bTipo);
            
            byte[] bFecha = new byte[10];
            archivo.read(bFecha);
            String fecha = new String(bFecha);
            
            byte[] bHora = new byte[11];
            archivo.read(bHora);
            String hora = new String(bHora);
            
            int numDeReg = archivo.readInt();
            
            return new Compra(idProd, idTarjeta, tipo, fecha, hora, numDeReg);
        } catch (IOException ex) {
            Logger.getLogger(CompraFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    void grabarRegistro(Compra compra, int numDeRegistro) {
        try {
            archivo.seek(numDeRegistro * RECORD_SIZE);
            
            archivo.writeBytes(compra.getIdProducto());
            
            archivo.writeBytes(compra.getIdTarjeta());
            
            archivo.writeBytes(setLongitudString(compra.getTipo(), 8));
            
            archivo.writeBytes(compra.getFecha());
            
            archivo.writeBytes(compra.getHora());
            
            archivo.writeInt(compra.getNumRegistro());
            
        } catch (IOException ex) {
            Logger.getLogger(CompraFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Compra> leerTodos() {
        ArrayList<Compra> todos = new ArrayList();
        for(int i = 0; i < numeroDeRegistros(); i++) {
            todos.add(leerRegistro(i));
        }
        return todos;
    }
    
}
