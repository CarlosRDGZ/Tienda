package tienda;

import java.util.List;

public class ControladorAdministrador extends ControladorUsuario<Administrador>{

    @Override
    public void crear(Administrador admin, Archivo archivo, List<Administrador> list) {
        admin.setNumDeRegistro(archivo.numeroDeRegistros());
        
        list.add(admin);
        
        archivo.grabarRegistro(admin, admin.getNumDeRegistro());
    }

    @Override
    public void eliminar(Administrador admin, Archivo archivo, List<Administrador> list) {
        Administrador ultimo = list.get(list.size() - 1);
        
        ultimo.setNumDeRegistro(admin.getNumDeRegistro());
        
        list.set(admin.getNumDeRegistro(), ultimo);
        archivo.grabarRegistro(ultimo, admin.getNumDeRegistro());
        
        list.remove(list.size() - 1);
        archivo.eliminar();
    }

    void crearLlave(Administrador e, LlaveAdmin llave) {
            llave.escrbirCodigoAcceso();
            llave.escribirDatos(e);
    }
    
}
