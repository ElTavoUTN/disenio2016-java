package Clases;

public class ArticuloProveedor extends Entidad {

    private String codigoExterno;
    public Articulo m_Articulo;
    public Proveedor m_Proveedor;

    public ArticuloProveedor() {

    }

    public void finalize() throws Throwable {

    }

    public String getCodigoExterno() {
        return codigoExterno;
    }

    public void setCodigoExterno(String codigoExterno) {
        this.codigoExterno = codigoExterno;
    }

    public Articulo getM_Articulo() {
        return m_Articulo;
    }

    public void setM_Articulo(Articulo m_Articulo) {
        this.m_Articulo = m_Articulo;
    }

    public Proveedor getM_Proveedor() {
        return m_Proveedor;
    }

    public void setM_Proveedor(Proveedor m_Proveedor) {
        this.m_Proveedor = m_Proveedor;
    }

}
