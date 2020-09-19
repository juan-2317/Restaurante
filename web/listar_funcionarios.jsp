<%@page import="controlador.ControllerFuncionario"%>
<%@page import="java.util.List"%>
<%@page import="uml.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Funcionarios</title>
        <link rel="stylesheet" href="css/estilos_consultar.css">
    </head>
    <body>
        <%
            ControllerFuncionario cf = new ControllerFuncionario();
            List<Funcionario> lista = cf.getLista();

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
                        <th>Código Funcionario</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Código Cuenta</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Funcionario f : lista) {%>
                    <tr>
                        <td><%= f.getIdFuncionario()%></td>
                        <td><%= f.getNombres()%></td>
                        <td><%= f.getApellidos()%></td>
                        <td><%= f.getIdCuenta()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%}%>
    </body>
</html>
