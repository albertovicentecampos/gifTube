/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author miguel
 */
@ApplicationScoped
public class ClientesDAO {
    private Map<String, Cliente> clientes = null;

    public ClientesDAO() {
        clientes = new HashMap<>();
    }
    
    /**
     * @brief funcion para buscar un cliente en el mapa
     * @param usuario usuario del cliente que se busca
     * @return cliente buscado, o null si no lo encuentra
     */
    public Cliente buscaCliente(String usuario){
        return clientes.get(usuario);
    }
    
    /**
     * @brief funcion para añadir un cliente al HashMap de clientes
     * @param cliente cliente que queremos añadir al mapa
     * @return true si consigue añadirlo, false si el usuario ya estaba en uso y no puede añadirse el cliente
     */
    public boolean altaCliente(Cliente cliente){
        if(!clientes.containsKey(cliente.getUsuario())){
            clientes.put(cliente.getUsuario(), cliente);
            return true;
        }
        return false;
    }
    
    /**
     * @brief funcion para borrar un cliente del mapa
     * @param usuario del cliente que queremos borrar
     * @return true si esta en el mapa y consigue borrarlo, false en caso contrario
     */
    public boolean borraCliente(String usuario){
        if(clientes.containsKey(usuario)){
            clientes.remove(usuario);
            return true;
        }else{
            return false;
        }
    }
     
}
