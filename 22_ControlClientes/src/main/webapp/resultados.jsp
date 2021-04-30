<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados TestDatos</title>
    </head>
    <body>
        <h1>Resultados TestDatos</h1>
        
        <p>Se ha insertado ${registros} registros en la BBDD de clientes.</p>
        <c:out value="${cliente}"/>
        <br/>
        <!-- Se comprueba si se ha insertado algún registro -->

            <p>Datos del cliente insertado</p>
            <ul>
                <li>Nombre: ${cliente.nombre}</li>
                <li>Apellido: ${cliente.apellido}</li>
                <li>Email: ${cliente.email}</li>
                <li>Teléfono: ${cliente.telefono}</li>
                <li>Saldo: ${cliente.saldo}</li>
            </ul>
        <br/>
        <a href="${pageContext.request.contextPath}/index.html">Volver a inicio</a>
    </body>
</html>
