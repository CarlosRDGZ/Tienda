package tienda;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LlaveTarjeta extends ArchivoLlave<Tarjeta> {

    public LlaveTarjeta(File file) {
        super(file);
    }

    @Override
    void escrbirCodigoAcceso(String codigo) {
        try {
            llave.writeBytes(codigo);
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    String leerCodigo() {
        try
        {
            llave.seek(0);
            
            byte[] bString = new byte[166];
            llave.read(bString);
            String str = new String(bString);
            return str;
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    void escribirDatos(Tarjeta e) {
        
        try {
            usuario.seek(0);
            
            String apPaterno  = e.getApPaterno();
            apPaterno = setLongitudString(apPaterno, 15);
            usuario.writeBytes(apPaterno);

            String apMaterno = e.getApMaterno();
            apMaterno= setLongitudString(apMaterno,15);
            usuario.writeBytes(apMaterno);

            String nombre = e.getNombre();
            nombre = setLongitudString(nombre,25);
            usuario.writeBytes(nombre);

            String idTarjeta = e.getIdTarjeta();
            usuario.writeBytes(idTarjeta);

            usuario.writeInt(e.getPuntos());
            
            String contra = e.getContrasenia();
            contra = setLongitudString(contra,16);
            usuario.writeBytes(contra);

            usuario.writeInt(e.getNumeroDeRegistro());
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    Tarjeta leerDatos() {
        try {
            usuario.seek(0);
            
            byte paterno[]=new byte [15];
            usuario.read(paterno);
            String apPaterno = getStringArreglada(paterno);
            
            byte materno []= new byte[15];
            usuario.read(materno);
            String apMaterno = getStringArreglada(materno);
            
            
            byte nombre []= new byte[25];
            usuario.read(nombre);
            String name = getStringArreglada(nombre);
            
            byte[] bIdTarjeta = new byte[8];
            
            usuario.read(bIdTarjeta);
            String idTarjeta = new String(bIdTarjeta);
            
            int puntos = usuario.readInt();
            
            byte[] bContra = new byte[16];
            usuario.read(bContra);
            String contra = getStringArreglada(bContra);
            
            int numeroDeRegistro = usuario.readInt();
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}