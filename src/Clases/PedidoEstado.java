package Clases;

import java.util.Date;

public class PedidoEstado extends Entidad {

    private Date fechaDesdePedidoEstado;
    private Date fechaHastaPedidoEstado;
    public EstadoPedido m_EstadoPedido;

    public void finalize() throws Throwable {

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

    public EstadoPedido getM_EstadoPedido() {
        return m_EstadoPedido;
    }

    public void setM_EstadoPedido(EstadoPedido m_EstadoPedido) {
        this.m_EstadoPedido = m_EstadoPedido;
    }

}
