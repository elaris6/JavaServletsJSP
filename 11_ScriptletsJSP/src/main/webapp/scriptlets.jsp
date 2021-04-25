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
        <%-- Scriplet para enviar información al navegador. --%>
        <% out.print("Saludos desde el Scriplet"); %>
        <br>
        <%-- Scriplet para manipular los objetos implícitos. --%>
        <% 
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicación: "+nombreAplicacion);
        %>
        <br>
        <%-- Scriplet con código condicionado. No es una buena práctica.
        Al compilar al scriplet, el código html se convierte en out.print(...), 
        por ello se puede poner fuera del scriplet, ya que al final quedará dentro
        del código java finalmente generado. --%>
        <% 
            if (session != null && session.isNew()){
        %>
        <br>
        La sesión SI es nueva
        <% 
            } else if (session != null){
        %>
        <br>
        La sesión NO es nueva
        <% } %>
        
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
