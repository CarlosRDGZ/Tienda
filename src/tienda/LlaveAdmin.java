package tienda;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LlaveAdmin extends ArchivoLlave<Administrador> {

    public LlaveAdmin(File file) {
        super(file);
    }

    @Override
    void escrbirCodigoAcceso() {
        try {
            String clave = "Administrador";
            clave = ControladorAdministrador.crearSeguridad(clave);
            
            String codigo = "";
            
            for(int i = 0; i < clave.length(); i++){
                int chr = clave.charAt(i);
                codigo += Integer.toHexString((int)chr);
            }
            System.out.println(codigo);
            llave.writeBytes(codigo);
        } catch (IOException ex) {
            Logger.getLogger(LlaveAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    String leerCodigo() {
        try
        {
            llave.seek(0);
            
            byte[] bString = new byte[26];
            llave.read(bString);
            String str = new String(bString);

            int[] hex = new int[13];

            String digits = "0123456789abcdef";
            for(int i = 0; i < 26; i += 2) {

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
            Logger.getLogger(LlaveAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    void escribirDatos(Administrador e) {
        
        try {
            usuario.seek(0);
            
            String user = ControladorAdministrador.crearSeguridad(e.getUsuario());
            usuario.writeBytes(setLongitudString(user, 8));
            
            String contra = ControladorAdministrador.crearSeguridad(e.getContrasenia());
            usuario.writeBytes(setLongitudString(contra, 16));
            
            usuario.writeInt(e.getNumDeRegistro());
            
        } catch (IOException ex) {
            Logger.getLogger(LlaveAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    Administrador leerDatos() {
        try {
            usuario.seek(0);
            
            byte[] bUsuario = new byte[8];
            usuario.read(bUsuario);
            String user = getStringArreglada(bUsuario);
            user = ControladorAdministrador.inverso(user);
            
            byte[] bContrasenia = new byte[16];
            usuario.read(bContrasenia);
            String contrasenia = getStringArreglada(bContrasenia);
            contrasenia = ControladorAdministrador.inverso(contrasenia);
            
            int numDeRegistro = usuario.readInt();
            
            return new Administrador(user, contrasenia, numDeRegistro);
        } catch (IOException ex) {
            Logger.getLogger(LlaveAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}