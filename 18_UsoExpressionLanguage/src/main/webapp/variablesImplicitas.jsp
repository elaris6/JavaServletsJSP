<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL varaibles implicitas</title>
    </head>
    <body>
        <h1>Expression Language y variables implicitas</h1>
        <%-- El uso de Expression Language simplifica en gran medida el acceso
        de lectura a atributos/metodos de Javabenas, así como a variables de
        sesion.
        No es posible ejecutar acciones de modificación con EL, solo lectura.

        La sintaxis es mediante la estructura "${EL}", donde "EL" será la
        expresión. La expresión seguirá la notación del punto, aunque también
        se admiten llaves para acceder a objetos de tipo Collection, Map o Array.
		
		Las variables informadas en EL se buscarán en todos los scopes, si no se
		indica uno concreto. Se buscará en orden: page, request, session, application.

        https://es.wikipedia.org/wiki/Expression_Language

        --%>
        <ul>
            <li>Nombre de aplicación: ${pageContext.request.contextPath}</li>
            <li>Navegador del cliente: ${header["User-Agent"]}</li>
            <li>id Sesión con expresión: <%=request.getSession().getId()%></li>
            <li>id Sesión con EL: ${pageContext.request.session.id}</li>
            <li>id Sesión con EL de la cookie: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <li>Parámetro recibido con nomenclatura del punto: ${param.usuario}</li>
            <li>Parámetro recibido con corchetes: ${param["usuario"]}</li>
        </ul>
        <br/>
        <a><a href="index.jsp">Volver a inicio</a>
    </body>
</html>
