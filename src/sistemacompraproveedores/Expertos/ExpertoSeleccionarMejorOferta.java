package sistemacompraproveedores.Expertos;

import CasosDeUso.Exepciones.ExcepcionesDelSistema;
import Clases.Cotizacion;
import Clases.CotizacionDetalle;
import Clases.EstadoCotizacionDetalle;
import Clases.EstadoPedido;
import Clases.EstadoReposicion;
import Clases.Pedido;
import Clases.PedidoDetalle;
import Clases.PedidoEstado;
import Clases.Proveedor;
import Clases.Reposicion;
import Clases.ReposicionDetalle;
import Estrategias.EstrategiaSeleccionCotizacion;
import Estrategias.FactoriaEstrategiaSeleccionCotizacion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.DTO.DTOArticulo;
import sistemacompraproveedores.DTO.DTOCotizacionSeleccionada;
import sistemacompraproveedores.FachadaPersistencia;

public class ExpertoSeleccionarMejorOferta {

    public void SeleccionarMejorOferta() throws RuntimeException {

        List<ReposicionDetalle> lreposiciondetalle = new ArrayList();
        List<DTOCotizacionSeleccionada> ldtoCotizacionSeleccionada = new ArrayList();
        List<CotizacionDetalle> lcotizaciondetalle = new ArrayList();
        List<DTOArticulo> ldtoArticulo = new ArrayList();
        List<Reposicion> lreposicion = new ArrayList();
        EstadoReposicion estadoreposicion = new EstadoReposicion();
        EstadoReposicion estaRepo = new EstadoReposicion();
        DTOArticulo undtoArticulo;
        DTOCotizacionSeleccionada undtoCot;
        FactoriaEstrategiaSeleccionCotizacion factoria;
        EstrategiaSeleccionCotizacion estrategia;
        EstadoCotizacionDetalle estadoseleccionada = new EstadoCotizacionDetalle();
        EstadoCotizacionDetalle estadonoseleccionada = new EstadoCotizacionDetalle();;
        List<CotizacionDetalle> noseleccionadas = new ArrayList();
        List<CotizacionDetalle> seleccionadas = new ArrayList();
        List<Proveedor> lproveedoresApedir = new ArrayList();
        EstadoPedido enCurso = new EstadoPedido();
        Calendar calendario = Calendar.getInstance();
        Random r = new Random(); // Es para generar un número aleatorio para el Pedido.
        List<Pedido> lpedido = new ArrayList();
        calendario.add(Calendar.MONTH, 1); // Obtengo la fecha de Vencimiento del Pedido.
        Date fechaEnUnMes = calendario.getTime(); // Obtengo la fecha de Vencimiento del Pedido.

        List<Criterio> criteriolist = new ArrayList();
        Criterio c1 = new Criterio();
        c1.setAtributo("nombreEstadoReposicion");
        c1.setOperacion("=");
        c1.setValor("Atendida");
        criteriolist.add(c1);
        try {
            estadoreposicion = (EstadoReposicion) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criteriolist).get(0); // busco nomenclador de EstadoReposicion
        } catch (IndexOutOfBoundsException e) {
            ExcepcionesDelSistema eds = new ExcepcionesDelSistema();
            eds.nomencladorAtendida();
        }

        criteriolist = new ArrayList();
        Criterio c2 = new Criterio();
        c2.setAtributo("m_EstadoReposicion");
        c2.setOperacion("=");
        c2.setValor(estadoreposicion);
        criteriolist.add(c2);

        lreposicion = (List) FachadaPersistencia.getInstance().buscar("Reposicion", criteriolist); // busco Reposiciones con EstadoReposicion "Atendida"
        if (lreposicion.size() == 0) {
            ExcepcionesDelSistema eds = new ExcepcionesDelSistema();
            eds.excepcionReposicionAtendida();

        }

