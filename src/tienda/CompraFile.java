/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraFile extends ArchivoAbstracto {
    private final int RECORD_SIZE = 24;

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
    
    public Compra leerRegistro(int numRegistro)
    {
        try
        {
            archivo.seek(numRegistro*RECORD_SIZE);
            
            long idProducto = archivo.readLong();
            
            long idTarjeta = archivo.readLong();
            
            int tipo = archivo.readInt();
            
            int numDeRegistro = archivo.readInt();
            
            return new Compra(idProducto, idTarjeta, tipo,numDeRegistro);
        } catch (IOException ex) {
            Logger.getLogger(CompraFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
