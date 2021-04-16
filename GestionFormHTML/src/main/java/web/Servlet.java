package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FormServlet")
public class Servlet extends HttpServlet{
    
    /* En este caso se sobreescribe el método "doPost()", que será el usado por el formulario. */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        // Se especifica el tiepo de contenido para la respuesta
        response.setContentType("text/html;charset=UTF-8");
        /* Para generar la respuesta se debe instanciar un objeto de la clase "PrintWriter"
        mediante el método "getWriter" del objeto "response".
        "PrintWriter" puede generar una excepción, por lo que se debe controlar o incluir en
        la firma deñ método. */
        PrintWriter out = response.getWriter();
        
        /* Leer los parámetros del formulario HTML mediante el método "getParameter()" de
        la interfaz HttpServletRequest. Se debe indicar como parámetro el atributo "name"
        indicado en el campo del formulario HTML. */
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        // Si se espera un array de valores, se debe usar el método "getParameterValues()"
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String especialidad = request.getParameter("especialidad");
        String ides[] = request.getParameterValues("ide");
        String comentarios = request.getParameter("comentarios");
        
        
        /* Al hacer "println" se escribe en la consola del servidor, que es onde se ejecuta
        el Servlet, no en la del cliente. */
        System.out.println("#-------------------------#");
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRequestURI());
        System.out.println(request.getParameterMap());
        System.out.println("#-------------------------#");
        
                
        /* No se debe generar código HTML desde un servlet. Lo correcto para esto es usar las
        JSP's, pues la forma de hacerlo desde un Servlet no es fácil de mantener.*/
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Respuesta formulario</title>");
        out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Respuesta del Servlet al Formulario</h1>");
        
        // Se crea un tabla para presentar los parámetros de la petición POST
        out.print("<table border='1'>");
        out.print("<caption>Parámetros procesados</caption>");
        out.print("<tr>");
        out.print("<th>Campo</th>");
        out.print("<th>Valor</th>");
        out.print("</tr>");
        
        // Fila para usuario
        out.print("<tr>");
        out.print("<td>Usuario</td>");
        out.print("<td>"+usuario+"</td>");
        out.print("</tr>");
        
        // Fila para password
        out.print("<tr>");
        out.print("<td>Password</td>");
        out.print("<td>"+password+"</td>");
        out.print("</tr>");
        
        // Fila para tecnologías. Al ser un array. Creamos primero un string con los valores.
        String tecnologiasString = "";
        for (String tecno:tecnologias){
            if (tecnologiasString.equals("")){
                tecnologiasString = tecnologiasString + tecno;
            }
            else {
                tecnologiasString = tecnologiasString + ", " + tecno;
            }
        } 
        
        out.print("<tr>");
        out.print("<td>Tecnología</td>");
        out.print("<td>"+tecnologiasString+"</td>");
        out.print("</tr>");
        
        // Fila para el género
        out.print("<tr>");
        out.print("<td>Género</td>");
        out.print("<td>"+genero+"</td>");
        out.print("</tr>");
        
        // Fila para la especialidad
        out.print("<tr>");
        out.print("<td>Especialidad</td>");
        out.print("<td>"+especialidad+"</td>");
        out.print("</tr>");
        
        /* Fila para ides favoritos. Al no ser obligatorio, comprobamos si existe
        primero, y en ese caso, convertimos el array a string. */
        String idesString = "Sin selección";
        if (ides != null){
            for (String ide:ides){
                if (idesString.equals("Sin selección")){
                    idesString = ide;
                }
                else {
                    idesString = idesString + ", " + ide;
                }
            }
        }
        
        
        out.print("<tr>");
        out.print("<td>IDE/Editor</td>");
        out.print("<td>"+idesString+"</td>");
        out.print("</tr>");
        
        // Fila para comentarios. Al no ser obligatorio, comprobamos si existe
        if(comentarios == null){
            comentarios = "";
        }
        out.print("<tr>");
        out.print("<td>Comentarios</td>");
        out.print("<td>"+comentarios+"</td>");
        out.print("</tr>");
        
        // Se cierra la tabla
        out.print("</table>");

        out.print("</body>");
        out.print("</html>");
        
        /* Se cierra el objeto de tipo "PrintWriter". */
        out.close();
    }
    
}
