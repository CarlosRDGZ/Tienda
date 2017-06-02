package tienda;

public class Controlador {
    
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
