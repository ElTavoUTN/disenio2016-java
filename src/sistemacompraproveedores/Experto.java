//package sistemacompraproveedores;
//
//import Clases.Articulo;
//import Clases.Reposicion;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class Experto {
//
//    public void Metodo() {
//        List<Criterio> criterioList = new ArrayList<>();
//        Criterio criterio1 = new Criterio();
//        criterio1.setAtributo("numero");
//        criterio1.setOperacion("=");
//        criterio1.setValor(3);
//        criterioList.add(criterio1);
//        
//        Reposicion reposicion = (Reposicion) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList).get(0);
//        //Acá se realizan los gets que no afectan en nada
//        Estado estado = reposicion.getEstado();
//        int codigoEstado = estado.getCodigo();
//        for (DetalleReposicion detalleReposicion : reposicion.getDetalleReposicionList()) {
//            detalleReposicion.getCantidad();
//            Articulo articulo = detalleReposicion.getArticulo();
//            articulo.getCodigo();
//        }
//       
// Reposicion nueva = new Reposicion();
//        nueva.setFecha(new Date());
//        nueva.setNumero(6);
//        Criterio criterio2 = new Criterio();
//        criterio2.setAtributo("codigo");
//        criterio2.setOperacion("=");
//        criterio2.setValor(1);
//        criterioList.clear();
//        criterioList.add(criterio2);
//        Estado e = (Estado) FachadaPersistencia.getInstance().buscar("Estado",
//                criterioList).get(0);
//        nueva.setEstado(e);
//        DetalleReposicion nuevoDetalle = new DetalleReposicion();
//        nuevoDetalle.setCantidad(5);
//        Criterio criterio3 = new Criterio();
//        criterio3.setAtributo("codigo");
//        criterio3.setOperacion("=");
//        criterio3.setValor(5);
//        criterioList.clear();
//        criterioList.add(criterio3);
//        Articulo a = (Articulo) FachadaPersistencia.getInstance().buscar("Articulo",
//                criterioList).get(0);
//        nuevoDetalle.setArticulo(a);
//        reposicion.addDetalleReposicionList(nuevoDetalle);
//        FachadaPersistencia.getInstance().guardar(nueva);
//        FachadaPersistencia.getInstance().guardar(nuevoDetalle);
//    }
//
//}

 
import Clases.Cotizacion;
import Clases.CotizacionDetalle;
import Clases.EstadoReposicion;
import Clases.Reposicion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOListaCotizacion;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.FachadaPersistencia;

