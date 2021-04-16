package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Un Servlet no es más que una clase de Java, que hereda de la clase HttpServlet.
Para que el navegador lo reconozca, se debe añadir la notación
@WebServlet("/pathServlet"). El path de acceso al servlet no tiene porque ser igual
que el de la clase.
Antíguamente los servlets se definían en el archivo de configuración "web.xml".
 */
@WebServlet("/HolaMundito")
public class HolaMundo extends HttpServlet {

    /* Se deben especidifar y sobreescribir los métodos que se vayan a necesitar
    en función de lo que haga el servlet. Las peticiones normales de navegador
    funcionan con el método GET, y las de formularios con POST.
    Es el servidor de aplicaciones el que hace llegar la petición a la aplicación. */
 /* Ejemplo de sobreescritura del método "doGet". */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /* Se define el tipo de respuesta que se va a devolver.
        https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletResponse.html
        https://javaee.github.io/javaee-spec/javadocs/javax/servlet/ServletResponse.html#setContentType-java.lang.String-
        https://developer.mozilla.org/es/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
         */
        response.setContentType("text/html;UTF-8");
        /* Para devolver la respuesta necesitamos crear un objeto de tipo "PrintWriter",
        sobre el que volcar la salira. El método "getWriter()" arroja la excepción "IOException". */
        PrintWriter out = response.getWriter();
        /* Aquí se podría ya devolver código HTML, pero para eso lo correcto es el uso de JSP's. */
        out.println("Hola Mundo desde un Servlet");
    }
}
