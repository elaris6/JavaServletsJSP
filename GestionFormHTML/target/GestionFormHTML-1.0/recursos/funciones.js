'use strict';

function validarForma(formulario){
    
    // Validación campo usuario
    let usuario = formulario.usuario;
    if(usuario.value === '' || usuario.value.length < 5){
        alert('El valor del campo usuario es incorrecto');
        usuario.focus();
        usuario.select();
        return false;
    }
    
    // Validación campo contraseña
    let password = formulario.password;
    if(password.value === '' || password.value.length < 5){
        alert('El valor del campo password es incorrecto');
        password.focus();
        password.select();
        return false;
    }
    
    // Validación checkboxes tecnologias
    var tecnologia = formulario.tecnologia;
    var checkSel = false;

    // Se recorre el posible array de casillas marcadas.
    for(var i = 0; i < tecnologia.length; i++){
        if(tecnologia[i].checked){
            checkSel = true;
        }
    }
    if (!checkSel){
        alert("Es necesario proporcionar al menos una tecnología.")
        return false;
    }
    
    // Validación combo género
    let genero = formulario.genero;
    let checkGen = false;
    
    for(let i = 0;i<genero.length;i++){
        if(genero[i].checked){
            checkGen = true;
        }
    }
    if(!checkGen){
        alert('Debes indicar el género');
        return false;
    }
    
    // Validación select especialidad
    let espec = formulario.especialidad;
    if(espec.value === ''){
        alert('Debes indicar una especialidad');
        return false;
    }
        
    // Si se llega a este punto, se puede considerar que el formulario es válido.
    alert("Formulario validado!");
    return true;
}



