<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el formulario</h1>
        
        <!-- Tenemos acceso directamente al objeto request del tipo "HttpServletRequest" -->
        Ususario: <%= request.getParameter("usuario") %>
        <br>
        Password: <%= request.getParameter("password") %>
        
        <br>
        <br>
        <a href="index.html">Volver al inicio</a>
        
        
    </body>
</html>
