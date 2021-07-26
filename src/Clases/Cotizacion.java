package Clases;

import java.sql.Time;
import java.util.*;

public class Cotizacion extends Entidad {

    private Date fechaCotizacion;
    private Date fechaEntregaCotizacion;
    private Date fechaVencimientoCotizacion;
    private Time horaEntregaCotizacion;
    private int numCotizacion;
    public List<CotizacionDetalle> m_CotizacionDetalleList = new ArrayList<>();
    public Reposicion m_Reposicion;
    public Proveedor m_Proveedor;
//    private static final int MAXVAL = 100;
//    private Integer[] result;

    public Cotizacion() {

    }

    public void finalize() throws Throwable {

    }

    public List<CotizacionDetalle> getM_CotizacionDetalleList() {
        return m_CotizacionDetalleList;
    }

    public void setM_CotizacionDetalleList(List<CotizacionDetalle> m_CotizacionDetalleList) {
        this.m_CotizacionDetalleList = m_CotizacionDetalleList;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public Date getFechaEntregaCotizacion() {
        return fechaEntregaCotizacion;
    }

    public void setFechaEntregaCotizacion(Date fechaEntregaCotizacion) {
        this.fechaEntregaCotizacion = fechaEntregaCotizacion;
    }

    public Date getFechaVencimientoCotizacion() {
        return fechaVencimientoCotizacion;
    }

    public void setFechaVencimientoCotizacion(Date fechaVencimientoCotizacion) {
        this.fechaVencimientoCotizacion = fechaVencimientoCotizacion;
    }

    public Time getHoraEntregaCotizacion() {
        return horaEntregaCotizacion;
    }

    public void setHoraEntregaCotizacion(Time horaEntregaCotizacion) {
        this.horaEntregaCotizacion = horaEntregaCotizacion;
    }

    public int getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public Reposicion getM_Reposicion() {
        return m_Reposicion;
    }

    public void setM_Reposicion(Reposicion m_Reposicion) {
        this.m_Reposicion = m_Reposicion;
    }

    public Proveedor getM_Proveedor() {
        return m_Proveedor;
    }

    public void setM_Proveedor(Proveedor m_Proveedor) {
        this.m_Proveedor = m_Proveedor;
    }

    public void addCotizacionDetalle(CotizacionDetalle cotizaciondetalle) {
        m_CotizacionDetalleList.add(cotizaciondetalle);
    }

    public void quitarCotizacionDetalle() {

        m_CotizacionDetalleList.remove(this);

    }

}
