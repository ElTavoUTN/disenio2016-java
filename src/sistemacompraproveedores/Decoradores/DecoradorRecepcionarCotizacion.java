package sistemacompraproveedores.Decoradores;

import CasosDeUso.Exepciones.ManejoExcepciones;
//import CasosDeUso.RecepcionarCotizacion4;
import java.util.List;
import sistemacompraproveedores.DTO.DTOCompletarCotizacion;
import sistemacompraproveedores.DTO.DTODetalleCotizacion;
import sistemacompraproveedores.DTO.DTOListaCotizacion;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.Expertos.ExpertoRecepcionarCotizacion;
import sistemacompraproveedores.FachadaInterna;

public class DecoradorRecepcionarCotizacion extends ExpertoRecepcionarCotizacion {

    public DecoradorRecepcionarCotizacion() {

    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public void volver() {
        System.out.println("terminar transaccion decorador");
        FachadaInterna.getInstance().endTransaction(false);
    }
    
     public void volver2() {
         
        System.out.println("terminar transaccion decorador");
        FachadaInterna.getInstance().endTransaction(false);
    }

   
    
    public List<DTOReposicion> buscarReposicion() throws ManejoExcepciones{

        FachadaInterna.getInstance().beginTransaction();
        return super.buscarReposicion();

    }

    public List<DTOListaCotizacion> seleccionarReposicion(int nroReposicion) {

        return super.seleccionarReposicion(nroReposicion);
    }

    public List<DTODetalleCotizacion> seleccionarCotizacion(int nroCotizacion) {

        return super.seleccionarCotizacion(nroCotizacion);
    }

    public void completarCotizacionDetalle(List<DTOCompletarCotizacion> dto) throws ManejoExcepciones{

        super.completarCotizacionDetalle(dto);
        FachadaInterna.getInstance().endTransaction(true);

    }
    public void terminarTransaccion(boolean algo){
        if(algo)
            FachadaInterna.getInstance().endTransaction(true);
        else  
            FachadaInterna.getInstance().endTransaction(false);
    }

}
