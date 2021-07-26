

package sistemacompraproveedores.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;


public class DTOCabeceraRanking {
    private Date fechaActual;
    private Date fechaFinal;
    private Date fechaInicial;
    private Date horaActual;
    public List<DTORankingProveedor> m_DTORankingProveedorlist = new ArrayList<DTORankingProveedor>();

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getHoraActual() {
        return horaActual;
    }

    public void setHoraActual(Date horaActual) {
        this.horaActual = horaActual;
    }

    public List<DTORankingProveedor> getM_DTORankingProveedorlist() {
        return m_DTORankingProveedorlist;
    }

    public void setM_DTORankingProveedorlist(List<DTORankingProveedor> m_DTORankingProveedorlist) {
        this.m_DTORankingProveedorlist = m_DTORankingProveedorlist;
    }
    
    public void addM_DTORankingProveedor(DTORankingProveedor dto){
    m_DTORankingProveedorlist.add(dto);}
    
    public void removeM_DTORankingProveedor(DTORankingProveedor dto){
    m_DTORankingProveedorlist.remove(dto);}
    
    
}
