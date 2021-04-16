package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletForm")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        /* Leer los parámetros del formulario HTML mediante el método "getParameter" de
        la interfaz HttpServletRequest. Se debe indicar como parámetro el atributo "name"
        indicado en el campo del formulario HTML. */
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        /* Al hacer "println" se escribe en la consola del servidor, que es onde se ejecuta
        el Servlet, no en la del cliente. */
        System.out.println("usuario: " + usuario);
        System.out.println("password: " + password);
        
        /* Para generar la respuesta se debe instanciar un objeto de la clase "PrintWriter"
        mediante el método "getWriter" del objeto "response".
        "PrintWriter" puede generar una excepción, por lo que se debe controlar o incluir en
        la firma deñ método. */
        PrintWriter out = response.getWriter();
        
        /* No se debe generar código HTML desde un servlet. Lo correcto para esto es usar las
        JSP's, pues la forma de hacerlo desde un Servlet no es fácil de mantener.*/
        out.print("<html>");
        out.print("<body>");
        out.print("<h1>Respuesta del Servlet</h1>");
        out.print("<p>El parámetro usuario es: " + usuario + " </p>");
        out.print("<p>El parámetro password es: " + password + "</p>");
        out.print("</br>");
        out.print("</body>");
        out.print("</html>");
        /* Se cierra el objeto de tipo "PrintWriter". */
        out.close();
    }
}
