package sistemacompraproveedores;

import sistemacompraproveedores.Decoradores.DecoradorPedidoConRechazosReiterados;
import sistemacompraproveedores.Decoradores.DecoradorAtenderPedidoDeCompra;
import sistemacompraproveedores.Decoradores.DecoradorCalcularCantidadPromedioDeEventosDeReposicion;
import sistemacompraproveedores.Decoradores.DecoradorCalcularReposicion;
import sistemacompraproveedores.Decoradores.DecoradorEnviarCorreoProveedor;
import sistemacompraproveedores.Decoradores.DecoradorFinalizarCotizacionProveedor;
import sistemacompraproveedores.Decoradores.DecoradorGenerarPedidoCotizacion;
import sistemacompraproveedores.Decoradores.DecoradorPorcentajeCotizacionesPromedio;
import sistemacompraproveedores.Decoradores.DecoradorRankearProveedor;
import sistemacompraproveedores.Decoradores.DecoradorRecepcionarCotizacion;
import sistemacompraproveedores.Decoradores.DecoradorRechazarPedidoDeCompra;
import sistemacompraproveedores.Decoradores.DecoradorSeleccionarMejorOferta;
import sistemacompraproveedores.Decoradores.DecoradorSincronizarListaDePrecios;

public class FabricaExpertos {

    private static FabricaExpertos instancia;

    public FabricaExpertos() {

    }

    public void finalize() throws Throwable {

    }

    public Object crearExperto(String s) {

        if (s.compareTo("GenerarPedidoCotizacion") == 0) {

            return new DecoradorGenerarPedidoCotizacion();

        } else if (s.compareTo("RecepcionarCotizacion") == 0) {

            return new DecoradorRecepcionarCotizacion();

        } else if (s.compareTo("AtenderPedidoDeCompra") == 0) {

            return new DecoradorAtenderPedidoDeCompra();

        } else if (s.compareTo("CalcularReposicion") == 0) {
            
            return new DecoradorCalcularReposicion();
        
        } else if (s.compareTo("SeleccionarMejorOferta") == 0){
        
            return new DecoradorSeleccionarMejorOferta();
            
        } else if (s.compareTo("EnviarCorreoProveedor")== 0){
        
            return new DecoradorEnviarCorreoProveedor();
            
        } else if (s.compareTo("SincronizarListaDePrecios")==0){
        
            return new DecoradorSincronizarListaDePrecios();
        } else if (s.compareTo("FinalizarCotizacionProveedor")==0){
            
            return new DecoradorFinalizarCotizacionProveedor();
            
        } else if (s.compareTo("RechazarPedidoDeCompra")==0){
            
            return new DecoradorRechazarPedidoDeCompra();
        } else if (s.compareTo("RankearProveedor")==0){
            
            return new DecoradorRankearProveedor();
        } else if (s.compareTo("PorcentajeCotizacionesPromedio")==0){
            
            return new DecoradorPorcentajeCotizacionesPromedio();
        } else if (s.compareTo("CalcularCantidadPromedioDeEventosDeReposicion")==0){
            
            return new DecoradorCalcularCantidadPromedioDeEventosDeReposicion();
        } else {

            return new DecoradorPedidoConRechazosReiterados();
    }
    }

    public static FabricaExpertos getinstancia() {
        if (instancia == null) {
            
            instancia = new FabricaExpertos();
        }
        return instancia;
    }
}//end FabricaExpertos
