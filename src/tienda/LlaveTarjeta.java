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
    void escrbirCodigoAcceso() {
        try {
            String clave = "Tarjeta de Lealtad";
            String codigo = "";
            for(int i = 0; i < clave.length(); i++){
                int chr = clave.charAt(i);
                codigo += Integer.toHexString((int)chr);
            }
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
            
            byte[] bString = new byte[36];
            llave.read(bString);
            String str = new String(bString);
            
            int[] hex = new int[13];

            String digits = "0123456789abcdef";
            for(int i = 0; i < 36; i += 2) {

                String s = str.substring(i, i+2);
                int power = 1;

                for(int j = 0; j < 2; j++) 
                {
                    char c = s.charAt(j);
                    int dec = digits.indexOf(c);
                    hex[i/2] += (Math.pow(16, power--)) * dec;
                }
            }

            StringBuilder readCode =  new StringBuilder();
            for(int i = 0; i < hex.length; i++)
                readCode.append((char) hex[i]);
            
            str = ControladorAdministrador.inverso(readCode.toString());
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
            
            String apPaterno  = ControladorTarjeta.crearSeguridad(e.getApPaterno());
            apPaterno = setLongitudString(apPaterno, 15);
            usuario.writeBytes(apPaterno);

            String apMaterno = ControladorTarjeta.crearSeguridad(e.getApMaterno());
            apMaterno= setLongitudString(apMaterno,15);
            usuario.writeBytes(apMaterno);

            String nombre = ControladorTarjeta.crearSeguridad(e.getNombre());
            nombre = setLongitudString(nombre,25);
            usuario.writeBytes(nombre);

            String idTarjeta = ControladorTarjeta.crearSeguridad(e.getIdTarjeta());
            usuario.writeBytes(idTarjeta);

            usuario.writeInt(e.getPuntos());
            
            String contra = ControladorTarjeta.crearSeguridad(e.getContrasenia());
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
            apPaterno = ControladorTarjeta.inverso(apPaterno);
            
            byte materno []= new byte[15];
            usuario.read(materno);
            String apMaterno = getStringArreglada(materno);
            apMaterno = ControladorTarjeta.inverso(apMaterno);            
            
            byte nombre []= new byte[25];
            usuario.read(nombre);
            String name = getStringArreglada(nombre);
            name = ControladorTarjeta.inverso(name);
            
            byte[] bIdTarjeta = new byte[8];
            
            usuario.read(bIdTarjeta);
            String idTarjeta = new String(bIdTarjeta);
            idTarjeta = ControladorTarjeta.inverso(idTarjeta);
            
            int puntos = usuario.readInt();
            
            byte[] bContra = new byte[16];
            usuario.read(bContra);
            String contra = getStringArreglada(bContra);
            contra = ControladorTarjeta.inverso(contra);
            
            int numeroDeRegistro = usuario.readInt();
            
            return new Tarjeta(apPaterno, apMaterno, name, idTarjeta, puntos, contra, numeroDeRegistro);
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}