/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 $(() => {
 window.ctrl = new ClientesCtrl(); //Register global var
 //ctrl.init(); //Attach view event Handlers
 });
 
 class ClientesCtrl {
 constructor() {
 this.config = {
 formulario: "form[name=signup]",
 ibNombre: "[id=txtNombre]", //document.getElementById('signup:txtNombre').value,
 p1: "[id=txtClave]", //document.getElementById('signup:txtClave').value,
 p2: "[id=txtConfirma]"//document.getElementById('signup:txtConfirma').value
 };
 }
 init() {
 $(this.config.formulario).on('submit', event => {
 if (this.validarDatos() === false) {
 event.preventDefault();
 }
 ;
 });
 $(this.config.ibNombre).focus();
 }
 validarDatos() {
 var result = true;
 var nombre = $(this.config.ibNombre).val();
 var p1 = $(this.config.p1).val();
 var p2 = $(this.config.p2).val();
 if (p1 != p2) {
 alert("Las passwords deben de coincidir");
 return false;
 } else {
 alert("Todo esta correcto");
 return true;
 }
 if (nombre.length < 6 || nombre.length > 16) {
 $('#errNombre').text('Nombre no válido');
 result = false;
 console.log("nombre inválido");
 }
 
 ;
 
 return result;
 }
 }
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
                .textContent = "Clave no válida (Debe contener al menos 8 caracteres debe contener 1 letra mayuscula, y 1 digito puede contener caracteres especiales) ";
        valido = false;
    }
    if (contra1 === contra2) {
        valido = true;
    } else {
        el('#errConfirma')
                .textContent = "Clave no similar a la primera";
        valido = false;
    }



    if (!valido)
        event.preventDefault(); //stop form submit
}




//if (usuario.search(/^\d{7,8}(-?[a-z])?$/i) === -1)