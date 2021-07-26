package sistemacompraproveedores.Decoradores;

import CasosDeUso.Exepciones.ManejoExcepciones;
import sistemacompraproveedores.DTO.DTOPedido;
import sistemacompraproveedores.DTO.DTOPedidoCabecera;
import sistemacompraproveedores.Expertos.ExpertoAtenderPedidoDeCompra;
import sistemacompraproveedores.FachadaInterna;

public class DecoradorAtenderPedidoDeCompra extends ExpertoAtenderPedidoDeCompra {

    public DecoradorAtenderPedidoDeCompra() {

    }

    public DTOPedidoCabecera atenderPedido(int nroPedido) throws ManejoExcepciones{

        FachadaInterna.getInstance().beginTransaction();

        return super.atenderPedido(nroPedido);
    }

    public DTOPedido obtenerPedidos() {
        return super.obtenerPedidos();
    }

    public void recepcionarPedido() throws IndexOutOfBoundsException {
        super.recepcionarPedido();
         FachadaInterna.getInstance().endTransaction(true);
    }

    public void rechazarPedido() {
        super.rechazarPedido();
        FachadaInterna.getInstance().endTransaction(true);
    }
    
    public void terminarExcepciones(boolean algo){
           if(algo)
          FachadaInterna.getInstance().endTransaction(true);
           else FachadaInterna.getInstance().endTransaction(false);
    }
 
}
