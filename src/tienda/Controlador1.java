package tienda;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Controlador1 {
    
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
            Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static Administrador crearAdmin(String usuario, String contrasenia) {
        String sub1 = contrasenia.substring(0, contrasenia.length()/2);
        String sub2 = contrasenia.substring((contrasenia.length()/2));
        System.out.println(sub1);
        System.out.println(sub2);
        StringBuilder contra = new StringBuilder();
        
        for(int i = 0; i < contrasenia.length(); i++) {
            if(i % 2 == 0) {
                int crct = (int) sub2.charAt(i/2) + 5;
                contra.append((char)crct);
            }
            else {
                int crct = (int) sub1.charAt(i/2) + 3;
                contra.append((char)crct);
            }
        }
        
        return new Administrador(usuario, contra.toString());
    }
    
    public static boolean verificarContrasenia(String contraSistema, String contraUsuario) {
        StringBuilder sub1 = new StringBuilder();
        StringBuilder sub2 = new StringBuilder();
        
        for(int i = 0; i < contraSistema.length(); i++) {
            if(i % 2 == 0) {
                int crct = (int) contraSistema.charAt(i) - 5;
                sub2.append((char)crct);
                System.out.println(sub2.toString());
            }
            else {
               int crct = (int) contraSistema.charAt(i) - 3;
                sub1.append((char)crct);
                System.out.println(sub1.toString()); 
            }
        }
        
        return(contraUsuario.equals(sub1.toString() + sub2.toString()));
    }
}
