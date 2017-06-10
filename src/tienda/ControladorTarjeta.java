package tienda;

import java.io.File;
import java.io.RandomAccessFile;
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
        
        File[] paths = File.listRoots();
        
            File file = new File(paths[paths.length -1].toString() + "/Tarjeta");
            LlaveTarjeta llave = new LlaveTarjeta(file);
            llave.escrbirCodigoAcceso();
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
}
