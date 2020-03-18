/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.gif;

import giftube.gif.GifDAO;
import giftube.gif.Gif;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

/**
 *
 * @author Alberto
 */

@RequestScoped
@Transactional
public class GifDAOjpa implements GifDAO {

    private final Logger logger = Logger.getLogger(GifDAOjpa.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    private Map<Integer, Gif> gifs = null;

    public GifDAOjpa() {
        gifs = new HashMap<>();
    }

    /**
     * @brief Funcion para buscar un gif en el mapa gifs
     * @param _gif gif a buscar
     * @return Devuelve el gif que ibamos buscando. Si este no lo encuentra el
     * valor es null
     */
    @Override
    public Gif buscarGif(Gif _gif) {
        return em.find(Gif.class, _gif.getId_gif());
    }

    /**
     * @brief Función para obtener la lista de todos los gifs disponibles que
     * hay almacenados en el mapa
     * @return Deuelve la lista con todos los gifs
     */
    @Override
    public List<Gif> buscaTodos() {
        List<Gif> lg = null;
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gif.class));
            Query q = em.createQuery(cq);
            lg = q.getResultList();
        }catch (Exception ex){
                logger.log(Level.SEVERE, ex.getMessage(),ex);
        }
        return lg;
    }

    /**
     * @brief Funcion para subir un gif, añadir un gif al mapa
     * @param _gif Gif que se quiere subir
     * @return True si se sube correctamente, False en caso de que el gif esté ya en el mapa
     */
    @Override
    @Transactional
    public boolean subirGif(Gif _gif) {
        boolean subir = false;
        try{
            em.persist(_gif);
            subir = true;
        }catch (Exception ex){
            logger.log(Level.SEVERE,ex.getMessage(),ex);
        }
        return subir;
    }

    /**
     * @brief Funcion para borrar un gif, borrar un gif del mapa
     * @param _gif Gif que se quiere borrar 
     * @return Ture si se borra correctamente, False en caso de que el gif no se encuentre dentro del mapa
     */
    @Override
    @Transactional
    public boolean borrarGif(Gif _gif) {
        boolean borrado = false;
        try {
            Gif g = null;
            try {
                g = em.getReference(Gif.class, _gif.getId_gif());
                g.getId_gif();
            } catch (EntityNotFoundException ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);

            }
            em.remove(g);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return borrado;
    }

    /**
     * @brief Funcion para modificar el titulo de un gif
     * @param _gif Gif que se quiere modificar el titulo
     * @param _titulo Titulo nuevo que se quiere poner al gif anterior
     */
    @Override
    public void modificarTitulo(Gif _gif, String _titulo) {
        gifs.get(_gif.getId_gif()).setTitulo_gif(_titulo);
    }

    /**
     * @brief Función para modificar la categoria (Tag) del gif
     * @param _gif Gif que se quiere modificar el tag
     * @param _tag Tag nuevo que se quiere poner al gif anterior
     */
    @Override
    public void modificarTag(Gif _gif, Tags _tag) {
       gifs.get(_gif.getId_gif()).setTag_gif(_tag);
    }

}
