package tienda;

public class Administrador {
    private String usuario;
    private String contrasenia;
    private int numDeRegistro;
    
    public Administrador(){}
    
    public Administrador(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    public Administrador(String usuario, String contrasenia, int numDeRegistro) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.numDeRegistro = numDeRegistro;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    public int getNumDeRegistro() {
        return numDeRegistro;
    }
    
    public void setNumDeRegistro(int numDeRegistro) {
        this.numDeRegistro = numDeRegistro;
    }
}