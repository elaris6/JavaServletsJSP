package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletGestionSesiones")
public class GestionSesiones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        /* El método "getSession()" sobre el objeto request devolverá la sesión http
        si esta existe, y si no, creará una nueva. */
 /* Si lacreación de cookies está permitida, el servidor de aplicaciones generará
        de forma automática un ID de sesión como una cookie, pero abstrae al servlet de esta
        gestión. Se permite interactuar con el objeto "HttpSession", pero en realidad
        lo que se ha creado es una cookie para el ID.
        Los atributos asociados a la sesión se guardan en el objeto "HttpSession" del
        lado del servidor en memoria, mientras la sesión esté activa.
        La duración de la sesión se puede definir como un atributo dinámico, o en el
        fichero de configuración "WEB-INF/web.xml", especificada en minutos en el tag
        "session-timeout". */
 /* Si las cookies no están permitidas, la gestión de sesión se hace mediante
        HttpREwriting, que es añadir siempre el ID de sesión como un atributo de la
        url en cada llamada, de forma que el servidor pueda hacer el control de
        sesión. */
        HttpSession sesion = request.getSession();

        String titulo = null;

        // Se recupera el atributo "contadorVisitas" de la sesión
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        // Si es nulo significa que no existe y es una nueva sesión
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido de nuevo";
        }

        // Se agrega o actualiza el valor en la sesión
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        // Se devuelve la respuesta al cliente
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();

        salida.print("<!DOCTYPE html>");
        salida.print("<html>");
        salida.print("<head>");
        salida.print("<title>Respuesta Servlet Cabeceras</title>");
        salida.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        salida.print("</head>");
        salida.print("<body>");
        salida.print("<h1>Respuesta Servlet Sesiones</h1>");
        salida.print("<p>" + titulo + "</p>");
        salida.print("<p>Número de visitas registradas: " + contadorVisitas + "</p>");
        salida.print("<p>ID de la sesión: " + sesion.getId() + "</p>");
        salida.print("<p>La sesión es nueva: " + sesion.isNew() + "</p>");
        salida.print("<p>Creación de la sesión: " + sesion.getCreationTime() + "</p>");
        salida.print("<p>Último acceso de la sesión: " + sesion.getLastAccessedTime() + "</p>");
        salida.print("</body>");
        salida.print("</html>");
        salida.close();

    }
}
