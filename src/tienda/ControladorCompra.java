package tienda;

/*import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;*/
import java.util.List;

public class ControladorCompra implements Controlador<Compra> {

    @Override
    public void crear(Compra compra, Archivo archivo, List<Compra> list) {
       /* LocalDateTime ahora = LocalDateTime.now();
        String hora = ahora.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        String fecha = ahora.format(DateTimeFormatter.ISO_LOCAL_DATE);
        
        compra.setFecha(fecha);
        compra.setHora(hora);*/
        compra.setNumRegistro(archivo.numeroDeRegistros());
        
        list.add(compra);
        
        archivo.grabarRegistro(compra, archivo.numeroDeRegistros());
    }

    @Override
    public void eliminar(Compra compra, Archivo archivo, List<Compra> list) {
        Compra ultimo = list.get(list.size() - 1);
        
        ultimo.setNumRegistro(compra.getNumRegistro());
        
        list.set(compra.getNumRegistro(), ultimo);
        archivo.grabarRegistro(ultimo, compra.getNumRegistro());
        
        list.remove(list.size() - 1);
        archivo.eliminar();
    }
    
}