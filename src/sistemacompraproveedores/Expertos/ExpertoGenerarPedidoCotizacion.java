package sistemacompraproveedores.Expertos;

import Adaptador.AdaptadorEnvioMail;
import Adaptador.FactoriaAdaptadorEnvioMail;
import Clases.ArticuloProveedor;
import Clases.Cotizacion;
import Clases.CotizacionDetalle;
import Clases.EstadoCotizacionDetalle;
import Clases.EstadoReposicion;
import Clases.Proveedor;
import Clases.Reposicion;
import Clases.ReposicionDetalle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTODetalleCotizacion;
import sistemacompraproveedores.DTO.DTOEmail;
import sistemacompraproveedores.DTO.DTOListaProveedores;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.DTO.DTOReposicionDetalle;
import sistemacompraproveedores.FachadaInterna;
import sistemacompraproveedores.FachadaPersistencia;

public class ExpertoGenerarPedidoCotizacion {

    public Reposicion m_Reposicion;
    public Cotizacion m_Cotizacion;

    public ExpertoGenerarPedidoCotizacion() {

    }

    public void finalize() throws Throwable {

    }

    public List<DTOReposicion> buscarReposicion() {

        List<DTOReposicion> dtoReposicion = new ArrayList<>();

        List<Criterio> criterioList = new ArrayList<>();

        Criterio c1 = new Criterio();
        c1.setAtributo("nombreEstadoReposicion");
        c1.setOperacion("=");
        c1.setValor("Calculada");
        criterioList.add(c1);

        EstadoReposicion estadoreposicion = (EstadoReposicion) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criterioList).get(0);

        criterioList.clear();

        Criterio c2 = new Criterio();
        c2.setAtributo("m_EstadoReposicion");
        c2.setOperacion("=");
        c2.setValor(estadoreposicion);
        criterioList.add(c2);

