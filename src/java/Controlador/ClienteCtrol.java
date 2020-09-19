package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uml.Cliente;
import modelo.dao.ClienteDaoImpl;
import modelo.idao.IClienteDao;

public class ClienteCtrol extends HttpServlet {

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

        // Si la condición se cumple se registrará el cliente
        if (request.getParameter("registrar_cli") != null) {
            IClienteDao cld = new ClienteDaoImpl();
            int idCliente = cld.getNumeroRegistros() + 1;
            String nombres = new String(request.getParameter("cclie").getBytes("ISO-8859-1"), "UTF-8");
            String apellidos = new String(request.getParameter("cape").getBytes("ISO-8859-1"), "UTF-8");
            int idFuncionario = Integer.parseInt(request.getParameter("ccfun"));
            Cliente cliente = new Cliente(idCliente, nombres, apellidos, idFuncionario);

            cld.insertar(cliente);

            request.getRequestDispatcher("exito.jsp").forward(request, response); // Redirigir a la página web
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
