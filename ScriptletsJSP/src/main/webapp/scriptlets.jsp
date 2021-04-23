<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con scriplets</title>
    </head>
    <body>
        <h1>JSP con scriplets</h1>
        <br>
        <%-- Los comentarios de JSP no se visualizan en el navegador, se omiten al compilar a Servlet. --%>
        <%-- Scriplet para enviar informaci�n al navegador. --%>
        <% out.print("Saludos desde el Scriplet"); %>
        <br>
        <%-- Scriplet para manipular los objetos impl�citos. --%>
        <% 
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicaci�n: "+nombreAplicacion);
        %>
        <br>
        <%-- Scriplet con c�digo condicionado. No es una buena pr�ctica.
        Al compilar al scriplet, el c�digo html se convierte en out.print(...), 
        por ello se puede poner fuera del scriplet, ya que al final quedar� dentro
        del c�digo java finalmente generado. --%>
        <% 
            if (session != null && session.isNew()){
        %>
        <br>
        La sesi�n SI es nueva
        <% 
            } else if (session != null){
        %>
        <br>
        La sesi�n NO es nueva
        <% } %>
        
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
