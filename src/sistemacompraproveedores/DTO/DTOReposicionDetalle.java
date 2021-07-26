package sistemacompraproveedores.DTO;


import java.util.Date;


public class DTOReposicionDetalle {
    
private int cantidadAReponerArticulo;
    private String codigoArticulo;
    private Date fechaReposiocion;
    private String nombreArticulo;
    private String nombreMarca;
    private String nombreTipoProducto;
    

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

  

    

}
