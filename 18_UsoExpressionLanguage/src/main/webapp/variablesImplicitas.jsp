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
        de lectura a atributos/metodos de Javabenas, as� como a variables de
        sesion.
        No es posible ejecutar acciones de modificaci�n con EL, solo lectura.

        La sintaxis es mediante la estructura "${EL}", donde "EL" ser� la
        expresi�n. La expresi�n seguir� la notaci�n del punto, aunque tambi�n
        se admiten llaves para acceder a objetos de tipo Collection, Map o Array.
		
		Las variables informadas en EL se buscar�n en todos los scopes, si no se
		indica uno concreto. Se buscar� en orden: page, request, session, application.

        https://es.wikipedia.org/wiki/Expression_Language

        --%>
        <ul>
            <li>Nombre de aplicaci�n: ${pageContext.request.contextPath}</li>
            <li>Navegador del cliente: ${header["User-Agent"]}</li>
            <li>id Sesi�n con expresi�n: <%=request.getSession().getId()%></li>
            <li>id Sesi�n con EL: ${pageContext.request.session.id}</li>
            <li>id Sesi�n con EL de la cookie: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <li>Par�metro recibido con nomenclatura del punto: ${param.usuario}</li>
            <li>Par�metro recibido con corchetes: ${param["usuario"]}</li>
        </ul>
        <br/>
        <a><a href="index.jsp">Volver a inicio</a>
    </body>
</html>
