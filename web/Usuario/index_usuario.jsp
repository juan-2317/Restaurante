<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    Integer nivel = (Integer) session.getAttribute("nivel");

    // Comprobar que la página haya pasado por un formulario de login
    if (nivel == null) {
        // En caso que no se haya iniciado sesión o se haya iniciado sesión con privilegios
        //  insuficientes, se redirigirá a la página de iniciarSesion.jsp
        response.sendRedirect("../iniciar_sesion.jsp");
    } else if (nivel == 1) {
        response.sendRedirect("../admin/index_administrador.jsp");
    }

%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Página</title>
        <link rel="stylesheet" href="../css/usuario.css">
    </head>
    <body>
        <div class="cabecera">
            Bienvenido <%= session.getAttribute("nombre")%> | 
            <a href="../iniciar_sesion.jsp?cerrar=true">Cerrar Sesión</a>
            <hr>
        </div>
        <nav class="menus">
            <ul>
                <li><a href="../registrar_producto.jsp" target="miframe">Registrar Productos</a></li>
                <li><a href="../listar_productos.jsp" target="miframe">Listar Productos</a></li>
                <li><a href="../registrar_cliente.jsp" target="miframe">Registro de Clientes</a></li>
            </ul>
        </nav>
        <iframe class="navegacion" name="miframe"></iframe>
    </body>
</html>
