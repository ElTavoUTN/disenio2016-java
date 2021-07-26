
package sistemacompraproveedores.Controladores;

import CasosDeUso.Informes.CalcularCantidadPromedioDeEventosDeReposicion2;
import CasosDeUso.Informes.Excepciones.CalcularCantidadPromedioDeEventosDeReposicionCaminoAlternativo3;
import java.util.Date;
import sistemacompraproveedores.DTO.DTOPromedioEventosDeReposicion;
import sistemacompraproveedores.Expertos.ExpertoAtenderPedidoDeCompra;
import sistemacompraproveedores.Expertos.ExpertoCalcularCantidadPromedioDeEventosDeReposicion;
import sistemacompraproveedores.FabricaExpertos;

public class ControladorCalcularCantidadPromedioDeEventosDeReposicion {
    
    public ExpertoCalcularCantidadPromedioDeEventosDeReposicion m_ExpertoCalcularCantidadPromedioDeEventosDeReposicion;

    public ControladorCalcularCantidadPromedioDeEventosDeReposicion(){
        
    }
    public DTOPromedioEventosDeReposicion promedioeventos(int anio) throws Exception  {
        m_ExpertoCalcularCantidadPromedioDeEventosDeReposicion = (ExpertoCalcularCantidadPromedioDeEventosDeReposicion) FabricaExpertos.getinstancia().crearExperto("CalcularCantidadPromedioDeEventosDeReposicion");
        return m_ExpertoCalcularCantidadPromedioDeEventosDeReposicion.promedioeventos(anio);
//        new CalcularCantidadPromedioDeEventosDeReposicion2(this, algo).setVisible(true);
        
    }
    public void CalcularCantidadPromedioDeEventosDeReposicion2(DTOPromedioEventosDeReposicion dto){
        new CalcularCantidadPromedioDeEventosDeReposicion2(dto).setVisible(true);
    }
    
    public void caminoAlternativo3(){
        new CalcularCantidadPromedioDeEventosDeReposicionCaminoAlternativo3().setVisible(true);
    }
}
