<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP setter</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean</h1>
        <%-- Para importar una clase de tipo JavaBean se usa la siguiente sintaxis.
        "id" es el nombre que se le da a la instancia, "class" es el nombre de la
        clase JavaBean que se instancia y "scope" es el �mbito que se le da entre:
        page, request, session, application. De �mbito menor a mayor.
        Si la instancia existe, la recupera, si no, la crear�. --%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        Modificamos los atributos:
        <br/>
        <br/>
        <%
            int baseValor = (int) (Math.random() * 100 + 1);
            int alturaValor = (int) (Math.random() * 100 + 1);
        %>
        <%-- Para modificar un atributo de la instancia creada se usar� la siguiente
        sintaxis, donde "name" es el nombre de la instancia, "property" el nombre
        del m�todo setter, sin "set" y con la primera letra en min�scula, y "value"
        el valor a asignar al atributo.
        El m�todo invocado no tiene porque ser un "setter" de un atributo, podr�a
        ser cualquier m�todo con formato "set", para a�adir informaci�n a la
        instancia. --%>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>"/>

        Nuevo valor base: <%=baseValor%>
        <br/>
        Nuevo valor altura: <%=alturaValor%>

        <br/>
        <br/>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
