package modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * @author jviveros
 */
public class Consultas {
    Conexion c = new Conexion();
    Connection con;

    public int AltaBaja(String query, String[] datos) throws SQLException, IOException { //para altas, bajas y cambios
        con = c.getConnection(); //creamos la conexión
        PreparedStatement stmt; //creamos un statement
        int opt = 0;
        if (con == null) {
            System.out.println("No hay conexion");
        } else {
            stmt = con.prepareStatement(query); //preparamos el query
            for (int i = 0; i < datos.length; i++) {
                stmt.setString(i + 1, datos[i]); //agregamos los datos al query
            }
            if (stmt.executeUpdate() > 0) { //ejecutamos el query
                opt = 1;
            }
        }
        return opt;

    }

//    public ResultSet Consultar(String query) throws SQLException, IOException { //para consultas
//        con = c.getConnection(); //obtenemos la conexión
//        ResultSet rs = null;
//        if (con == null) {
//            System.out.println("No hay conexion");
//        } else {
//            Statement st = con.createStatement(); //creamos el statement
//            rs = st.executeQuery(query); //ejecutamos el query
//        }
//        return rs;
//    }
    
        public ResultSet Consultar(String query, String[] datos) throws SQLException, IOException { //para consultas
        con = c.getConnection(); //obtenemos la conexión
        ResultSet rs = null;
        if (con == null) {
            System.out.println("No hay conexion");
        } else {
            PreparedStatement stmt = con.prepareStatement(query); //preparamos el query
            for (int i = 0; i < datos.length; i++) {
                stmt.setString(i + 1, datos[i]); //agregamos los datos al query
            }
            rs = stmt.executeQuery(); //ejecutamos el query
        }
        return rs;
    }
}
