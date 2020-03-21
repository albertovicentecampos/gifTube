/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author miguel
 */
@Named("ctrlCliente")
@ViewScoped
public class controladorCliente implements Serializable{
    @Inject
    private ClienteDAO clienteDAO;
    
    private static final Logger logger = Logger.getLogger(controladorCliente.class.getName());
    
    private Cliente cliente;

    public controladorCliente() {
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public List<Cliente> getClientes() {
        logger.info(clienteDAO.buscaTodos().toString());
        return clienteDAO.buscaTodos();
    }
    
    public void crea(){
        logger.info("Creando cliente ");
        clienteDAO.altaCliente(cliente);
        logger.info("Nombre: " + cliente.getNombre() + " Apellidos: " + cliente.getApellidos() +
                 "Usuario: " + cliente.getUsuario());
    }
    
    public void borra(){
        logger.info("Borrando cliente");
        clienteDAO.borraCliente(cliente);
        logger.info("Cliente borrado: Usuario: " + cliente.getUsuario() + " Nombre: " + cliente.getNombre());
    }
    
    public void login(){
        Cliente clienteLogeado = clienteDAO.buscaCliente(cliente);
        if(clienteLogeado == null){
            logger.info("No existe ningun cliente con el usuario: " + cliente.getUsuario());
        }else{
            if(clienteLogeado.getPassword() != cliente.getPassword()){
                logger.info("Usuario " + cliente.getUsuario() + " logeado correctamente");
            }else{
                logger.info("Contraseña incorrecta");
            }
        }
    }
    
    public void editarNombre(){
        
    }
}
