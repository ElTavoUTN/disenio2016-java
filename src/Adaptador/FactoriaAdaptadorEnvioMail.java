package Adaptador;

import Clases.Parametro;
import java.util.ArrayList;
import java.util.List;
import sistemacompraproveedores.Criterio;
import sistemacompraproveedores.FachadaPersistencia;

public class FactoriaAdaptadorEnvioMail {

    static FactoriaAdaptadorEnvioMail instancia;
    AdaptadorEnvioMail enviomail;

    public FactoriaAdaptadorEnvioMail() {

    }

    public void finalize() throws Throwable {

    }

    public static FactoriaAdaptadorEnvioMail getInstance() {

        if (instancia == null) {

            instancia = new FactoriaAdaptadorEnvioMail();
        }
        return instancia;

    }

    public AdaptadorEnvioMail obtenerAdaptadorEnvioMail(String mail) {

        List<Criterio> criteriolist = new ArrayList<>();
        Criterio c2 = new Criterio();
        c2.setAtributo("descripcionParametro");
        c2.setOperacion("=");
        c2.setValor("ProtocoloMail");
        criteriolist.add(c2);

        List<Parametro> parametrolist = (List) FachadaPersistencia.getInstance().buscar("Parametro", criteriolist);

        System.out.println("Protocolo parametrolist " + parametrolist.size());

        for (Parametro par : parametrolist) {

            if (mail.compareTo(par.getValorParametro()) == 0) {

                AdaptadorSMTP enviomailsmtp = new AdaptadorSMTP();
                enviomail = enviomailsmtp;

                System.out.println("Entra al SMTP");

            } else if (mail.compareTo(par.getValorParametro()) == 0) {

                AdaptadorMAPI enviomailmapi = new AdaptadorMAPI();
                enviomail = enviomailmapi;

            }

        }

        return enviomail;
    }

}
