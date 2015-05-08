package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * @author jviveros
 */
public class DatosBD {

    ArrayList<Usuario> listaUsuarios = new ArrayList();
    ArrayList<Usuario> soloUsuario = new ArrayList();
    ArrayList<Sucursal> listaSucursal = new ArrayList();
    ArrayList<Producto> listaProducto = new ArrayList();
    ArrayList<Producto> soloProducto = new ArrayList();

    public String accesoUsuario(String usuario, String contrasena) throws SQLException, IOException {
        String rol = "";
        Consultas c = new Consultas();
        String query = "SELECT Rol FROM Usuario WHERE UsuarioID = ? and Contrasena = ? ";
        String[] s = {usuario, contrasena};
        java.sql.ResultSet rs = c.Consultar(query, s);
        while (rs.next()) {
            rol = rs.getString("Rol");
        }
        return rol;
    }

    public boolean setUsuario(String usuario, String nombreUsuario, String contrasena, String rol, String sucursalID) throws SQLException, IOException {
        boolean ban = false;
        String query, query2;
        int num = 0;
        Consultas c = new Consultas();
        ResultSet r;
        query = "SELECT 1 AS numUsuarios FROM Usuario WHERE UsuarioID=?";
        String[] s1 = {usuario};
        r = c.Consultar(query, s1);
        while (r.next()) {
            num = r.getInt("numUsuarios");
        }
        if (num > 0) {
            ban = false;
        } else {
            query2 = "INSERT INTO Usuario (UsuarioID, UsuarioNombre, Contrasena, Rol, SucursalID) VALUES (?, ?, ?, ?, ?)";
            String[] s = {usuario, nombreUsuario, contrasena, rol, sucursalID};
            if (c.AltaBaja(query2, s) == 1) {
                ban = true;
            }
        }
        return ban;
    }

    public boolean setProducto(String productoID, String nombre, String descripcion, String precio) throws SQLException, IOException {
        boolean ban = false;
        String query, query2;
        int num = 0;
        Consultas c = new Consultas();
        ResultSet r;
        query = "SELECT 1 AS numProducto FROM Producto WHERE ProductoID=?";
        String[] s1 = {productoID};
        r = c.Consultar(query, s1);
        while (r.next()) {
            num = r.getInt("numProducto");
        }
        if (num > 0) {
            ban = false;
        } else {
            query2 = "INSERT INTO Producto (ProductoID, Nombre, Descripcion, Precio) VALUES (?, ?, ?, ?)";
            String[] s = {productoID, nombre, descripcion, precio};
            if (c.AltaBaja(query2, s) == 1) {
                ban = true;
            }
        }
        return ban;
    }

    public boolean setCompra(String usuarioID, String productoID, String precio_c, String precio_v, String cantidad_c, String cantidad_cu, String cantidad_u, String t_compra) throws SQLException, IOException {
        boolean ban = false;
        String query;
        Consultas c = new Consultas();
        query = "INSERT INTO Compra (UsuarioID, ProductoID, Precio_compra, Precio_venta, Fecha, Cantidad_caja, Unidad_caja ,Cantidad_unitario, Total_compra) VALUES (?, ?, ?, ?, GETDATE(), ?, ?, ?, ?)";
        String[] s = {usuarioID, productoID, precio_c, precio_v, cantidad_c, cantidad_cu, cantidad_u, t_compra};
        if (c.AltaBaja(query, s) == 1) {
            ban = true;
        }

        return ban;
    }

    public boolean setMovAlmacen(String sucursalID, String usuarioID, String productoID, String cantidad_c, String cantidad_cu, String cantidad_u) throws SQLException, IOException {
        boolean ban = false;
        String query, query1, query2;
        int caja = 0, caja_u = 0, unit = 0;
        int n_caja = 0, n_caja_u = 0, n_unit = 0;
        int upt_caja = 0, upt_caja_u = 0, upt_unit = 0;
        Consultas c = new Consultas();
        ResultSet r;
        query = "SELECT Cantidad_caja, Unidad_caja, Cantidad_unitario FROM Almacen WHERE ProductoID=? AND SucursalID=?";
        String[] s1 = {productoID, sucursalID};
        r = c.Consultar(query, s1);
        while (r.next()) {
            caja = r.getInt("Cantidad_caja");
            caja_u = r.getInt("Unidad_caja");
            unit = r.getInt("Cantidad_unitario");
        }
        n_caja = Integer.parseInt(cantidad_c);
        n_caja_u = Integer.parseInt(cantidad_cu);
        n_unit = Integer.parseInt(cantidad_u);
        if ((caja > 0 || unit > 0) && caja_u == n_caja_u) {
            if (n_caja > 0) {
                upt_caja = n_caja + caja;
                upt_caja_u = n_caja_u;
                upt_unit = (n_caja * n_caja_u) + unit;
            } else if (n_unit > 0) {
                upt_caja = caja;
                upt_caja_u = caja_u;
                upt_unit = unit + n_unit;
            }

            String update_caja = Integer.toString(upt_caja);
            String update_caja_u = Integer.toString(upt_caja_u);
            String update_unit = Integer.toString(upt_unit);

            query1 = "UPDATE Almacen SET Cantidad_caja = ?, Unidad_caja = ?, Cantidad_unitario = ?, Fecha = GETDATE() WHERE ProductoID = ? AND SucursalID = ?";
            String[] s = {update_caja, update_caja_u, update_unit, productoID, sucursalID};
            if (c.AltaBaja(query1, s) == 1) {
                ban = true;
            }
        } else {
            query2 = "INSERT INTO Almacen (SucursalID, UsuarioID, ProductoID, Cantidad_caja, Unidad_caja, Cantidad_unitario, Fecha) VALUES (?, ?, ?, ?, ?, ?, GETDATE())";
            String[] s = {sucursalID, usuarioID, productoID, cantidad_c, cantidad_cu, cantidad_u};
            if (c.AltaBaja(query2, s) == 1) {
                ban = true;
            }
        }
        return ban;

    }

