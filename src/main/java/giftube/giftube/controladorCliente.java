package giftube.giftube;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author miguel
 */
@Named("ctrlCliente")
@ViewScoped
public class controladorCliente implements Serializable {

    @Inject
    private ClienteDAOJPA clienteDAO;

    @Inject
    private Preferencias pref;
    
    @Inject
    private HttpServletRequest request;

    private static final Logger logger = Logger.getLogger(controladorCliente.class.getName());

    private Cliente cliente;

    public controladorCliente() {
    }

    @PostConstruct
    public void init() {
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

    public String crea() {
        logger.info("Creando cliente ");
        if (clienteDAO.altaCliente(cliente)) {
            logger.info("Nombre: " + cliente.getNombre() + " Apellidos: " + cliente.getApellidos()
                    + " Usuario: " + cliente.getUsuario());
            return "login?faces-redirect=true";
        } else {
            return "";
        }
    }

    public String borra() throws ServletException {
        logger.info("Borrando cliente");
        cliente = pref.getC();
        logger.info("Usuario: " + cliente.getUsuario());
        clienteDAO.borraCliente(cliente);
        logger.info("Cliente borrado: Usuario: " + cliente.getUsuario() + " Nombre: " + cliente.getNombre());
        pref.logout();
        pref.loggout();
        return "main1?faces-redirect=true";
    }

    public String login() throws ServletException {
        try{
        Cliente clienteLogeado = clienteDAO.buscaCliente(cliente);
        if (clienteLogeado == null) {
            logger.info("No existe ningun cliente con el usuario: " + cliente.getUsuario());
        } else {
            if (clienteLogeado.getPassword() != cliente.getPassword()) {
                logger.info("Usuario " + cliente.getUsuario() + " logeado correctamente");
                pref.setActualUsuarioid(clienteLogeado.getUsuario());
                pref.setC(clienteLogeado);
                return "main1?faces-redirect=true";
            } else {
                logger.info("Contraseña incorrecta");
            }
        }}
        catch(Exception e){ pref.logout();
        pref.loggout();}
        return "main1?faces-redirect=true";
    }

   

    public String editarNombre() {
        logger.info("Editando nombre");
        clienteDAO.modificaNombre(pref.getActualUsuarioid(), cliente.getNombre());
        logger.info("nuevo nombre: " + cliente.getNombre());
        return "configuracion?faces-redirect=true";
    }

    public String editarApellidos() {
        logger.info("Editando apellidos");
        clienteDAO.modificaApellidos(pref.getActualUsuarioid(), cliente.getApellidos());
        logger.info("Nuevos apellidos: " + cliente.getApellidos());
        return "configuracion?faces-redirect=true";
    }

    public String editarGenero() {
        logger.info("Editando genero");
        clienteDAO.modificaGenero(pref.getActualUsuarioid(), cliente.getGenero());
        return "configuracion?faces-redirect=true";
    }

    public String editarFechaNacimiento() {
        logger.info("Editando fecha de nacimiento");
        clienteDAO.modificaFechaNacimiento(pref.getActualUsuarioid(), cliente.getFechaNacimiento());
        return "configuracion?faces-redirect=true";
    }

    public String editarBiografia() {
        logger.info("Editando biografia");
        clienteDAO.modificaBiografia(pref.getActualUsuarioid(), cliente.getBiografia());
        return "configuracion?faces-redirect=true";
    }

    public String editarTodo() {
        editarNombre();
        editarApellidos();
        editarGenero();
        editarFechaNacimiento();
        editarBiografia();
        pref.setC(cliente);
        return "configuracion?faces-redirect=true";
    }
}
