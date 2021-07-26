package sistemacompraproveedores;

import Adaptador.AdaptadorEnvioMail;
import Adaptador.FactoriaAdaptadorEnvioMail;
import sistemacompraproveedores.DTO.DTOEmail;


public class SistemaCompraProveedores {

    public static void main(String[] args) {
        System.out.println("antes del adaptador");
        
        FachadaInterna.getInstance().beginTransaction();
        
        DTOEmail dto = new DTOEmail();
        
        
        
AdaptadorEnvioMail enviomail = FactoriaAdaptadorEnvioMail.getInstance().obtenerAdaptadorEnvioMail("SMTP");

        System.out.println("antes del if");
        

            
   enviomail.enviarMail(dto);
        System.out.println("Sale Mail");
        
    }
    
}
