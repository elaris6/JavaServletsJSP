package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class ServletCabeceras extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();

        salida.print("<!DOCTYPE html>");
        salida.print("<html>");
        salida.print("<head>");
        salida.print("<title>Respuesta Servlet Cabeceras</title>");
        salida.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        salida.print("</head>");
        salida.print("<body>");
        salida.print("<h1>Respuesta Servlet Cabeceras</h1>");

        // Se imprime el método http de la petición
        String metodoHttp = request.getMethod();
        salida.print("Método Http: " + metodoHttp);
        salida.print("</br>");

        // Se imprime la uri de la petición
        String uri = request.getRequestURI();
        salida.print("URI solicitada: " + uri);
        salida.print("</br>");

        // Imprimir todos las cabeceras recibidas en la petición
        Enumeration cabeceras = request.getHeaderNames();
        while (cabeceras.hasMoreElements()) {
            String nombreCabecera = (String) cabeceras.nextElement();
            salida.print("<b>" + nombreCabecera + "</b>:");
            salida.print(request.getHeader(nombreCabecera));
            salida.print("</br>");
        }

        salida.print("</body>");
        salida.print("</html>");

        salida.close();

    }

}
