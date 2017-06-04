package tienda;

import java.util.List;

public interface Controlador<E> {
   public void crear(E e, Archivo archivo, List<E> list);
   
   public void eliminar(E e, Archivo archivo, List<E> list);
}
