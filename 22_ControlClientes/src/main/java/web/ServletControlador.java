package web;

import datos.*;
import dominio.ClienteDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Se recupera el parámetro de acción
        String accion = request.getParameter("accion");
        // Se valida el valor recuperado y se ejecuta la acción correspondiente al mismo
        if (accion != null) {
            switch (accion) {
                case "editar":
                    modificarCliente(request, response);
                    accionDefecto(request, response);
                    break;
                case "eliminar":
                    eliminarCliente(request, response);
                    accionDefecto(request, response);
                    break;
                default:
                    accionDefecto(request, response);
            }
        } else {
            accionDefecto(request, response);
        }
    }

    private void accionDefecto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Se obtiene el listado de clientes de la tabla cliente
        List<ClienteDTO> clientes = new ClienteDAOJDBC().listar();
        System.out.println("Clientes recuperados: " + clientes.size());
        HttpSession sesion = request.getSession();
        // Se incluye el listado de clientes en el alcance de request
        sesion.setAttribute("clientes", clientes);
        // Se incluye el número total de clientes en el alcance de la request
        sesion.setAttribute("totalClientes", clientes.size());
        // Se incluye la suma del saldo de clientes en el alcance de la request
        sesion.setAttribute("saldoTotal", saldoClientes(clientes));
        //Se redirecciona la salida al JSP que mostrará la información
        /* En este caso no se realiza con los métodos "getRequestDispatcher()" + "forward()"
        ya que al ser peticiones internas, al navegador no le llega que se ha seleccionado
        otro JSP a mostrar, y se qeuda con el último que tenía, provocando errores de flujo.*/
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    // Método para obtener el saldo total de los clientes
    private double saldoClientes(List<ClienteDTO> clientes) {

        double sumSaldo = 0;

        for (ClienteDTO cliente : clientes) {
            sumSaldo += cliente.getSaldo();
        }

        return sumSaldo;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Se recupera el parámetro de acción
        String accion = request.getParameter("accion");
        // Se valida el valor recuperado y se ejecuta la acción correspondiente al mismo
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCliente(request, response);
                    accionDefecto(request, response);
                    break;
                case "editar":
                    modificarCliente(request, response);
                    accionDefecto(request, response);
                    break;
                default:
                    accionDefecto(request, response);

            }

        } else {
            accionDefecto(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /* Recogemos los parámetros de la request */
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !saldoString.equals("")) {
            saldo = Double.parseDouble(saldoString);
        }

        /* Creamos el objeto Cliente e invocamos el método de inserción. */
        ClienteDTO clienteTmp = new ClienteDTO(nombre, apellido, email, telefono, saldo);
        ClienteDAO clienteDAO = new ClienteDAOJDBC();
        int registros = clienteDAO.insertar(clienteTmp);
        System.out.println("Registros insertados: " + registros);

    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /* Recogemos el id de cliente a modificar de la request,
        y comprobamos que no sea nulo o vacío. */
        int idCliente = 0;
        String idString = request.getParameter("idCliente");
        if (idString != null && !idString.equals("")) {
            idCliente = Integer.parseInt(idString);
            String nombre = request.getParameter("nombre");
            if (nombre != null && !nombre.equals("")) {
                ClienteDTO cliente = new ClienteDTO(idCliente, nombre, request.getParameter("apellido"), request.getParameter("email"), request.getParameter("telefono"), Double.parseDouble(request.getParameter("saldo")));
                int registros = new ClienteDAOJDBC().actualizar(cliente);

            } else {
                ClienteDTO cliente = new ClienteDAOJDBC().encontrar(idCliente);
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("/WEB-INF/paginas/cliente/editarCliente.jsp").forward(request, response);
            }
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /* Recogemos el id de cliente a eliminar de la request,
        y comprobamos que no sea nulo o vacío. */
        int idCliente = 0;
        String idString = request.getParameter("idCliente");
        if (idString != null && !idString.equals("")) {
            idCliente = Integer.parseInt(idString);
        }
        /* Creamos el objeto cliente y ejecutamos el método de eliminación. */
        ClienteDTO clienteTmp = new ClienteDTO(idCliente);
        int registros = new ClienteDAOJDBC().eliminar(clienteTmp);
        System.out.println("Registros eliminados: " + registros);

    }
}
