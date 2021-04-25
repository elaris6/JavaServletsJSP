<%-- Agregamos declaraciones a una JSP.
Podemos agregar atributos o métodos, que pasarán a formar parte del Servlet
generado a partir de la JSP.--%>

<%-- La diferencia al agregar código en un scriptlet es que los atributos y
métodos de una decalración serán incluidos a invel de la clase principal del
Servlet, pero si se incluye código dentro de un scriptlet, éste se agregará
dentro del bloque "try" del método "_jspService", con lo que no podrán ser
accedidos desde fuera de este ámbito y no se podrán declarar métodos, al estar
ya dentro de un método. --%>


<%!
//Declaramos un atributo para el usuario con su método get
    private String usuario = "nombreUsuario";

    public String getUsuario() {
        return this.usuario + " desde el método";
    }

//Declaramos un contador de visitas
    private int contadorVisitas = 1;

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaraciones JSP</title>
    </head>
    <body>
        <h1>Uso de declaraciones en JSP</h1>

        Valor de usaurio por medio del atributo: <%= this.usuario%>
        </br>
        Valor de usaurio por medio del método: <%= this.getUsuario()%>
        </br>
        Valor del atributo contadorVisitas: <%= this.contadorVisitas++%>
    </body>
</html>
