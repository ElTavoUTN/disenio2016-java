package sistemacompraproveedores.Controladores;

import CasosDeUso.Exepciones.ExcepcionesDelSistema;
import CasosDeUso.Exepciones.SeleccionarMejorOfertaCaminoAlternativo1;
import CasosDeUso.Exepciones.SeleccionarMejorOfertaCaminoAlternativo2;
import CasosDeUso.Exepciones.SeleccionarMejorOfertaCaminoAlternativo3;
import CasosDeUso.Exepciones.SeleccionarMejorOfertaCaminoAlternativo4;
import CasosDeUso.Exepciones.SeleccionarMejorOfertaCaminoAlternativo5;
import CasosDeUso.Exepciones.SeleccionarMejorOfertaCaminoAlternativo6;
import sistemacompraproveedores.Expertos.ExpertoSeleccionarMejorOferta;
import sistemacompraproveedores.FabricaExpertos;

public class ControladorSeleccionarMejorOferta {

    public ExpertoSeleccionarMejorOferta m_ExpertoSeleccionarMejorOferta;

    public ControladorSeleccionarMejorOferta() {
    }

    public void excepcionReposicionAtendida() {

        SeleccionarMejorOfertaCaminoAlternativo5 pantalla = new SeleccionarMejorOfertaCaminoAlternativo5();
        pantalla.setVisible(true);

    }

    public void excepcionSeleccionada() {

        SeleccionarMejorOfertaCaminoAlternativo3 pantalla = new SeleccionarMejorOfertaCaminoAlternativo3();
        pantalla.setVisible(true);

    }

    public void excepcionNoseleccionada() {

        SeleccionarMejorOfertaCaminoAlternativo2 pantalla = new SeleccionarMejorOfertaCaminoAlternativo2();
        pantalla.setVisible(true);

    }

    public void excepcionEncurso() {

        SeleccionarMejorOfertaCaminoAlternativo1 pantalla = new SeleccionarMejorOfertaCaminoAlternativo1();
        pantalla.setVisible(true);

    }

    public void excepcionPendienteRecepcion() {

        SeleccionarMejorOfertaCaminoAlternativo4 pantalla = new SeleccionarMejorOfertaCaminoAlternativo4();
        pantalla.setVisible(true);

    }

    public void excepcionAtendida() {

        SeleccionarMejorOfertaCaminoAlternativo6 pantalla = new SeleccionarMejorOfertaCaminoAlternativo6();
        pantalla.setVisible(true);

    }

    public void SeleccionarMejorOferta() throws ExcepcionesDelSistema {

        this.m_ExpertoSeleccionarMejorOferta = (ExpertoSeleccionarMejorOferta) FabricaExpertos.getinstancia().crearExperto("SeleccionarMejorOferta");
        this.m_ExpertoSeleccionarMejorOferta.SeleccionarMejorOferta();

    }

}//Fin Controlador
