
package Estrategias;

import sistemacompraproveedores.DTO.DTOArticulo;
import sistemacompraproveedores.DTO.DTOCotizacionSeleccionada;


public interface EstrategiaSeleccionCotizacion {
    

public DTOCotizacionSeleccionada determinarMejorCotizacion(DTOArticulo a);

}
