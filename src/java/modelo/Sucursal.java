package modelo;

/*
 * @author jviveros
 */
public class Sucursal {
    private String SucursalID;
    private String Direccion;
    
    public Sucursal(){}
    public Sucursal(String sucursalID, String direccion){
        this.SucursalID = sucursalID;
        this.Direccion = direccion;
    }
    public String getSucursalID(){
        return SucursalID;
    }
    public String getDireccion(){
        return Direccion;
    }
}