        List<Reposicion> lreposicion = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList);

        for (Reposicion reposicion : lreposicion) {

            DTOReposicion undtoreposicion = new DTOReposicion();

            undtoreposicion.setNumeroReposicion(reposicion.getNumReposicion());

            for (ReposicionDetalle repodetalle : reposicion.getM_ReposicionDetalleList()) {

                DTOReposicionDetalle dtoRepoDetalle = new DTOReposicionDetalle();

                dtoRepoDetalle.setNombreArticulo(repodetalle.getM_Articulo().getNombreArticulo());
                dtoRepoDetalle.setCantidadAReponerArticulo(repodetalle.getCantidadAreponer());
                dtoRepoDetalle.setNombreMarca(repodetalle.getM_Articulo().getM_Marca().getNombreMarca());
                dtoRepoDetalle.setNombreTipoProducto(repodetalle.getM_Articulo().getM_TipoProducto().getNombreTipo());
                dtoRepoDetalle.setCodigoArticulo(repodetalle.getM_Articulo().getCodigoArticulo());

//                undtoreposicion.setnombreArticulo(repodetalle.getM_Articulo().getNombreArticulo());
//                undtoreposicion.setcantidadAReponerArticulo(repodetalle.getCantidadAreponer());
//                undtoreposicion.setNombreMarca(repodetalle.getM_Articulo().getM_Marca().getNombreMarca());
//                undtoreposicion.setNombreTipoProducto(repodetalle.getM_Articulo().getM_TipoProducto().getNombreTipo());
//                undtoreposicion.setCodigoArticulo(repodetalle.getM_Articulo().getCodigoArticulo());
//                
                undtoreposicion.addDTOReposicionDetalle(dtoRepoDetalle);

            }

            dtoReposicion.add(undtoreposicion);
        }

        return dtoReposicion;

    }

    public List<DTOReposicion> buscarReposicion2(int nroRepo) {

        List<DTOReposicion> dtoReposicion = new ArrayList<>();

        List<Criterio> criterioList = new ArrayList<>();

        Criterio c1 = new Criterio();
        c1.setAtributo("nombreEstadoReposicion");
        c1.setOperacion("=");
        c1.setValor("Calculada");
        criterioList.add(c1);

        EstadoReposicion estadoreposicion = (EstadoReposicion) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criterioList).get(0);

        criterioList.clear();

        Criterio c2 = new Criterio();
        c2.setAtributo("m_EstadoReposicion");
        c2.setOperacion("=");
        c2.setValor(estadoreposicion);
        criterioList.add(c2);

        List<Reposicion> lreposicion = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList);

        for (Reposicion reposicion : lreposicion) {

            DTOReposicion undtoreposicion = new DTOReposicion();

            undtoreposicion.setNumeroReposicion(reposicion.getNumReposicion());

            for (ReposicionDetalle repodetalle : reposicion.getM_ReposicionDetalleList()) {

                DTOReposicionDetalle dtoRepoDetalle = new DTOReposicionDetalle();

                dtoRepoDetalle.setNombreArticulo(repodetalle.getM_Articulo().getNombreArticulo());
                dtoRepoDetalle.setCantidadAReponerArticulo(repodetalle.getCantidadAreponer());
                dtoRepoDetalle.setNombreMarca(repodetalle.getM_Articulo().getM_Marca().getNombreMarca());
                dtoRepoDetalle.setNombreTipoProducto(repodetalle.getM_Articulo().getM_TipoProducto().getNombreTipo());
                dtoRepoDetalle.setCodigoArticulo(repodetalle.getM_Articulo().getCodigoArticulo());

//                undtoreposicion.setnombreArticulo(repodetalle.getM_Articulo().getNombreArticulo());
//                undtoreposicion.setcantidadAReponerArticulo(repodetalle.getCantidadAreponer());
//                undtoreposicion.setNombreMarca(repodetalle.getM_Articulo().getM_Marca().getNombreMarca());
//                undtoreposicion.setNombreTipoProducto(repodetalle.getM_Articulo().getM_TipoProducto().getNombreTipo());
//                undtoreposicion.setCodigoArticulo(repodetalle.getM_Articulo().getCodigoArticulo());
//                
                undtoreposicion.addDTOReposicionDetalle(dtoRepoDetalle);

            }

            dtoReposicion.add(undtoreposicion);
        }

        return dtoReposicion;

    }

    public void seleccionarReposicion(int codReposicion) {

        Date today = new Date();

        List<DTODetalleCotizacion> dtoDetalleCotizacion = new ArrayList<>();

        List<Criterio> criterioList = new ArrayList<>();

        Criterio c8 = new Criterio();
        c8.setAtributo("numReposicion");
        c8.setOperacion("=");
        c8.setValor(codReposicion);
        criterioList.add(c8);

        m_Reposicion = (Reposicion) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList).get(0);

        DTOListaProveedores dtoListaProveedores = new DTOListaProveedores();

        System.out.println("antes del primer for");

        for (ReposicionDetalle reposiciondetalle : m_Reposicion.getM_ReposicionDetalleList()) {

            criterioList.clear();

            criterioList = new ArrayList<>();

            Criterio c3 = new Criterio();
            c3.setAtributo("m_Articulo");
            c3.setOperacion("contains");
            c3.setValor(reposiciondetalle.getM_Articulo());
            criterioList.add(c3);

            List<ArticuloProveedor> artProveedor = (List) FachadaPersistencia.getInstance().buscar("ArticuloProveedor", criterioList);
            System.out.println("dentro del primer for ");
            for (ArticuloProveedor artP : artProveedor) {

                System.out.println("Dentro del Segundo for");

                boolean estP = artP.getM_Proveedor().isEstadoProveedor();

                if (estP == true) {

                    System.out.println("dentro del primer if");

                    dtoListaProveedores.addProveedor(artP.getM_Proveedor());

                }
            }
        }

        System.out.println("Esperando entrar al tercer for");

        for (Proveedor proveedor1 : dtoListaProveedores.getProveedor()) {

            System.out.println("tercer for");
            String codProv1 = proveedor1.getCodigoProveedor();

            for (Proveedor proveedor2 : dtoListaProveedores.getProveedor()) {

                System.out.println("Cuarto for");
                String codProv2 = proveedor2.getCodigoProveedor();

                if (codProv1.equals(codProv2)) {

                    System.out.println("Dentro del segundo if");

                    dtoListaProveedores.quitarProveedor();

                }

            }

        }

        for (Proveedor proveedor3 : dtoListaProveedores.getProveedor()) {

            System.out.println("Quinto for ");

            Cotizacion cotizacion = new Cotizacion();

            cotizacion.setM_Reposicion(m_Reposicion);
            cotizacion.setM_Proveedor(proveedor3);
            cotizacion.setNumCotizacion(6);
            cotizacion.setFechaCotizacion(today);

            criterioList.clear();

            criterioList = new ArrayList<>();

            Criterio c4 = new Criterio();
            c4.setAtributo("m_Proveedor");
            c4.setOperacion("contains");
            c4.setValor(proveedor3);
            criterioList.add(c4);

            for (ReposicionDetalle lrepo : m_Reposicion.getM_ReposicionDetalleList()) {

                System.out.println("Sexto for ");
                criterioList.clear();

                criterioList = new ArrayList<>();

                Criterio c9 = new Criterio();
                c9.setAtributo("m_Articulo");
                c9.setOperacion("contains");
                c9.setValor(lrepo.getM_Articulo());
                criterioList.add(c9);

                List<ArticuloProveedor> lartprov = (List) FachadaPersistencia.getInstance().buscar("ArticuloProveedor", criterioList);

                boolean existeArtProv = false;

                if (lartprov.isEmpty()) {

                    System.out.println("tercer if");

                    existeArtProv = true;
                }

                if (!existeArtProv) {

                    System.out.println("Cuarto If");
                    CotizacionDetalle cotiDetalle = new CotizacionDetalle();

                    criterioList.clear();
                    criterioList = new ArrayList<>();

                    Criterio c5 = new Criterio();
                    c5.setAtributo("nombreEstadoCotizacionDetalle");
                    c5.setOperacion("=");
                    c5.setValor("Creada");
                    criterioList.add(c5);

                    EstadoCotizacionDetalle estadoCotiDet = (EstadoCotizacionDetalle) FachadaPersistencia.getInstance().buscar("EstadoCotizacionDetalle", criterioList).get(0);

                    cotiDetalle.setM_EstadoCotizacionDetalle(estadoCotiDet);
                    cotiDetalle.setM_ArticuloProveedor(lartprov.get(0));
                    cotiDetalle.setRenglonCotizacion(7);
                    cotiDetalle.setM_ReposicionDetalle(lrepo);
                    cotizacion.addCotizacionDetalle(cotiDetalle);

                    FachadaInterna.getInstance().guardar(cotizacion);
                    FachadaInterna.getInstance().guardar(cotiDetalle);

                    System.out.println("Pasó los guardar");

                }

            }

        }

    }

    public void enviarPedidoCotizacion(Date fechaVenc) {

      //  if(fechaVenc>=  && fechaVenc<=  )
        m_Cotizacion.setFechaVencimientoCotizacion(fechaVenc);

        List<Criterio> criterioList = new ArrayList<>();

        Criterio c5 = new Criterio();
        c5.setAtributo("nombreEstadoCotizacionDetalle");
        c5.setOperacion("=");
        c5.setValor(m_Cotizacion.getM_CotizacionDetalleList().get(0).getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle().equals("Creada"));
        criterioList.add(c5);

        List<Cotizacion> listcotizacion = (List) FachadaPersistencia.getInstance().buscar("Cotizacion", criterioList);

        for (Cotizacion mcotizacion : listcotizacion) {

            //  FachadaPersistencia.getInstance().guardar(mcotizacion);
            DTOEmail undtomail = new DTOEmail();

            undtomail.setTo(mcotizacion.getM_Proveedor().getEmailProveedor());
            undtomail.setCc(" ");
            undtomail.setCco(" ");
            undtomail.setFrom("Sistema Sinapsis");
            undtomail.setAsunto("Pedido de Cotizacion " + mcotizacion.getNumCotizacion());

            undtomail.setMensaje("Estimado " + mcotizacion.getM_Proveedor().getNombreProveedor() + " nos dirijimos a usted a fin de solicitarle tenga a bien realizar la cotización sobre los artículos cuya descripción se adjuntan: ");

            for (CotizacionDetalle cotidetalle : mcotizacion.getM_CotizacionDetalleList()) {

                int cantidadAPedirCotizacion = cotidetalle.getCantidadAPedirCotizacion();
                String codigoExterno = cotidetalle.getM_ArticuloProveedor().getCodigoExterno();
                String nombreArticulo = cotidetalle.getM_ArticuloProveedor().getM_Articulo().getNombreArticulo();

                System.out.println("Setea en Mensaje lo siguiente: Código Artículo" + codigoExterno + "Nombre Artículo" + nombreArticulo + "Cantidad" + cantidadAPedirCotizacion + ".");

            }
            
            
            AdaptadorEnvioMail enviomail = (AdaptadorEnvioMail)FactoriaAdaptadorEnvioMail.getInstance().obtenerAdaptadorEnvioMail("SMTP");
            
            enviomail.enviarMail(undtomail);
           
            /*Se va a preparar el mail a mandar en
            esta parte
            */
            
            

        }
        
      
        criterioList.clear();
        
       criterioList = new ArrayList<>();

        Criterio c10 = new Criterio();
        c10.setAtributo("nombreEstadoReposicion");
        c10.setOperacion("=");
        c10.setValor("Pendiente a Cotizar");
        criterioList.add(c10);
        
        EstadoReposicion estadoreposicion = (EstadoReposicion) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criterioList).get(0);
        
    m_Reposicion.setM_EstadoReposicion(estadoreposicion);
    
     FachadaInterna.getInstance().guardar(m_Reposicion);
    
        }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void volver() {

    }

    public void volver2() {

    }

    
     public Date sumarRestarDiasFecha(Date fecha, int dias){

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0	
 
      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos	
 }
}
