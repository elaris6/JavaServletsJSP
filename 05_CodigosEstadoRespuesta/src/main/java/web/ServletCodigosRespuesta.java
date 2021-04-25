package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletRespuesta")
public class ServletCodigosRespuesta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();

        //Hardcodeando valores correctos de usuario y contraseña
        String usuarioOK = "user001";
        String passwordOK = "secreto$";

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        if (usuario.equals(usuarioOK) && password.equals(passwordOK)) {

            salida.print("<!DOCTYPE html>");
            salida.print("<html>");
            salida.print("<head>");
            salida.print("<title>Respuesta Servlet Cabeceras</title>");
            salida.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            salida.print("</head>");
            salida.print("<body>");
            salida.print("<h1>Respuesta Servlet Validación</h1>");

            salida.print("<p>Login OK - Usuario: <b>" + usuario + "</b></p>");

            salida.print("</body>");
            salida.print("</html>");
        } else {
            /* Constantes para los códigos de respuesta estándares HTTP.
            https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletResponse.html
             */
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario o contraseña incorrectos");
        }
        salida.close();
    }

}
