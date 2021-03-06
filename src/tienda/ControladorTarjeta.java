package tienda;

import java.util.List;

public class ControladorTarjeta extends ControladorUsuario<Tarjeta>{
    
    @Override
    public void crear(Tarjeta tarjeta, Archivo archivo, List<Tarjeta> lista) {
        
        tarjeta.setPuntos(0);
        
        tarjeta.setNumeroDeRegistro(archivo.numeroDeRegistros());
        
        long nuevoId;
        if(archivo.idRegistrado())
            nuevoId = archivo.obtenerIdActual();
        else
            nuevoId = 0;
        
        String idTarjeta = "" + nuevoId++;
        archivo.grabarIdActual(nuevoId);
        
        while(idTarjeta.length() < 8)
            idTarjeta = "0" + idTarjeta;
        
        tarjeta.setIdTarjeta(idTarjeta);
        
        lista.add(tarjeta);
        archivo.grabarRegistro(tarjeta, tarjeta.getNumeroDeRegistro());
        
    }

    @Override
    public void eliminar(Tarjeta e, Archivo archivo, List<Tarjeta> lista) {
        Tarjeta ultimo = lista.get(lista.size() - 1);
        
        ultimo.setNumeroDeRegistro(e.getNumeroDeRegistro());
        
        lista.set(e.getNumeroDeRegistro(), ultimo);
        archivo.grabarRegistro(ultimo, e.getNumeroDeRegistro());
        
        lista.remove(lista.size() - 1);
        archivo.eliminar();
    }
    
    void crearLlave(Tarjeta e, LlaveTarjeta llave) {
        llave.escrbirCodigoAcceso();
        llave.escribirDatos(e);
    }
    
    public void comprarEfectivo(Tarjeta tarjeta, ArchivoTarjeta archivo,
            List<Tarjeta> list, LlaveTarjeta llave, Producto producto) {
        
        int puntos = (int)producto.getCosto()/10;
        tarjeta.setPuntos(tarjeta.getPuntos() + puntos);
        
        archivo.grabarRegistro(tarjeta, tarjeta.getNumeroDeRegistro());
        
        list.set(tarjeta.getNumeroDeRegistro(), tarjeta);
        
        llave.escribirDatos(tarjeta);
    }
    
    public void comprarPuntos(Tarjeta tarjeta, ArchivoTarjeta archivo,
            List<Tarjeta> list, LlaveTarjeta llave, Producto producto) {
        
        int puntos = ((int)producto.getCosto()*115)/100;
        tarjeta.setPuntos(tarjeta.getPuntos() - puntos);
        
        archivo.grabarRegistro(tarjeta, tarjeta.getNumeroDeRegistro());
        
        list.set(tarjeta.getNumeroDeRegistro(), tarjeta);
        
        llave.escribirDatos(tarjeta);
    }
}