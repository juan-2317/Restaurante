<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Productos</title>
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
            <form action="ProductoCtrol" method="post">
                <div id="titulo">PRODUCTO</div>
                <fieldset>
                    <legend>Datos del producto</legend>
                    <div class="campos">
                        <label for="cnom">Nombre:</label>
                        <input type="text" id="cnom" name="cnom" required>
                    </div>
                    <div class="campos">
                        <label for="cvalor">Valor:</label>
                        <input type="text" id="cvalor" name="cvalor" required pattern="[0-9]{1,10}">
                    </div>
                </fieldset>
                <div id="subir">
                    <input type="submit" id="registrar_prod" name="registrar_prod" value="Registrar" class="subir">
                </div>
            </form>
        </div>
        <%}%>
    </body>
</html>
