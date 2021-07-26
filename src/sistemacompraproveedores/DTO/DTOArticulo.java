package sistemacompraproveedores.DTO;

import Clases.Articulo;
import Clases.CotizacionDetalle;
import Clases.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class DTOArticulo {

    public Articulo m_Articulo;
    public List<CotizacionDetalle> m_ListCotizacionDetalle = new ArrayList<>();
    public List<Proveedor> m_ListProveedor = new ArrayList<>();
    public boolean toxico;

    public Articulo getM_Articulo() {
        return m_Articulo;
    }

    public List<CotizacionDetalle> getM_ListCotizacionDetalle() {
        return m_ListCotizacionDetalle;
    }

    public List<Proveedor> getM_ListProveedor() {
        return m_ListProveedor;
    }

    public boolean isToxico() {
        return toxico;
    }

    public void setM_Articulo(Articulo m_Articulo) {
        this.m_Articulo = m_Articulo;
    }

    public void setM_ListCotizacionDetalle(List<CotizacionDetalle> m_ListCotizacionDetalle) {
        this.m_ListCotizacionDetalle = m_ListCotizacionDetalle;
    }

    public void setM_ListProveedor(List<Proveedor> m_ListProveedor) {
        this.m_ListProveedor = m_ListProveedor;
    }

    public void setToxico(boolean toxico) {
        this.toxico = toxico;
    }

     public void addCotizacionDetalle(CotizacionDetalle cotizacionDetalle) {
        m_ListCotizacionDetalle.add(cotizacionDetalle);
    }

    public void quitarCotizacionDetalle() {

        m_ListCotizacionDetalle.remove(this);

    }
    
     public void addProveedor(Proveedor proveedor) {
        m_ListProveedor.add(proveedor);
    }

    public void quitarProveedor() {

        m_ListProveedor.remove(this);

    }
    
}
