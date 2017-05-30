package tienda;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ArchivoAbstracto
{
    protected RandomAccessFile archivo;

    public ArchivoAbstracto(String nombreArchivo)
    {
        try 
        {archivo = new RandomAccessFile (nombreArchivo + ".dat", "rw");} 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(ArchivoAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

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
