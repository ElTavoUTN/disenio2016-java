package sistemacompraproveedores.Controladores;


import CasosDeUso.CalcularReposicion;
import CasosDeUso.Exepciones.CalcularReposicionCaminoAlternativo1;
import CasosDeUso.Exepciones.CalcularReposicionCaminoAlternativo2;
import CasosDeUso.Exepciones.CalcularReposicionCaminoAlternativo7;
import java.util.List;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.Expertos.ExpertoCalcularReposicion;
import sistemacompraproveedores.FabricaExpertos;

public class ControladorCalcularReposicion {
    
    public ExpertoCalcularReposicion m_ExpertoCalcularReposicion;
    public ControladorCalcularReposicion(){}

    public List<DTOReposicion> calcularReposicion() throws org.hibernate.PropertyValueException,IndexOutOfBoundsException{
    
    m_ExpertoCalcularReposicion = (ExpertoCalcularReposicion) FabricaExpertos.getinstancia().crearExperto("CalcularReposicion");
     
		return m_ExpertoCalcularReposicion.calcularReposicion();}
         
	

    public void terminarTranscaccion(boolean a) {
        if(m_ExpertoCalcularReposicion==null) m_ExpertoCalcularReposicion = new ExpertoCalcularReposicion();
        m_ExpertoCalcularReposicion.terminarTranscaccion(a);}


    public void caminoalternativo1(){
       new CalcularReposicionCaminoAlternativo1().setVisible(true);}
    
    public void caminoalternativo2(){
        new CalcularReposicionCaminoAlternativo2().setVisible(true);}

    public void caminoalternativo7(){
        new CalcularReposicionCaminoAlternativo7().setVisible(true);}



}