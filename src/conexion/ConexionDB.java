/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SanthyHA
 */
public class ConexionDB {
    

    static String URL ="jdbc:mysql://localhost:3306/banco";
    static String USUARIO = "root";
    static String CONTRASEÑA = "junomava3842";
    Connection con;
    
    public Connection ConexionDB(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexion establecida...");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("No se pudeo establecer la conexion: "+e);
        }    
        return con;
    }
    
    
    public ResultSet ejecuta(String sql,String a,String b,String c,String d,String e,String f,String g,File file) {
        ResultSet resultado = null;
        try {
            PreparedStatement s =  ConexionDB().prepareStatement(sql);
            //s.executeUpdate(sql
            FileInputStream input = new FileInputStream(file);
            s.setString(1, a);
            s.setString(2, b);
            s.setString(3, c);
            s.setString(4, d);
            s.setString(5, e);
            s.setString(6, f);
            s.setString(7, g);
            s.setBinaryStream(8, input);
            s.executeUpdate();
        } catch (SQLException | FileNotFoundException z) {
            System.out.println("error:"+z);
            return null;
        }
        return resultado;
    }
}
