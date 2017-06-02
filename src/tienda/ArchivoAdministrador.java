package tienda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoAdministrador extends ArchivoAbstracto {
    private final int RECORD_SIZE = 24;
    
    public ArchivoAdministrador(String nombreArchivo) {
        super(nombreArchivo);
    }
    
    @Override
    void eliminar() {
        try {
            archivo.setLength(archivo.length() - RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    int numeroDeRegistros() {
        try {
            return (int)(archivo.length()/RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public Administrador leerRegistro(int numRegistro)
    {
        try
        {
            archivo.seek(numRegistro*RECORD_SIZE);
            
            byte[] bUsuario = new byte[8];
            archivo.read(bUsuario);
            String usuario = getStringArreglada(bUsuario);
            
            byte[] bContrasenia = new byte[16];
            archivo.read(bContrasenia);
            String contrasenia = getStringArreglada(bContrasenia);
            
            return new Administrador(usuario, contrasenia);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void grabarRegistro(Administrador administrador, int numRegistro) {
         try
        {
            archivo.seek(numRegistro*RECORD_SIZE);
            
            archivo.writeBytes(setLongitudString(administrador.getUsuario(), 8));
            
            archivo.writeBytes(setLongitudString(administrador.getContrasenia(), 16));
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Administrador> leerTodos() {
        ArrayList<Administrador> todos = new ArrayList();
        for(int i = 0; i < numeroDeRegistros(); i++)
            todos.add(null);
        return todos;
    }
}