<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registar Pedidos</title>
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
            <form action="ReporteCtrol" method="post">
                <div id="titulo">PEDIDO</div>
                <fieldset>
                    <legend>Datos del producto</legend>
                    <div class="campos">
                        <label for="ccprod">Código Producto:</label>
                        <input type="text" id="ccprod" name="ccprod" required pattern="[0-9]{1,10}">
                    </div>
                    <div class="campos">
                        <label for="ccclie">Código Cliente:</label>
                        <input type="text" id="ccclie" name="ccclie" required pattern="[0-9]{1,10}">
                    </div>
                    <div class="campos">
                        <label for="ccanti">Cantidad:</label>
                        <input type="text" id="ccanti" name="ccanti" required pattern="[0-9]{1,10}">
                    </div>
                    <div class="campos">
                        <label for="cfecha">Fecha:</label>
                        <input type="text" id="cfecha" name="cfecha" required placeholder="AAAA/MM/DD">
                    </div>
                </fieldset>
                <div id="subir">
                    <input type="submit" id="registrar_ped" name="registrar_ped" value="Registrar" class="subir">
                </div>
            </form>
        </div>
        <%}%>
    </body>
</html>
