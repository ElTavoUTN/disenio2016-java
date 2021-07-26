package sistemacompraproveedores.Controladores;


import CasosDeUso.AtenderPedidoDeCompra3;
import CasosDeUso.AtenderPedidoDeCompra4;
import CasosDeUso.Exepciones.AtenderPedidoDeCompraCaminoAlternativo1;
import CasosDeUso.Exepciones.AtenderPedidoDeCompraCaminoAlternativo2;
import CasosDeUso.Exepciones.AtenderPedidoDeCompraCaminoAlternativo3;
import CasosDeUso.Exepciones.AtenderPedidoDeCompraCaminoAlternativo4;
import CasosDeUso.Exepciones.AtenderPedidoDeCompraCaminoAlternativo6;
import CasosDeUso.Exepciones.ManejoExcepciones;
import Clases.Pedido;
import java.util.ArrayList;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOPedido;
import sistemacompraproveedores.DTO.DTOPedidoCabecera;
import sistemacompraproveedores.Expertos.ExpertoAtenderPedidoDeCompra;
import sistemacompraproveedores.FabricaExpertos;
import sistemacompraproveedores.FachadaInterna;
import sistemacompraproveedores.FachadaPersistencia;
import sistemacompraproveedores.Sistema;

public class ControladorAtenderPedidoDeCompra {

public ExpertoAtenderPedidoDeCompra m_ExpertoAtenderPedidoDeCompra;

    public ControladorAtenderPedidoDeCompra() {

    }
    
    public DTOPedidoCabecera atenderPedido(int nroPedido) throws ManejoExcepciones{
 
       m_ExpertoAtenderPedidoDeCompra =   (ExpertoAtenderPedidoDeCompra) FabricaExpertos.getinstancia().crearExperto("AtenderPedidoDeCompra");
              
       return m_ExpertoAtenderPedidoDeCompra.atenderPedido(nroPedido);
    }

    public void obtenerPedidos() {
        DTOPedido alc =  m_ExpertoAtenderPedidoDeCompra.obtenerPedidos();
        
        new AtenderPedidoDeCompra3(this,alc).setVisible(true);   
    }

    public void recepcionarPedido() throws IndexOutOfBoundsException{
        m_ExpertoAtenderPedidoDeCompra.recepcionarPedido();
        new AtenderPedidoDeCompra4().setVisible(true); 
    }

    public void rechazarPedido() {
        m_ExpertoAtenderPedidoDeCompra.rechazarPedido();
        new AtenderPedidoDeCompraCaminoAlternativo6().setVisible(true);
    }
    
    public void caminoalternativo1(){
        new AtenderPedidoDeCompraCaminoAlternativo1().setVisible(true);
    }
    public void caminoalternativo2(){
        new AtenderPedidoDeCompraCaminoAlternativo2().setVisible(true);
    }
    public void caminoalternativo3(){
        new AtenderPedidoDeCompraCaminoAlternativo3().setVisible(true);
    }
    public void caminoalternativo4(){
        new AtenderPedidoDeCompraCaminoAlternativo4().setVisible(true);
    }
    public void caminoalternativo6(){
        new AtenderPedidoDeCompraCaminoAlternativo6().setVisible(true);
    }
    
    public void terminarExcepciones(boolean algo){
          new Sistema().setVisible(true);
    }

}
