package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        // Creamos o recuperamos el objeto HttpSession
        HttpSession sesion = request.getSession();

        // Recuperamos la lista de artículos previos si existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        // Verificamos si la lista de artículos existía previamente y si no, la creamos
        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        // Recogemos el nuevo artículo recogio de la petición
        String articulo = request.getParameter("articulo");

        // Verificamos si se ha recibido un nuevo artículo en la petición
        if (articulo != null && !articulo.trim().equals("")) {
            /* Si se ha recibido lo agregamso a la lista de artículos. Al estar 
            trabajando con un objetos con referencia en memoria, cuando se actualiza
            el objeto "articulos", también se actualiza sin tener que hacer nada
            el atributo "artñiculos" de la sesión, puesto que no es un objeto
            independiente, sino que apunta al objeto "artículos". */
            articulos.add(articulo);
        }

        /* Bloque "try with resources.
        Lo que hace este tipo de bloque es incluir el código que abre un recurso
        dentro de una sentencia try, y esto cierra automáticamente el recurso al
        terminar el bloque. */
        try (PrintWriter salida = response.getWriter()) {
            
            // Se genera la salida con la lista de artículos.
            salida.print("<!DOCTYPE html>");
            salida.print("<html>");
            salida.print("<head>");
            salida.print("<title>Respuesta Servlet Cabeceras</title>");
            salida.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            salida.print("</head>");
            salida.print("<body>");

            salida.print("<h1>Respuesta Servlet Carrito Compra</h1>");
            salida.print("<h3>Lista de artículos</h3>");
            //salida.print("<ul>");

            // Iteramos e imprimimos los artículos
            for (String art : articulos) {
                salida.print("<li>" + art + "</li>");
            }

            //salida.print("</ul>");
            salida.print("</br>");
            salida.print("<a href='/EjemploCarritoCompras'>Volver a incio<a>");
            salida.print("</body>");
            salida.print("</html>");
        }

    }

}