        for (Reposicion reposicion : lreposicion) {
            System.out.println("Reposicion número: " + reposicion.getNumReposicion());
            lreposiciondetalle = reposicion.getM_ReposicionDetalleList();
            System.out.println("cantidad de Detalles de la Reposicion: " + lreposiciondetalle.size());

            for (ReposicionDetalle reposicionDetalle : lreposiciondetalle) {

                undtoArticulo = new DTOArticulo();
                undtoArticulo.setM_Articulo(reposicionDetalle.getM_Articulo());

                criteriolist.clear();
                Criterio c3 = new Criterio();
                c3.setAtributo("m_ReposicionDetalle");
                c3.setOperacion("=");
                c3.setValor(reposicionDetalle);
                criteriolist.add(c3);

                lcotizaciondetalle = (List) FachadaPersistencia.getInstance().buscar("CotizacionDetalle", criteriolist);

                for (int g = 0; g < lcotizaciondetalle.size(); g++) {
                    int cabeceralista = 0;
                    String s = lcotizaciondetalle.get(cabeceralista).getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle();
                    if (!(s.compareTo("Cargada") == 0)) {

                        lcotizaciondetalle.remove(cabeceralista);

                    }// Fin if comparador de EstadoCotizacion==Cargada

                }// Remuevo las CotizacionDetalle que no estan "Cargada" de la lista

                if (!(lcotizaciondetalle.get(0).getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle().compareTo("Cargada") == 0) && lcotizaciondetalle.size() == 1) {
                    lcotizaciondetalle.clear();
                }// si todos las CotizacionDetalle de la ReposicionDetalle actual estan en un estado distinto de "Cargada", se las ignora a la hora de Seleccionar la mejor oferta.

                List<Proveedor> p = new ArrayList();

                if (lcotizaciondetalle.size() > 0) {
                    for (int g = 0; g < lcotizaciondetalle.size(); g++) {
                        String s = lcotizaciondetalle.get(g).getM_EstadoCotizacionDetalle().getNombreEstadoCotizacionDetalle();
                        if (s.compareTo("Cargada") == 0) {

                            p.add(lcotizaciondetalle.get(g).getM_ArticuloProveedor().getM_Proveedor());

                        }// Fin if comparador de EstadoCotizacion==Cargada

                    }// Fin for por lista de CotizacionDetalle para una ReposicionDetalle

                    undtoArticulo.setM_ListProveedor(p);
                    undtoArticulo.setM_ListCotizacionDetalle(lcotizaciondetalle);
                    ldtoArticulo.add(undtoArticulo);
                    System.out.println("el tamaño de la lista es: " + lcotizaciondetalle.size());
                }

            }// Fin for por ReposicionDetalle

            for (DTOArticulo dtoarticulo : ldtoArticulo) {

// Llama a la factoria y luego a la Estrategia correspondiente de acuerdo a si el articulo es "toxico" o "no toxico". 
                estrategia = FactoriaEstrategiaSeleccionCotizacion.getInstancia().obtenerEstrategiaSeleccionCotizacion(dtoarticulo);
                undtoCot = estrategia.determinarMejorCotizacion(dtoarticulo);
                ldtoCotizacionSeleccionada.add(undtoCot);

            } // Fin for por DTOArticulo        

            criteriolist.clear();
            Criterio c4 = new Criterio();
            c4.setAtributo("nombreEstadoCotizacionDetalle");
            c4.setOperacion("=");
            c4.setValor("Seleccionada");
            criteriolist.add(c4);

            // Nomenclador de EstadoCotizacionDetalle "Seleccionada"
            try {
                estadoseleccionada = (EstadoCotizacionDetalle) FachadaPersistencia.getInstance().buscar("EstadoCotizacionDetalle", criteriolist).get(0);
            } catch (IndexOutOfBoundsException e) {
                ExcepcionesDelSistema eds = new ExcepcionesDelSistema();
                eds.nomencladorSeleccionada();
            }

            criteriolist.clear();
            Criterio c5 = new Criterio();
            c5.setAtributo("nombreEstadoCotizacionDetalle");
            c5.setOperacion("=");
            c5.setValor("No Seleccionada");
            criteriolist.add(c5);

            // Nomenclador de EstadoCotizacionDetalle "Seleccionada"
            try {
                estadonoseleccionada = (EstadoCotizacionDetalle) FachadaPersistencia.getInstance().buscar("EstadoCotizacionDetalle", criteriolist).get(0);
            } catch (IndexOutOfBoundsException e) {
                ExcepcionesDelSistema eds = new ExcepcionesDelSistema();
                eds.nomencladorNoSeleccionada();
            }

            criteriolist.clear();
            Criterio c6 = new Criterio();
            c6.setAtributo("nombreEstadoPedido");
            c6.setOperacion("=");
            c6.setValor("En Curso");
            criteriolist.add(c6);

            // Nomenclador de EstadoPedido "En Curso"
            try {
                enCurso = (EstadoPedido) FachadaPersistencia.getInstance().buscar("EstadoPedido", criteriolist).get(0);
            } catch (IndexOutOfBoundsException e) {
                ExcepcionesDelSistema eds = new ExcepcionesDelSistema();
                eds.nomencladorEncurso();
            }

            for (DTOArticulo dtoart : ldtoArticulo) {

                List<CotizacionDetalle> cotdet = dtoart.getM_ListCotizacionDetalle();

                for (CotizacionDetalle ct : cotdet) {

                    noseleccionadas.add(ct);

                }

            } // for para armar una lista con todas las cotizaciones detalle a las que hay que cambiarle el estado segun corresponda.

            for (DTOCotizacionSeleccionada dtocotsel : ldtoCotizacionSeleccionada) {

                CotizacionDetalle cT = dtocotsel.getCotizacionDeta();

                for (DTOArticulo dtoart : ldtoArticulo) {

                    List<CotizacionDetalle> lcotdetalle = dtoart.getM_ListCotizacionDetalle();

                    for (CotizacionDetalle lct : lcotdetalle) {

                        if (cT.equals(lct)) {

                            if (!seleccionadas.contains(lct)) {

                                seleccionadas.add(lct);
                            }
                        }

                    }

                }

            }// Fin for para armar la lista con las cotizaciones detalle a las que hay que cambiarle es estado a "Seleccionada".  

            for (CotizacionDetalle cotd : seleccionadas) {

                if (noseleccionadas.contains(cotd)) {

                    noseleccionadas.remove(cotd);

                }

            } // Fin for para armar la lista con las cotizaciones detalle a las que hay que cambiarle es estado a "No Seleccionada".  

            for (CotizacionDetalle ct : seleccionadas) {

                ct.setM_EstadoCotizacionDetalle(estadoseleccionada);
                FachadaPersistencia.getInstance().guardar(ct);

            } //Cambia el estado de las cotizaciones detalle a "Seleccionada" y las guarda.

            for (CotizacionDetalle ct : noseleccionadas) {

                ct.setM_EstadoCotizacionDetalle(estadonoseleccionada);
                FachadaPersistencia.getInstance().guardar(ct);

            } //Cambia el estado de las cotizaciones detalle a "No Seleccionada" y las guarda.

            for (DTOCotizacionSeleccionada undto : ldtoCotizacionSeleccionada) {

                String codPro = undto.getCodigoProveedor();

                criteriolist.clear();
                Criterio c7 = new Criterio();
                c7.setAtributo("codigoProveedor");
                c7.setOperacion("=");
                c7.setValor(codPro);
                criteriolist.add(c7);

                Proveedor p = (Proveedor) FachadaPersistencia.getInstance().buscar("Proveedor", criteriolist).get(0);

                if (!lproveedoresApedir.contains(p)) {

                    lproveedoresApedir.add(p);

                }
            } // Armo una lista con los Proveedores a los cuales les voy a realizar un Pedido.

            // Armado del Pedido con su PedidoEstado y los PedidoDetalle correspodientes
            for (Proveedor prov : lproveedoresApedir) {

                int nroRenglon = 1;
                String proveedorActual = prov.getCodigoProveedor();
                List<PedidoEstado> lpe = new ArrayList();
                List<PedidoDetalle> lpedidoDetalle = new ArrayList();
                Pedido nuevoPedido = new Pedido();
                nuevoPedido.setFechaPedido(new Date());
                nuevoPedido.setM_Proveedor(prov);
                nuevoPedido.setFechaVencimientoPedido(fechaEnUnMes);
                Random rdm = new Random(r.nextLong());
                int nro = rdm.nextInt();
                if (nro < 0) {
                    nro = nro * (-1);
                } // Si el numero es negativo, lo paso a positivo.
                nuevoPedido.setNumPedido(nro);
                PedidoEstado pedEstado = new PedidoEstado();
                pedEstado.setFechaDesdePedidoEstado(new Date());
                pedEstado.setM_EstadoPedido(enCurso);
                lpe.add(pedEstado);
                nuevoPedido.setM_PedidoEstadoList(lpe);
                nuevoPedido.setM_Reposicion(reposicion); // Asocia el Pedido a la Reposicion actual( for(Reposicion reposicion : lreposicion) ).
                CotizacionDetalle cotizaciondetalle = new CotizacionDetalle(); // es para buscar su cabecera y asociarla a la cabecera del pedido.
                Cotizacion cotizacionParaAsociarAlPedido = new Cotizacion();
                PedidoDetalle pd = new PedidoDetalle();

                for (DTOCotizacionSeleccionada cotselec : ldtoCotizacionSeleccionada) { // cada cotselec se corresponde con una ReposicionDetalle de la Reposicion actual.

                    if (proveedorActual.compareTo(cotselec.getCodigoProveedor()) == 0) {

                        ReposicionDetalle repo = new ReposicionDetalle();

                        for (ReposicionDetalle repdet : lreposiciondetalle) { // lreposiciondetalle contiene los detalle reposicion de la Reposicion actual.

                            if (cotselec.getCotizacionDeta().getM_ArticuloProveedor().getM_Articulo().equals(repdet.getM_Articulo())) {

                                repo = repdet;

                            }

                        } // Obtengo la reposicion detalle correspodiente para asociarla al pedido detalle

                        cotizaciondetalle = cotselec.getCotizacionDeta(); // luego busco la cabecera para esta cotizacion detalle.

                        pd = new PedidoDetalle();
                        pd.setRenglonPedido(nroRenglon);
                        pd.setM_CotizacionDetalle(cotizaciondetalle);
                        pd.setCantidadPedido(cotizaciondetalle.getCantidadAPedirCotizacion());
                        pd.setM_Articulo(cotizaciondetalle.getM_ArticuloProveedor().getM_Articulo());
                        pd.setM_ReposicionDetalle(repo);

                        lpedidoDetalle.add(pd); // Armo una lista con todos los pedidodetalle que debo asociar al pedido actual.  

                        nroRenglon = nroRenglon + 1;

                    }

                }

//              criteriolist.clear();
//              Criterio c8= new Criterio();
//              c8.setAtributo("m_CotizacionDetalleList");
//              c8.setOperacion("contains");
//              c8.setValor(cotizaciondetalle);
//              criteriolist.add(c8);
//                
//              cotizacionParaAsociarAlPedido= (Cotizacion) FachadaPersistencia.getInstance().buscar("Cotizacion", criteriolist).get(0);
                //Esta es la busqueda mas efectiva...hay que revisar el mapeo porque no la realiza.
                criteriolist.clear();
                Criterio c8 = new Criterio();
                c8.setAtributo("numCotizacion");
                c8.setOperacion("");
                c8.setValor("");
                criteriolist.add(c8);

                // Busco Todas las cotizaciones de la base de datos.
                List<Cotizacion> lcotizacion = (List) FachadaPersistencia.getInstance().buscar("Cotizacion", criteriolist);

                for (Cotizacion cot : lcotizacion) {

                    List<CotizacionDetalle> lcotiDeta = cot.getM_CotizacionDetalleList();

                    for (CotizacionDetalle codetalle : lcotiDeta) {

                        if (cotizaciondetalle.equals(codetalle)) {

                            cotizacionParaAsociarAlPedido = cot;
                            System.out.println("El OID de la cotizacion a asociar al pedido es: " + cotizacionParaAsociarAlPedido.getOID());

                        }

                    }

                } // Determino Cual es la cabecera de Cotizacion que tengo que asociar al Pedido actual

                nuevoPedido.setM_PedidoDetalleList(lpedidoDetalle);
                nuevoPedido.setM_Cotizacion(cotizacionParaAsociarAlPedido);
                lpedido.add(nuevoPedido); // Armo un lista con los Pedidos creados para luego armar el mail y enviarlo al Proveedor correspondiente.
                FachadaPersistencia.getInstance().guardar(nuevoPedido); // guardo la cabecera del Pedido creado
                FachadaPersistencia.getInstance().guardar(pedEstado); // guardo el PedidoEstado asociado al Pedido creado. 

                for (int i = 0; i < lpedidoDetalle.size(); i++) {

                    FachadaPersistencia.getInstance().guardar(lpedidoDetalle.get(i)); // guardo lo/s PedidoDetalle asociado/s al Pedido creado.

                }

            } // Fin for para armar y guardar los Pedidos.

            criteriolist.clear();
            Criterio c9 = new Criterio();
            c9.setAtributo("nombreEstadoReposicion");
            c9.setOperacion("=");
            c9.setValor("Atendida Pendiente de Recepcion");
            criteriolist.add(c9);
            try {
                estaRepo = (EstadoReposicion) FachadaPersistencia.getInstance().buscar("EstadoReposicion", criteriolist).get(0);
            } catch (IndexOutOfBoundsException e) {
                ExcepcionesDelSistema eds = new ExcepcionesDelSistema();
                eds.nomencladorAtendidaPendienteRecepcion();
            }

            reposicion.setM_EstadoReposicion(estaRepo); // cambio el estado de la reposcion actual a "Atendida Pendiente de Recepcion".
            FachadaPersistencia.getInstance().guardar(reposicion); // guardo la Reposicion actual con su nuevo estado.

        }// Fin for por Reposicion

