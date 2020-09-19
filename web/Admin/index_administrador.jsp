<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    Integer nivel = (Integer) session.getAttribute("nivel");

    // Comprobar que la página haya pasado por un formulario de login
    if (nivel == null) {
        // En caso que no se haya iniciado sesión o se haya iniciado sesión con privilegios
        //  insuficientes, se redirigirá a la página de iniciar_sesion.jsp
        response.sendRedirect("../iniciar_sesion.jsp");
    } else if (nivel == 2) {
        response.sendRedirect("../usuario/index_usuario.jsp");
    }

%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Página</title>
        <link rel="stylesheet" href="../css/administrar.css">
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
                <li><a href="../registrar_funcionario.jsp" target="miframe">Registro de Funcionarios</a></li>
                <li><a href="../listar_funcionarios.jsp" target="miframe">Listar Funcionarios</a></li>
                <li><a href="../registrar_cliente.jsp" target="miframe">Registro de Clientes</a></li>
                <li><a href="../listar_clientes.jsp" target="miframe">Listar Clientes</a></li>
                <li><a href="../registrar_pedido.jsp" target="miframe">Gestión de Pedidos</a></li>
                <li><a href="../listar_pedidos.jsp" target="miframe">Reporte de Pedidos</a></li>
            </ul>
        </nav>
        <iframe class="navegacion" name="miframe"></iframe>
    </body>
</html>
