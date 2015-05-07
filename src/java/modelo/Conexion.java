/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jviveros
 */
public class Conexion {
  public Connection getConnection() throws FileNotFoundException, IOException {
    String USERNAME = "sa",
           PASSWORD = "Admin.1234",
           CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
           URL = "jdbc:sqlserver://localhost:1433;databaseName=Papeleria"; 
   
    Connection con;
    try {
      Class.forName(CLASSNAME);//Obtenmos el driver de SQL Server
      con = DriverManager.getConnection(URL, USERNAME, PASSWORD);//Conectamos a nuestra base de datos
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println(e.toString());
      con = null;
    }
    return con;
  }
  
//  public static void main(String args []) throws IOException{
//      Conexion c = new Conexion();
//      if(c.getConnection() != null){
//          System.out.println("Acceso positivo");
//      }else{
//          System.out.println("Acceso negativo");
//      }
//  }
}

