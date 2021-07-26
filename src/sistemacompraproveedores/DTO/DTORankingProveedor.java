/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemacompraproveedores.DTO;

/**
 *
 * @author Martin
 */
public class DTORankingProveedor {
    private String codigoProveedor;
    private String nombreProveedor;
    private float totalDescuento=0;
    private float totalPrecioDeLista=0;
    private float totalPreciosCotizados=0;
    private boolean banderaRemove = true;

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public float getTotalPrecioDeLista() {
        return totalPrecioDeLista;
    }

    public void setTotalPrecioDeLista(float totalPrecioDeLista) {
        this.totalPrecioDeLista = totalPrecioDeLista;
    }

    public float getTotalPreciosCotizados() {
        return totalPreciosCotizados;
    }

    public void setTotalPreciosCotizados(float totalPreciosCotizados) {
        this.totalPreciosCotizados = totalPreciosCotizados;
    }

    public boolean isBanderaRemove() {
        return banderaRemove;
    }

    public void setBanderaRemove(boolean banderaRemove) {
        this.banderaRemove = banderaRemove;
    }
    
    
    
    
    public void addtotalDescuento(float x){
    totalDescuento = this.getTotalDescuento()+x;}
    public void addtotalPrecioDeLista(float x){
    totalPrecioDeLista = this.getTotalPrecioDeLista()+x;}
    public void addtotalPreciosCotizados(float x){
    totalPreciosCotizados = this.getTotalPreciosCotizados()+x;}
  
    
    
    
}
