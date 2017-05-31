
package tienda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoProducto extends ArchivoAbstracto
{
    private final int RECORD_SIZE = 36;
    
    public ArchivoProducto(String nombreArchivo) {
        super(nombreArchivo);
    }

    @Override
    void eliminar() {
        try {
            archivo.setLength(archivo.length() - RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    int numeroDeRegistros() {
        try {
            return (int)(archivo.length()/RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public Producto leerRegistro(int numRegistro)
    {
        try
        {
            archivo.seek(numRegistro*RECORD_SIZE);
            
            byte[] bNombre = new byte[20];
            archivo.read(bNombre);
            String nombre = getStringArreglada(bNombre);
            
            float costo = archivo.readFloat();
            
            long productoID = archivo.readLong();
            
            int numDeRegistro = archivo.readInt();
            
            return new Producto(nombre, costo, productoID, numDeRegistro);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarRegistro(Producto producto, int numRegistro)
    {
        try
        {
            archivo.seek(numRegistro*RECORD_SIZE);
            
            archivo.writeBytes(setLongitudString(producto.getNombre(), 20));
            
            archivo.writeFloat(producto.getCosto());
            
            archivo.writeFloat(producto.getCodigo());
            
            archivo.writeInt(producto.getNumDeRegistro());
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Producto> leerTodos()
    {
        ArrayList<Producto> todos = new ArrayList();
        for(int i = 0; i < numeroDeRegistros(); i++)
            todos.add(null);
        return todos;
    }
}
