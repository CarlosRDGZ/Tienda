package tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Identificadores {
    
    private RandomAccessFile archivo;
    
    public Identificadores() {
        try {
            archivo =  new RandomAccessFile("Identificadores.dmc", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIdProdutos(long id) {
        try {
            archivo.seek(0);
            
            archivo.writeLong(id);
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIdTarjeta(long id) {
        try {
            archivo.seek(8);
            
            archivo.writeLong(id);
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIdAdministradores(long id) {
        try {
            archivo.seek(16);
            
            archivo.writeLong(id);
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIdCompra(long id) {
        try {
            archivo.seek(24);
            
            archivo.writeLong(id);
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public long getIdProductos() {
        try {
            archivo.seek(0);
            
            return archivo.readLong();
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public long getIdTarjeta() {
        try {
            archivo.seek(8);
            
            return archivo.readLong();
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public long getIdAdministradores() {
        try {
            archivo.seek(16);
            
            return archivo.readLong();
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public long getIdCompras() {
        try {
            archivo.seek(24);
            
            return archivo.readLong();
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public long longitudIdentificadores() {
        try {
            archivo.length();
        } catch (IOException ex) {
            Logger.getLogger(Identificadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
