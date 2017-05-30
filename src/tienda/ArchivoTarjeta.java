package tienda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoTarjeta extends ArchivoAbstracto
{
    private  final int RECORD_SIZE = 67;
    
    public ArchivoTarjeta(String nombreArchivo) {
        super(nombreArchivo);
    }

    @Override
    public void eliminar() {
        try {
            archivo.setLength(archivo.length() - RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int numeroDeRegistros()
    {
        try {
            return (int)(archivo.length()/RECORD_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public Tarjeta leerRegistro(int numRegistro)
    {
        try
        {
            archivo.seek(numRegistro * RECORD_SIZE);
            
            byte paterno[]=new byte [15];
            archivo.read(paterno);
            String apPaterno = getStringArreglada(paterno);
            
            byte materno []= new byte[15];
            archivo.read(materno);
            String apMaterno = getStringArreglada(materno);
            
           
            byte nombre []= new byte[25];
            archivo.read(nombre);
            String name = getStringArreglada(nombre);
            
            long idTarjeta = archivo.readLong();
            
            int puntos = archivo.readInt();
            
            int numeroDeRegistro = archivo.readInt();
            
            return new Tarjeta(apPaterno, apMaterno, name, idTarjeta, puntos, numeroDeRegistro);
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarRegistro(Tarjeta tarjeta, int numRegistro)
    {
        try
        {
            long posicion = RECORD_SIZE * numRegistro;
            archivo.seek(posicion);
            String apPaterno  = tarjeta.getApMaterno();
            apPaterno = setLongitudString(apPaterno, 15);
            archivo.writeBytes(apPaterno);

            String apMaterno = tarjeta.getApMaterno();
            apMaterno= setLongitudString(apMaterno,15);
            archivo.writeBytes(apMaterno);

            String nombre = tarjeta.getNombre();
            nombre = setLongitudString(nombre,25);
            archivo.writeBytes(nombre);

            archivo.writeLong(tarjeta.getIdTarjeta());

            archivo.writeInt(tarjeta.getPuntos());

            archivo.writeInt(tarjeta.getNumeroDeRegistro());
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Tarjeta> leerTodos()
    {
        ArrayList<Tarjeta> todosRegistros = new ArrayList();
        for(int i = 0; i < numeroDeRegistros(); i++)
        {
            Tarjeta tarjeta = leerRegistro(i);
            todosRegistros.add(tarjeta);
        }
        return todosRegistros;
    }
}
