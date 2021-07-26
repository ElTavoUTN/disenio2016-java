
package sistemacompraproveedores.Controladores;

import CasosDeUso.Exepciones.ManejoExcepciones;
import CasosDeUso.Informes.Excepciones.RankearProveedorCaminoAlternativo1;
import CasosDeUso.Informes.Excepciones.RankearProveedorCaminoAlternativo2;
import CasosDeUso.Informes.Excepciones.RankearProveedorCaminoAlternativo3;
import CasosDeUso.Informes.RankearProveedor;
import CasosDeUso.Informes.RankearProveedor2;
import CasosDeUso.Informes.RankearProveedor3;
import CasosDeUso.Informes.RankearProveedor4;
import java.util.Date;
import sistemacompraproveedores.DTO.DTOCabeceraRanking;
import sistemacompraproveedores.Expertos.ExpertoRankearProveedor;
import sistemacompraproveedores.FabricaExpertos;
import sistemacompraproveedores.Informes;

public class ControladorRankearProveedor {
    ExpertoRankearProveedor m_ExpertoRankearProveedor;
    public ControladorRankearProveedor() {}
    
    public DTOCabeceraRanking realizarRanking(Date desde, Date hasta) throws ManejoExcepciones{
        m_ExpertoRankearProveedor = (ExpertoRankearProveedor) FabricaExpertos.getinstancia().crearExperto("RankearProveedor");
        return m_ExpertoRankearProveedor.realizarRanking(desde, hasta);
    }
    
    public void terminartransacccion(boolean a){
        m_ExpertoRankearProveedor.terminartransacccion(a);}
    
   public void rankearcaminoalternativo1(){
        new RankearProveedorCaminoAlternativo1().setVisible(true);}
   public void rankearcaminoalternativo2(){
        new RankearProveedorCaminoAlternativo2().setVisible(true);}
   public void rankearcaminoalternativo3(){
        new RankearProveedorCaminoAlternativo3().setVisible(true);}
   public void rankearproveedor3(){
        new RankearProveedor3().setVisible(true);}
   public void rankearproveedor2(Date desde,Date hasta){
        new RankearProveedor2(desde,hasta);}
   public void rankearproveedor(){
        new RankearProveedor().setVisible(true);}
   public void informes(){
        new Informes().setVisible(true);}
   public void rankearproveedor4(DTOCabeceraRanking dto, Date desde, Date hasta){
        new RankearProveedor4(dto, desde, hasta).setVisible(true);}
   
    
    
}
