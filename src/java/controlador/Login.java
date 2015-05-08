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
import javax.servlet.http.HttpSession;
import modelo.DatosBD;

/*
 * @author jviveros
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usuario    = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");
            DatosBD bd = new DatosBD();
            HttpSession session = request.getSession(true);
            switch (bd.accesoUsuario(usuario, contrasena)) {
                case "admin":
                    session.setAttribute("usuario", usuario);
                    session.setAttribute("rol", bd.accesoUsuario(usuario, contrasena));
                    response.sendRedirect("Admin.jsp");
                    break;
                case "user":
                    session.setAttribute("usuario", usuario);
                    session.setAttribute("rol", bd.accesoUsuario(usuario, contrasena));
                    response.sendRedirect("Usuario.jsp");
                    break;
                case "almacen":
                    session.setAttribute("usuario", usuario);
                    session.setAttribute("rol", bd.accesoUsuario(usuario, contrasena));
                    response.sendRedirect("Almacen.jsp");
                    break;
                default:
                    out.println("Usuario o Contraseña incorrectos");
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
