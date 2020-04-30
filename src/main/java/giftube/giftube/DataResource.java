/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Pacalor
 */
@Path("/gif") //Acceso /datos/gif
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {
    private static final Logger logger = Logger.getLogger(DataResource.class.getName());
    
    @Inject
    comentarioDAO comentDAO;
    
    @Inject
    GifDAOjpa gifDAO;
    
    @GET
    public List<Gif> listado() {
        logger.info("pedido rest");
        List<Gif> data=gifDAO.todos();
        for (Gif gif1 : data) {
           gif1.setFile_gif(null);
        }
        return data;
    }
    
}
