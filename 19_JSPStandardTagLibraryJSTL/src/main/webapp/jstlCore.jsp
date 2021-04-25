<%-- JSTL. Java server pages Standard Tag Library
Se usa para importar librerías que se pueden usar para facilitar el uso de
elementos y tareas comunes. Existen varias librerías JSTL: core, xml, sql...

Por ejemplo en la librería Core existen funciones implementadas para por ejemplo:
definir variables, crear bloques condicionales, iterar elementos...

DOCUMENTACIÓN: http://www.w3big.com/es/jsp/jsp-jstl.html

La carga de una librería JSTL se lleva a cabo mediante la siguiente sintaxis,
en la que la uri no implica un acceso a internet, se irá a buscar la librería
al servidor de aplicaciones.

--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con JSTL Core</title>
    </head>
    <body>
        <h1>JSP con JSTL Core</h1>
        <!-- Se define una variable -->
        <c:set var="nombre" value="Israel" />
        <!-- Se accede al valor de una variable -->
        Variable nombre: <c.out value="${nombre}"/>
    <br/>
    <br/>
    Variable con código HTML:
    <c:out value="<h4>Código html en H4</h4>" escapeXml="false"/>
    <br/>
    <br/>
    <!-- Código condicionado, uso de "if" -->
    <c:set var="bandera" value="true"/>
    <c:if test="${bandera}">
        La variable bandera es verdadera
    </c:if>

    <c:if test="${param.opcion != null}" >
        <!-- Código condicionado, uso de "switch" -->
        <c:choose>
            <c:when test="${param.opcion == 1}">
                <br/>
                Opción 1 seleccionada
            </c:when>
            <c:when test="${param.opcion == 2}">
                <br/>
                Opción 2 seleccionada
            </c:when>
            <c:otherwise>
                <br/>
                Opción desconocida: ${param.opcion}
            </c:otherwise>
        </c:choose>
    </c:if>

    <!-- Iterar un array -->
    <%
        // Creamos un array y lo incluímos en el scope de la request
        String nombres[] = {"Mari", "Alicia", "Natalia"};
        request.setAttribute("nombres", nombres);
    %>
    <br/>
    <br/>
    Lista de nombres:
    <br/>
    <ul>
        <c:forEach var="nom" items="${nombres}">
            <li>${nom}</li>
            </c:forEach>
    </ul>

    <br/>
    <a href="index.jsp">Volver a inicio</a>





</body>
</html>
