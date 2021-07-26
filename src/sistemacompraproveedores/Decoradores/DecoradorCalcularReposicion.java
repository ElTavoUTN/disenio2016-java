package sistemacompraproveedores.Decoradores;

import java.text.ParseException;
import java.util.List;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.Expertos.ExpertoCalcularReposicion;
import sistemacompraproveedores.FachadaInterna;

public class DecoradorCalcularReposicion extends ExpertoCalcularReposicion {

    
    
    public DecoradorCalcularReposicion() {}
    
    public void terminarTranscaccion(boolean a){
        System.out.println("terminar transaccion decorador");
        if(a)FachadaInterna.getInstance().endTransaction(true);
        else FachadaInterna.getInstance().endTransaction(false);
    }
 public List<DTOReposicion> calcularReposicion()throws org.hibernate.PropertyValueException{

        FachadaInterna.getInstance().beginTransaction();
        
        return super.calcularReposicion();
}

}
