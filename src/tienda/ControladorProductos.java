package tienda;

import java.util.List;

public class ControladorProductos implements Controlador<Producto>{

    @Override
    public void crear(Producto producto, Archivo archivo, List<Producto> list) {
        int numRegistro = archivo.numeroDeRegistros();
        
        producto.setNumDeRegistro(numRegistro);
        
        long nuevoId;
        if(archivo.idRegistrado())
            nuevoId = archivo.obtenerIdActual();
        else
            nuevoId = 0;
        
        String id = "" + nuevoId++;
        archivo.grabarIdActual(nuevoId);
        
        while(id.length() < 8)
            id = "0" + id;
        
        producto.setCodigo(id);
        
        list.add(producto);
        archivo.grabarRegistro(producto, numRegistro);
    }

    @Override
    public void eliminar(Producto producto, Archivo archivo, List<Producto> list) {
        Producto ultimo = list.get(list.size() - 1);
        int borrableNumReg = producto.getNumDeRegistro();
        
        ultimo.setNumDeRegistro(borrableNumReg);
        
        list.set(borrableNumReg, ultimo);
        archivo.grabarRegistro(ultimo, borrableNumReg);
        
        list.remove(list.size() - 1);
        archivo.eliminar();
    }
    
}
