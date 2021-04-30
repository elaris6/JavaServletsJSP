<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP getter</title>
    </head>
    <body>
        <h1>JSP que recupera los valores de un JavaBean</h1>
        <%-- Para importar una clase de tipo JavaBean se usa la siguiente sintaxis.
        "id" es el nombre que se le da a la instancia, "class" es el nombre de la
        clase JavaBean que se instancia y "scope" es el �mbito que se le da entre:
        page, request, session, application. De �mbito menor a mayor.
        Si la instancia existe, la recupera, si no, la crear�.--%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        <br/>
        <%-- Para obtener un atributo o resultado de la instancia creada se usar�
        la siguiente sintaxis, donde "name" es el nombre de la instancia, "property"
        el nombre del m�todo setter, sin "get" y con la primera letra en min�scula,
        pudiendo no ser un getter de un atributo de clase, sino cualquier m�todo
        de tipo "get". --%>
        Valor base: <jsp:getProperty name="rectangulo" property="base"/>
        <br/>
        Valor altura: <jsp:getProperty name="rectangulo" property="altura"/>
        <br/>
        <%-- En este caso se hace un "get" de un m�todo que no es un "getter" de
        un atributo, sino que devuelve un c�lculo de la clase. --%>
        Valor �rea: <jsp:getProperty name="rectangulo" property="area"/>
        <br/>
        <br/>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
