package sistemacompraproveedores.DTO;

public class DTODetalleCotizacion {

    private int cantidadAPedirCotizacion;
    private String nombreArticulo;
    private String nombreMarca;
    private String nombreTipo;
    private double precioArticuloLista;
    private double precioCotizacion;
    private int cantidadCotizada;
    private int renglonCotizacion;
    private String codigoArticulo;
    private int reposicion;
    private String proveedor;

    public int getReposicion() {
        return reposicion;
    }

    public void setReposicion(int reposicion) {
        this.reposicion = reposicion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getRenglonCotizacion() {
        return renglonCotizacion;
    }

    public void setRenglonCotizacion(int renglonCotizacion) {
        this.renglonCotizacion = renglonCotizacion;
    }

    public int getCantidadAPedirCotizacion() {
        return cantidadAPedirCotizacion;
    }

    public void setCantidadAPedirCotizacion(int cantidadAPedirCotizacion) {
        this.cantidadAPedirCotizacion = cantidadAPedirCotizacion;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public double getPrecioArticuloLista() {
        return precioArticuloLista;
    }

    public void setPrecioArticuloLista(double precioArticuloLista) {
        this.precioArticuloLista = precioArticuloLista;
    }

    public double getPrecioCotizacion() {
        return precioCotizacion;
    }

    public void setPrecioCotizacion(double precioCotizacion) {
        this.precioCotizacion = precioCotizacion;
    }

    public int getCantidadCotizada() {
        return cantidadCotizada;
    }

    public void setCantidadCotizada(int cantidadCotizada) {
        this.cantidadCotizada = cantidadCotizada;
    }

}
