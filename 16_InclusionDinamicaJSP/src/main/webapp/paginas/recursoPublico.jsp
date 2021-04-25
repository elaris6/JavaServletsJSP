<%-- En la inclusión dinámica, al no crearse un único recuros de salida, es posible
incluir los TAGS principales de HTML o no, según convenga. Normalmente no se deben
incluir, ya que formarán parte de la JSP principal. --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h3>Recurso Público</h3>
        <br/>
        Inclusión de contenido dinámico desde un JSP público
        <br/>
        Nombre de la aplicación: <%= request.getContextPath()%>
    </body>
</html>
