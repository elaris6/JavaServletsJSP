<%-- En la inclusi�n din�mica, al no crearse un �nico recuros de salida, es posible
incluir los TAGS principales de HTML o no, seg�n convenga. Normalmente no se deben
incluir, ya que formar�n parte de la JSP principal. --%>
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
        Este recurso recibe un par�metro de color de fondo y lo aplica al style del body
    </body>
</html>
