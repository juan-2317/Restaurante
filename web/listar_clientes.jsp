<%@page import="java.util.List"%>
<%@page import="controlador.ControllerCliente"%>
<%@page import="uml.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Clientes</title>
        <link rel="stylesheet" href="css/estilos_consultar.css">
    </head>
    <body>
        <%
            ControllerCliente cc = new ControllerCliente();
            List<Cliente> lista = cc.getLista();

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
                        <th>Código Cliente</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Código Funcionario</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Cliente c : lista) {%>
                    <tr>
                        <td><%= c.getIdCliente()%></td>
                        <td><%= c.getNombres()%></td>
                        <td><%= c.getApellidos()%></td>
                        <td><%= c.getIdFuncionario()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%}%>
    </body>
</html>
