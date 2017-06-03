package tienda;

abstract class ControladorUsuario<E> implements Controlador<E> {
    
    protected String crearContrasenia(String contrasenia) {
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
        return contra.toString();
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
