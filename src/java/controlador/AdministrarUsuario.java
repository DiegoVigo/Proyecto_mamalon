package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DatosBD;

/*
 * @author jviveros
 */
public class AdministrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DatosBD bd = new DatosBD();
            String op = request.getParameter("opcion");
            switch (op) {
                case "agregarUsuario":
                    String agrUserID = request.getParameter("agrUserID");
                    String agrNombreUser = request.getParameter("agrNombreUser");
                    String agrRol = request.getParameter("agrRol");
                    String agrContrasena = request.getParameter("agrContrasena");
                    String agrContrasena1 = request.getParameter("agrContrasena1");
                    String agrSucursal = request.getParameter("agrSucursal");
                    if (agrContrasena.equals(agrContrasena1)) {
                        if (bd.setUsuario(agrUserID, agrNombreUser, agrContrasena, agrRol, agrSucursal)) {
                            response.sendRedirect(request.getHeader("referer"));
                        } else {
                            out.print("Error al agregar usuario");
                        }
                    } else {
                        out.print("Contraseñas no coinciden.");
                    }

                    break;
                case "eliminarUsuario":
                    String eliminarUsuario = request.getParameter("elimUsuario");
                    if (bd.eliminarUsuario(eliminarUsuario)) {
                        response.sendRedirect(request.getHeader("referer"));
                    } else {
                        out.print("Error al eliminar usuario");
                    }
                    break;
                case "agregarProducto":
                    String agrProductoID = request.getParameter("agrProductoID");
                    String agrNombreProducto = request.getParameter("agrNombreProducto");
                    String agrDescripcionProducto = request.getParameter("agrDescripcionProducto");
                    String agrPrecioProducto = request.getParameter("agrPrecioProducto");
                    if (bd.setProducto(agrProductoID, agrNombreProducto, agrDescripcionProducto, agrPrecioProducto)) {
                        response.sendRedirect(request.getHeader("referer"));
                    } else {
                        out.println("Error al agregar producto");
                    }
                    break;
                case "eliminarProducto":
                    String eliminarProducto = request.getParameter("elimProducto");
                    if (bd.eliminarProducto(eliminarProducto)) {
                        response.sendRedirect(request.getHeader("referer"));
                    } else {
                        out.print("Error al eliminar Producto");
                    }
                    break;
                case "modificarProducto":
                    String mProductoID = request.getParameter("modProductoID");
                    String mNombreProducto = request.getParameter("modNombreProducto");
                    String mDescripcionProducto = request.getParameter("modDescripcionProducto");
                    String mPrecioProducto = request.getParameter("modPrecioProducto");
                    out.println(mProductoID + mNombreProducto + mDescripcionProducto + mPrecioProducto);
                    if (bd.modificarProducto(mProductoID, mNombreProducto, mDescripcionProducto, mPrecioProducto)) {
                        response.sendRedirect(request.getHeader("referer"));
                    } else {
                        out.print("Error al modificar Producto");
                    }
                    break;
                case "agregarCompra":
                    int cajas,u_cajas,total_unidades = 0;
                    float p_compra, total_compra;
                    String compraUsuarioID = request.getParameter("agrCompraUsuarioID");
                    String compraProductoID = request.getParameter("agrCompraProductoID");
                    String precio_compra = request.getParameter("agrCompraPrecio_c");
                    String precio_venta = request.getParameter("agrCompraPrecio_v");
                    String cantidad_caja = request.getParameter("agrCompraCantidadCaja");
                    String cantidad_cajau = request.getParameter("agrCompraCantidadCajau");
                    String cantidad_unit = request.getParameter("agrCompraCantidadUnit");
                    if (cantidad_unit.equals("0")) {
                        cajas = Integer.parseInt(cantidad_caja);
                        u_cajas = Integer.parseInt(cantidad_cajau);
                        total_unidades = cajas * u_cajas;
                        cantidad_unit = Integer.toString(total_unidades);
                    }
                    p_compra = Float.parseFloat(precio_compra);
                    total_compra = total_unidades * p_compra;
                    String t_compra = Float.toString(total_compra);
//                    out.print(compraUsuarioID+"<br/>"+ compraProductoID+"<br/>"+ precio_compra+"<br/>"+ precio_venta+ "<br/>"+cantidad_caja+ "<br/>"+cantidad_cajau+ "<br/>"+cantidad_unit+"<br/>"+t_compra);
                    if (bd.setCompra(compraUsuarioID, compraProductoID, precio_compra, precio_venta, cantidad_caja, cantidad_cajau, cantidad_unit,t_compra)) {
                        if (bd.setMovAlmacen("00000", compraUsuarioID,compraProductoID, cantidad_caja, cantidad_cajau, cantidad_unit)
                                && bd.modificarPrecioProducto(compraProductoID, precio_venta)) {
                            response.sendRedirect(request.getHeader("referer"));
                        } else {
                            out.print("Error al agregar compra");
                        }
                    }
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
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdministrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
