package Clases;

public class Marca extends Entidad {

    private String codigoMarca;
    private String nombreMarca;

    public Marca() {

    }

    public void finalize() throws Throwable {

    }

    public String getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(String codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

}
