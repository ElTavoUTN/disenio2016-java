package sistemacompraproveedores.Decoradores;

import sistemacompraproveedores.Expertos.ExpertoSeleccionarMejorOferta;
import sistemacompraproveedores.FachadaInterna;


public class DecoradorSeleccionarMejorOferta extends ExpertoSeleccionarMejorOferta {
    
    public DecoradorSeleccionarMejorOferta(){}
    
    public void SeleccionarMejorOferta(){
    
        FachadaInterna.getInstance().beginTransaction();
        super.SeleccionarMejorOferta();
        //FachadaInterna.getInstance().endTransaction(true);
    
    }


}//Fin Decorador
