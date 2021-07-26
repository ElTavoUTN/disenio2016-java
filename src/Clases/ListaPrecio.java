package Clases;

import java.util.List;

public class ListaPrecio extends Entidad {

    private int numListaPrecio;
    public List<ListaPrecioDetalle> m_ListaPrecioDetalleList;
    public Proveedor m_Proveedor;
    private boolean vigente;

    public ListaPrecio() {

    }

    public int getNumListaPrecio() {
        return numListaPrecio;
    }

    public void setNumListaPrecio(int numListaPrecio) {
        this.numListaPrecio = numListaPrecio;
    }

    public List<ListaPrecioDetalle> getM_ListaPrecioDetalleList() {
        return m_ListaPrecioDetalleList;
    }

    public void setM_ListaPrecioDetalleList(List<ListaPrecioDetalle> m_ListaPrecioDetalleList) {
        this.m_ListaPrecioDetalleList = m_ListaPrecioDetalleList;
    }

    public Proveedor getM_Proveedor() {
        return m_Proveedor;
    }

    public void setM_Proveedor(Proveedor m_Proveedor) {
        this.m_Proveedor = m_Proveedor;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

}
