package Estrategias;


import Clases.Articulo;
import Clases.CotizacionDetalle;
import Clases.Pedido;
import Clases.PedidoDetalle;
import Clases.PedidoEstado;
import Clases.Proveedor;
import java.util.ArrayList;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOArticulo;
import sistemacompraproveedores.DTO.DTOCotizacionSeleccionada;
import sistemacompraproveedores.FachadaPersistencia;



public class EstrategiaSeleccionPorProveedor implements EstrategiaSeleccionCotizacion {

    public EstrategiaSeleccionPorProveedor(){}

    

    public DTOCotizacionSeleccionada determinarMejorCotizacion(DTOArticulo DTOa){
       

        DTOCotizacionSeleccionada dtoCotSel= new DTOCotizacionSeleccionada();
        Articulo articulo= DTOa.getM_Articulo();
        List<PedidoDetalle> lpedidodetalle= new ArrayList();
        List<Pedido> lpedido;
        List<Pedido> lpedidoSeleccionados= new ArrayList();
        List<PedidoEstado>lpedidoEstado= new ArrayList();
        Pedido pedidoReciente;
        List<CotizacionDetalle> lcotizaciondetalle= new ArrayList();
        CotizacionDetalle cotDetalleMenorPrecio;
        Proveedor proveedorUltimaCompra;
        List<Proveedor> lproveedor= new ArrayList();
     
        
        List<Criterio> criteriolist = new ArrayList();
        Criterio c1= new Criterio();
        c1.setAtributo("m_Articulo");
        c1.setOperacion("=");
        c1.setValor(articulo);
        criteriolist.add(c1);
        
        lpedidodetalle= (List) FachadaPersistencia.getInstance().buscar("PedidoDetalle", criteriolist);
        
//        for(PedidoDetalle pedidodetalle : lpedidodetalle){
//        
//           criteriolist.clear();
//           Criterio c2= new Criterio();
//           c2.setAtributo("m_PedidoDetalleList");
//           c2.setOperacion("contains");
//           c2.setValor(pedidodetalle);
//           criteriolist.add(c2);
//           Pedido ped= (Pedido) FachadaPersistencia.getInstance().buscar("Pedido", criteriolist).get(0);
//           lpedido.add(ped);
//            
//         }
        
     // HAY QUE ARREGLAR EL MAPEO PARA OPTIMIZAR ESTA BUSQUEDA, LA CUAL TRAE TODOS LOS PEDIDOS EXISTENTES.   
        
        criteriolist.clear();
        Criterio c2= new Criterio();
        c2.setAtributo("m_PedidoDetalleList");
        c2.setOperacion("");
        c2.setValor("");
        criteriolist.add(c2);
       
        lpedido= (List) FachadaPersistencia.getInstance().buscar("Pedido", criteriolist);
            
        System.out.println("La cantidad de Pedidos encontrados: "+lpedido.size());
         
        for(Pedido pedido : lpedido){   
        
            List<PedidoDetalle>lpd=pedido.getM_PedidoDetalleList();
            for(PedidoDetalle pedidodetalle : lpedidodetalle){
            
                int i=0;
                
                if(lpd.get(i).getM_Articulo().equals(pedidodetalle.getM_Articulo())){
                    if(!lpedidoSeleccionados.contains(pedido)){
                        lpedidoSeleccionados.add(pedido);
                    }
                 }
                
                i=i+1;
             }
         }// Fin for por Pedidos
       
        pedidoReciente= lpedidoSeleccionados.get(0);
        for(int i=0; i<lpedidoSeleccionados.size(); i++){
        
            lpedidoEstado= lpedidoSeleccionados.get(i).getM_PedidoEstadoList();
            
            for(PedidoEstado pedEst : lpedidoEstado){
                String s=pedEst.getM_EstadoPedido().getNombreEstadoPedido();
                if(s.compareTo("Recepcionado") == 0){
                    if(pedidoReciente.getFechaPedido().before(lpedidoSeleccionados.get(i).getFechaPedido())){
                        
                        pedidoReciente=lpedidoSeleccionados.get(i);
                    
                    }
                    
                 }
             }
        
         } // for para determinar el Pedido "Recepcionado" mas reciente para este articulo.
        System.out.println("la fecha del pedido mas reciente para el articulo es: "+pedidoReciente.getFechaPedido());
        lcotizaciondetalle=DTOa.getM_ListCotizacionDetalle();
        cotDetalleMenorPrecio=lcotizaciondetalle.get(0);
        for(int i=0; i<lcotizaciondetalle.size(); i++){
        
            if(lcotizaciondetalle.get(i).getPrecioCotizacion()<cotDetalleMenorPrecio.getPrecioCotizacion()){
            
                cotDetalleMenorPrecio=lcotizaciondetalle.get(i);
                
            }
        
         }
        
        if(pedidoReciente.equals(lpedidoSeleccionados.get(0))){ //Si se cumple la condicion del if significa que no hay Pedidos Recepcionado para este Articulo
        // CARGA EL DTOCOTIZACIONSELECCIONADA CON LOS ATRIBUTOS DE LA COTIZACION CON MENOR PRECIO.
        
        dtoCotSel.setCantidadCotizada(cotDetalleMenorPrecio.getCantidadCotizada());
        dtoCotSel.setCodigoArticulo(cotDetalleMenorPrecio.getM_ArticuloProveedor().getM_Articulo().getCodigoArticulo());
        dtoCotSel.setCodigoProveedor(cotDetalleMenorPrecio.getM_ArticuloProveedor().getM_Proveedor().getCodigoProveedor());
        dtoCotSel.setPrecioCotizacion(cotDetalleMenorPrecio.getPrecioCotizacion());
        dtoCotSel.setCotizacionDeta(cotDetalleMenorPrecio);
        
        return dtoCotSel;
        } // CP_06
        else{
// Logica para priorizar al proveedor de la ultima compra, si es que nos cotizo y dicha cotizacion no supera por un 15% a la cotizacion con menor precio.
        lproveedor=DTOa.getM_ListProveedor();
            for(Proveedor pro : lproveedor){
        
                if(pro.getCodigoProveedor()==pedidoReciente.getM_Proveedor().getCodigoProveedor()){ // verifica si el proveedor al que le compre por ultima vez, me ha cotizado para este articulo.
            
                    proveedorUltimaCompra=pro;
                
                    for(CotizacionDetalle cotdet : lcotizaciondetalle){
                
                        if(cotdet.getM_ArticuloProveedor().getM_Proveedor().getCodigoProveedor()== proveedorUltimaCompra.getCodigoProveedor()){
                    
                        double precioCotizacion=cotdet.getPrecioCotizacion();
                        double precioCotizacionMenor=cotDetalleMenorPrecio.getPrecioCotizacion();
                        double tope=precioCotizacionMenor+((precioCotizacionMenor*15)/100);
                        
                            if(precioCotizacion<=tope){
                        
                            dtoCotSel.setCantidadCotizada(cotdet.getCantidadCotizada());
                            dtoCotSel.setCodigoArticulo(cotdet.getM_ArticuloProveedor().getM_Articulo().getCodigoArticulo());
                            dtoCotSel.setCodigoProveedor(cotdet.getM_ArticuloProveedor().getM_Proveedor().getCodigoProveedor());
                            dtoCotSel.setPrecioCotizacion(cotdet.getPrecioCotizacion());
                            dtoCotSel.setCotizacionDeta(cotdet);
                            return dtoCotSel;
                            //DEVUELVE EL DTOCOTIZACIONSELECCIONADA PRIORIZANDO AL PROVEEDOR AL QUE SE LE COMPRO EL ARTICULO LA ULTIMA VEZ.
                            } // CP_07 o CP_08
                    
                         }
                
                
                     }
                         
                 }
                else{
                    dtoCotSel.setCantidadCotizada(cotDetalleMenorPrecio.getCantidadCotizada());
                    dtoCotSel.setCodigoArticulo(cotDetalleMenorPrecio.getM_ArticuloProveedor().getM_Articulo().getCodigoArticulo());
                    dtoCotSel.setCodigoProveedor(cotDetalleMenorPrecio.getM_ArticuloProveedor().getM_Proveedor().getCodigoProveedor());
                    dtoCotSel.setPrecioCotizacion(cotDetalleMenorPrecio.getPrecioCotizacion());
                    dtoCotSel.setCotizacionDeta(cotDetalleMenorPrecio);
        
                    
                
                 } // CP_09     
             } // Fin Logica para priorizar al proveedor de la ultima compra, si es que nos cotizo y dicha cotizacion no supera por un 15% a la cotizacion con menor precio.
        
            }
    return dtoCotSel; // devolucion del CP_09   
   } // Fin determinarMejorCotizacion

}