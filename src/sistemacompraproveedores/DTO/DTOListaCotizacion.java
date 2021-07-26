package sistemacompraproveedores.DTO;

import java.util.Date;

public class DTOListaCotizacion {

    private Date fechaCotizacion;
    private Date fechaVencimientoCotizacion;
    private String nombreProveedor;
    private int numCotizacion;

    public DTOListaCotizacion() {

    }

    public void finalize() throws Throwable {

    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public Date getFechaVencimientoCotizacion() {
        return fechaVencimientoCotizacion;
    }

    public void setFechaVencimientoCotizacion(Date fechaVencimientoCotizacion) {
        this.fechaVencimientoCotizacion = fechaVencimientoCotizacion;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

}
