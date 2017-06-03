package tienda;

import java.util.ArrayList;

public interface Controlador<E> {
   public E crear(E e);
   
   public E editar(E e);
   
   public void eliminar(ArrayList<E> array, E e);
}
