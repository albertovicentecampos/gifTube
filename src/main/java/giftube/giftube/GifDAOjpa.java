/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.Gif.Tags;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Alberto
 */
@ApplicationScoped
@Transactional
public class GifDAOjpa implements Serializable {

    private final Logger logger = Logger.getLogger(GifDAOjpa.class.getName());

    @PersistenceContext
    private EntityManager em;

    private Gif gif;

    public GifDAOjpa() {
        gif = new Gif();
    }

    public Gif buscarGif(Gif _gif) {
        return em.find(Gif.class, _gif.getId_gif());
    }

    public Gif buscarGif(int _gif) {
        return em.find(Gif.class, _gif);
    }

    public List<Gif> todos() {
        List<Gif> lg = null;
        try {
            Query q = em.createQuery("Select g from Gif g", Gif.class);
            lg = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lg;
    }
    
    public boolean subirGif(Gif _gif) {
        boolean subir = false;
        try {
            em.persist(_gif);
            subir = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return subir;
    }

    public boolean borrarGif(Gif _gif) {
        boolean borrado = false;
        try {
            Gif g = null;
            g = em.find(Gif.class, _gif.getId_gif());
            em.remove(g);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
        return borrado;
    }

    public List<Gif> gifBuscaUsuario(String usuario) {
        List<Gif> lg = null;
        String usuarioJSQL = "Select g from Gif g where g.usuario_gif=:us";
        try {
            lg = em.createQuery(usuarioJSQL, Gif.class).setParameter("us", usuario).getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lg;
    }

    public void modificarTitulo(int id_gif, String _titulo) {
        try {
            Gif g = em.find(Gif.class, id_gif);
            g.setTitulo_gif(_titulo);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se ha podido realizar el cambio de titulo para el gif");
        }
    }

    public void modificarTag(int id_gif, Tags _tag) {
        try {
            Gif g = em.find(Gif.class, id_gif);
            g.setTag_gif(_tag);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se ha podido realizar el cambio de tag para el gif");
        }
    }

    public boolean guarda(Gif _gif) {
        boolean guardado = false;
        try {
            _gif = em.merge(_gif);
            guardado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return guardado;
    }
    
    public void modificarLike(int id_gif, Integer _like) {
        try {
            Gif g = em.find(Gif.class, id_gif);
            g.setLikes(_like);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se ha podido realizar el cambio de tag para el gif");
        }
    }
    public void modificarDislike(int id_gif, Integer _dislike) {
        try {
            Gif g = em.find(Gif.class, id_gif);
            g.setDislikes(_dislike);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se ha podido realizar el cambio de tag para el gif");
        }
    }
}
