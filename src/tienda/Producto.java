package tienda;

public class Producto
{
    private String nombre;
    private float costo;
    private long productoID;
    private int numDeRegistro;
    
    public Producto(){}
    
    public Producto(String nombre, float costo, long productoID, int numDeRegistro){
        this.nombre = nombre;
        this.costo = costo;
        this.productoID = productoID;
        this.numDeRegistro = numDeRegistro;        
    }

    public String getNombre() {
        return nombre;
    }

    public float getCosto() {
        return costo;
    }

    public long getCodigo() {
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

    public void setCodigo(long productoID) {
        this.productoID = productoID;
    }

    public void setNumDeRegistro(int numDeRegistro) {
        this.numDeRegistro = numDeRegistro;
    }
    
    
}
