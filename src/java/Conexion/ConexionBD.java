/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.*;

/**
 *
 * @author Leonardo
 */
public class ConexionBD {
    
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_rest?serverTimezone=UTC";
    static String user = "root";
    static String pass = "admin";
    protected Connection conn = null;
    
    public ConexionBD() {
        try {
            Class.forName(driver);
            
            conn = (Connection)DriverManager.getConnection(url, user, pass);
            
            if (conn != null) {
                System.out.println("Conexion Realizada..." + conn);
            }
        } catch(SQLException ex) {
            System.out.println("Conexion Fallida...." + ex.getMessage());
        } catch(ClassNotFoundException ex) {
            System.out.println("Falta Driver...." + ex.getMessage());
        }
    }
    
    public Connection Connected() {
        return conn;
    }
    
    public Connection Discconet() {
        try {
            conn.close();
        } catch(SQLException ex) {
            System.out.println("Error de Desconexion...." + ex.getMessage());
        }
        
        return null;
    }
}
