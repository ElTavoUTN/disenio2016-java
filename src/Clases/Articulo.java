package Clases;

public class Articulo extends Entidad {

    private String codigoArticulo;
    private String nombreArticulo;
    private int stockArticulo;
    public TipoProducto m_TipoProducto;
    public Marca m_Marca;

    public Articulo() {

    }

    public void finalize() throws Throwable {

    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getStockArticulo() {
        return stockArticulo;
    }

    public void setStockArticulo(int stockArticulo) {
        this.stockArticulo = stockArticulo;
    }

    public TipoProducto getM_TipoProducto() {
        return m_TipoProducto;
    }

    public void setM_TipoProducto(TipoProducto m_TipoProducto) {
        this.m_TipoProducto = m_TipoProducto;
    }

    public Marca getM_Marca() {
        return m_Marca;
    }

    public void setM_Marca(Marca m_Marca) {
        this.m_Marca = m_Marca;
    }

}
