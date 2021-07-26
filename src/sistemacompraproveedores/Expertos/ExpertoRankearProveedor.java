
package sistemacompraproveedores.Expertos;

import CasosDeUso.Exepciones.ManejoExcepciones;
import Clases.Cotizacion;
import Clases.CotizacionDetalle;
import Clases.Proveedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOCabeceraRanking;
import sistemacompraproveedores.DTO.DTORankingProveedor;
import sistemacompraproveedores.FachadaPersistencia;

public class ExpertoRankearProveedor{

    public ExpertoRankearProveedor() {}
    
    public DTOCabeceraRanking realizarRanking(Date desde,Date hasta) throws ManejoExcepciones{
    
    DTOCabeceraRanking dtocabecera = new DTOCabeceraRanking();
    dtocabecera.setFechaInicial(desde);
    dtocabecera.setFechaFinal(hasta);
    
    List<Criterio> criteriolist = new ArrayList<>();
    Criterio c1 = new Criterio();
    c1.setAtributo("estadoProveedor");
    c1.setOperacion("=");
    c1.setValor(true);
    criteriolist.add(c1);
    
    List<Proveedor> proveedorhabilitadolist = (List) FachadaPersistencia.getInstance().buscar("Proveedor", criteriolist);
    if(proveedorhabilitadolist.isEmpty()) throw new ManejoExcepciones("Rankear.nohayproveedoreshabilitados");
    criteriolist.clear();
    int cantidadDetalles = 0; 
    for (Proveedor listproveedor : proveedorhabilitadolist){
        System.out.println("nombreproveedor "+listproveedor.getNombreProveedor());
        DTORankingProveedor dtoproveedor = new DTORankingProveedor();
        Criterio c2 = new Criterio();
        c2.setAtributo("m_Proveedor");
        c2.setOperacion("=");
        c2.setValor(listproveedor);
            
        Criterio c3 = new Criterio();
        c3.setAtributo("fechaCotizacion");
        c3.setOperacion(">=");
        c3.setValor(desde);
            
        Criterio c4 = new Criterio();
        c4.setAtributo("fechaCotizacion");
        c4.setOperacion("<=");
        c4.setValor(hasta);
            
        criteriolist.add(c2);
        criteriolist.add(c3);
        criteriolist.add(c4);
            
        List<Cotizacion> cotizacionlist = (List) FachadaPersistencia.getInstance().buscar("Cotizacion", criteriolist);
        if(cotizacionlist.isEmpty()) continue;
        criteriolist.clear();
        
        for (Cotizacion listcotizacion : cotizacionlist){
            for(CotizacionDetalle listdetallecot : listcotizacion.getM_CotizacionDetalleList()){
                if (listdetallecot.getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle().equals("Seleccionada") || listdetallecot.getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle().equals("No seleccionada")){
                    dtoproveedor.addtotalPrecioDeLista(listdetallecot.getPrecioArticuloLista());
                    dtoproveedor.addtotalPreciosCotizados((float) listdetallecot.getPrecioCotizacion());
                    dtoproveedor.setBanderaRemove(false);
                    cantidadDetalles++;
                }
               }
              }

        float descuento = (1 -dtoproveedor.getTotalPreciosCotizados()/dtoproveedor.getTotalPrecioDeLista())*100;
        System.out.println("descuento: "+descuento);
        dtoproveedor.setTotalDescuento(descuento);
        dtoproveedor.setCodigoProveedor(listproveedor.getCodigoProveedor());
        dtoproveedor.setNombreProveedor(listproveedor.getNombreProveedor());
        dtocabecera.addM_DTORankingProveedor(dtoproveedor);
        
        
        
        } //termina loop por proveedor
        
        if(cantidadDetalles==0) throw new ManejoExcepciones("Rankear.nohaycotdisponiblesparalasfechasingresadas");
        if(dtocabecera.getM_DTORankingProveedorlist().isEmpty()){throw new ManejoExcepciones("Rankear.nohaycotparafechasingresadas");}
        System.out.println("antes del remove hay "+dtocabecera.getM_DTORankingProveedorlist().size());
        
        for(int i=0; i< dtocabecera.getM_DTORankingProveedorlist().size(); i++){
            System.out.println(dtocabecera.getM_DTORankingProveedorlist().get(i).getNombreProveedor());
            System.out.println(dtocabecera.getM_DTORankingProveedorlist().get(i).getNombreProveedor()+" bandera: "+dtocabecera.getM_DTORankingProveedorlist().get(i).isBanderaRemove());
            if((dtocabecera.getM_DTORankingProveedorlist().get(i).isBanderaRemove())){
                dtocabecera.removeM_DTORankingProveedor(dtocabecera.getM_DTORankingProveedorlist().get(i)); i--;}
        }
        System.out.println("despues del remove hay "+dtocabecera.getM_DTORankingProveedorlist().size());
        

    Comparator<DTORankingProveedor> comparador = new Comparator<DTORankingProveedor>() {
    public int compare(DTORankingProveedor a, DTORankingProveedor b ) {
        int resultado = Float.compare( a.getTotalDescuento(), b.getTotalDescuento());
        if(resultado != 0) {return resultado;}
        return resultado;

    }
    };
    
    Collections.sort(dtocabecera.getM_DTORankingProveedorlist(),Collections.reverseOrder(comparador));
      
    
    return dtocabecera;}

    public void terminartransacccion(boolean a) {}
    
}
