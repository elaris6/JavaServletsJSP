<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance Variables</title>
    </head>
    <body>
        <h1>Despliega Variables en alcances</h1>
        Variables en alcance Request:<br/>
        Base: ${rectanguloRequest.base}<br/>
        Altura: ${rectanguloRequest.altura}<br/>
        Area: ${rectanguloRequest.area}<br/>
        <c:if test="${rectanguloRequest.area} == null">
            <!-- Esto no funciona porque la variable ni siquiera existe. -->
            Las variables del alcance Request están vacías
        </c:if>
        <%
            if(request.getAttribute("rectanguloRequest") == null){
        %>
            <br/>
            Las variables del alcance Request no existen.
            <br/>
        <% } %>
            
        <br/>
        Variables en alcance Session:<br/>
        Base: ${rectanguloSesion.base}<br/>
        Altura: ${rectanguloSesion.altura}<br/>
        Area: ${rectanguloSesion.area}<br/>
        <br/>
        Variables en alcance Application:<br/>
        Base: ${rectanguloAplicacion.base}<br/>
        Altura: ${rectanguloAplicacion.altura}<br/>
        Area: ${rectanguloAplicacion.area}<br/>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver a inicio</a>
        
    </body>
</html>
