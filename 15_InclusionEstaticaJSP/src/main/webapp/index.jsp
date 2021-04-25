<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion Estatica</title>
    </head>
    <body>
        <h1>Ejemplo de inclusión Estática de JSPs</h1>
        <br/>
        <%-- El contenido de los archivos HTML o JSP incluidos se volcará en el
        JSP principal, pero se creará una única salida unificada, por lo que
        los cambios en los subcomponentes no se verán reflejados sin refrescar
        la compilación del servlet final. --%>
        <ul>
            <li><%@include file ="paginas/noticias1.html" %></li>
            <li><%@include file ="paginas/noticias2.jsp" %></li>
        </ul>


    </body>
</html>
