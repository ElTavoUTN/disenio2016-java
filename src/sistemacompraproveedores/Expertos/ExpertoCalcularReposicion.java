package sistemacompraproveedores.Expertos;

import Adaptador.AdaptadorSistemaGestion;
import Adaptador.FactoriaAdaptadorSistemaGestion;
import Clases.Articulo;
import Clases.EstadoPedido;
import Clases.EstadoReposicion;
import Clases.Pedido;
import Clases.PedidoDetalle;
import Clases.PedidoEstado;
import Clases.Reposicion;
import Clases.ReposicionDetalle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOCantidadAReponerArticulo;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.FachadaPersistencia;

public class ExpertoCalcularReposicion {
    List<DTOReposicion> dtoreposicionlist = new ArrayList<>();
    
    public ExpertoCalcularReposicion(){}
    
    public <T> List<T> union(List<T> list1, List<T> list2) { // metodo para unir dos listas
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<>(set);}
    
    public <T> List<T> union4(List<T> list1, List<T> list2, List<T> list3, List<T> list4) { // metodo para unir cuatro listas
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        set.addAll(list3);
        set.addAll(list4);
        return new ArrayList<>(set);}

    public List<DTOReposicion> calcularReposicion() throws org.hibernate.PropertyValueException, IndexOutOfBoundsException{
	
        EstadoReposicion estadoreposicioncalculada=null;
        List<Criterio> criteriolist = new ArrayList<>();
        Criterio c1 = new Criterio();
        c1.setAtributo("");
        c1.setOperacion("");
        c1.setValor("");
        criteriolist.add(c1);
        
        List<Articulo> articulolist = (List) FachadaPersistencia.getInstance().buscar("Articulo", criteriolist);
        if(articulolist.isEmpty()) throw new IndexOutOfBoundsException();
        List<DTOCantidadAReponerArticulo> listdtocantidadAReponerarticulo = new ArrayList<>();
        
        for(Articulo listarticulo : articulolist ){
            System.out.println("Iteracion bucle articulo "+listarticulo.getNombreArticulo()+" OID "+listarticulo.getOID());
            
            Criterio c3 = new Criterio();
            c3.setAtributo("nombreEstadoPedido");
            c3.setOperacion("=");
            c3.setValor("En Curso");
            criteriolist.clear();
            criteriolist.add(c3);
            
            EstadoPedido estadoPedidoEnCurso = (EstadoPedido) FachadaPersistencia.getInstance().buscar("EstadoPedido", criteriolist).get(0);
            
            
            Criterio c4 = new Criterio();
            c4.setAtributo("nombreEstadoPedido");
            c4.setOperacion("=");
            c4.setValor("Rechazado Pendiente de Entrega");
            criteriolist.clear();
            criteriolist.add(c4);
            
            EstadoPedido estadoPedidoRechazadoPE = (EstadoPedido) FachadaPersistencia.getInstance().buscar("EstadoPedido", criteriolist).get(0);
                        
            Criterio c5 = new Criterio();   
            c5.setAtributo("fechaHastaPedidoEstado");
            c5.setOperacion("=");
            c5.setValor(null);
           
            List<Criterio> criteriolist2 = new ArrayList<>();
            Criterio c6 = new Criterio();
            c6.setAtributo("m_EstadoPedido");
            c6.setOperacion("=");
            c6.setValor(estadoPedidoEnCurso);
            criteriolist.clear();
            criteriolist2.add(c5);
            criteriolist2.add(c6);
            
            List<PedidoEstado> pedidoestadoEnCursolist = (List) FachadaPersistencia.getInstance().buscar("PedidoEstado", criteriolist2);
//            System.out.println("Size arreglo pedidoestado "+ pedidoestadoEnCursolist.size());
          
            
            Criterio c7 = new Criterio();
            c7.setAtributo("m_EstadoPedido");
            c7.setOperacion("=");
            c7.setValor(estadoPedidoRechazadoPE);
            criteriolist.clear();
            criteriolist.add(c5);
            criteriolist.add(c7);
            
            List<PedidoEstado> pedidoestadorechazadoPElist = (List) FachadaPersistencia.getInstance().buscar("PedidoEstado", criteriolist);
//            System.out.println("Size arreglo rechazadoPE " + pedidoestadorechazadoPElist.size());
            
            DTOCantidadAReponerArticulo dtocantidadarticulo = new DTOCantidadAReponerArticulo();
            dtocantidadarticulo.setArticulo(listarticulo);
            
            List<PedidoEstado> pedidoestadounionlist=null;
            
            pedidoestadounionlist = union(pedidoestadoEnCursolist, pedidoestadorechazadoPElist); 
//            System.out.println("Size arreglo union " + pedidoestadounionlist.size());
            criteriolist.clear();
            
            for(PedidoEstado listpedidoestadounion : pedidoestadounionlist){
//                    System.out.println("PEDIDOESTADO actual OID "+listpedidoestadounion.getOID());
                    Criterio c8 = new Criterio();
                    c8.setAtributo("m_PedidoEstadoList");
                    c8.setOperacion("contains");
                    c8.setValor(listpedidoestadounion);
                    criteriolist.clear();
                    criteriolist.add(c8);
                    
                    Pedido pedido = (Pedido) FachadaPersistencia.getInstance().buscar("Pedido", criteriolist).get(0);
//                    System.out.println("PEDIDO OID " +pedido.getOID());
//                    System.out.println("Cantidad detalles pedido actual "+pedido.getM_PedidoDetalleList().size());
                                                       
                    for(PedidoDetalle listpedidodetalle : pedido.getM_PedidoDetalleList()){
//                        System.out.println("OID articulo del pedidodetalle actual "+ listpedidodetalle.getM_Articulo().getOID());
//                        System.out.println("Nombre pedidodetallelist-articulo actual "+ listpedidodetalle.getM_Articulo().getNombreArticulo());
                        
                        if(listarticulo.getOID().equals(listpedidodetalle.getM_Articulo().getOID())){
                            dtocantidadarticulo.addCantidadReponer(listpedidodetalle.getCantidadPedido());}
                        
//                        System.out.println(dtocantidadarticulo.getArticulo().getNombreArticulo()+" Cantidad dto "+ dtocantidadarticulo.getCantidadReponer());
                        
                    }
            
            }       
                            
            Criterio c18 = new Criterio();
            c18.setAtributo("nombreEstadoReposicion");
            c18.setOperacion("<>");
            c18.setValor("Finalizada");
            Criterio c9 = new Criterio();
            c9.setAtributo("nombreEstadoReposicion");
            c9.setOperacion("<>");
            c9.setValor("Atendida Pendiente de Recepcion"); 
            criteriolist.clear();
            criteriolist.add(c18);
            criteriolist.add(c9);
            
            List<EstadoReposicion> estadoreposicionlist = (List) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criteriolist);
//            System.out.println("Size arreglo estadoreposicion: "+ estadoreposicionlist.size());
       
            EstadoReposicion estadoreposicionpendientecotizar=null;
            EstadoReposicion estadoreposicionnotificada=null;
            EstadoReposicion estadoreposicionatendida=null;
            
                for(EstadoReposicion listestadoreposicion : estadoreposicionlist){
                    switch (listestadoreposicion.getNombreEstadoReposicion()){
                        case "Calculada":
                            estadoreposicioncalculada = listestadoreposicion; break;
                        case "Pendiente a Cotizar":
                            estadoreposicionpendientecotizar = listestadoreposicion; break;
                        case "Notificada":
                            estadoreposicionnotificada = listestadoreposicion; break;
                        case "Atendida":
                            estadoreposicionatendida = listestadoreposicion; break;
                     }
                }
                        
            Criterio c10 = new Criterio();
            c10.setAtributo("m_EstadoReposicion");
            c10.setOperacion("=");
            c10.setValor(estadoreposicioncalculada);
            criteriolist.clear();
            criteriolist.add(c10);
            
            List<Reposicion> reposicionescalculadas = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criteriolist);
            
            
            Criterio c11 = new Criterio();
            c11.setAtributo("m_EstadoReposicion");
            c11.setOperacion("=");
            c11.setValor(estadoreposicionpendientecotizar);
            criteriolist.clear();
            criteriolist.add(c11);
                
