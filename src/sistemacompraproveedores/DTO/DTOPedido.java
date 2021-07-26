package sistemacompraproveedores.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTOPedido {

    private Date fechaVencimiento;
    private String nombreProveedor;
    private int numeroPedido;
    public List<DTOListaPedido> m_DTOListaPedido = new ArrayList<>();

    public DTOPedido() {

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

    public List<DTOListaPedido> getM_DTOListaPedido() {
        return m_DTOListaPedido;
    }

    public void setM_DTOListaPedido(List<DTOListaPedido> m_DTOListaPedido) {
        this.m_DTOListaPedido = m_DTOListaPedido;
    }

    public void addDTOListaPedido(DTOListaPedido dto) {
        m_DTOListaPedido.add(dto);
    }

    public void quitarDTOListaPedido() {
        m_DTOListaPedido.remove(this);
    }

}
