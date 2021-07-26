package sistemacompraproveedores.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTOReposicion {

    private int cantidadAReponerArticulo;
    private String codigoArticulo;
    private Date fechaReposiocion;
    private String nombreArticulo;
    private int numeroReposicion;
    private String nombreMarca;
    private String nombreTipoProducto;
    private String nombreEstadoReposcion;
    private List<DTOReposicionDetalle> dtoRepodetalle = new ArrayList<>();

    public DTOReposicion() {
    }

    public DTOReposicion(int cantidadAReponerArticulo, String codigoArticulo, Date fechaReposiocion, String nombreArticulo, int numeroReposicion, String nombreMarca, String nombreTipoProducto) {
        this.cantidadAReponerArticulo = cantidadAReponerArticulo;
        this.codigoArticulo = codigoArticulo;
        this.fechaReposiocion = fechaReposiocion;
        this.nombreArticulo = nombreArticulo;
        this.numeroReposicion = numeroReposicion;
        this.nombreMarca = nombreMarca;
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public int getCantidadAReponerArticulo() {
        return cantidadAReponerArticulo;
    }

    public void setCantidadAReponerArticulo(int cantidadAReponerArticulo) {
        this.cantidadAReponerArticulo = cantidadAReponerArticulo;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public Date getFechaReposiocion() {
        return fechaReposiocion;
    }

    public void setFechaReposiocion(Date fechaReposiocion) {
        this.fechaReposiocion = fechaReposiocion;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getNumeroReposicion() {
        return numeroReposicion;
    }

    public void setNumeroReposicion(int numeroReposicion) {
        this.numeroReposicion = numeroReposicion;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public String getNombreEstadoReposcion() {
        return nombreEstadoReposcion;
    }

    public void setNombreEstadoReposcion(String nombreEstadoReposcion) {
        this.nombreEstadoReposcion = nombreEstadoReposcion;
    }

    public List<DTOReposicionDetalle> getDtoRepodetalle() {
        return dtoRepodetalle;
    }

    public void setDtoRepodetalle(List<DTOReposicionDetalle> dtoRepodetalle) {
        this.dtoRepodetalle = dtoRepodetalle;
    }

    public void addDTOReposicionDetalle(DTOReposicionDetalle dtoRepodet) {
        dtoRepodetalle.add(dtoRepodet);
    }

    public void quitarDTOReposicionDetalle() {

        dtoRepodetalle.remove(this);

    }

}
