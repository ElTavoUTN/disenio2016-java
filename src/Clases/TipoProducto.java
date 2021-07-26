package Clases;

public class TipoProducto extends Entidad {

    private String codigoTipo;
    private String nombreTipo;
    private String toxico;

    public TipoProducto() {

    }

    public void finalize() throws Throwable {

    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getToxico() {
        return toxico;
    }

    public void setToxico(String toxico) {
        this.toxico = toxico;
    }
}
