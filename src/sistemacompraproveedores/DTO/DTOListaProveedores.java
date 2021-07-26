package sistemacompraproveedores.DTO;

import Clases.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class DTOListaProveedores {

    private List<Proveedor> proveedor = new ArrayList<>();

    public DTOListaProveedores() {

    }

    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    public void addProveedor(Proveedor p) {
        proveedor.add(p);
    }

    public void quitarProveedor() {
        proveedor.remove(this);
    }

}
