package tienda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class ArchivoLlave<E>{
    
    protected RandomAccessFile llave;
    protected RandomAccessFile usuario;
    protected RandomAccessFile compras;
    
    public ArchivoLlave(File file) {
        try {
            llave = new RandomAccessFile(file.toString() + "batman.dmc", "rw");
            usuario = new RandomAccessFile(file.toString() + "robin.dmc", "rw");
            compras = new RandomAccessFile(file.toString() + "baticueva.dmc", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoLlave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    abstract void escrbirCodigoAcceso(String codigo);
    
    abstract String leerCodigo();

    abstract void escribirDatos(E e);
    
    abstract E leerDatos();
    
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