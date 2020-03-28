/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import giftube.giftube.Gif;
import giftube.giftube.Gif.Tags;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    private Gif_usuario gifUsuario;
    private Gif gif;

    public GifDAOjpa() {
        gifUsuario = new Gif_usuario();
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

//    @Transactional
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

    public List<Gif> buscaTodos(String usuario) {
        List<Gif> lg = null;
        String usuarioSQL = "Select g from Gif g where g.usuario_gif=:usuario";
        try {
//            TypedQuery<Gif> g = em.createQuery(usuarioSQL, Gif.class)
//                    .setParameter("usuario", request.getParameter("usuario"));
//            lg = g.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lg;
    }

    public void modificarTitulo(Gif _gif, String _titulo) {
        String gifSQL = "update Gif g set g.titulo_gif=:titulo " + "where g.id_gif=_gif.id_gif";
        try {
            Query q = em.createQuery(gifSQL);
            int updateCount = q.setParameter("titulo", _titulo).executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

//        try {
//            _gif.setTitulo_gif(_titulo);
//            _gif = em.merge(_gif);
//
//        } catch (Exception ex) {
//            logger.log(Level.SEVERE, ex.getMessage());
//        }
    }

    public void modificarTag(Gif _gif, Tags _tag) {
        try {
            Gif g = null;
            g = em.find(Gif.class, _gif.getId_gif());
            g.setTag_gif(_tag);
            g = em.merge(g);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
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
}
