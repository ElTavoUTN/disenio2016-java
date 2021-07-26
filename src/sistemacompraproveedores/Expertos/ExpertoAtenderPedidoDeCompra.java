package sistemacompraproveedores.Expertos;

import Adaptador.AdaptadorEnvioMail;
import Adaptador.FactoriaAdaptadorEnvioMail;
import CasosDeUso.Exepciones.ManejoExcepciones;
import Clases.Articulo;
import Clases.EstadoPedido;
import Clases.EstadoReposicion;
import Clases.Pedido;
import Clases.PedidoDetalle;
import Clases.PedidoEstado;
import Clases.Reposicion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import sistemacompraproveedores.Controladores.ControladorAtenderPedidoDeCompra;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOEmail;
import sistemacompraproveedores.DTO.DTOHistorialPedido;
import sistemacompraproveedores.DTO.DTOListaPedido;
import sistemacompraproveedores.DTO.DTOPedido;
import sistemacompraproveedores.DTO.DTOPedidoCabecera;
import sistemacompraproveedores.FachadaInterna;
import sistemacompraproveedores.FachadaPersistencia;

public class ExpertoAtenderPedidoDeCompra {
    ControladorAtenderPedidoDeCompra cont;
    
    public Pedido m_Pedido;

    public ExpertoAtenderPedidoDeCompra() {

    }

    public DTOPedidoCabecera atenderPedido(int nroPedido) throws ManejoExcepciones{
                  
        List<Criterio> criterioList = new ArrayList<>();
      
        Criterio c1 = new Criterio();
        c1.setAtributo("numPedido");
        c1.setOperacion("=");
        c1.setValor(nroPedido);
        criterioList.add(c1);
        
        List<Pedido> m_Pedidolist = (List) FachadaPersistencia.getInstance().buscar("Pedido", criterioList);
        
        if(m_Pedidolist.isEmpty()){
            throw new ManejoExcepciones("Pedido nulo"); 
        }
        m_Pedido = m_Pedidolist.get(0);
        criterioList = new ArrayList<>();

        Criterio c2 = new Criterio();
        c2.setAtributo("m_Pedido");
        c2.setOperacion("=");
        c2.setValor(m_Pedido);
        criterioList.add(c2);
       
        String nombreestrepo = m_Pedido.getM_Reposicion().getM_EstadoReposicion().getNombreEstadoReposicion();

        DTOPedidoCabecera undtopedidocabecera = new DTOPedidoCabecera();
        
        if (nombreestrepo.compareTo("Atendida Pendiente de Recepcion")==0) {
            
            undtopedidocabecera.setFechaVencimiento(m_Pedido.getFechaVencimientoPedido());
            undtopedidocabecera.setNombreProveedor(m_Pedido.getM_Proveedor().getNombreProveedor());
            undtopedidocabecera.setNumeroPedido(m_Pedido.getNumPedido());
                     
            for (PedidoEstado pedEst : m_Pedido.getM_PedidoEstadoList()) {
                
                DTOHistorialPedido undtohistorialpedido = new DTOHistorialPedido();
                
                String estadoPedido = pedEst.getM_EstadoPedido().getNombreEstadoPedido();
                
                if(!(estadoPedido.compareTo("Recepcionado")==0) || (estadoPedido.compareTo("Rechazado")==0)){//osea, si el estadoPedido esta en curso o rechazado pendiente de entrega
                    
                        Date fechaDesde = pedEst.getFechaDesdePedidoEstado();
                        Date fechaHasta  = pedEst.getFechaHastaPedidoEstado();
                        undtohistorialpedido.setFechaDesdePedidoEstado(fechaDesde);
                        undtohistorialpedido.setFechaHastaPedidoEstado(fechaHasta);
                        undtohistorialpedido.setNombreEstadoPedido(estadoPedido);
                        undtopedidocabecera.addDTOHistorialPedido(undtohistorialpedido);
                        undtopedidocabecera.getDtohistorialpedido().size();
                        
                } else{
                    throw new ManejoExcepciones("curso rechazado o no atendida");
                } 
            }
            
        } else {
            throw new ManejoExcepciones("curso rechazado o no atendida"); 
        }
        
        return undtopedidocabecera;
     
    }

