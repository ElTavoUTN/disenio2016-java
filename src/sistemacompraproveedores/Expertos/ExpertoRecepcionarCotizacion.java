package sistemacompraproveedores.Expertos;

import CasosDeUso.Exepciones.ManejoExcepciones;
import Clases.Articulo;
import sistemacompraproveedores.DTO.DTOListaCotizacion;
import Clases.Cotizacion;
import Clases.CotizacionDetalle;
import Clases.EstadoCotizacionDetalle;
import Clases.EstadoReposicion;
import Clases.ListaPrecio;
import Clases.ListaPrecioDetalle;
import Clases.Proveedor;
import Clases.Reposicion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOCompletarCotizacion;
import sistemacompraproveedores.DTO.DTODetalleCotizacion;
import sistemacompraproveedores.DTO.DTOReposicion;
import sistemacompraproveedores.FachadaInterna;
import sistemacompraproveedores.FachadaPersistencia;

public class ExpertoRecepcionarCotizacion {

    public Cotizacion m_Cotizacion;
    public Reposicion m_Reposicion;
    public Proveedor m_Proveedor;

    public ExpertoRecepcionarCotizacion() {

    }

    public <T> List<T> union(List<T> list1, List<T> list2) { // metodo para unir dos listas
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<>(set);
    }

    public ExpertoRecepcionarCotizacion(Cotizacion m_Cotizacion, Reposicion m_Reposicion) {
        this.m_Cotizacion = m_Cotizacion;
        this.m_Reposicion = m_Reposicion;
        this.m_Proveedor = m_Proveedor;
    }

    public void finalize() throws Throwable {

    }

    public List<DTOReposicion> buscarReposicion() throws ManejoExcepciones {

        List<DTOReposicion> dtoReposicion = new ArrayList();

        List<Criterio> criterioList = new ArrayList<>();

        Criterio c1 = new Criterio();
        c1.setAtributo("nombreEstadoReposicion");
        c1.setOperacion("=");
        c1.setValor("Pendiente a Cotizar");
        criterioList.add(c1);

        EstadoReposicion estadoreposicion = (EstadoReposicion) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criterioList).get(0);

        criterioList = new ArrayList<>();

        Criterio c2 = new Criterio();
        c2.setAtributo("m_EstadoReposicion");
        c2.setOperacion("=");
        c2.setValor(estadoreposicion);
        criterioList.add(c2);

