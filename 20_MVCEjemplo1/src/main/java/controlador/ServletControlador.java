package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        // 1. Procesamos los parámetros (no hay en este ejemplo)
        
        // 2. Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3,6);
        
        // 3. Agregamos el JavaBean a algún ámbito/alcance (request, session, application)
        //      En este caso el alcance "page" no se puede usar ya que este solo es visible para las JSP
        request.setAttribute("mensaje", "Soy el contenido de una variable en request.");
        
        // Se agrega al ámbito de sesión
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectanguloBean",rec);
        
        
        // 4. Redireccionamos a la Vista
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request, response);
        
    }
}
