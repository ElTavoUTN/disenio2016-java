package sistemacompraproveedores.DTO;

import java.util.Date;

public class DTOHistorialPedido {

    private Date fechaDesdePedidoEstado;
    private Date fechaHastaPedidoEstado;
    private String nombreEstadoPedido;

    public DTOHistorialPedido() {

    }

    public Date getFechaDesdePedidoEstado() {
        return fechaDesdePedidoEstado;
    }

    public void setFechaDesdePedidoEstado(Date fechaDesdePedidoEstado) {
        this.fechaDesdePedidoEstado = fechaDesdePedidoEstado;
    }

    public Date getFechaHastaPedidoEstado() {
        return fechaHastaPedidoEstado;
    }

    public void setFechaHastaPedidoEstado(Date fechaHastaPedidoEstado) {
        this.fechaHastaPedidoEstado = fechaHastaPedidoEstado;
    }

    public String getNombreEstadoPedido() {
        return nombreEstadoPedido;
    }

    public void setNombreEstadoPedido(String nombreEstadoPedido) {
        this.nombreEstadoPedido = nombreEstadoPedido;
    }

}
