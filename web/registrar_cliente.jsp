<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Clientes</title>
        <link rel="stylesheet" href="css/estilos_registrar.css">
    </head>
    <body>
        <%
            // Comprobar que la página haya pasado por un formulario de login
            if (session.getAttribute("nivel") == null) {
        %>
        <h1>Por favor, inicie sesión para poder modificar la base de datos</h1>
        <%} else {%>
        <div class="insertar">
            <form action="ClienteCtrol" method="post">
                <div id="titulo">CLIENTE</div>
                <fieldset>
                    <legend>Datos del cliente</legend>
                    <div class="campos">
                        <label for="cclie">Nombre:</label>
                        <input type="text" id="cclie" name="cclie" required>
                    </div>
                    <div class="campos">
                        <label for="cape">Apellidos:</label>
                        <input type="text" id="cape" name="cape" required>
                    </div>
                    <div class="campos">
                        <label for="ccfun">Código Funcionario:</label>
                        <input type="text" id="ccfun" name="ccfun" required pattern="[0-9]{1,10}">
                    </div>
                </fieldset>
                <div id="subir">
                    <input type="submit" id="registrar_cli" name="registrar_cli" value="Registrar" class="subir">
                </div>
            </form>
        </div>
        <%}%>
    </body>
</html>
