package sistemacompraproveedores.Controladores;

import CasosDeUso.Exepciones.ManejoExcepciones;
import CasosDeUso.Exepciones.RecepcionarCotizacionCaminoAlternativo1;
import CasosDeUso.Exepciones.RecepcionarCotizacionCaminoAlternativo2;
import CasosDeUso.Exepciones.RecepcionarCotizacionCaminoAlternativo3;
import CasosDeUso.Exepciones.RecepcionarCotizacionCaminoAlternativo4;
import CasosDeUso.RecepcionarCotizacion;
import CasosDeUso.RecepcionarCotizacion2;
import CasosDeUso.RecepcionarCotizacion3;
import CasosDeUso.RecepcionarCotizacion6;
import java.util.List;
import sistemacompraproveedores.DTO.DTOCompletarCotizacion;
import sistemacompraproveedores.DTO.DTODetalleCotizacion;
import sistemacompraproveedores.DTO.DTOListaCotizacion;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.Expertos.ExpertoRecepcionarCotizacion;
import sistemacompraproveedores.FabricaExpertos;
import sistemacompraproveedores.Sistema;

public class ControladorRecepcionarCotizacion {

    public ExpertoRecepcionarCotizacion m_ExpertoRecepcionarCotizacion;

    public ControladorRecepcionarCotizacion() {

    }

    public void iniciar() {

    }

    public void volver() { //vuelve a Pantalla de Sistema

        m_ExpertoRecepcionarCotizacion.volver();

        new Sistema().setVisible(true);

    }

    public void volver2() throws ManejoExcepciones{ // Vuelve a Pantall de Seleccionar Reposicion

        m_ExpertoRecepcionarCotizacion.volver2();

        new RecepcionarCotizacion().setVisible(true);

    }

    public ControladorRecepcionarCotizacion(ExpertoRecepcionarCotizacion m_ExpertoRecepcionarCotizacion) {
        this.m_ExpertoRecepcionarCotizacion = m_ExpertoRecepcionarCotizacion;
    }

    public List<DTOReposicion> buscarReposicion() throws ManejoExcepciones {

        m_ExpertoRecepcionarCotizacion = (ExpertoRecepcionarCotizacion) FabricaExpertos.getinstancia().crearExperto("RecepcionarCotizacion");

        return m_ExpertoRecepcionarCotizacion.buscarReposicion();

    }

    public void seleccionarReposicion(int nroReposicion) {

        List<DTOListaCotizacion> alc = m_ExpertoRecepcionarCotizacion.seleccionarReposicion(nroReposicion);

        new RecepcionarCotizacion2(this, alc).setVisible(true); // Pantalla 2
    }

    public void seleccionarCotizacion(int nroCotizacion) {

        List<DTODetalleCotizacion> alc = m_ExpertoRecepcionarCotizacion.seleccionarCotizacion(nroCotizacion);

        new RecepcionarCotizacion3(this, alc).setVisible(true); // Pantalla 3
    }

    public void completarCotizacionDetalle(List<DTOCompletarCotizacion> dto) throws ManejoExcepciones {

        m_ExpertoRecepcionarCotizacion.completarCotizacionDetalle(dto);
        new RecepcionarCotizacion6().setVisible(true);
     

    }
    public void caminoAlternativo1(){
        new RecepcionarCotizacionCaminoAlternativo1().setVisible(true);
    }
    public void caminoAlternativo2(){
        new RecepcionarCotizacionCaminoAlternativo2().setVisible(true);
    }
    public void caminoAlternativo3(){
        new RecepcionarCotizacionCaminoAlternativo3().setVisible(true);
    }
     public void caminoAlternativo4(){
        new RecepcionarCotizacionCaminoAlternativo4().setVisible(true);
    }
    public void terminarTransaccion(boolean algo){
         new Sistema().setVisible(true);
    }
}
