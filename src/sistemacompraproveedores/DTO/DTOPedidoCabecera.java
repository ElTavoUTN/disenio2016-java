package sistemacompraproveedores.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTOPedidoCabecera {

    private Date fechaVencimiento;
    private String nombreProveedor;
    private int numeroPedido;
    private List<DTOHistorialPedido> dtohistorialpedido = new ArrayList<>();

    public DTOPedidoCabecera() {

    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<DTOHistorialPedido> getDtohistorialpedido() {
        return dtohistorialpedido;
    }

    public void setDtohistorialpedido(List<DTOHistorialPedido> dtohistorialpedido) {
        this.dtohistorialpedido = dtohistorialpedido;
    }

    public void addDTOHistorialPedido(DTOHistorialPedido dtohistorial) {
        dtohistorialpedido.add(dtohistorial);
    }

    public void quitarDTOHistorialPedido() {

        dtohistorialpedido.remove(this);

    }

}
