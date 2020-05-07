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
    el('#errNombre').textContent = null;
    el('#errApellidos').textContent = null;
    el('#errUsuario').textContent = null;
    el('#errClave').textContent = null;
    el('#errConfirma').textContent = null;
    
    if (nombre.length < 3 || nombre.length > 20) {
        el('#errNombre')
                .textContent = "La longitud del nombre no es válida [3, 20]";
        valido = false;
    }
    if (apellidos.length < 2 || apellidos.length > 30) {
        el('#errApellidos')
                .textContent = "La longitud del apellido no es válida [2, 30]";
        valido = false;
    }
    if (usuario.length < 4 || usuario.length > 12) {
        el('#errUsuario')
                .textContent = "La longitud del usuario no es válida [4, 12]";
        valido = false;
    }
    if (contra1.search(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm) === -1) {
        el('#errClave')
                .textContent = "Clave no válida (Debe contener al menos 8 caracteres, al menos 1 letra mayúscula y 1 dígito, puede contener caracteres especiales) ";
        valido = false;
    }


    if (contra1 !== contra2) {
        el('#errConfirma')
                .textContent = "Las claves no coinciden";
        valido = false;
    }

    if (!valido)
        event.preventDefault(); //stop form submit
}




