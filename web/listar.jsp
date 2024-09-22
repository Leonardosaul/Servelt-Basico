<%-- 
    Document   : listar
    Created on : 21 set. 2024, 20:14:40
    Author     : Leonardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Clientes</title>
    </head>
    <body>
        <h1>Listado de Clientes</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>DNI</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${Lista}">
                    <tr>
                        <td>${cliente.getId()}</td>
                        <td>${cliente.getApellidos()}</td>
                        <td>${cliente.getNombres()}</td>
                        <td>${cliente.getDNI()}</td>
                        <td>
                            <a href="Controler?Op=Consultar&Id=${cliente.getId()}">
                                Consultar
                            </a>
                        </td>
                        <td>
                            <a href="Controler?Op=Modificar&Id=${cliente.getId()}">
                                Modificar
                            </a>
                        </td>
                        <td>
                            <a href="Controler?Op=Eliminar&Id=${cliente.getId()}">
                                Eliminar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
