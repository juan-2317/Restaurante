<%@page import="java.util.List"%>
<%@page import="controlador.ControllerPedidoCliente"%>
<%@page import="uml.PedidoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Pedidos</title>
        <link rel="stylesheet" href="css/estilos_consultar.css">
    </head>
    <body>
        <%
            ControllerPedidoCliente cpc = new ControllerPedidoCliente();
            List<PedidoCliente> lista = cpc.getLista();

            Integer nivel = (Integer) session.getAttribute("nivel");
            if (nivel == null) {
                out.println("<h1>Por favor, inicie sesión para poder ver la lista</h1>");
            } else if (nivel == 2) {
                response.sendRedirect("usuario/index_usuario.jsp");
            } else {
        %>
        <div class="tabla">
            <h1>RESULTADOS</h1>
            <table class="lista_bd">
                <thead>
                    <tr>
                        <th>Código Producto</th>
                        <th>Código Cliente</th>
                        <th>Cantidad</th>
                        <th>Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (PedidoCliente p : lista) {%>
                    <tr>
                        <td><%= p.getIdProducto()%></td>
                        <td><%= p.getIdCliente()%></td>
                        <td><%= p.getCantidad()%></td>
                        <td><%= p.getFecha()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%}%>
    </body>
</html>