        for (int i = 0; i < ldtoCotizacionSeleccionada.size(); i++) {

            System.out.println("El Codigo del Proveedor es: " + ldtoCotizacionSeleccionada.get(i).getCodigoProveedor());
            System.out.println("El nombre del articulo es: " + ldtoCotizacionSeleccionada.get(i).getCotizacionDeta().getM_ArticuloProveedor().getM_Articulo().getNombreArticulo());
            System.out.println("La cantidad del articulo es: " + ldtoCotizacionSeleccionada.get(i).getCantidadCotizada());
            System.out.println("El precio cotizado para el articulo es: " + ldtoCotizacionSeleccionada.get(i).getPrecioCotizacion());
            System.out.println("El OIDCotizacionDetalle es:" + ldtoCotizacionSeleccionada.get(i).getCotizacionDeta().getOID());
            System.out.println("------------------------------------------------------------------------------------------");

        }

        System.out.println("cantidad de DTOArticulo en la lista= " + ldtoArticulo.size());
        System.out.println("cantidad de DTOCotizacionSeleccionada= " + ldtoCotizacionSeleccionada.size());
        System.out.println("Fin Seleccionar Mejor Oferta" + " ;) ");

    }// Fin metodo SeleccionarMejorOferta

}// Fin ExpertoSeleccionarMejorOferta
