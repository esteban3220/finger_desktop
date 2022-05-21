/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SanthyHA
 */
public class ConexionDB {
    

    static String URL ="jdbc:mysql://localhost:3306/banco";
    static String USUARIO = "root";
    static String CONTRASEÑA = "";
    Connection con;
    
    public ConexionDB(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexion establecida...");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("No se pudeo establecer la conexion: "+e);
        }    
    }
    public Connection getConnection(){
        return con;
    }
}
