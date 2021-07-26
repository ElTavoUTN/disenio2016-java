/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemacompraproveedores.Decoradores;

import CasosDeUso.Exepciones.ManejoExcepciones;
import java.util.Date;
import sistemacompraproveedores.DTO.DTOCabeceraRanking;
import sistemacompraproveedores.Expertos.ExpertoRankearProveedor;
import sistemacompraproveedores.FachadaInterna;

/**
 *
 * @author Martin
 */
public class DecoradorRankearProveedor extends ExpertoRankearProveedor{

    public DecoradorRankearProveedor() {
    }
    
    public DTOCabeceraRanking realizarRanking(Date desde, Date hasta) throws ManejoExcepciones{
    FachadaInterna.getInstance().beginTransaction();
    return super.realizarRanking(desde, hasta);
    }
    public void terminartransacccion(boolean a){
    
    if(a)FachadaInterna.getInstance().endTransaction(true);
    else{
        FachadaInterna.getInstance().endTransaction(false);
    System.out.println("terminé la transaccion");
    }
    }





}
