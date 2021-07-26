package sistemacompraproveedores.Decoradores;

import java.sql.Date;
import java.util.List;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.Expertos.ExpertoGenerarPedidoCotizacion;
import sistemacompraproveedores.FachadaInterna;

public class DecoradorGenerarPedidoCotizacion extends ExpertoGenerarPedidoCotizacion {

    public DecoradorGenerarPedidoCotizacion() {

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

    public List<DTOReposicion> buscarReposicion() {

        FachadaInterna.getInstance().beginTransaction();

        return super.buscarReposicion();

    }

    public void seleccionarReposicion(int codReposicion) {

        super.seleccionarReposicion(codReposicion);

    }

    public void enviarPedidoCotizacion(Date fechaVenc) {

        super.enviarPedidoCotizacion(fechaVenc);
        
        FachadaInterna.getInstance().endTransaction(true);

    }

}
