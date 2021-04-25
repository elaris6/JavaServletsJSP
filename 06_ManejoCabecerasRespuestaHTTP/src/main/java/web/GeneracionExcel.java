package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletGeneracionExcel")
public class GeneracionExcel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /* Se puede devolver otro tipo de contenido que no sea "text/html", indicando
        el mismo en el método "setContentType".
        En este ejemplo será un excel y el tipo MIME es: "application/vnd.ms-excel".
        En este caso "vnd" significa "Vendor Specific", al ser un formato propietario.
        Tipos MIME:
        https://developer.mozilla.org/es/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
         */
        response.setContentType("application/vnd.ms-excel");

        /* Para indicar al navegador que lo que ocurrirá al dar al enlace es que se devolverá
        un contenido, se genera una cabecera de respuesta HTTP de tipo "Content-Disposition",
        y además se indica en el segundo parámetro que el contenido será un fichero a
        descargar "attachment;filename=Ejemplo.xls". */
        response.setHeader("Content-Disposition", "attachment;filename=Ejemplo.xls");

        /* Para indicar al navegador que no cachee contenido del enlace y se genere siempre
        de nuevo se deben establecer las siguientes cabeceras de respuesta HTTP. */
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        // Con la siguiente cabecera se indica que el contenido expire de inmediato.
        response.setDateHeader("Expires", -1);

        // Generamos dos números aleatorios
        int ope1 = (int) (Math.random() * 100);
        int ope2 = (int) (Math.random() * 100);

        // Se devuelve la información al cliente desde el servidor
        /* Para un uso más ampliado de MS Excel con Java se recomiendo la librería:
        poi.apache.org */
        PrintWriter salida = response.getWriter();
        // En este caso si es importante imprimir con "println" para que salte de línea.
        salida.println("\tValores");
        salida.println("\t" + ope1);
        salida.println("\t" + ope2);
        salida.println("Suma\t=SUMA(b2:b3);");
        salida.close();

    }
}
