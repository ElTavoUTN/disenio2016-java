package sistemacompraproveedores.Controladores;

import CasosDeUso.GenerarPedidoDeCotizacion;
import CasosDeUso.GenerarPedidoDeCotizacion2;
import CasosDeUso.GenerarPedidoDeCotizacion3;
import java.util.Date;
import java.util.List;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.Expertos.ExpertoGenerarPedidoCotizacion;
import sistemacompraproveedores.FabricaExpertos;
import sistemacompraproveedores.Sistema;

public class ControladorGenerarPedidoCotizacion {

    public ExpertoGenerarPedidoCotizacion m_ExpertoGenerarPedidoCotizacion;

    public ControladorGenerarPedidoCotizacion() {

    }
    
     public void volver() { //vuelve a Pantalla de Sistema

        m_ExpertoGenerarPedidoCotizacion.volver();

        new Sistema().setVisible(true);

    }
     
       public void volver2() throws Exception { // Vuelve a Pantall de Seleccionar Reposicion

        m_ExpertoGenerarPedidoCotizacion.volver2();

        new GenerarPedidoDeCotizacion().setVisible(true);

    }

    public ControladorGenerarPedidoCotizacion(ExpertoGenerarPedidoCotizacion m_ExpertoGenerarPedidoCotizacion) {
        this.m_ExpertoGenerarPedidoCotizacion = m_ExpertoGenerarPedidoCotizacion;
    }

    public List<DTOReposicion> buscarReposicion() {

        m_ExpertoGenerarPedidoCotizacion = (ExpertoGenerarPedidoCotizacion) FabricaExpertos.getinstancia().crearExperto("GenerarPedidoCotizacion");

        return m_ExpertoGenerarPedidoCotizacion.buscarReposicion();
    }

    public void seleccionarReposicion(int codReposicion) {

        m_ExpertoGenerarPedidoCotizacion.seleccionarReposicion(codReposicion);
        
        new GenerarPedidoDeCotizacion2(this).setVisible(true);
    }

    public void enviarPedidoCotizacion(Date fechaVenc) {

        m_ExpertoGenerarPedidoCotizacion.enviarPedidoCotizacion(fechaVenc);
        
        new GenerarPedidoDeCotizacion3().setVisible(true);
    }

}
