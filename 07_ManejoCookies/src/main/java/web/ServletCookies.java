package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletCookies")
public class ServletCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Suponemos que el usuario visita por primera vez el sitio
        boolean nuevoUsuario = true;
        int numVisitas = 1;

        // Se obtiene el array de cookies del objeto request
        Cookie[] cookies = request.getCookies();

        // Se busca si ya existe una cookie creada con anterioridad
        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")) {
                    /* Si ya existe la cookie y tiene el valor adecuado, significa
                    que es un usuario recurrente. */
                    nuevoUsuario = false;
                }

                if (c.getName().equals("numVisitas")) {
                    /* Si existe la cookie del número de visitas, se intenta leer el valor
                    y en caso de que se pueda leer, se incrementa dicho valor. */
                    try {
                        numVisitas = Integer.parseInt(c.getValue()) + 1;
                        System.out.println("Número de visitas: " + numVisitas);
                    } catch (NumberFormatException e) {
                        numVisitas = 1;
                        System.out.println("Cookie numVisitas valor erróneo.");

                    }
                }
            }

        }

        String mensaje = null;
        if (nuevoUsuario) {

            /* Si no existe la cookie "visitanteRecurrente", creamos las cookies
            de primera visita. */
            Cookie cookieVisitiante = new Cookie("visitanteRecurrente", "si");
            Cookie cookieNumVisitas = new Cookie("numVisitas", "1");
            numVisitas = 1;
            response.addCookie(cookieVisitiante);
            /* Se puede definir tiempo de vigencia de una coolie mediante el método
                "setMaxAge(int segundos)". */
            cookieNumVisitas.setMaxAge(3600 * 24 * 365); //La ponemos para un año solo al crearla
            response.addCookie(cookieNumVisitas);
            mensaje = "Gracias por visitar este sitio por primera vez";
        } else {
            mensaje = "Gracias por visitar el sitio de nuevo.";
            if (numVisitas == 1) {
                Cookie cookieNumVisitas = new Cookie("numVisitas", "1");
                cookieNumVisitas.setMaxAge(3600 * 24 * 365);
                response.addCookie(cookieNumVisitas);
            } else {
                Cookie cookieNumVisitas = new Cookie("numVisitas", String.valueOf(numVisitas));
                response.addCookie(cookieNumVisitas);

            }

        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();

        salida.print("<!DOCTYPE html>");
        salida.print("<html>");
        salida.print("<head>");
        salida.print("<title>Respuesta Servlet Cabeceras</title>");
        salida.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        salida.print("</head>");
        salida.print("<body>");
        salida.print("<h1>Respuesta Servlet Cookies</h1>");
        salida.print("<p>" + mensaje + "</p>");
        salida.print("<p>Número de visitas registradas: " + numVisitas + "</p>");
        salida.print("</body>");
        salida.print("</html>");
        salida.close();
    }
}
