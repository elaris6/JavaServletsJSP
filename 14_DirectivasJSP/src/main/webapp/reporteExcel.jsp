
<%-- Directiva para indicar importaciones de paquetes Java necesarios. --%>
<%@page import="utilidades.Conversiones, java.util.Date" %>
<%-- Directiva para indicar el tipo MIME de la respuesta. En este caso un fichero Excel. --%>
<%@page contentType="application/vnd.ms-excel" %>
<%-- Directiva para indicar el JSP que gestionar� los errores en tiempo de ejecuci�n.
Los JSP que gestionan errores, deben ubicarse dentro de la carpeta "WEB-INF" de la
aplicaci�n, para que sean privados. De esta forma solo los componentes de esta
aplicaci�n podr�n acceder a este JSP y no se podr� acceder desde el navegador,
por ejemplo.

Esto no es obligatorio, pero es una buena pr�ctica. --%>
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>

<%
    /* Se agrega la cabecera de la respuesta para indicar que �sta ser� con un
    fichero de tipo Excel.
    En lugar de indicar el valor "attachment;filename=", se indica "inline;filename="
    para permitir la redirecci�n al JSP de gesti�n de errores, ya que con el valor
    de "attachment, no se permiten redirecciones. */
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <%-- No se indica el meta del content-type, porque se especifica en la
        directiva correspondiente. --%>
        <title>Reporte Excel</title>
    </head>
    <body>
        <%-- Se escribe el contenido HTML directamente en la salida Excel,
        d�ndole formato de tabla. --%>
        <h1>Reporte Excel en JSP</h1>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripci�n</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprender todos los conceptos b�sicos de Java</td>
                <td><%=Conversiones.formateaFecha(new Date())%></td>
            </tr>
            <tr>
                <td>2. Programaci�n con Java</td>
                <td>Conocimiento de todos los conceptos referentes a la POO</td>
                <%-- Se puede indicar un valor inv�lido como entrada del m�todo que
                formatea fechas, para provocar una excepci�n y controlar el
                error mediante un JSP espec�fico. --%>
                <td><%=Conversiones.formateaFecha(new Date())%></td>
            </tr>
        </table>
    </body>
</html>
