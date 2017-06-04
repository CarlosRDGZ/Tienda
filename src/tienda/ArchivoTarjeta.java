package tienda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoTarjeta extends Archivo<Tarjeta>
{
    private  final int RECORD_SIZE = 87;
    
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
    
    @Override
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
            
            byte[] bIdTarjeta = new byte[8];
            
            archivo.read(bIdTarjeta);
            String idTarjeta = new String(bIdTarjeta);
            
            int puntos = archivo.readInt();
            
            byte[] bContra = new byte[16];
            archivo.read(bContra);
            String contra = getStringArreglada(bContra);
            
            int numeroDeRegistro = archivo.readInt();
            
            return new Tarjeta(apPaterno, apMaterno, name, idTarjeta, puntos, contra, numeroDeRegistro);
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void grabarRegistro(Tarjeta tarjeta, int numRegistro)
    {
        try
        {
            long posicion = RECORD_SIZE * numRegistro;
            
            archivo.seek(posicion);
            
            String apPaterno  = tarjeta.getApPaterno();
            apPaterno = setLongitudString(apPaterno, 15);
            archivo.writeBytes(apPaterno);

            String apMaterno = tarjeta.getApMaterno();
            apMaterno= setLongitudString(apMaterno,15);
            archivo.writeBytes(apMaterno);

            String nombre = tarjeta.getNombre();
            nombre = setLongitudString(nombre,25);
            archivo.writeBytes(nombre);

            String idTarjeta = tarjeta.getIdTarjeta();
            archivo.writeBytes(idTarjeta);

            archivo.writeInt(tarjeta.getPuntos());
            
            String contra = tarjeta.getContrasenia();
            contra = setLongitudString(contra,16);
            archivo.writeBytes(contra);

            archivo.writeInt(tarjeta.getNumeroDeRegistro());
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
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
