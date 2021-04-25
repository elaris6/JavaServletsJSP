<%-- Agregamos declaraciones a una JSP.
Podemos agregar atributos o m�todos, que pasar�n a formar parte del Servlet
generado a partir de la JSP.--%>

<%-- La diferencia al agregar c�digo en un scriptlet es que los atributos y
m�todos de una decalraci�n ser�n incluidos a invel de la clase principal del
Servlet, pero si se incluye c�digo dentro de un scriptlet, �ste se agregar�
dentro del bloque "try" del m�todo "_jspService", con lo que no podr�n ser
accedidos desde fuera de este �mbito y no se podr�n declarar m�todos, al estar
ya dentro de un m�todo. --%>


<%!
//Declaramos un atributo para el usuario con su m�todo get
    private String usuario = "nombreUsuario";

    public String getUsuario() {
        return this.usuario + " desde el m�todo";
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
        Valor de usaurio por medio del m�todo: <%= this.getUsuario()%>
        </br>
        Valor del atributo contadorVisitas: <%= this.contadorVisitas++%>
    </body>
</html>
