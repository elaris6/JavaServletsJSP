<section id="action" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <!-- Botón volver atrás -->
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i>&nbsp;Volver a inicio
                </a>
            </div>
            <!-- Botón guardar cambios cliente -->
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i>&nbsp;Guardar cambios
                </button>
            </div>
            <!-- Botón eliminar cliente -->
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}" class="btn btn-danger btn-block">
                    <i class="fas fa-minus"></i>&nbsp;Eliminar cliente
                </a>
            </div>
        </div>
    </div>
</section>