package Adaptador;

import Clases.Parametro;
import java.util.ArrayList;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.FachadaPersistencia;

public class FactoriaAdaptadorSistemaGestion {

    static FactoriaAdaptadorSistemaGestion instancia;
    AdaptadorSistemaGestion sistemagestion;

    public FactoriaAdaptadorSistemaGestion() {
    }

    static public FactoriaAdaptadorSistemaGestion getInstancia() {
        if (instancia == null) {

            instancia = new FactoriaAdaptadorSistemaGestion();
        }
        return instancia;
    }

    public AdaptadorSistemaGestion obtenerAdaptador(String nombre) {

        List<Criterio> criteriolist = new ArrayList<>();
        Criterio c2 = new Criterio();
        c2.setAtributo("descripcionParametro");
        c2.setOperacion("=");
        c2.setValor("SistemaVentas");
        criteriolist.add(c2);

        List<Parametro> parametrolist = (List) FachadaPersistencia.getInstance().buscar("Parametro", criteriolist);
        System.out.println("Cantidad parametrolist " + parametrolist.size());

        for (Parametro listparametro : parametrolist) {
            if (nombre.compareTo(listparametro.getValorParametro()) == 0) {
                AdaptadorSistemaTango sistematango2 = new AdaptadorSistemaTango();
                System.out.println("nombre adaptador " + nombre);
                sistemagestion = sistematango2;
            } else if (nombre.compareTo(listparametro.getValorParametro()) == 0) {
                AdaptadorSistemaSion7 sistemasion7 = new AdaptadorSistemaSion7();
                sistemagestion = sistemasion7;
            }
        }
        return sistemagestion;
    }
}