    public boolean eliminarUsuario(String nombre) throws SQLException, IOException {
        boolean ban = false;
        Consultas c = new Consultas();
        String query = "DELETE FROM Usuario WHERE UsuarioID = ? AND Rol <> 'admin'";
        String[] s = {nombre};
        if (c.AltaBaja(query, s) == 1) {
            ban = true;
        }
        return ban;
    }

    public boolean eliminarProducto(String productoID) throws SQLException, IOException {
        boolean ban = false;
        Consultas c = new Consultas();
        String query = "DELETE FROM Producto WHERE ProductoID = ?";
        String[] s = {productoID};
        if (c.AltaBaja(query, s) == 1) {
            ban = true;
        }
        return ban;
    }

    public boolean modificarProducto(String productoID, String nombre, String descripcion, String precio) throws SQLException, IOException {
        boolean ban = false;
        Consultas c = new Consultas();
        String query = "UPDATE Producto SET Nombre = ?, Descripcion = ?, Precio = ? WHERE ProductoID = ?";
        String[] s = {nombre, descripcion, precio, productoID};
        if (c.AltaBaja(query, s) == 1) {
            ban = true;
        }
        return ban;
    }

    public boolean modificarPrecioProducto(String productoID, String precio) throws SQLException, IOException {
        boolean ban = false;
        Consultas c = new Consultas();
        String query = "UPDATE Producto SET Precio = ? WHERE ProductoID = ?";
        String[] s = {precio, productoID};
        if (c.AltaBaja(query, s) == 1) {
            ban = true;
        }
        return ban;
    }

    public ArrayList<Usuario> listaUsuarios() throws SQLException, IOException {
        Consultas c = new Consultas();
        String query = "SELECT * FROM Usuario WHERE Rol <> 'admin'";
        String[] s = {};
        java.sql.ResultSet rs = c.Consultar(query, s);
        while (rs.next()) {
            String UsuarioID = rs.getString("UsuarioID");
            String UsuarioNombre = rs.getString("UsuarioNombre");
            String Rol = rs.getString("Rol");
            String Contrasena = rs.getString("Contrasena");
            String SucursalID = rs.getString("SucursalID");
            Usuario u = new Usuario(UsuarioID, UsuarioNombre, Rol, Contrasena, SucursalID);
            listaUsuarios.add(u);
        }
        return listaUsuarios;
    }

    public ArrayList<Sucursal> listaSucursal() throws SQLException, IOException {
        Consultas c = new Consultas();
        String query = "SELECT * FROM Sucursal";
        String[] s = {};
        java.sql.ResultSet rs = c.Consultar(query, s);
        while (rs.next()) {
            String SucursalID = rs.getString("SucursalID");
            String Direccion = rs.getString("Direccion");
            Sucursal su = new Sucursal(SucursalID, Direccion);
            listaSucursal.add(su);
        }
        return listaSucursal;
    }

    public ArrayList<Producto> listaProducto() throws SQLException, IOException {
        Consultas c = new Consultas();
        String query = "SELECT * FROM Producto ORDER BY Nombre";
        String[] s = {};
        java.sql.ResultSet rs = c.Consultar(query, s);
        while (rs.next()) {
            String ProductoID = rs.getString("ProductoID");
            String Nombre = rs.getString("Nombre");
            String Descripcion = rs.getString("Descripcion");
            String Precio = rs.getString("Precio");
            Producto p = new Producto(ProductoID, Nombre, Descripcion, Precio);
            listaProducto.add(p);
        }
        return listaProducto;
    }

    public ArrayList<Usuario> getUsuario(String nombre) throws SQLException, IOException {
        Consultas c = new Consultas();
        String query = "SELECT * FROM Usuario WHERE UsuarioID = ?";
        String[] s = {nombre};
        java.sql.ResultSet rs = c.Consultar(query, s);
        while (rs.next()) {
            String UsuarioID = rs.getString("UsuarioID");
            String UsuarioNombre = rs.getString("UsuarioNombre");
            String Rol = rs.getString("Rol");
            String Contrasena = rs.getString("Contrasena");
            String SucursalID = rs.getString("SucursalID");
            Usuario u = new Usuario(UsuarioID, UsuarioNombre, Rol, Contrasena, SucursalID);
            soloUsuario.add(u);
        }
        return soloUsuario;
    }

    public ArrayList<Producto> getProducto(String productoID) throws SQLException, IOException {
        Consultas c = new Consultas();
        String query = "SELECT * FROM Producto WHERE ProductoID = ?";
        String[] s = {productoID};
        java.sql.ResultSet rs = c.Consultar(query, s);
        while (rs.next()) {
            String ProductoID = rs.getString("ProductoID");
            String ProductoNombre = rs.getString("Nombre");
            String ProductoDescripcion = rs.getString("Descripcion");
            String ProductoPrecio = rs.getString("Precio");
            Producto p = new Producto(ProductoID, ProductoNombre, ProductoDescripcion, ProductoPrecio);
            soloProducto.add(p);
        }
        return soloProducto;
    }
//   public static void main(String args []) throws SQLException, IOException{
//       DatosBD bd = new DatosBD();
//       bd.setCompra("uviveros", "lib001", "10.00", "14.00", "3", "0");
//   }
}
