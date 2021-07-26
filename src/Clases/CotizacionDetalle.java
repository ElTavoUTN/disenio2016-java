package Clases;

public class CotizacionDetalle extends Entidad {

    private int cantidadAPedirCotizacion;
    private int cantidadCotizada;
    private float precioArticuloLista;
    private double precioCotizacion;
    private int renglonCotizacion;
    public EstadoCotizacionDetalle m_EstadoCotizacionDetalle;
    public ArticuloProveedor m_ArticuloProveedor;
    public ReposicionDetalle m_ReposicionDetalle;

    public CotizacionDetalle() {

    }

    public ReposicionDetalle getM_ReposicionDetalle() {
        return m_ReposicionDetalle;
    }

    public void setM_ReposicionDetalle(ReposicionDetalle m_ReposicionDetalle) {
        this.m_ReposicionDetalle = m_ReposicionDetalle;
    }

    public int getCantidadAPedirCotizacion() {
        return cantidadAPedirCotizacion;
    }

    public void setCantidadAPedirCotizacion(int cantidadAPedirCotizacion) {
        this.cantidadAPedirCotizacion = cantidadAPedirCotizacion;
    }

    public int getCantidadCotizada() {
        return cantidadCotizada;
    }

    public void setCantidadCotizada(int cantidadCotizada) {
        this.cantidadCotizada = cantidadCotizada;
    }

    public float getPrecioArticuloLista() {
        return precioArticuloLista;
    }

    public void setPrecioArticuloLista(float precioArticuloLista) {
        this.precioArticuloLista = precioArticuloLista;
    }

    public double getPrecioCotizacion() {
        return precioCotizacion;
    }

    public void setPrecioCotizacion(double precioCotizacion) {
        this.precioCotizacion = precioCotizacion;
    }

    public int getRenglonCotizacion() {
        return renglonCotizacion;
    }

    public void setRenglonCotizacion(int renglonCotizacion) {
        this.renglonCotizacion = renglonCotizacion;
    }

    public EstadoCotizacionDetalle getM_EstadoCotizacionDetalle() {
        return m_EstadoCotizacionDetalle;
    }

    public void setM_EstadoCotizacionDetalle(EstadoCotizacionDetalle m_EstadoCotizacionDetalle) {
        this.m_EstadoCotizacionDetalle = m_EstadoCotizacionDetalle;
    }

    public ArticuloProveedor getM_ArticuloProveedor() {
        return m_ArticuloProveedor;
    }

    public void setM_ArticuloProveedor(ArticuloProveedor m_ArticuloProveedor) {
        this.m_ArticuloProveedor = m_ArticuloProveedor;
    }

}
