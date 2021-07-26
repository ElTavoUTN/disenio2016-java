package CasosDeUso.Exepciones;

import sistemacompraproveedores.Controladores.ControladorSeleccionarMejorOferta;


public class ExcepcionesDelSistema extends RuntimeException{
    
    
    public void excepcionReposicionAtendida(){
    
    ControladorSeleccionarMejorOferta cont= new ControladorSeleccionarMejorOferta();
    
    cont.excepcionReposicionAtendida();
    }
    
    public void nomencladorSeleccionada(){
    
    ControladorSeleccionarMejorOferta cont= new ControladorSeleccionarMejorOferta();
    cont.excepcionSeleccionada();
        
    }
    public void nomencladorNoSeleccionada(){
        
    ControladorSeleccionarMejorOferta cont= new ControladorSeleccionarMejorOferta();
    cont.excepcionNoseleccionada();
    
    }
    
    public void nomencladorEncurso(){
    
    ControladorSeleccionarMejorOferta cont= new ControladorSeleccionarMejorOferta();
    cont.excepcionEncurso();
    
    }
    public void nomencladorAtendidaPendienteRecepcion(){
    
    ControladorSeleccionarMejorOferta cont= new ControladorSeleccionarMejorOferta();
    cont.excepcionPendienteRecepcion();
    
    }
    
    public void nomencladorAtendida(){
    
    ControladorSeleccionarMejorOferta cont= new ControladorSeleccionarMejorOferta();
    cont.excepcionAtendida();
    
    }
    
}
