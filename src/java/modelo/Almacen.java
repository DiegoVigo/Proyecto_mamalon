package modelo;

/*
 * @author jviveros
 */
public class Almacen {
    private String SucursalID,
                   UsuarioID,
                   ProductoID,
                   Cantidad_caja,
                   Unidad_caja,
                   Cantidad_unitario,
                   Fecha;
    public Almacen(){}
    public Almacen(String sucursalID, String usuarioID, String productoID, String cantidad_caja, String unidad_caja, String cantidad_unitario, String fecha){
        this.SucursalID = sucursalID;
        this.UsuarioID = usuarioID;
        this.ProductoID = productoID;
        this.Cantidad_caja = cantidad_caja;
        this.Unidad_caja = unidad_caja;
        this.Cantidad_unitario = cantidad_unitario;
        this.Fecha = fecha;
    }
    public String getSucursalID(){
        return SucursalID;
    }
    public String getUsuarioID(){
        return UsuarioID;
    }
    public String getProductoID(){
        return ProductoID;
    }
    public String getCantidad_caja(){
        return Cantidad_caja;
    }
    public String getUnidad_caja(){
        return Unidad_caja;
    }
    public String getCantidad_unitario(){
        return Cantidad_unitario;
    }
    public String getFecha(){
        return Fecha;
    }
}
