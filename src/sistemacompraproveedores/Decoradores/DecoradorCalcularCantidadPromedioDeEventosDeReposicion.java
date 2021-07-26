package sistemacompraproveedores.Decoradores;

import java.util.Date;
import sistemacompraproveedores.DTO.DTOPromedioEventosDeReposicion;
import sistemacompraproveedores.Expertos.ExpertoCalcularCantidadPromedioDeEventosDeReposicion;
import sistemacompraproveedores.FachadaInterna;

public class DecoradorCalcularCantidadPromedioDeEventosDeReposicion extends ExpertoCalcularCantidadPromedioDeEventosDeReposicion{
    
    public DecoradorCalcularCantidadPromedioDeEventosDeReposicion(){
        
    }
    public DTOPromedioEventosDeReposicion promedioeventos(int anio) throws Exception  {
        FachadaInterna.getInstance().beginTransaction();

        return super.promedioeventos(anio);
    }
}
