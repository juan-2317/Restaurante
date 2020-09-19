<%@page import="java.util.List"%>
<%@page import="uml.Producto"%>
<%@page import="controlador.ControllerProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Productos</title>
        <link rel="stylesheet" href="css/estilos_consultar.css">
    </head>
    <body>
        <%
            ControllerProducto cpr = new ControllerProducto();
            List<Producto> lista = cpr.getLista();

            if (session.getAttribute("nivel") == null) {
                out.println("<h1>Por favor, inicie sesión para poder ver la lista</h1>");
            } else {
        %>
        <div class="tabla">
            <h1>RESULTADOS</h1>
            <table class="lista_bd">
                <thead>
                    <tr>
                        <th>Código Producto</th>
                        <th>Nombre Producto</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Producto p : lista) {%>
                    <tr>
                        <td><%= p.getIdProducto()%></td>
                        <td><%= p.getNomProducto()%></td>
                        <td><%= p.getValor()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%}%>
    </body>
</html>
