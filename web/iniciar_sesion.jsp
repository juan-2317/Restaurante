<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    Integer nivel = (Integer) session.getAttribute("nivel");

    // Esta condición se cumple en caso que el usuario inicie sesión
    if (nivel != null) {

        // Debido a que el método getAttribute puede devolver null se utiliza
        //  el método equals en lugar del operador de comparación ==
        if (nivel == 1) {
            response.sendRedirect("admin/index_administrador.jsp");
        } else if (nivel == 2) {
            response.sendRedirect("usuario/index_usuario.jsp");
        }
    }

    if (request.getParameter("cerrar") != null) {
        session.invalidate();
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login con JSP + MySQL</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <div class="main">
            <form action="SesionCtrol" id="formlg" method="post">
                <input type="text" name="usuariolg" pattern="[A-Za-z0-9_-]{1,15}" required placeholder="Usuario">
                <input type="password" name="passlg" pattern="[A-Za-z0-9_-]{1,15}" required placeholder="Contraseña">
                <input type="submit" name="btn_iniciar" class="botonlg" value="Iniciar Sesión">
            </form>
        </div>
    </body>
</html>
