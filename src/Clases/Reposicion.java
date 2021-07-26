package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Reposicion extends Entidad{

    private Date fechaReposicion;
    private int numReposicion;
    private List<ReposicionDetalle> m_ReposicionDetalleList;
    private EstadoReposicion m_EstadoReposicion;

    public Reposicion() {
    }

    public Date getFechaReposicion() {
        return fechaReposicion;
    }

    public void setFechaReposicion(Date fechaReposicion) {
        this.fechaReposicion = fechaReposicion;
    }

    public int getNumReposicion() {
        return numReposicion;
    }

    public void setNumReposicion(int numReposicion) {
        this.numReposicion = numReposicion;
    }

    public EstadoReposicion getM_EstadoReposicion() {
        return m_EstadoReposicion;
    }

    public void setM_EstadoReposicion(EstadoReposicion m_EstadoReposicion) {
        this.m_EstadoReposicion = m_EstadoReposicion;
    }

    public List<ReposicionDetalle> getM_ReposicionDetalleList() {
        return m_ReposicionDetalleList;
    }

    public void setM_ReposicionDetalleList(List<ReposicionDetalle> m_ReposicionDetalleList) {
        this.m_ReposicionDetalleList = m_ReposicionDetalleList;
    }

    public void addM_ReposicionDetalleList (ReposicionDetalle reposiciondetalle){
    m_ReposicionDetalleList.add(reposiciondetalle);}
    
    public void removeM_ReposicionDetalleList(){
    m_ReposicionDetalleList.remove(this);
    }

  

}
