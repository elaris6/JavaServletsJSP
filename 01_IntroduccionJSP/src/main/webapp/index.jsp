<%-- 
    Los comentarios en JSP's se añaden con estos caracteres de apertura y cierre.

    Un JSP es un componente del servidor, no es un archivo html. A la hora de 
    ejecutarse, se traducirá de forma automática a un Servlet que se compilará.
	Esta traducción solo se realiza la primera vez que se llama al JSP. Se podría
	incluso pre-compilar las JSP a Servlet para ahorrar tiempo en la primera ejecución.

--%>

<%-- Esto son directivas, que se usan para configurar los atributos y dependencias 
de una JSP. En este caso para indicar el content type, en lugar de hacerlo desde el
objeto "response" del servlet, y para cargar una librería. --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%-- Esta línea sobra ya que se ha especificado en una directiva
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> --%>
        <title>Intro JSP</title>
    </head>
    <body>
        <h1>Hello World con una JSP!</h1>
        
        <ul>
            <%-- Podremos agregar código según convenga dentro del JSP mediante 
            lo que se conoce como Scriptlet. 
            <% Con estos caracteres se inicia un Scriptlet, que puede contener
                código Java de cualquier tipo, siempre que pueda ser ejecutando
                teniendo en cuenta que al cimpilarse se incluirá dentro del método
                "service()" del Servlet generado a partir del JSP.
            <%! Con estos caracteres se inicia una declaración de una variable o
                métodos que pertenezcan al Servlet generado desde la JSP.
            <%= Con estos caracteres se imprime una expresión, como si se hiciese
                un "System.out.println()", o un "out.println()" desde el Servlet.
                El objeto "out" de tipo "PrintWriter" estará disponible por defecto
                en un scriptlet.
            --%>
            <li> <% out.print("Hola mundo desde un scriptlet del JSP"); %> </li>
            <li> ${"Hola mundo con Expression Languaje (EL)"} </li>
            <li> <%= "Hola mundo desde una Expresión" %> </li>
            <li> <c:out value="Hola mundo con JavaServer Pages Standard Library (JSTL)"/> </li>
        </ul>
    </body>
</html>
