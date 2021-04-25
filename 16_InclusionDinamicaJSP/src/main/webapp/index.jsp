<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo inclusion dinamica</title>
    </head>
    <body>
        <h1>Ejemplo de Inclusi�n Din�mica de JSPs</h1>
        <%-- Las JSP incluidas de forma din�mica no generar�n su propio serlvet,
        salvo que se las invoque de forma independeinte. Lo que hace la JSP
        principal al incluirlas es hacer una llamada a las JSP secundarias:
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paginas/recursoPublico.jsp", out, false);
        --%>
        <br/>
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br/>
        <%-- Es posible pasar par�etros a una JSP inclu�da de forma din�mica. --%>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
