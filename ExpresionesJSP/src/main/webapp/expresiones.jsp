<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        Concatenación <%= "Saludos" + " " + "desde JSP" %>
        <br>
        Operación matemática <%= 2 * 3 + 5 / 6 %>
        <br>
        Session id <%= session.getId() %>
        <br>
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
