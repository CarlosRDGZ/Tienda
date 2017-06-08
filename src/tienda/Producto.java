package tienda;

public class Producto
{
    private String nombre;
    private float costo;
    private String marca;
    private String productoID;
    private int numDeRegistro;
    
    public Producto(){}
    
    public Producto(String nombre, String marca, float costo) {
        this.nombre = nombre;
        this.costo = costo;
        this.marca = marca;
    }
    
    public Producto(String nombre, String marca, float costo, String productoID, int numDeRegistro){
        this.nombre = nombre;
        this.costo = costo;
        this.marca = marca;
        this.productoID = productoID;
        this.numDeRegistro = numDeRegistro;        
    }

    public String getNombre() {
        return nombre;
    }

    public float getCosto() {
        return costo;
    }

    public String getCodigo() {
        return productoID;
    }

    public int getNumDeRegistro() {
        return numDeRegistro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setCodigo(String productoID) {
        this.productoID = productoID;
    }

    public void setNumDeRegistro(int numDeRegistro) {
        this.numDeRegistro = numDeRegistro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
