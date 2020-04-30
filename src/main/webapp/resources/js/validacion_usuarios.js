/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(() => {
    window.ctrl = new ClientesCtrl(); //Register global var
    //ctrl.init(); //Attach view event Handlers
});

class ClientesCtrl {
    constructor() {
        this.config = {
            formulario: "form[name=signup]", 
            ibNombre: "[id=txtNombre]",//document.getElementById('signup:txtNombre').value,
            p1: "[id=txtClave]",//document.getElementById('signup:txtClave').value,
            p2: "[id=txtConfirma]"//document.getElementById('signup:txtConfirma').value
        };
    }
    //init() {
    //        $(this.config.formulario).on('submit', event => {
      //              if (this.validarDatos() === false) {
        //                event.preventDefault();
          //          }
            //        ;
    //            });
    //    $(this.config.ibNombre).focus();
   // }
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