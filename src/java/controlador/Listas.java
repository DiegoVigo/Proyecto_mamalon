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
public class Listas extends HttpServlet {
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
                case "3"://Lista de productos eliminar
                    out.println("Producto: "
                              + "<select id=\"elimProducto\" name=\"elimProducto\" onchange=\"MostrarInfoProducto()\">");
                    out.println("<option selected disabled hidden value=''>Selecciona Producto</option>");
                    for(int i = 0; i< listaProductos.size();i++){
                        out.println("<option value=\'"+listaProductos.get(i).getProductoID()+"\'>"
                                    +listaProductos.get(i).getProductoID()+" - "+listaProductos.get(i).getNombre()+"</option>");
                    }
                        out.println("</select><br/>");
                    break;
                case "4"://Lista de productos modificar
                    out.println("Producto: "
                              + "<select id=\"modProducto\" name=\"modProducto\" onchange=\"ModificarInfoProducto()\">");
                    out.println("<option selected disabled hidden value=''>Selecciona Producto</option>");
                    for(int i = 0; i< listaProductos.size();i++){
                        out.println("<option value=\'"+listaProductos.get(i).getProductoID()+"\'>"
                                    +listaProductos.get(i).getProductoID()+" - "+listaProductos.get(i).getNombre()+"</option>");
                    }
                        out.println("</select><br/>");
                    break;
                case "5"://Lista de productos
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
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
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
