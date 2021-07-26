package Clases;

public class Proveedor extends Entidad {

    private String codigoProveedor;
    private int cuitProveedor;
    private String emailProveedor;
    private boolean estadoProveedor;
    private String nombreProveedor;
    private SistemaProveedor m_sistemaProveedor;

    public Proveedor() {

    }

    public void finalize() throws Throwable {

    }

    public SistemaProveedor getM_sistemaProveedor() {
        return m_sistemaProveedor;
    }

    public void setM_sistemaProveedor(SistemaProveedor m_sistemaProveedor) {
        this.m_sistemaProveedor = m_sistemaProveedor;
    }

    public boolean isEstadoProveedor() {
        return estadoProveedor;
    }

    public void setEstadoProveedor(boolean estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public int getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(int cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

}
