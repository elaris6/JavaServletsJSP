package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHora")
public class HoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // En este caso definimos la salida MIME estándar "text/html"
        response.setContentType("text/html;charset=UTF-8");

        /* Se genera una cabecera que indicará al navegador que la respuesta se
        refrescará automáticamente cada x segundos (en el ejemplo "1"). */
        response.setHeader("refresh", "1");

        // Obtenemos fecha y hora actual
        Date fecha = new Date();

        // Clase para formatear fechas/horas
        // https://docs.oracle.com/javase/10/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat formateador = new SimpleDateFormat("'Hora actual:' HH:mm:ss");
        // Pasamos la fecha actual como parámetro al objeto formateador para obtener la hora.
        String horaConFormato = formateador.format(fecha);

        PrintWriter salida = response.getWriter();
        salida.print(horaConFormato);
        salida.close();

    }
}
