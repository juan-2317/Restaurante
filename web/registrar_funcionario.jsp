<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Funcionarios</title>
        <link rel="stylesheet" href="css/estilos_registrar.css">
    </head>
    <body>
        <%
            Integer nivel = (Integer) session.getAttribute("nivel");
            // Comprobar que la página haya pasado por un formulario de login
            if (nivel == null) {
        %>
        <h1>Por favor, inicie sesión para poder modificar la base de datos</h1>
        <%} else if (nivel == 2) {
            response.sendRedirect("usuario/index_usuario.jsp");
        } else {%>
        <div class="insertar">
            <form action="FuncionarioCtrol" method="post">
                <div id="titulo">FUNCIONARIO</div>
                <fieldset>
                    <legend>Datos del funcionario</legend>
                    <div class="campos">
                        <label for="cnom">Nombres:</label>
                        <input type="text" id="cnom" name="cnom" required>
                    </div>
                    <div class="campos">
                        <label for="cape">Apellidos:</label>
                        <input type="text" id="cape" name="cape" required>
                    </div>
                    <div class="campos">
                        <label for="crol">Escoja tipo de rol:</label>
                        <select id="crol" name="crol">
                            <option value="1">Administrador</option>
                            <option value="2">Usuario</option>                           
                        </select>                       
                    </div>
                    <div class="campos">
                        <label for="cnom_user">Nombre Usuario:</label>
                        <input type="text" id="cnom_user" name="cnom_user" pattern="[A-Za-z0-9_-]{1,15}" required>
                    </div>
                    <div class="campos">
                        <label for="cclave">Contraseña:</label>
                        <input type="password" id="cclave" name="cclave" pattern="[A-Za-z0-9_-]{1,15}" required>
                    </div>
                </fieldset>
                <div id="subir">
                    <input type="submit" id="registrar_fun" name="registrar_fun" value="Registrar" class="subir">
                </div>
            </form>
        </div>
        <%}%>
    </body>
</html>
