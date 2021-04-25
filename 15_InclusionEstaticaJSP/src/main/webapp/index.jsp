<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion Estatica</title>
    </head>
    <body>
        <h1>Ejemplo de inclusi�n Est�tica de JSPs</h1>
        <br/>
        <%-- El contenido de los archivos HTML o JSP incluidos se volcar� en el
        JSP principal, pero se crear� una �nica salida unificada, por lo que
        los cambios en los subcomponentes no se ver�n reflejados sin refrescar
        la compilaci�n del servlet final. --%>
        <ul>
            <li><%@include file ="paginas/noticias1.html" %></li>
            <li><%@include file ="paginas/noticias2.jsp" %></li>
        </ul>


    </body>
</html>
