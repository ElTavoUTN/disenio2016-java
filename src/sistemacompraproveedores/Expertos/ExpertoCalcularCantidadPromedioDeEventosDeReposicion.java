
package sistemacompraproveedores.Expertos;

import Clases.Pedido;
import Clases.Reposicion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOPromedioEventosDeReposicion;
import sistemacompraproveedores.FachadaPersistencia;


public class ExpertoCalcularCantidadPromedioDeEventosDeReposicion {
    public ExpertoCalcularCantidadPromedioDeEventosDeReposicion(){

	}

	   public DTOPromedioEventosDeReposicion promedioeventos(int anio) throws Exception {
                float valorInicial = 0;
                int comprobar = 0;
                DTOPromedioEventosDeReposicion dtoProm = new DTOPromedioEventosDeReposicion();
                dtoProm.setAnioInforme(anio);
                List<Criterio> criterioList = new ArrayList<>();

                Criterio c1 = new Criterio();
                c1.setAtributo("");
                c1.setOperacion("");
                c1.setValor("");
                criterioList.add(c1);
                List<Reposicion> rep = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList);
                
                for(Reposicion repo : rep){
                    
                    Date fecha = repo.getFechaReposicion();
                    int añoRepo = obtenerAnio(fecha);
                    if (añoRepo == anio){ 
                    comprobar = comprobar + 1;
                    valorInicial = valorInicial +1;
                   
                    dtoProm.setEventosReposicion((int) (valorInicial));
                    dtoProm.setAnioInforme(anio);
                    }
                }
                if (comprobar == 0){
                    throw new Exception();
                }
                float totalEventos = dtoProm.getEventosReposicion();
                dtoProm.setTotalReposiciones(totalEventos/12);
                
                return dtoProm;
	}
           
            public int obtenerAnio(Date date) {//Metodo para obtener el valor numero de año de una fecha

               if (null == date) {

                   return 0;

               } else {

                   String formato = "yyyy";
                   SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
                   return Integer.parseInt(dateFormat.format(date));

               }

           }
}
