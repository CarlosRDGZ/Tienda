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
            File llaveFile = new File(file.toString() + "/batman.dmc");
            File usuarioFile = new File(file.toString() + "/robin.dmc");
            llave = new RandomAccessFile(llaveFile, "rw");
            usuario = new RandomAccessFile(usuarioFile, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoLlave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    abstract void escrbirCodigoAcceso();
    
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