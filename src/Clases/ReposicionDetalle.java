package Clases;

public class ReposicionDetalle extends Entidad{
    
	private int cantidadAreponer;
	private int renglonReposicion;
	public Articulo m_Articulo;
	public Reposicion m_Reposicion;

	public ReposicionDetalle(){

	}

	public void finalize() throws Throwable {

	}

    public int getCantidadAreponer() {
        return cantidadAreponer;
    }

    public void setCantidadAreponer(int cantidadAreponer) {
        this.cantidadAreponer = cantidadAreponer;
    }

    public int getRenglonReposicion() {
        return renglonReposicion;
    }

    public void setRenglonReposicion(int renglonReposicion) {
        this.renglonReposicion = renglonReposicion;
    }

    public Articulo getM_Articulo() {
        return m_Articulo;
    }

    public void setM_Articulo(Articulo m_Articulo) {
        this.m_Articulo = m_Articulo;
    }

    public Reposicion getM_Reposicion() {
        return m_Reposicion;
    }

    public void setM_Reposicion(Reposicion m_Reposicion) {
        this.m_Reposicion = m_Reposicion;
    }
        
        
}
