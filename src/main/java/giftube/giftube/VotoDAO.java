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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Pacalor
 */
@RequestScoped
@Transactional
public class VotoDAO {
    @PersistenceContext
    private EntityManager em;
    
    private List<Voto> votos;
    
    private static final Logger logger = Logger.getLogger(comentarioDAO.class.getName());
    
    private Voto actualV;
    
    public void add(Voto v){
        try{
            em.persist(v);
        }catch(Exception e) {
            logger.log(Level.SEVERE, "No se pueden escribir el voto", e);
        }
    }
    
    public boolean alreadyVote(String user,int gif){
        try {
             votos=em.createQuery("select c from Voto c where c.gif_id = :gif", Voto.class).setParameter("gif", gif).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pueden recuperar los votos", e);
            votos = new ArrayList<>();
        }
        for (Voto comentario1 : votos) {
            if(comentario1.getUser().equals(user)){
                return false;
            }
        }
        return true;
    }
    
    public void like(String user,int gif){
        Voto aux;
        try {
            aux=em.createQuery("select c from Voto c where c.gif_id = :gif AND c.user = :us", Voto.class).setParameter("gif", gif).setParameter("us", user).getSingleResult();
            aux.setType(1);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pueden recuperar los votos", e);
            votos = new ArrayList<>();
        }
    }
    
    public void dislike(String user,int gif){
        Voto aux;
        try {
            aux=em.createQuery("select c from Voto c where c.gif_id = :gif AND c.user = :us", Voto.class).setParameter("gif", gif).setParameter("us", user).getSingleResult();
            aux.setType(-1);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pueden recuperar los votos", e);
            votos = new ArrayList<>();
        }

    }
    
    public Voto getVoto(String user,int gif){
        Voto aux=new Voto();
        try {
             votos=em.createQuery("select c from Voto c where c.gif_id = :gif", Voto.class).setParameter("gif", gif).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pueden recuperar los votos", e);
            votos = new ArrayList<>();
        }
        for (Voto comentario1 : votos) {
            if(comentario1.getUser().equals(user)){
                return comentario1;
            }
        }
        return aux;
    }
    
}
