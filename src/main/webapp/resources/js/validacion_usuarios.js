/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', () => {
    document.getElementById("fcliente")
            .addEventListener('submit', validarFormulario);
});


function validarFormulario(event) {
    var el = selector => document.querySelector(selector);
    var nombre = el('#fcliente\\:txtNombre').value;
    var apellidos = el('#fcliente\\:txtApellidos').value;
    var usuario = el('#fcliente\\:txtUsuario').value;
    var contra1 = el('#fcliente\\:txtClave').value;
    var contra2 = el('#fcliente\\:txtConfirma').value;
    var valido = true;
    if (nombre.length < 3 || nombre.length > 50) {
        el('#errNombre')
                .textContent = "La longitud del nombre no es válida";
        valido = false;
    }
    if (apellidos.length < 2 || apellidos.length > 30) {
        el('#errApellidos')
                .textContent = "La longitud del apellido no es válida";
        valido = false;
    }
    if (usuario.length < 4 || usuario.length > 12) {
        el('#errUsuario')
                .textContent = "La longitud del usuario no es válida";
        valido = false;
    }
    if (contra1.search(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm) === -1) {
        el('#errClave')
                .textContent = "Clave no válida (Debe contener al menos 8 caracteres, debe contener al menos 1 letra mayuscula y 1 digito, puede contener caracteres especiales) ";
        valido = false;
    }


    if (contra1 !== contra2) {
        el('#errConfirma')
                .textContent = "La clave no coincide con la primera";
        valido = false;
    }

    if (!valido)
        event.preventDefault(); //stop form submit
}




