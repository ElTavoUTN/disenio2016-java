package Clases;

public class EstadoPedido extends Entidad {

    private int codigoEstadoPedido;
    private String nombreEstadoPedido;

    public EstadoPedido() {

    }

    public void finalize() throws Throwable {

    }

    public int getCodigoEstadoPedido() {
        return codigoEstadoPedido;
    }

    public void setCodigoEstadoPedido(int codigoEstadoPedido) {
        this.codigoEstadoPedido = codigoEstadoPedido;
    }

    public String getNombreEstadoPedido() {
        return nombreEstadoPedido;
    }

    public void setNombreEstadoPedido(String nombreEstadoPedido) {
        this.nombreEstadoPedido = nombreEstadoPedido;
    }

    
}
