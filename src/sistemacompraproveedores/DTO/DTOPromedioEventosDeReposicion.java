package sistemacompraproveedores.DTO;

import java.util.Date;

public class DTOPromedioEventosDeReposicion {

    private int anioInforme;
    private int eventosReposicion;
    private float totalReposiciones;

    public float getTotalReposiciones() {
        return totalReposiciones;
    }

    public void setTotalReposiciones(float totalReposiciones) {
        this.totalReposiciones = totalReposiciones;
    }

    public DTOPromedioEventosDeReposicion() {

    }

    public int getAnioInforme() {
        return anioInforme;
    }

    public void setAnioInforme(int anioInforme) {
        this.anioInforme = anioInforme;
    }

    public int getEventosReposicion() {
        return eventosReposicion;
    }

    public void setEventosReposicion(int eventosReposicion) {
        this.eventosReposicion = eventosReposicion;
    }

  

}
