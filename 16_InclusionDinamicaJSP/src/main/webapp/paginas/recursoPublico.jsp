<%-- En la inclusi�n din�mica, al no crearse un �nico recuros de salida, es posible
incluir los TAGS principales de HTML o no, seg�n convenga. Normalmente no se deben
incluir, ya que formar�n parte de la JSP principal. --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h3>Recurso P�blico</h3>
        <br/>
        Inclusi�n de contenido din�mico desde un JSP p�blico
        <br/>
        Nombre de la aplicaci�n: <%= request.getContextPath()%>
    </body>
</html>