    public DTOPedido obtenerPedidos() {
        DTOPedido undtopedido = new DTOPedido();
           
            undtopedido.setFechaVencimiento(m_Pedido.getFechaVencimientoPedido());
            undtopedido.setNombreProveedor(m_Pedido.getM_Proveedor().getNombreProveedor());
            undtopedido.setNumeroPedido(m_Pedido.getNumPedido());
            
            
            for(PedidoDetalle pedDet : m_Pedido.getM_PedidoDetalleList()){
                
                DTOListaPedido undtolistapedido = new DTOListaPedido();
                
                undtolistapedido.setNombreArticulo(pedDet.getM_Articulo().getNombreArticulo());
                undtolistapedido.setCodigoArticulo(pedDet.getM_Articulo().getCodigoArticulo());
                undtolistapedido.setCantidadPedido(pedDet.getCantidadPedido());
                undtolistapedido.setNombreMarca(pedDet.getM_Articulo().getM_Marca().getNombreMarca());
                undtopedido.addDTOListaPedido(undtolistapedido);
            }
            
		return undtopedido;
    }

    public void recepcionarPedido() throws IndexOutOfBoundsException{
        
        Date nuevaFecha = new Date();
        
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
            for(PedidoEstado pedEst : m_Pedido.getM_PedidoEstadoList()){
                Date fecha = pedEst.getFechaHastaPedidoEstado();
                
                if(fecha == null){
                    pedEst.setFechaHastaPedidoEstado(nuevaFecha);
                    
                    FachadaPersistencia.getInstance().guardar(pedEst);
                }
            }
            PedidoEstado pedidoEsta = new PedidoEstado();//Crea una nueva instancia de PedidoEstado
            pedidoEsta.setFechaDesdePedidoEstado(nuevaFecha);
            String mailProv = m_Pedido.getM_Proveedor().getEmailProveedor();
            String nombProv = m_Pedido.getM_Proveedor().getNombreProveedor();
           
            List<Criterio> criterioList = new ArrayList<>();
            
            Criterio c3 = new Criterio();
            c3.setAtributo("nombreEstadoPedido");
            c3.setOperacion("=");
            c3.setValor("Recepcionado");
            criterioList.add(c3);
            
            List<EstadoPedido> estPed = (List) FachadaPersistencia.getInstance().buscar("EstadoPedido",criterioList);
            if (estPed.isEmpty()){
               throw new IndexOutOfBoundsException("Recepcionado");
            }
            pedidoEsta.setM_EstadoPedido(estPed.get(0));
            m_Pedido.addPedidoEstado(pedidoEsta);
            
            DTOEmail emailAcepta = new DTOEmail();
            emailAcepta.setTo(mailProv);
            emailAcepta.setFrom("Sistema Sinapsis");
            emailAcepta.setAsunto("Su pedido: "+ m_Pedido.getNumPedido()+" ha sido aceptado.");
            emailAcepta.setMensaje("Sr "+nombProv+" le informamos que en el dia de la fecha "+formato.format(nuevaFecha)+" su pedido numero "+m_Pedido.getNumPedido()+" ha sido aceptado en nuestro sistema");
            
            AdaptadorEnvioMail envioMail = (AdaptadorEnvioMail) FactoriaAdaptadorEnvioMail.getInstance().obtenerAdaptadorEnvioMail("SMTP");
           
            envioMail.enviarMail(emailAcepta);
            
            JOptionPane.showMessageDialog(null, "Se ha enviado un correo de aceptacion de Pedido al proveedor "+nombProv, "Información", JOptionPane.INFORMATION_MESSAGE);

            
            for(PedidoDetalle pedDet : m_Pedido.getM_PedidoDetalleList()){
                Articulo art = pedDet.getM_Articulo();
                int stock = art.getStockArticulo();
                int cantPed = pedDet.getCantidadPedido();
                
                art.setStockArticulo(stock + cantPed);
                FachadaInterna.getInstance().guardar(art);
            }
            Reposicion rep = m_Pedido.getM_Reposicion();
            
            criterioList.clear();
            Criterio c4 = new Criterio();
            c4.setAtributo("m_Reposicion");
            c4.setOperacion("=");
            c4.setValor(rep);
            criterioList.add(c4);
            
            List<Pedido> ped = (List) FachadaPersistencia.getInstance().buscar("Pedido",criterioList);
            
            
            int cantPedidos = 0;
            for(Pedido pedi : ped){
                
                cantPedidos++;
            }
            int recepcionados = 0;
            for(Pedido pedido : ped){
                for(PedidoEstado otroPedEst : pedido.getM_PedidoEstadoList()){
                    FachadaInterna.getInstance().guardar(otroPedEst);
                     String estPedi = otroPedEst.getM_EstadoPedido().getNombreEstadoPedido();
                      if ((estPedi.compareTo("Recepcionado") == 0 || estPedi.compareTo("Rechazado") == 0)){
                        recepcionados++; 
                      }
                 }
                }
          
              if (cantPedidos == recepcionados){
                criterioList.clear();
                Criterio c5 = new Criterio();
                c5.setAtributo("nombreEstadoReposicion");
                c5.setOperacion("=");
                c5.setValor("Finalizada");
                criterioList.add(c5);
                List<EstadoReposicion> estRepo = (List) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criterioList);
                       if(estRepo.isEmpty()){
                    throw new IndexOutOfBoundsException("Finalizada");
                }
                rep.setM_EstadoReposicion(estRepo.get(0));
                FachadaInterna.getInstance().guardar(rep);
          
              } 
             FachadaInterna.getInstance().guardar(m_Pedido);
             
    }

    public void rechazarPedido()  {
        
        Date fechaActual = new Date();
            for(PedidoEstado pedEst : m_Pedido.getM_PedidoEstadoList()){
                Date fecha = pedEst.getFechaHastaPedidoEstado();
                
                if(fecha == null){
                    pedEst.setFechaHastaPedidoEstado(fechaActual);
                }
            }
 
            PedidoEstado pedidoEstado = new PedidoEstado();
            pedidoEstado.setFechaDesdePedidoEstado(fechaActual);
            String mailProv = m_Pedido.getM_Proveedor().getEmailProveedor();
            String nombProv = m_Pedido.getM_Proveedor().getNombreProveedor();
           
            List<Criterio> criterioList = new ArrayList<>();
                      
            Criterio c3 = new Criterio();
            c3.setAtributo("nombreEstadoPedido");
            c3.setOperacion("=");
            c3.setValor("Rechazado Pendiente De Entrega");
            criterioList.add(c3);           
            EstadoPedido estPed = (EstadoPedido) FachadaPersistencia.getInstance().buscar("EstadoPedido",criterioList).get(0);
            
            pedidoEstado.setM_EstadoPedido(estPed);
            m_Pedido.addPedidoEstado(pedidoEstado); 
          
            DTOEmail emailRechaza = new DTOEmail();
            emailRechaza.setTo(mailProv);
            emailRechaza.setFrom("Sistema Sinapsis");
            emailRechaza.setAsunto("Su pedido: "+m_Pedido.getNumPedido()+"ha sido rechazado.");
            emailRechaza.setMensaje("Sr "+nombProv+" le informamos que en el dia de la fecha "+fechaActual+" su pedido numero "+m_Pedido.getNumPedido()+" ha sido rechazado");
            
            JOptionPane.showMessageDialog(null, "Se ha enviado un correo de rechazo de Pedido al proveedor "+nombProv, "Información", JOptionPane.INFORMATION_MESSAGE);
            
            FachadaInterna.getInstance().guardar(pedidoEstado);
            FachadaInterna.getInstance().guardar(m_Pedido);
            
           
        }
    public void terminarExcepciones(boolean algo){}

}


