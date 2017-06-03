package tienda;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Controlador {
    
    public static boolean tarjetaValida(File path) {
        try 
        {
            RandomAccessFile file = new RandomAccessFile(path, "r");
            
            if(file.length() == 166) {
            
                file.seek(0);

                byte[] bytes = new byte[166];
                file.read(bytes);
                String readBytes = new String(bytes);

                int[] hex = new int[83];

                String digits = "0123456789abcdef";
                for(int i = 0; i < 166; i += 2) {

                    String s = readBytes.substring(i, i+2);
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

                String code = "Nueva tarjeta de lealta. Esta tarjeta permite alamacenar puntos y realizar compras.";

                return code.equals(readCode.toString());
            }
            else
                return false;
            
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static Administrador crearAdmin(String usuario, String contrasenia) {
        String subContra1 = contrasenia.substring(0,contrasenia.length()/2);
        String subContra2 = contrasenia.substring(contrasenia.length()/2);
        
        char[] caract = new char[contrasenia.length()];
        
        for(int i = 0; i < contrasenia.length(); i++) {
            int chrct;
            if(i % 2 == 0) {
                chrct = (int) subContra2.charAt(i/2) + 15;
                caract[i] = (char) chrct;
            }
            else {
                chrct = (int) subContra2.charAt(i/2) + 15;
                caract[i] = (char) chrct;
            }
                
        }
        
        String contra = new String(caract);
        return new Administrador(usuario, contra);
    }
    
    public static boolean verificarContrasenia(String contraSistema, String contraUsuario) {
        char[] caract1 = new char[contraSistema.length()];
        char[] caract2;
        if(contraSistema.length() % 2 == 0)
            caract2 = new char[contraSistema.length()/2];
        else
            caract2 = new char[contraSistema.length()/2 + 1];

        for(int i = 0; i < contraSistema.length(); i++) {
            int chrct;
            if(i % 2 == 0) {
                chrct = (int) contraSistema.charAt(i) -15;
                caract2[i/2] = (char) chrct;
            }
            else {
               chrct = (int) contraSistema.charAt(i) -15;
               caract1[i/2] = (char) chrct; 
            }
        }
        String contrasenia = new String(caract1);
        String contra1 = new String(caract2);
        
        contrasenia += contra1;
        
        return contrasenia.equals(contraUsuario);
    }
}
