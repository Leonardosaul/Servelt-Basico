/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler;

import Conexion.ConexionBD;
import Entidades.Cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "Controler", urlPatterns = {"/Controler"})
public class Controler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Op = request.getParameter("Op");
        ArrayList<Cliente> Lista = new ArrayList();
        
        ConexionBD conBD = new ConexionBD();
        Connection conn = conBD.Connected();
        
        PreparedStatement ps;
        ResultSet rs;
        
        switch (Op) {
            case "Listar":
                try {
                    
                    String sql = "SELECT * FROM Cliente";
                    ps = conn.prepareStatement(sql);
                    rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        Cliente cliente = new Cliente();
                        
                        cliente.setId(rs.getString("Id_Cliente"));
                        cliente.setApellidos(rs.getString("Apellidos"));
                        cliente.setNombres(rs.getString("Nombres"));
                        cliente.setDNI(rs.getString("DNI"));
                        cliente.setDireccion(rs.getString("Direccion"));
                        cliente.setTelefono(rs.getString("Telefono"));
                        cliente.setMovil(rs.getString("Movil"));
                        
                        Lista.add(cliente);
                    }
                    
                    request.setAttribute("Lista", Lista);
                    request.getRequestDispatcher("listar.jsp").forward(request, response);
                    
                } catch(SQLException ex) {
                    System.out.println("Error de SQL...." + ex.getMessage());
                } finally {
                    conBD.Discconet();
                }
                break;
            case "Consultar":
                
                break;
            case "Nuevo":
                
                break;
            case "Modificar":
                
                break;
            case "Eliminar":
                
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
