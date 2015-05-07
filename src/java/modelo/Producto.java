package modelo;

/*
 * @author jviveros
 */
public class Producto {
    private String ProductoID;
    private String Nombre;
    private String Descripcion;
    private String Precio;
    
    public Producto(){}
    public Producto(String productoID, String nombre, String descripcion, String precio){
        this.ProductoID = productoID;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
    }
    public String getProductoID(){
        return ProductoID;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getDescripcion(){
        return Descripcion;
    }
    public String getPrecio(){
        return Precio;
    }
}
