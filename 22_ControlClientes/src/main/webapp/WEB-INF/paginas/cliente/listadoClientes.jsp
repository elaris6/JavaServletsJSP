<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES"/>
<section id="clientes">
    <div class="container">
        <div class="row">
            <!-- Bloque para tabla de clientes -->
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de clientes para generar las filas necesarias -->
                            <c:forEach var="cliente" items="${clientes}" varStatus="vuelta">
                                <tr>
                                    <!-- Se define en el "for each" el atributo "varStatus" con un nombre
                                    cualquiera ("vuelta"), y este atributo almacenará información sobre
                                    la iteración del bucle.
                                    https://mail.codejava.net/java-ee/jstl/jstl-core-tag-foreach -->
                                    <td>${vuelta.count}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency" currencySymbol="&euro;"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                           class="btn btn-secondary"><i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Bloque para tarjetas laterales para los totales -->
            <div class="col-md-4">
                <!-- Tarjeta Salto Total Clientes -->
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency" currencySymbol="&euro;"/>
                        </h4>
                    </div>
                </div>
                <!-- Tarjeta Número de clientes -->
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>&nbsp;&nbsp;&nbsp;${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregar Cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>