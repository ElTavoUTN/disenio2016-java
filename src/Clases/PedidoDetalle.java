package Clases;

public class PedidoDetalle extends Entidad {

    private int cantidadPedido;
    private int renglonPedido;
    public Articulo m_Articulo;
    public CotizacionDetalle m_CotizacionDetalle;
    public ReposicionDetalle m_ReposicionDetalle;

    public void finalize() throws Throwable {

    }

    public int getRenglonPedido() {
        return renglonPedido;
    }

    public void setRenglonPedido(int renglonPedido) {
        this.renglonPedido = renglonPedido;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public Articulo getM_Articulo() {
        return m_Articulo;
    }

    public void setM_Articulo(Articulo m_Articulo) {
        this.m_Articulo = m_Articulo;
    }

    public ReposicionDetalle getM_ReposicionDetalle() {
        return m_ReposicionDetalle;
    }

    public void setM_ReposicionDetalle(ReposicionDetalle m_ReposicionDetalle) {
        this.m_ReposicionDetalle = m_ReposicionDetalle;
    }

    public CotizacionDetalle getM_CotizacionDetalle() {
        return m_CotizacionDetalle;
    }

    public void setM_CotizacionDetalle(CotizacionDetalle m_CotizacionDetalle) {
        this.m_CotizacionDetalle = m_CotizacionDetalle;
    }

}
