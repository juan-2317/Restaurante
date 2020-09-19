package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.CuentaUsuarioDaoImpl;
import modelo.idao.ICuentaUsuarioDao;

public class SesionCtrol extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        if (request.getParameter("btn_iniciar") != null) {
            ICuentaUsuarioDao acc = new CuentaUsuarioDaoImpl();

            String nombre = new String(request.getParameter("usuariolg").getBytes("ISO-8859-1"), "UTF-8");
            String clave = new String(request.getParameter("passlg").getBytes("ISO-8859-1"), "UTF-8");
            int nivel = acc.validar(nombre, clave);

            if (nivel == 0) {
                request.getRequestDispatcher("mensaje_incorrecto.jsp").forward(request, response);
            } else {
                // Iniciamos sesión y le mandamos los siguientes atributos
                HttpSession iniciarSesion = request.getSession();
                iniciarSesion.setAttribute("nivel", nivel);
                iniciarSesion.setAttribute("nombre", nombre);

                request.getRequestDispatcher("iniciar_sesion.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
