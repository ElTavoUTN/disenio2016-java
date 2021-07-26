package sistemacompraproveedores.DTO;

import Clases.Articulo;

public class DTOCantidadAReponerArticulo {

    private Articulo articulo;
    private int cantidadReponer = 0;

    public DTOCantidadAReponerArticulo() {

    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidadReponer() {
        return cantidadReponer;
    }

    public void setCantidadReponer(int cantidadReponer) {
        this.cantidadReponer = this.cantidadReponer + cantidadReponer;
    }

    public void addCantidadReponer(int x) {
        cantidadReponer = this.getCantidadReponer() + x;
    }

    public void subtractCantidadReponer(int x) {
        cantidadReponer = this.getCantidadReponer() - x;
    }

}
