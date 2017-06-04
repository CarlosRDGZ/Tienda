package tienda;

import java.util.ArrayList;

public class ControladorTarjeta extends ControladorUsuario<Tarjeta>{

    @Override
    public Tarjeta crear(Tarjeta tarjeta, Archivo archivo, Identificadores id) {
        
        tarjeta.setPuntos(0);
        
        tarjeta.setNumeroDeRegistro(archivo.numeroDeRegistros());
        
        long idTarjeta;
        if(id.longitudIdentificadores() < 16)
            idTarjeta = 0;
        else
            idTarjeta = id.getIdTarjeta();
        tarjeta.setIdTarjeta(idTarjeta);
        id.updateIdTarjeta(idTarjeta + 1);
        
        return tarjeta;
    }

    @Override
    public Tarjeta editar(Tarjeta e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(ArrayList<Tarjeta> array, Tarjeta e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
