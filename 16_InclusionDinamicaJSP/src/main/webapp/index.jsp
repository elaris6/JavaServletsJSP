<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo inclusion dinamica</title>
    </head>
    <body>
        <h1>Ejemplo de Inclusión Dinámica de JSPs</h1>
        <%-- Las JSP incluidas de forma dinámica no generarán su propio serlvet,
        salvo que se las invoque de forma independeinte. Lo que hace la JSP
        principal al incluirlas es hacer una llamada a las JSP secundarias:
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paginas/recursoPublico.jsp", out, false);
        --%>
        <br/>
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br/>
        <%-- Es posible pasar paráetros a una JSP incluída de forma dinámica. --%>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
