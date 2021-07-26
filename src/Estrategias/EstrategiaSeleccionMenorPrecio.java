package Estrategias;

import Clases.CotizacionDetalle;
import Clases.Proveedor;
import java.util.ArrayList;
import java.util.List;
import sistemacompraproveedores.DTO.DTOArticulo;
import sistemacompraproveedores.DTO.DTOCotizacionSeleccionada;

public class EstrategiaSeleccionMenorPrecio implements EstrategiaSeleccionCotizacion {

    EstrategiaSeleccionMenorPrecio() {
    }

    public DTOCotizacionSeleccionada determinarMejorCotizacion(DTOArticulo DTOa) {

        DTOCotizacionSeleccionada dtoCotSel = new DTOCotizacionSeleccionada();
        List<CotizacionDetalle> lCotizacionDetalle = DTOa.getM_ListCotizacionDetalle();
        List<Proveedor> lproveedor = new ArrayList();

        CotizacionDetalle cotdetMenorPrecio = lCotizacionDetalle.get(0);
        for (int i = 0; i < lCotizacionDetalle.size(); i++) {

            if (lCotizacionDetalle.get(i).getPrecioCotizacion() < cotdetMenorPrecio.getPrecioCotizacion()) {

                cotdetMenorPrecio = lCotizacionDetalle.get(i);
            }
        }// Fin for para determinar CotizacionDetalle con menor precioCotizacion del DTOArticulo

        lproveedor = DTOa.getM_ListProveedor();
        for (Proveedor p : lproveedor) {

            if (cotdetMenorPrecio.getM_ArticuloProveedor().getM_Proveedor().getCodigoProveedor() == p.getCodigoProveedor()) {

                dtoCotSel.setCantidadCotizada(cotdetMenorPrecio.getCantidadCotizada());
                dtoCotSel.setCodigoArticulo(cotdetMenorPrecio.getM_ArticuloProveedor().getM_Articulo().getCodigoArticulo());
                dtoCotSel.setCodigoProveedor(cotdetMenorPrecio.getM_ArticuloProveedor().getM_Proveedor().getCodigoProveedor());
                dtoCotSel.setPrecioCotizacion(cotdetMenorPrecio.getPrecioCotizacion());
                dtoCotSel.setCotizacionDeta(cotdetMenorPrecio);
            }
        }

        return dtoCotSel;
    }

}// Fin Estrategia Seleccion Menor Precio
