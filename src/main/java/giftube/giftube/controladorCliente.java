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
    private ClienteDAOJPA clienteDAO;
    
    @Inject 
    private Preferencias pref;
    
    private static final Logger logger = Logger.getLogger(controladorCliente.class.getName());
    
    private Cliente cliente;

    public controladorCliente() {
    }
    
    @PostConstruct
    public void init(){
        /*if(clienteDAO.buscaCliente(pref.getActualUsuarioid()) == null){
            cliente = new Cliente();
        }else{
            cliente = clienteDAO.buscaCliente(pref.getActualUsuarioid());
        }*/
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public List<Cliente> getClientes() {
        logger.info(clienteDAO.buscaTodos().toString());
        return clienteDAO.buscaTodos();
    }
    
    public String crea(){
        logger.info("Creando cliente ");
        if(clienteDAO.altaCliente(cliente)){
        logger.info("Nombre: " + cliente.getNombre() + " Apellidos: " + cliente.getApellidos() +
                 " Usuario: " + cliente.getUsuario());
        return "login?faces-redirect=true&usuario="+cliente.getUsuario();
        }
        else return"";
    }
    
    public void borra(){
        logger.info("Borrando cliente");
        if(clienteDAO.buscaCliente(pref.getActualUsuarioid()) == null){
            logger.info("No se puede borrar la cuenta porque el usuario no existe.");
        }else{
            cliente=clienteDAO.buscaCliente(pref.getActualUsuarioid());
            clienteDAO.borraCliente(pref.getActualUsuarioid());
            logger.info("Cliente borrado: Usuario: " + cliente.getUsuario() + " Nombre: " + cliente.getNombre());
        }
    }
    
    public String login(){
        Cliente clienteLogeado = clienteDAO.buscaCliente(cliente);
        if(clienteLogeado == null){
            logger.info("No existe ningun cliente con el usuario: " + cliente.getUsuario());
        }else{
            if(clienteLogeado.getPassword() != cliente.getPassword()){
                logger.info("Usuario " + cliente.getUsuario() + " logeado correctamente");
                pref.setActualUsuarioid(clienteLogeado.getUsuario());
                return "main1?faces-redirect=true";
            }else{
                logger.info("Contraseña incorrecta");
            }
        }
        return "";
    }
    
    public String editarNombre(){
        logger.info("Editando nombre");
        clienteDAO.modificaNombre(pref.getActualUsuarioid(), cliente.getNombre());
        logger.info("nuevo nombre: " + cliente.getNombre());
        return "configuracion?faces-redirect=true";
    }
}
