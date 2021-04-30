<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de variables</title>
    </head>
    <body>
        <h1>Despliegue de variables</h1>
        <%-- Se accede a la variable de prueba añadida en el alcance de request --%>
        Variable en alcance request: ${mensaje}
        <br/>
        <br/>
        <%-- Se accede a las variables del JavaBean compartido en el alcance de sesión.
            Mediante EL, accedemmos a los "getter" para recuperar los valores. --%>
        Variables en alcance sesión:
        <br/>
        Base: ${rectanguloBean.base}
        <br/>
        Altura: ${rectanguloBean.altura}
        <br/>
        Area: ${rectanguloBean.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver a inicio</a>
    </body>
</html>
