
package Estrategias;

import sistemacompraproveedores.DTO.DTOArticulo;


public class FactoriaEstrategiaSeleccionCotizacion {
    
    private static FactoriaEstrategiaSeleccionCotizacion instancia= null;
    
    
    public static synchronized FactoriaEstrategiaSeleccionCotizacion getInstancia(){
    
     
        if(instancia==null){
        
            instancia= new FactoriaEstrategiaSeleccionCotizacion();
            
        }
        
        return instancia;
    
     }

    public EstrategiaSeleccionCotizacion obtenerEstrategiaSeleccionCotizacion(DTOArticulo dtoArt){
    
        String s=dtoArt.getM_Articulo().getM_TipoProducto().getToxico();
        
        if(s.compareTo("false") == 0){
        
            return new EstrategiaSeleccionMenorPrecio();
            
        }
        
        else   return new EstrategiaSeleccionPorProveedor();
        
    }
    
    
    

 }
