package Adaptador;

import Clases.Articulo;
import java.util.Random;

public class AdaptadorSistemaSion7 implements AdaptadorSistemaGestion {

    public int obtenerPromedioVentas(Articulo articulo) {

        Random rdm = new Random();
        Integer nro = rdm.nextInt();
        if (nro < 0) {
            nro = nro * (-1);
        }
        while (nro > 150) {
            nro = nro / 2;
        }

        return nro;
    }

}