        List<Reposicion> lreposicionpen = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList);

        criterioList = new ArrayList<>();

        c1 = new Criterio();
        c1.setAtributo("nombreEstadoReposicion");
        c1.setOperacion("=");
        c1.setValor("Notificada");
        criterioList.add(c1);

        estadoreposicion = (EstadoReposicion) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criterioList).get(0);

        criterioList = new ArrayList<>();
        c2 = new Criterio();
        c2.setAtributo("m_EstadoReposicion");
        c2.setOperacion("=");
        c2.setValor(estadoreposicion);
        criterioList.add(c2);

        List<Reposicion> lreposicionnotificada = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList);

        List<Reposicion> listaRepo = union(lreposicionpen, lreposicionnotificada);

        if (listaRepo.isEmpty()) {
            throw new ManejoExcepciones("PendienteNotificada");
        }

        for (Reposicion reposicion : listaRepo) {

            DTOReposicion undtoreposicion = new DTOReposicion();

            int nrorepo = reposicion.getNumReposicion();
            Date fecha = reposicion.getFechaReposicion();

            undtoreposicion.setNumeroReposicion(nrorepo);
            undtoreposicion.setFechaReposiocion(fecha);

            dtoReposicion.add(undtoreposicion);
        }

        return dtoReposicion;
    }

    //Método Seleccionar Reposicion
    public List<DTOListaCotizacion> seleccionarReposicion(int nroReposicion) {

        List<DTOListaCotizacion> dtoListaCotizacion = new ArrayList<>();

        List<Criterio> criterioList = new ArrayList<>();

        Criterio c3 = new Criterio();
        c3.setAtributo("numReposicion");
        c3.setOperacion("=");
        c3.setValor(nroReposicion);
        criterioList.add(c3);

        m_Reposicion = (Reposicion) FachadaPersistencia.getInstance().buscar("Reposicion", criterioList).get(0);

        criterioList = new ArrayList<>();

        c3 = new Criterio();
        c3.setAtributo("m_Reposicion");
        c3.setOperacion("=");
        c3.setValor(m_Reposicion);
        criterioList.add(c3);

        List<Cotizacion> lcotizacion = (List) FachadaPersistencia.getInstance().buscar("Cotizacion", criterioList);

        for (Cotizacion cotizacion : lcotizacion) {

            boolean nocreada = false;

            System.out.println(cotizacion.getM_CotizacionDetalleList().size());
            for (CotizacionDetalle detalleCoti : cotizacion.getM_CotizacionDetalleList()) {
                System.out.println(detalleCoti.getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle());
                if (!detalleCoti.getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle().equals("Creada")) {
                    nocreada = true;

                }
            }
            if (!nocreada) {
                DTOListaCotizacion undtolistacotizacion = new DTOListaCotizacion();

                undtolistacotizacion.setNumCotizacion(cotizacion.getNumCotizacion());

                undtolistacotizacion.setFechaCotizacion(cotizacion.getFechaCotizacion());

                undtolistacotizacion.setFechaVencimientoCotizacion(cotizacion.getFechaVencimientoCotizacion()); // pone fecha de vencimiento

                undtolistacotizacion.setNombreProveedor(cotizacion.getM_Proveedor().getNombreProveedor()); // setea nombre proveedor

                dtoListaCotizacion.add(undtolistacotizacion);
            }

        }
        return dtoListaCotizacion;
    }

    public List<DTODetalleCotizacion> seleccionarCotizacion(int nroCotizacion) {

        List<DTODetalleCotizacion> dtoDetalleCotizacion = new ArrayList<>();

        try {

            List<Criterio> criterioList = new ArrayList<>();

            Criterio c8 = new Criterio();
            c8.setAtributo("numCotizacion");
            c8.setOperacion("=");
            c8.setValor(nroCotizacion);
            criterioList.add(c8);

            m_Cotizacion = (Cotizacion) FachadaPersistencia.getInstance().buscar("Cotizacion", criterioList).get(0);

            criterioList.clear();

            Criterio c4 = new Criterio();
            c4.setAtributo("m_Proveedor");
            c4.setOperacion("=");
            c4.setValor(m_Cotizacion.getM_Proveedor());
            criterioList.add(c4);

            criterioList = new ArrayList<>();

            Criterio c7 = new Criterio();
            c7.setAtributo("vigente");
            c7.setOperacion("=");
            c7.setValor(true);
            criterioList.add(c7);

            ListaPrecio listaprecio = (ListaPrecio) FachadaPersistencia.getInstance().buscar("ListaPrecio", criterioList).get(0);

            for (CotizacionDetalle cotizaciondetalle : m_Cotizacion.getM_CotizacionDetalleList()) {

                Articulo co = cotizaciondetalle.getM_ArticuloProveedor().getM_Articulo();

                for (ListaPrecioDetalle listapreciodetalle : listaprecio.getM_ListaPrecioDetalleList()) {

                    Articulo li = listapreciodetalle.getM_Articulo();

                    if (co.getCodigoArticulo().equals(li.getCodigoArticulo())) {

                        cotizaciondetalle.setPrecioArticuloLista((float) listapreciodetalle.getPrecioArticulo());

                    }

                }

                DTODetalleCotizacion undtodetalleCotizacion = new DTODetalleCotizacion();

                undtodetalleCotizacion.setCantidadAPedirCotizacion(cotizaciondetalle.getCantidadAPedirCotizacion());
                undtodetalleCotizacion.setNombreArticulo(cotizaciondetalle.getM_ArticuloProveedor().getM_Articulo().getNombreArticulo());
                undtodetalleCotizacion.setNombreMarca(cotizaciondetalle.getM_ArticuloProveedor().getM_Articulo().getM_Marca().getNombreMarca());
                undtodetalleCotizacion.setNombreTipo(cotizaciondetalle.getM_ArticuloProveedor().getM_Articulo().getM_TipoProducto().getNombreTipo());
                undtodetalleCotizacion.setPrecioArticuloLista(cotizaciondetalle.getPrecioArticuloLista());
                undtodetalleCotizacion.setPrecioCotizacion(cotizaciondetalle.getPrecioCotizacion());
                undtodetalleCotizacion.setCantidadCotizada(cotizaciondetalle.getCantidadCotizada());
                undtodetalleCotizacion.setRenglonCotizacion(cotizaciondetalle.getRenglonCotizacion());
                undtodetalleCotizacion.setCodigoArticulo(cotizaciondetalle.getM_ArticuloProveedor().getM_Articulo().getCodigoArticulo());
                undtodetalleCotizacion.setProveedor(m_Cotizacion.getM_Proveedor().getNombreProveedor());
                undtodetalleCotizacion.setReposicion(m_Cotizacion.getM_Reposicion().getNumReposicion());

                dtoDetalleCotizacion.add(undtodetalleCotizacion);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return dtoDetalleCotizacion;
    }

    // Método Completar Cotizacion Detalle
    public void completarCotizacionDetalle(List<DTOCompletarCotizacion> dto) throws ManejoExcepciones {

        System.out.println(dto);

        for (DTOCompletarCotizacion ldto : dto) {

            System.out.println(ldto.getCantidad());
            System.out.println(ldto.getPrecio());
            System.out.println(ldto.getRenglon());
        }

        String nombreEstadoCotizacionDetalle = null;

        List<Criterio> criterioList = new ArrayList<>();

        Criterio c5 = new Criterio();
        c5.setAtributo("nombreEstadoCotizacionDetalle");
        c5.setOperacion("=");
        c5.setValor("Cargada");
        criterioList.add(c5);

        List<EstadoCotizacionDetalle> estadocotizaciondetalle = (List) FachadaPersistencia.getInstance().buscar("EstadoCotizacionDetalle", criterioList);

        if (estadocotizaciondetalle.isEmpty()) {
            throw new ManejoExcepciones("Cargada");
        }
        criterioList.clear();
        Criterio c9 = new Criterio();
        c9.setAtributo("nombreEstadoCotizacionDetalle");
        c9.setOperacion("=");
        c9.setValor("Descartada");
        criterioList.add(c9);

        List<EstadoCotizacionDetalle> estadocotizaciondetalledesc = (List) FachadaPersistencia.getInstance().buscar("EstadoCotizacionDetalle", criterioList);
        if (estadocotizaciondetalledesc.isEmpty()) {
            throw new ManejoExcepciones("Descartada");
        }
        for (DTOCompletarCotizacion dtocompletarcotizacion : dto) {

            for (CotizacionDetalle cotizaciondetalle : m_Cotizacion.getM_CotizacionDetalleList()) {

                if (cotizaciondetalle.getRenglonCotizacion() == dtocompletarcotizacion.getRenglon()) {
                    int cantidadAPedir = cotizaciondetalle.getCantidadAPedirCotizacion();
                    int dtocantidad = dtocompletarcotizacion.getCantidad();
                    double lprecioArticulo = cotizaciondetalle.getPrecioArticuloLista();
                    double dtoprecio = dtocompletarcotizacion.getPrecio();

                    cotizaciondetalle.setPrecioCotizacion(dtoprecio); // setea dtoPrecio

                    cotizaciondetalle.setCantidadCotizada(dtocantidad); // setea dtoCantidad

                    if (dtoprecio <= lprecioArticulo) {

                        if (dtocantidad == cantidadAPedir) {

                            cotizaciondetalle.setM_EstadoCotizacionDetalle(estadocotizaciondetalle.get(0));  // Setea Cargada

                        } else {

                            cotizaciondetalle.setM_EstadoCotizacionDetalle(estadocotizaciondetalledesc.get(0));//Setea Descartada
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "¡Ingrese nuevamente Precio!", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
                System.out.println("Estoy en el for");
                FachadaInterna.getInstance().guardar(cotizaciondetalle);

            }

        }

        Reposicion m_Reposicion1 = m_Cotizacion.getM_Reposicion();

        criterioList = new ArrayList<>();

        Criterio c10 = new Criterio();

        c10.setAtributo("m_Reposicion");
        c10.setOperacion("=");
        c10.setValor(m_Reposicion1);
        criterioList.add(c10);

        List<Cotizacion> lcoti = (List) FachadaPersistencia.getInstance().buscar("Cotizacion", criterioList);

        boolean todascreadas = true;

        for (Cotizacion forCotizacion : lcoti) {

            for (CotizacionDetalle cotizaciondetalle : forCotizacion.getM_CotizacionDetalleList()) {

                String nombreestcotdet = cotizaciondetalle.getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle();

                nombreEstadoCotizacionDetalle = nombreestcotdet;

                if (!(nombreEstadoCotizacionDetalle.compareTo("Descartada") == 0 || nombreEstadoCotizacionDetalle.compareTo("Cargada") == 0)) {
                    System.out.println(nombreEstadoCotizacionDetalle);
                    todascreadas = false;
                    System.out.println(cotizaciondetalle.getRenglonCotizacion());
                    System.out.println(cotizaciondetalle.getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle());
                }
            }
        }

        if (todascreadas) { //Si todos las CotizacionDetalles tienen nombreEstadoCotizacionDetalle == "Descartada" [OR] "Cargada"

            criterioList = new ArrayList<>();

            Criterio c6 = new Criterio();
            c6.setAtributo("nombreEstadoReposicion");
            c6.setOperacion("=");
            c6.setValor("Atendida");
            criterioList.add(c6);

            List<EstadoReposicion> estadoreposicion = (List) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criterioList);
            if (estadoreposicion.isEmpty()) {
                throw new ManejoExcepciones("Atendida");
            }

            m_Reposicion1.setM_EstadoReposicion(estadoreposicion.get(0));

            FachadaPersistencia.getInstance().guardar(m_Reposicion1);

        }

    }

    public void volver() {
    }

    public void volver2() {
    }

    public void terminarTransaccion(boolean algo) {
    }
;
}
