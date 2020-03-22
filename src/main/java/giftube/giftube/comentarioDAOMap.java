/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Pacalor
 */

@ApplicationScoped
public class comentarioDAOMap implements Serializable{
    
    Map<Integer,List<Comentario>> DDBB;
    private static final Logger logger = Logger.getLogger(comentarioDAOMap.class.getName());
    private String comentario;
    private List<Comentario> comentarios;

    public comentarioDAOMap() {
        this.DDBB=new HashMap<>();
        this.comentarios=new ArrayList<>();
        this.comentario="";
        
    }
   
    
    public List<Comentario> buscaTodos(int gif){
        if(DDBB.containsKey(gif)){
            comentarios=DDBB.get(gif);
        }else{
            comentarios=new ArrayList<>();
        }

        logger.info("Carga comentarios \n"+comentarios);
        return comentarios;
    }
    
    public void add(Comentario c){
        if(DDBB.containsKey(c.getGif_id())){
            comentarios=DDBB.get(c.getGif_id());
        }else{
            comentarios=new ArrayList<>();
        }
        comentarios.add(c);
        DDBB.put(c.getGif_id(), comentarios);
    }
    
    public boolean alreadyComent(String user,int gif){
        if(DDBB.containsKey(gif)){
            comentarios=DDBB.get(gif);
        }else{
            return true;
        }
        for (Comentario comentario1 : comentarios) {
            if(comentario1.getUser().equals(user)){
                return false;
            }
        }
        return true;
    }
}
