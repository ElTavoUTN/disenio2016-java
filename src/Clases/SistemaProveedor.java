package Clases;

public class SistemaProveedor extends Entidad{

    private String nombreSistemaProveedor;

    public SistemaProveedor() {

    }

    public SistemaProveedor(String nombreSistemaProveedor) {
        this.nombreSistemaProveedor = nombreSistemaProveedor;
    }
    
    

    public void finalize() throws Throwable {

    }

    public String getNombreSistemaProveedor() {
        return nombreSistemaProveedor;
    }

    public void setNombreSistemaProveedor(String nombreSistemaProveedor) {
        this.nombreSistemaProveedor = nombreSistemaProveedor;
    }

}
