package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DatosBD;
import modelo.Producto;
import modelo.Sucursal;
import modelo.Usuario;

/*
 * @author jviveros
 */
public class ListaUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            DatosBD bd = new DatosBD();
            ArrayList<Usuario> listaUsuarios = bd.listaUsuarios();
            ArrayList<Sucursal> listaSucursal = bd.listaSucursal();
            ArrayList<Producto> listaProductos = bd.listaProducto();
            switch (op) {
                case "1"://Lista de Sucursales
                    out.println("Sucursal: ");
                    out.println("<select id=\"agrSucursal\" name=\"agrSucursal\">");
                    out.println("<option selected disabled hidden value=''>Selecciona Sucursal</option>");
                    for(int i = 0; i< listaSucursal.size();i++){
                        out.println("<option value=\'"+listaSucursal.get(i).getSucursalID()+"\'>"
                                    +listaSucursal.get(i).getSucursalID()+" - "+listaSucursal.get(i).getDireccion()+"</option>");
                    }
                        out.println("</select><br/>");
                    break;
                case "2"://Lista de Usuarios
                    out.println("Usuario: "
                              + "<select id=\"elimUsuario\" name=\"elimUsuario\" onchange=\"MostrarInfoUsuario()\">");
                    out.println("<option selected disabled hidden value=''>Selecciona Usuario</option>");
                    for(int i = 0; i< listaUsuarios.size();i++){
                        out.println("<option value=\'"+listaUsuarios.get(i).getUsuarioID()+"\'>"
                                +listaUsuarios.get(i).getUsuarioNombre()+" - "+listaUsuarios.get(i).getRol()+"</option>");
                    }
                        out.println("</select><br/>");
                    break;
                case "3"://Información Usuario a Eliminar
                    String usuario = request.getParameter("eUsuario");
                    ArrayList<Usuario> eUsuario = bd.getUsuario(usuario);
                    out.println("<br/>UserID  : "+eUsuario.get(0).getUsuarioID());
                    out.println("<br/>Nombre  : "+eUsuario.get(0).getUsuarioNombre());
                    out.println("<br/>Rol     : "+eUsuario.get(0).getRol());
                    out.println("<br/>Sucursal: "+eUsuario.get(0).getSucursalID());
                    break;
                case "4"://Lista de productos eliminar
                    out.println("Producto: "
                              + "<select id=\"elimProducto\" name=\"elimProducto\" onchange=\"MostrarInfoProducto()\">");
                    out.println("<option selected disabled hidden value=''>Selecciona Producto</option>");
                    for(int i = 0; i< listaProductos.size();i++){
                        out.println("<option value=\'"+listaProductos.get(i).getProductoID()+"\'>"
                                    +listaProductos.get(i).getProductoID()+" - "+listaProductos.get(i).getNombre()+"</option>");
                    }
                        out.println("</select><br/>");
                    break;
                case "5"://Información Producto a Eliminar
                    String producto = request.getParameter("eProducto");
                    ArrayList<Producto> eProducto = bd.getProducto(producto);
                    out.println("<br/>ProductoID  : "+eProducto.get(0).getProductoID());
                    out.println("<br/>Nombre      : "+eProducto.get(0).getNombre());
                    out.println("<br/>Descripcion : "+eProducto.get(0).getDescripcion());
                    out.println("<br/>Precio      : "+eProducto.get(0).getPrecio());
                    out.println("<br/><input type=\"hidden\" name=\"opcion\" value=\"eliminarProducto\"></input>\n" +
                                "<input type=\"submit\" value=\"Eliminar\"></input>");
                    break;
                case "6"://Lista de productos modificar
                    out.println("Producto: "
                              + "<select id=\"modProducto\" name=\"modProducto\" onchange=\"ModificarInfoProducto()\">");
                    out.println("<option selected disabled hidden value=''>Selecciona Producto</option>");
                    for(int i = 0; i< listaProductos.size();i++){
                        out.println("<option value=\'"+listaProductos.get(i).getProductoID()+"\'>"
                                    +listaProductos.get(i).getProductoID()+" - "+listaProductos.get(i).getNombre()+"</option>");
                    }
                        out.println("</select><br/>");
                    break;
                case "7"://Información Producto a Eliminar
                    String productom = request.getParameter("mProducto");
                    ArrayList<Producto> mProducto = bd.getProducto(productom);
                    out.println("<form action=\"AdministrarUsuario\" method=\"post\">");
                    out.println("<br/>Nombre:  <input type=\"text\" name=\"modNombreProducto\" value=\""+mProducto.get(0).getNombre()+"\" required></input>");
                    out.println("<br/>Descripcion:  <input type=\"text\" name=\"modDescripcionProducto\" value=\""+mProducto.get(0).getDescripcion()+"\" required></input>");
                    out.println("<br/>Precio:  <input type=\"number\" name=\"modPrecioProducto\" value=\""+mProducto.get(0).getPrecio()+"\" step=\"0.01\" required> Pesos</input>");
                    out.println("<br/><input type=\"hidden\" name=\"opcion\" value=\"modificarProducto\"></input>\n" +
                                "<br/><input type=\"hidden\" name=\"modProductoID\" value=\""+mProducto.get(0).getProductoID()+"\"></input>\n"+
                                "<input type=\"submit\" value=\"Modificar\"></input>");
                    out.println("</form>");
                    break;
                case "8"://Lista de productos
                    out.println("<select id=\"agrCompraProductoID\" name=\"agrCompraProductoID\">");
                    out.println("<option selected disabled hidden value=''>Selecciona Producto</option>");
                    for(int i = 0; i< listaProductos.size();i++){
                        out.println("<option value=\'"+listaProductos.get(i).getProductoID()+"\'>"
                                    +listaProductos.get(i).getProductoID()+" - "+listaProductos.get(i).getNombre()+", "+listaProductos.get(i).getDescripcion()+"</option>");
                    }
                        out.println("</select><br/>");
                    break;
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
