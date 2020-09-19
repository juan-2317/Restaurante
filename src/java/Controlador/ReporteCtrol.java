package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uml.PedidoCliente;
import modelo.dao.PedidoClienteDaoImpl;
import modelo.idao.IPedidoClienteDao;

public class ReporteCtrol extends HttpServlet {

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

        // Si la condición se cumple se registrará el pedido
        if (request.getParameter("registrar_ped") != null) {
            int idProducto = Integer.parseInt(request.getParameter("ccprod"));
            int idCliente = Integer.parseInt(request.getParameter("ccclie"));
            int cantidad = Integer.parseInt(request.getParameter("ccanti"));
            String fecha = new String(request.getParameter("cfecha").getBytes("ISO-8859-1"), "UTF-8");

            PedidoCliente pedCliente = new PedidoCliente(idProducto, idCliente, cantidad, fecha);
            IPedidoClienteDao pcd = new PedidoClienteDaoImpl();
            pcd.insertar(pedCliente);

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
