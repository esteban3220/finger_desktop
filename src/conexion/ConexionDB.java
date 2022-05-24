/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    
    public String ejecuta(String sql,String a,String b,String c,String d,String e,String f,String g,File file) {
        String ID = null;
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
            
            PreparedStatement stmt = con.prepareStatement("select Id from usuario order by id desc limit 1");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
                ID = rs.getString("Id");
            
            ConexionDB().close();
            
        } catch (SQLException | FileNotFoundException z) {
            System.out.println("error:"+z);
            return null;
        }
        return ID;
    }
    
    public File getTemplate(String a) {
        PreparedStatement stmt = null; 
        InputStream input = null;
        FileOutputStream output = null;
        File file = null;
        try {
            stmt = ConexionDB().prepareStatement("select huella from usuario where Id ="+a);
            ResultSet rs = stmt.executeQuery();

            file = new File("C:\\Users\\Don-yoshi\\Documents\\file.ftp");
            output = new FileOutputStream(file);

            if (rs.next()) {
                input = rs.getBinaryStream("huella");
                System.out.println("Leyendo archivo desde la base de datos...");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                System.out.println("> Archivo guardado en : " + file.getAbsolutePath());
            }ConexionDB().close();
            
        } catch (SQLException | IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (IOException | SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return file;
    }
}
