package sistemacompraproveedores;

public class ConfiguracionSMTP {

    private String contraseña;
    private String host;
    private String puerto;
    private String usuario;

    public ConfiguracionSMTP() {

    }

    public void finalize() throws Throwable {

    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
