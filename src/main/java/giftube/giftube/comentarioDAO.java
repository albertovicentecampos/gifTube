/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.Size;

/**
 *
 * @author Pacalor
 */

@RequestScoped
@Transactional
public class comentarioDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    private String comentario;
    private List<Comentario> comentarios;
    
    private static final Logger logger = Logger.getLogger(comentarioDAO.class.getName());
    
    public List<Comentario> buscaTodos(){
        try {
             comentarios=em.createQuery("select c from Comentario c", Comentario.class).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pueden recuperar los comentarios", e);
            comentarios = new ArrayList<>();
        }
        return comentarios;
    }
    public List<Comentario> buscaTodos(int gif){
        try {
             comentarios=em.createQuery("select c from Comentario c where c.gif_id = :gif", Comentario.class).setParameter("gif", gif).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pueden recuperar los comentarios", e);
            comentarios = new ArrayList<>();
        }
        return comentarios;
    }
    
    public void add(Comentario c){
        em.persist(c);
    }
    
    public boolean alreadyComent(String user,int gif){
        try {
             comentarios=em.createQuery("select c from Comentario c where c.gif_id = :gif", Comentario.class).setParameter("gif", gif).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pueden recuperar los comentarios", e);
            comentarios = new ArrayList<>();
        }
        for (Comentario comentario1 : comentarios) {
            if(comentario1.getUser().equals(user)){
                return false;
            }
        }
        return true;
    }
    
}
