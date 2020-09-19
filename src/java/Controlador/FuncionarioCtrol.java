package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uml.CuentaUsuario;
import modelo.dao.CuentaUsuarioDaoImpl;
import uml.Funcionario;
import modelo.dao.FuncionarioDaoImpl;
import modelo.idao.ICuentaUsuarioDao;
import modelo.idao.IFuncionarioDao;

public class FuncionarioCtrol extends HttpServlet {

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

        // Si la condición se cumple se registrará el funcionario
        if (request.getParameter("registrar_fun") != null) {
            // Insertar nueva cuenta de usuario
            ICuentaUsuarioDao cudao = new CuentaUsuarioDaoImpl();
            int idCuenta, nivel;
            String nombreUsuario, contra;

            idCuenta = cudao.getNumeroRegistros() + 1;
            nombreUsuario = new String(request.getParameter("cnom_user").getBytes("ISO-8859-1"), "UTF-8");
            contra = new String(request.getParameter("cclave").getBytes("ISO-8859-1"), "UTF-8");
            nivel = Integer.parseInt(request.getParameter("crol"));

            CuentaUsuario cuenta = new CuentaUsuario(idCuenta, nombreUsuario, contra, nivel);
            cudao.insertar(cuenta);

            // Insertar nuevo funcionario
            IFuncionarioDao fdao = new FuncionarioDaoImpl();
            String nombres = new String(request.getParameter("cnom").getBytes("ISO-8859-1"), "UTF-8");
            String apellidos = new String(request.getParameter("cape").getBytes("ISO-8859-1"), "UTF-8");
            int idFuncionario = fdao.getNumeroRegistros() + 1;

            Funcionario funcionario = new Funcionario(idFuncionario, nombres, apellidos, idCuenta);
            fdao.insertar(funcionario);

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
