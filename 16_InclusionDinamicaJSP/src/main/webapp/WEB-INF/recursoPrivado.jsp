<%-- En la inclusión dinámica, al no crearse un único recuros de salida, es posible
incluir los TAGS principales de HTML o no, según convenga. Normalmente no se deben
incluir, ya que formarán parte de la JSP principal. --%>
<%
    String colorFondo = request.getParameter("colorFondo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: <%=colorFondo%>">
        <h3>Recurso Privado</h3>
        Este recurso recibe un parámetro de color de fondo y lo aplica al style del body
    </body>
</html>
