package tienda;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Archivo<E>
{
    protected RandomAccessFile archivo;

    public Archivo(String nombreArchivo)
    {
        try 
        {archivo = new RandomAccessFile (nombreArchivo + ".dmc", "rw");} 
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