            List<Reposicion> reposicionespendientescotizar = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criteriolist);
            
            
            Criterio c12 = new Criterio();
            c12.setAtributo("m_EstadoReposicion");
            c12.setOperacion("=");
            c12.setValor(estadoreposicionnotificada);
            criteriolist.clear();
            criteriolist.add(c12);
            
            List<Reposicion> reposicionesnotificadas = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criteriolist);
            
            Criterio c13 = new Criterio();
            c13.setAtributo("m_EstadoReposicion");
            c13.setOperacion("=");
            c13.setValor(estadoreposicionatendida);
            criteriolist.clear();
            criteriolist.add(c13);
            
            List<Reposicion> reposicionesatendidas = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criteriolist);
            
            List<Reposicion> resposicionestotaleslist = union4(reposicionescalculadas,reposicionespendientescotizar,reposicionesnotificadas,reposicionesatendidas);
            
            for(Reposicion listreposicionestotales : resposicionestotaleslist){
                System.out.println("reposiciones distintas finalizada/atendidaPR OID "+listreposicionestotales.getOID());
                for(ReposicionDetalle listreposiciondetalle : listreposicionestotales.getM_ReposicionDetalleList()){
                    if(listreposiciondetalle.getM_Articulo().getOID().equals(listarticulo.getOID())){
                       dtocantidadarticulo.subtractCantidadReponer(listreposiciondetalle.getCantidadAreponer()); 
                       System.out.println(dtocantidadarticulo.getArticulo().getNombreArticulo()+" Cantidad dto "+dtocantidadarticulo.getCantidadReponer());}
                }    
            }
            listdtocantidadAReponerarticulo.add(dtocantidadarticulo);
        }//termina loop por articulo
        
        System.out.println("Sali del bucle por articulo");
        List<ReposicionDetalle> detallereposicionlist = new ArrayList<>();
        int i = 1;
        
        for(DTOCantidadAReponerArticulo listdto : listdtocantidadAReponerarticulo){
            if (listdto.getCantidadReponer()>0){
                int promedioventas=0;
                System.out.println(listdto.getArticulo().getNombreArticulo()+" Cantidad dto del listdto "+listdto.getCantidadReponer());
                ReposicionDetalle reposiciondetalle = new ReposicionDetalle();
                reposiciondetalle.setRenglonReposicion(i); i++;
                reposiciondetalle.setM_Articulo(listdto.getArticulo());
                reposiciondetalle.setCantidadAreponer(listdto.getCantidadReponer());
                
                AdaptadorSistemaGestion sistemagestion = (AdaptadorSistemaGestion)FactoriaAdaptadorSistemaGestion.getInstancia().obtenerAdaptador("Tango");

                promedioventas = sistemagestion.obtenerPromedioVentas(listdto.getArticulo());
                reposiciondetalle.setCantidadAreponer(promedioventas - listdto.getArticulo().getStockArticulo() - listdto.getCantidadReponer());
                System.out.println("Cantidad a reponer detallereposicion "+reposiciondetalle.getCantidadAreponer());
                if (reposiciondetalle.getCantidadAreponer()>0){
                detallereposicionlist.add(reposiciondetalle);}
                }
        
        }   
        if (estadoreposicioncalculada==null){ 
            throw new org.hibernate.PropertyValueException("","","");}
        if (!detallereposicionlist.isEmpty()){
            
            Reposicion reposicion = new Reposicion();
            reposicion.setFechaReposicion(new Date());
            reposicion.setNumReposicion(ExpertoCalcularReposicion.generarNroAleatorio());
            reposicion.setM_EstadoReposicion(estadoreposicioncalculada);        
            FachadaPersistencia.getInstance().guardar(reposicion);
            reposicion.setM_ReposicionDetalleList(detallereposicionlist);
            
            for(ReposicionDetalle listdetallereposicion: detallereposicionlist){
                FachadaPersistencia.getInstance().guardar(listdetallereposicion);
                System.out.println("Cantidad reponer detallereposicion "+listdetallereposicion.getCantidadAreponer());
                DTOReposicion dtoreposicion = new DTOReposicion();
                dtoreposicion.setCodigoArticulo(listdetallereposicion.getM_Articulo().getCodigoArticulo());
                dtoreposicion.setNombreArticulo(listdetallereposicion.getM_Articulo().getNombreArticulo());
                dtoreposicion.setCantidadAReponerArticulo(listdetallereposicion.getCantidadAreponer());
                dtoreposicion.setFechaReposiocion(reposicion.getFechaReposicion());
                dtoreposicion.setNumeroReposicion(reposicion.getNumReposicion());
                dtoreposicion.setNombreEstadoReposcion(reposicion.getM_EstadoReposicion().getNombreEstadoReposicion());
                dtoreposicionlist.add(dtoreposicion);
                
            }
        
        } 
        
        return dtoreposicionlist;
    }
     
    static private int generarNroAleatorio(){
    Random rdm = new Random();
       Integer nro= rdm.nextInt();
       if(nro<0) nro= nro*(-1);
       while(nro>150){
       nro = nro / 2;}
       return nro;
    }
    
    public void terminarTranscaccion(boolean a) {}    
    
}
