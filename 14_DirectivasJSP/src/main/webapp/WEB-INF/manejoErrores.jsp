<%-- Directiva para indicar que esta JSP será encargada de gestionar errores y
pueda tener al objeto implícito "Esception", ya uqe de otra forma no tendría
acceso.
Por defecto este valor es "false" en las JSP. --%>
<%@page import="java.io.PrintWriter"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Errores</title>
    </head>
    <body>
        <h1>Manejo de Errores en JSP</h1>
        <br/>
        <%-- Se imprime el mensaje principal del error. --%>
        Ocurrio una excepción en tiempo de ejecución: <%= exception.getMessage()%>
        <br/>
        <br/>
        <textarea cols="60" rows="10">
            <%
                // Se imprime la pila completa del error.
                exception.printStackTrace(new PrintWriter(out));
            %>
        </textarea>
        <br/>
        <a href="index.html">Volver a inicio</a>
    </body>
</html>
