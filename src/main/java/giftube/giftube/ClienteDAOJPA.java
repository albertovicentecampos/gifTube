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
import static giftube.giftube.Cliente.Genero;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author miguel
 */
@RequestScoped
@Transactional
public class ClienteDAOJPA{
    
    @PersistenceContext
    private EntityManager em;
    
    Cliente cliente;
    
    private static final Logger logger = Logger.getLogger(ClienteDAOJPA.class.getName());
    
    public ClienteDAOJPA() {
        cliente = new Cliente();
    }
    
    /**
     * @brief funcion para buscar un cliente en la base de datos
     * @param usuario usuario del cliente que se busca
     * @return cliente buscado, o null si no lo encuentra
     */
    public Cliente buscaCliente(Cliente cliente){
        return em.find(Cliente.class, cliente.getUsuario());
    }
    
    public Cliente buscaCliente(String user){
        return em.find(Cliente.class, cliente.getUsuario());
    }
    /**
     * @brief funcion para obtener todos los clientes almacenados en la base de datos
     * @return todos los clientes de la base de datos
     */
    public List<Cliente> buscaTodos(){
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            listaClientes = em.createQuery("select * from Cliente", Cliente.class).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se han podido recuperar la lista de clientes", e);
        }
        return listaClientes;
    }
    
    /**
     * @brief funcion para añadir un cliente a la base de datos
     * @param cliente cliente que queremos añadir a la base de datos
     * @return true si consigue añadirlo, false si el usuario ya estaba en uso y no puede añadirse el cliente
     */
    public boolean altaCliente(Cliente cliente){
        boolean creado = false;
        try{
            em.persist(cliente);
            creado = true;
        }catch (Exception e){
            logger.log(Level.SEVERE, "No se ha podido añadir el cliente a la base de datos", e);
        }
        return creado;
    }

    /**
     * @brief funcion para borrar un cliente del mapa
     * @param cliente objeto cliente que queremos borrar
     * @return true si esta en la BBDD y consigue borrarlo, false en caso contrario
     */
    public boolean borraCliente(Cliente cliente){
        boolean borrado = false;
        try{
            Cliente c = null;
            c = em.find(Cliente.class, cliente.getUsuario());
            em.remove(c);
            borrado = true;
        }catch(Exception e){
            logger.log(Level.SEVERE, "No se ha podido borrar el cliente de la base de datos", e);
        }
        
        return borrado;
    }
    /**
     * @brief funcion para borrar un cliente del mapa
     * @param user usuario del cliente que queremos borrar
     * @return true si esta en la BBDD y consigue borrarlo, false en caso contrario
     */
    public boolean borraCliente(String user){
        boolean borrado = false;
        try{
            Cliente c = null;
            c = em.find(Cliente.class, user);
            em.remove(c);
            borrado = true;
        }catch(Exception e){
            logger.log(Level.SEVERE, "No se ha podido borrar el cliente d ela base de datos", e);
        }
        
        return borrado;
    }
    
    public boolean guarda(Cliente c){
        boolean guardado = false;
        try {
            c = em.merge(c);
            guardado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se ha podido guardar el cliente", ex);
        }
        return guardado;
    }
    
    public void modificaNombre(String user, String nombre) {
        try{
            Cliente c = em.find(Cliente.class, user);
            c.setNombre(nombre);
        }catch(Exception e){
            logger.log(Level.SEVERE, "No se ha podido modificar el nombre del usuario");
        }
    }

    public void modificaApellidos(String user, String apellidos) {
        try{
            Cliente c = em.find(Cliente.class, user);
            c.setApellidos(apellidos);
        }catch(Exception e){
            logger.log(Level.SEVERE, "No se ha podido modificar los apellidos del usuario");
        }
    }

    public void modificaFechaNacimiento(String user, Date fecha) {
        try{
            Cliente c = em.find(Cliente.class, user);
            c.setFechaNacimiento(fecha);
        }catch(Exception e){
            logger.log(Level.SEVERE, "No se ha podido modificar la fecha de nacimiento del usuario");
        }
    }

    public void modificaGenero(String user, Genero genero) {
        try{
            Cliente c = em.find(Cliente.class, user);
            c.setGenero(genero);
        }catch(Exception e){
            logger.log(Level.SEVERE, "No se ha podido modificar el genero del usuario");
        }
    }
    
    public void modificaBiografia(String user, String biografia){
        try{
            Cliente c = em.find(Cliente.class, user);
            c.setBiografia(biografia);
        }catch(Exception e){
            logger.log(Level.SEVERE, "No se ha podido modificar la biografia del usuario");
        }
    }
    
}
