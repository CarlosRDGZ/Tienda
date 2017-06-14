package tienda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LlaveTarjeta extends ArchivoLlave<Tarjeta> {

    public LlaveTarjeta(File file) {
        super(file);
        try {
            compras = new RandomAccessFile(file.toString() + "/baticueva.dmc", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    void escrbirCodigoAcceso() {
        try {
            String clave = "Tarjeta de Lealtad";
            clave = ControladorTarjeta.crearSeguridad(clave);
            
            String codigo = "";
            for(int i = 0; i < clave.length(); i++){
                int chr = clave.charAt(i);
                codigo += Integer.toHexString((int)chr);
            }
            
            llave.writeBytes(codigo);
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    String leerCodigo() {
        try
        {
            llave.seek(0);
            
            byte[] bString = new byte[36];
            llave.read(bString);
            String str = new String(bString);
            
            int[] hex = new int[18];

            String digits = "0123456789abcdef";
            for(int i = 0; i < 36; i += 2) {

                String s = str.substring(i, i+2);
                int power = 1;

                for(int j = 0; j < 2; j++) 
                {
                    char c = s.charAt(j);
                    int dec = digits.indexOf(c);
                    hex[i/2] += (Math.pow(16, power--)) * dec;
                }
            }

            StringBuilder readCode =  new StringBuilder();
            for(int i = 0; i < hex.length; i++)
                readCode.append((char) hex[i]);
            
            str = ControladorAdministrador.inverso(readCode.toString());
            return str;
            
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    void escribirDatos(Tarjeta e) {
        
        try {
            usuario.seek(0);
            
            String apPaterno  = ControladorTarjeta.crearSeguridad(e.getApPaterno());
            apPaterno = setLongitudString(apPaterno, 15);
            usuario.writeBytes(apPaterno);

            String apMaterno = ControladorTarjeta.crearSeguridad(e.getApMaterno());
            apMaterno= setLongitudString(apMaterno,15);
            usuario.writeBytes(apMaterno);

            String nombre = ControladorTarjeta.crearSeguridad(e.getNombre());
            nombre = setLongitudString(nombre,25);
            usuario.writeBytes(nombre);

            String idTarjeta = ControladorTarjeta.crearSeguridad(e.getIdTarjeta());
            usuario.writeBytes(idTarjeta);

            usuario.writeInt(e.getPuntos());
            
            String contra = ControladorTarjeta.crearSeguridad(e.getContrasenia());
            contra = setLongitudString(contra,16);
            usuario.writeBytes(contra);

            usuario.writeInt(e.getNumeroDeRegistro());
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    Tarjeta leerDatos() {
        try {
            usuario.seek(0);
            
            byte paterno[]=new byte [15];
            usuario.read(paterno);
            String apPaterno = getStringArreglada(paterno);
            apPaterno = ControladorTarjeta.inverso(apPaterno);
            
            byte materno []= new byte[15];
            usuario.read(materno);
            String apMaterno = getStringArreglada(materno);
            apMaterno = ControladorTarjeta.inverso(apMaterno);
            
            byte nombre []= new byte[25];
            usuario.read(nombre);
            String name = getStringArreglada(nombre);
            name = ControladorTarjeta.inverso(name);
            
            byte[] bIdTarjeta = new byte[8];
            usuario.read(bIdTarjeta);
            String idTarjeta = new String(bIdTarjeta);
            idTarjeta = ControladorTarjeta.inverso(idTarjeta);
            
            int puntos = usuario.readInt();
            
            byte[] bContra = new byte[16];
            usuario.read(bContra);
            String contra = getStringArreglada(bContra);
            contra = ControladorTarjeta.inverso(contra);
            
            int numeroDeRegistro = usuario.readInt();
            
            return new Tarjeta(apPaterno, apMaterno, name, idTarjeta, puntos, contra, numeroDeRegistro);
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void registrarCompra(Compra compra) {
        try {
            compra.setNumRegistro(cantCompras());
            
            compras.seek(cantCompras() * 49);
            
            String idProd = compra.getIdProducto();
            idProd = ControladorTarjeta.crearSeguridad(idProd);
            compras.writeBytes(idProd);
            
            String idTarj = compra.getIdTarjeta();
            idTarj = ControladorTarjeta.crearSeguridad(idTarj);
            compras.writeBytes(idTarj);
            
            String tipo = compra.getTipo();
            tipo = ControladorTarjeta.crearSeguridad(tipo);
            compras.writeBytes(setLongitudString(tipo, 8));
            
            String fecha = compra.getFecha();
            fecha = ControladorTarjeta.crearSeguridad(fecha);
            compras.writeBytes(fecha);
            
            String hora = compra.getHora();
            hora = ControladorTarjeta.crearSeguridad(hora);
            compras.writeBytes(hora);
            
            compras.writeInt(compra.getNumRegistro());
            
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Compra leerCompra(int numRegistro) {
        try {
            compras.seek(numRegistro * 49);
            
            byte[] bIDProd = new byte[8];
            compras.read(bIDProd);
            String idProd = new String(bIDProd);
            idProd = ControladorTarjeta.inverso(idProd);
            
            byte[] bIDTarjeta = new byte[8];
            compras.read(bIDTarjeta);
            String idTarjeta = new String(bIDTarjeta);
            idTarjeta = ControladorTarjeta.inverso(idTarjeta);
            
            byte[] bTipo = new byte[8];
            compras.read(bTipo);
            String tipo = getStringArreglada(bTipo);
            tipo = ControladorTarjeta.inverso(tipo);
            
            byte[] bFecha = new byte[10];
            compras.read(bFecha);
            String fecha = new String(bFecha);
            fecha = ControladorTarjeta.inverso(fecha);
            
            byte[] bHora = new byte[11];
            compras.read(bHora);
            String hora = new String(bHora);
            hora = ControladorTarjeta.inverso(hora);
            
            int numDeReg = compras.readInt();
            
            return new Compra(idProd, idTarjeta, tipo, fecha, hora, numDeReg);
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Compra> leerTodasCompras() {
        ArrayList<Compra> comprasArray = new ArrayList();
        for(int i = 0; i < cantCompras(); i++) {
            Compra compra = leerCompra(i);
            comprasArray.add(compra);
        }
        return comprasArray;
    }
    
    private int cantCompras() {
        try {
            return  (int)compras.length()/49;
        } catch (IOException ex) {
            Logger.getLogger(LlaveTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}