package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido extends Entidad {

    private int numPedido;
    private Date fechaPedido;
    private Date fechaVencimientoPedido;
    public List<PedidoEstado> m_PedidoEstadoList;
    public Reposicion m_Reposicion;
    public List<PedidoDetalle> m_PedidoDetalleList;
    public Proveedor m_Proveedor;
    public Cotizacion m_Cotizacion;

    public Pedido() {

    }

    public void finalize() throws Throwable {

    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaVencimientoPedido() {
        return fechaVencimientoPedido;
    }

    public void setFechaVencimientoPedido(Date fechaVencimientoPedido) {
        this.fechaVencimientoPedido = fechaVencimientoPedido;
    }

    public List<PedidoEstado> getM_PedidoEstadoList() {
        return m_PedidoEstadoList;
    }

    public void setM_PedidoEstadoList(List<PedidoEstado> m_PedidoEstadoList) {
        this.m_PedidoEstadoList = m_PedidoEstadoList;
    }

    public Reposicion getM_Reposicion() {
        return m_Reposicion;
    }

    public void setM_Reposicion(Reposicion m_Reposicion) {
        this.m_Reposicion = m_Reposicion;
    }

    public List<PedidoDetalle> getM_PedidoDetalleList() {
        return m_PedidoDetalleList;
    }

    public void setM_PedidoDetalleList(List<PedidoDetalle> m_PedidoDetalleList) {
        this.m_PedidoDetalleList = m_PedidoDetalleList;
    }

    public Proveedor getM_Proveedor() {
        return m_Proveedor;
    }

    public void setM_Proveedor(Proveedor m_Proveedor) {
        this.m_Proveedor = m_Proveedor;
    }

    public Cotizacion getM_Cotizacion() {
        return m_Cotizacion;
    }

    public void setM_Cotizacion(Cotizacion m_Cotizacion) {
        this.m_Cotizacion = m_Cotizacion;
    }

    public void addPedidoEstado(PedidoEstado pedEst){
        m_PedidoEstadoList.add(pedEst);
    }
    public void quitarPedidoEstado(){
        m_PedidoEstadoList.remove(this);
    }
    public void addPedidoDetalle(PedidoDetalle pedDet){
        m_PedidoDetalleList.add(pedDet);
    }
    public void quitarPedidoDetalle(){
        m_PedidoDetalleList.remove(this);
    }
    
}
