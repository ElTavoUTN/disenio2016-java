package Clases;

public class ListaPrecioDetalle extends Entidad {

    private double precioArticulo;
    private int renglonLista;
    public Articulo m_Articulo;

    public ListaPrecioDetalle() {

    }

    public void finalize() throws Throwable {

    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getRenglonLista() {
        return renglonLista;
    }

    public void setRenglonLista(int renglonLista) {
        this.renglonLista = renglonLista;
    }

    public Articulo getM_Articulo() {
        return m_Articulo;
    }

    public void setM_Articulo(Articulo m_Articulo) {
        this.m_Articulo = m_Articulo;
    }

}
