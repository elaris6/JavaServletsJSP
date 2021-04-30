package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        // 1. Procesamos los parámetros (no hay en este ejemplo)
        String accion = "";
        if(request.getParameter("accion")!=null){
            accion = request.getParameter("accion");
        }
        
        // 2. Creamos los JavaBeans. Para el ejemplo creamos tres beans, para añadir uno a cada alcance
        Rectangulo recRequest = new Rectangulo(1,2);
        Rectangulo recSesion = new Rectangulo(3,4);
        Rectangulo recApp = new Rectangulo(5,6);
        
        // 3. Agregamos cada JavaBean a su ámbito/alcance (request, session, application) con objetivo demostrativo
        //      En este caso el alcance "page" no se puede usar ya que este solo es visible para las JSP
        
        // Revisamos que acción se ha recibido
        if(accion.equals("agregarVariables")){
            // Alcance Request
            request.setAttribute("rectanguloRequest", recRequest);
            // Alcance Sesión
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion", recSesion);
            // Alcance Aplicación
            ServletContext aplic = this.getServletContext();
            aplic.setAttribute("rectanguloAplicacion", recApp);
            // Agregamos un mensaje sobre la acción
            request.setAttribute("mensaje", "Las variables fueron agregadas.");
            // 4. Redireccionamos a la página de inicio, con el mensaje de acción
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if (accion.equals("listarVariables")){
            // Agregamos un mensaje sobre la acción
            request.setAttribute("mensaje", "Listar las variables.");
            // 4. Redireccionamos a la Vista
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        }
        else {
            // Agregamos un mensaje sobre la acción
            request.setAttribute("mensaje", "Acción no proporcionada o desconocida.");
            // 4. Redireccionamos a la página de inicio, ya que no se proporcionó acción
            request.getRequestDispatcher("index.jsp").forward(request, response);
            /* También se puede hacer una redirección mediante el método "sendRedirect"
            del objeto "response", pero si se hace de esta forma, no se podrá compartir
            ningún atributo de los objetos "request" y "response", ya que no se están
            propagando.
            response.sendRedirect("index.jsp);     */
        }

        
    }
}
