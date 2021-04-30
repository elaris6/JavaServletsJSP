package datos;

import dominio.ClienteDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/TestDatos")
public class TestDatos extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        /* Recogemos los parámetros de la request */
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        /* Creamos el objeto Cliente e invocamos el método de inserción. */
        ClienteDTO clienteTmp = new ClienteDTO(nombre,apellido,email,telefono,saldo);
        ClienteDAO clienteDAO = new ClienteDAOJDBC();
        int registros = clienteDAO.insertar(clienteTmp);
        
        request.setAttribute("registros", registros);
        request.setAttribute("cliente", clienteTmp);
        request.getRequestDispatcher("resultados.jsp").forward(request,response);
    }
}
