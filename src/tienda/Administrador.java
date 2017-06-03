package tienda;

public class Administrador {
    private String usuario;
    private String contrasenia;
    
    public Administrador(){}
    
    public Administrador(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}