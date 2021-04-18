package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletDescargaFicheroServidor")
public class DescargaFicheroServidor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /* Ejemplo basado en código de:
        https://www.codejava.net/java-ee/servlet/java-servlet-download-file-example
         */
        // Recogemos el nombre del fichero solicitado para la descarga
        String ficheroSolicitado = request.getParameter("file");
        System.out.println(ficheroSolicitado);

        // Se crea ruta absoluta y se comprueba si el fichero existe
        String pathArchivo = "C:\\CODE\\Java\\UniversidadJava\\JavaEE\\ManejoCabecerasRespuestaHTTP\\ficheros\\" + ficheroSolicitado;
        File ficheroDescarga = new File(pathArchivo);
        boolean existe = ficheroDescarga.exists();

        // Para obtener el path del contexto del proyecto
        System.out.println("RealPath = " + getServletContext().getRealPath(""));
        System.out.println("ContextPath: " + getServletContext().getContextPath());

        if (!existe) {
            // Si el fichero no existe, se devuelve error 404.
            /* Constantes para los códigos de respuesta estándares HTTP.
            https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletResponse.html
             */
            String mensajeError = "Fichero " + ficheroSolicitado + " no encontrado";
            response.sendError(HttpServletResponse.SC_NOT_FOUND, mensajeError);

        } else {

            System.out.println("Fichero encontrado: " + pathArchivo);

            // Se obtiene el ServletContext
            ServletContext context = getServletContext();
            /* Se obtiene el tipo MIME del fichero. Para esto se pasa el String
            de la ruta, no el objeto "File".
            https://developer.mozilla.org/es/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
             */
            String mimeType = context.getMimeType(pathArchivo);
            if (mimeType == null) {
                // Se asigna a tipo binario, si el tipo MIME no se encuentra
                mimeType = "application/octet-stream";
            }
            System.out.println("Tipo MIME: " + mimeType);

            /* Se asigna a la respuesta el tipo MIME del fichero, y el tamaño
            del fichero (en bytes). */
            response.setContentType(mimeType);
            response.setContentLength((int) ficheroDescarga.length());

            /* Para indicar al navegador que no cachee contenido del enlace y se genere siempre
            de nuevo se deben establecer las siguientes cabeceras de respuesta HTTP. */
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            // Con la siguiente cabecera se indica que el contenido expire de inmediato.
            response.setDateHeader("Expires", -1);

            /* Para indicar al navegador que lo que ocurrirá al dar al enlace es que se devolverá
            un contenido, se genera una cabecera de respuesta HTTP de tipo "Content-Disposition",
            y además se indica en el segundo parámetro que el contenido será un fichero a
            descargar "attachment;filename=nom_fich.extension". */
 /* Las cabeceras se forman con clave:valor */
            String claveCabecera = "Content-Disposition";
            String valorCabecera = String.format("attachment;filename=\"%s\"", ficheroDescarga.getName());
            response.setHeader(claveCabecera, valorCabecera);

            /* Se obtiene un objeto de tipo "FileInputStream" para leer el fichero,
            y un objeto de tipo "OutputStream" del objeto "response" para escribir en la salida. */
            FileInputStream inStream = new FileInputStream(ficheroDescarga);
            OutputStream outStream = response.getOutputStream();

            /* Se define un array de tipo "byte" para el buffer de lectura. */
            byte[] buffer = new byte[4096];
            // Contador de bytes leídos.
            int bytesRead = 0;

            /* Se lee el fichero con el buffer. al llegar al fin del fichero, el
            método "read()" devolverá valor -1 para el número de bytes leídos. */
            while ((bytesRead = inStream.read(buffer)) != -1) {
                // Se escribe el buffer leído en el flujo de salida.
                outStream.write(buffer, 0, bytesRead);
            }

            /* Se cierran los flujos de input y output. En el momento de cerrar
            el output de salida, será cuando se lance la descarga al cliente. */
            inStream.close();
            outStream.close();
        }
    }
}
