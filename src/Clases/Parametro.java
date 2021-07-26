package Clases;

public class Parametro {

    String codigoParametro;
    String descripcionParametro;
    String valorParametro;

    public String getCodigoParametro() {
        return codigoParametro;
    }

    public void setCodigoParametro(String codigoParametro) {
        this.codigoParametro = codigoParametro;
    }

    public String getDescripcionParametro() {
        return descripcionParametro;
    }

    public void setDescripcionParametro(String descripcionParametro) {
        this.descripcionParametro = descripcionParametro;
    }

    public String getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(String valorParametro) {
        this.valorParametro = valorParametro;
    }

    public Parametro() {
    }

    public Parametro(String codigoParametro, String descripcionParametro, String valorParametro) {
        this.codigoParametro = codigoParametro;
        this.descripcionParametro = descripcionParametro;
        this.valorParametro = valorParametro;
    }

    

    
}
