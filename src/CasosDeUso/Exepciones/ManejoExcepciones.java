
package CasosDeUso.Exepciones;

public class ManejoExcepciones extends Exception{
    private String parametro;
    
    public ManejoExcepciones(String parametro){
        this.parametro = parametro;
    }

    public String getParametro() {
        return parametro;
    }
     
    
}
