<%-- JSTL. Java server pages Standard Tag Library
Se usa para importar librer�as que se pueden usar para facilitar el uso de
elementos y tareas comunes. Existen varias librer�as JSTL: core, xml, sql...

Por ejemplo en la librer�a Core existen funciones implementadas para por ejemplo:
definir variables, crear bloques condicionales, iterar elementos...

DOCUMENTACI�N: http://www.w3big.com/es/jsp/jsp-jstl.html

La carga de una librer�a JSTL se lleva a cabo mediante la siguiente sintaxis,
en la que la uri no implica un acceso a internet, se ir� a buscar la librer�a
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
    Variable con c�digo HTML:
    <c:out value="<h4>C�digo html en H4</h4>" escapeXml="false"/>
    <br/>
    <br/>
    <!-- C�digo condicionado, uso de "if" -->
    <c:set var="bandera" value="true"/>
    <c:if test="${bandera}">
        La variable bandera es verdadera
    </c:if>

    <c:if test="${param.opcion != null}" >
        <!-- C�digo condicionado, uso de "switch" -->
        <c:choose>
            <c:when test="${param.opcion == 1}">
                <br/>
                Opci�n 1 seleccionada
            </c:when>
            <c:when test="${param.opcion == 2}">
                <br/>
                Opci�n 2 seleccionada
            </c:when>
            <c:otherwise>
                <br/>
                Opci�n desconocida: ${param.opcion}
            </c:otherwise>
        </c:choose>
    </c:if>

    <!-- Iterar un array -->
    <%
        // Creamos un array y lo inclu�mos en el scope de la request
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
