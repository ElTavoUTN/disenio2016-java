package sistemacompraproveedores.DTO;

import Clases.CotizacionDetalle;

public class DTOCotizacionSeleccionada {

    public int cantidadCotizada;
    public String codigoArticulo;
    public String codigoProveedor;
    public CotizacionDetalle cotizacionDeta;
    public double precioCotizacion;

    public int getCantidadCotizada() {
        return cantidadCotizada;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public CotizacionDetalle getCotizacionDeta() {
        return cotizacionDeta;
    }

    public double getPrecioCotizacion() {
        return precioCotizacion;
    }

    public void setCantidadCotizada(int cantidadCotizada) {
        this.cantidadCotizada = cantidadCotizada;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setCotizacionDeta(CotizacionDetalle cotizacionDeta) {
        this.cotizacionDeta = cotizacionDeta;
    }

    public void setPrecioCotizacion(double precioCotizacion) {
        this.precioCotizacion = precioCotizacion;
    }

}
