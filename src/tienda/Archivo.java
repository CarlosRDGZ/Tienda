package tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Archivo<E>
{
    protected RandomAccessFile archivo;
    private RandomAccessFile idsArchivo;

    public Archivo(String nombreArchivo)
    {
        try 
        {
            archivo = new RandomAccessFile (nombreArchivo + ".dmc", "rw");
            idsArchivo = new RandomAccessFile(nombreArchivo + "ID.dmc", "rw");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    abstract void grabarRegistro(E e, int numDeRegistro);
    
    abstract E leerRegistro(int numDeRegistro);
    
    abstract ArrayList<E> leerTodos();

    abstract void eliminar();

    abstract int numeroDeRegistros();
    
    public void grabarIdActual(long id) {
        try {
            idsArchivo.seek(0);
            idsArchivo.writeLong(id);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public long obtenerIdActual() {
        try {
            idsArchivo.seek(0);
            return idsArchivo.readLong();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public boolean idRegistrado() {
        try {
            return idsArchivo.length() == 8;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    protected String setLongitudString(String string, int longitud)
    {
        StringBuilder strBldr = new StringBuilder(string);

        strBldr.setLength(longitud);

        return strBldr.toString();
    }

    protected String getStringArreglada(byte strBytes[])
    {
        String str = new String(strBytes);

        if(str.indexOf('\0') != -1)
            return str.substring(0, str.indexOf('\0'));
        else
            return str;
    }
}
