/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author miguel
 */
public class ClientesDAOjpa implements ClientesDAO{
    private Map<String, Cliente> clientes = null;
    
    public ClientesDAOjpa() {
        clientes = new HashMap<>();
    }
    
    /**
     * @brief funcion para buscar un cliente en el mapa
     * @param usuario usuario del cliente que se busca
     * @return cliente buscado, o null si no lo encuentra
     */
    public Cliente buscaCliente(Cliente cliente){
        return clientes.get(cliente.getUsuario());
    }
    
    /**
     * @brief funcion para obtener todos los clientes almacenados en el map
     * @return todos los clientes del mapa
     */
    public List<Cliente> buscaTodos(){
        return clientes.values().stream().collect(Collectors.toList());
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
    public boolean borraCliente(Cliente cliente){
        if(clientes.containsKey(cliente.getUsuario())){
            clientes.remove(cliente.getUsuario());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void modificaNombre(Cliente cliente, String nombre) {
        clientes.get(cliente.getUsuario()).setNombre(nombre);
    }

    @Override
    public void modificaApellidos(Cliente cliente, String apellidos) {
        clientes.get(cliente.getUsuario()).setApellidos(apellidos);
    }

    @Override
    public void modificaFechaNacimiento(Cliente cliente, Date fecha) {
        clientes.get(cliente.getUsuario()).setFechaNacimiento(fecha);
    }

    @Override
    public void modificaGenero(Cliente cliente, Genero genero) {
        clientes.get(cliente.getUsuario()).setGenero(genero);
    }
    
}
