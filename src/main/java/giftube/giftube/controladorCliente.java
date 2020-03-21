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
        return clienteDAO.buscaTodos();
    }
    
    public void crea(){
        clienteDAO.altaCliente(cliente);
    }
    
    public void borra(){
        clienteDAO.borraCliente(cliente);
    }
        
}
