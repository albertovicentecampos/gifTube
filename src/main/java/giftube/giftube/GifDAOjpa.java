/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.GifDAO;
import giftube.giftube.Gif;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 *
 * @author Alberto
 */
@ApplicationScoped
@Transactional

public class GifDAOjpa implements GifDAO {

    private final Logger logger = Logger.getLogger(GifDAOjpa.class.getName());

//    @PersistenceContext
//    private EntityManager em;
    private ArrayList<Gif> gifs = null;
    private int idGif = 1;

    //private Map<Integer, Gif> gifs = null;
    public GifDAOjpa() {
        if (gifs == null) {
            gifs = new ArrayList<>();
            gifs.add(new Gif(idGif++, "Titulo1", Tags.AMOR, "GifTube.git\\src\\main\\webapp\\resources\\images\\nature1.jpg"));
            gifs.add(new Gif(idGif++, "Titulo2", Tags.AMOR, "GifTube.git\\src\\main\\webapp\\resources\\images\\nature1.jpg"));
        }
    }

    /**
     * @brief Funcion para buscar un gif en el mapa gifs
     * @param _gif gif a buscar
     * @return Devuelve el gif que ibamos buscando. Si este no lo encuentra el
     * valor es null
     */
    @Override
    public Gif buscarGif(Gif _gif) {
        Gif encontrado = null;
        for (Gif g : gifs) {
            if (g.getId_gif() == _gif.getId_gif()) {
                encontrado = new Gif(g.getId_gif(), g.getTitulo_gif(), g.getTag_gif(), g.getUbicacion_gif());
            }
        }
        return encontrado;

        //return gifs.get(_gif.getId_gif());
        //return em.find(Gif.class, _gif.getId_gif());
    }

    /**
     * @brief Función para obtener la lista de todos los gifs disponibles que
     * hay almacenados en el mapa
     * @return Deuelve la lista con todos los gifs
     */
    @Override
    public List<Gif> buscaTodos() {

        return gifs;

        //return gifs.values().stream().collect(Collectors.toList());
        /*
        List<Gif> lg = null;
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gif.class));
            Query q = em.createQuery(cq);
            lg = q.getResultList();
        }catch (Exception ex){
                logger.log(Level.SEVERE, ex.getMessage(),ex);
        }
        return lg;*/
    }

    /**
     * @brief Funcion para subir un gif, añadir un gif al mapa
     * @param _gif Gif que se quiere subir
     * @return True si se sube correctamente, False en caso de que el gif esté
     * ya en el mapa
     */
    @Override
    //@Transactional
    public boolean subirGif(Gif _gif) {
        Gif ng = new Gif(_gif.getId_gif(), _gif.getTitulo_gif(), _gif.getTag_gif(), _gif.getUbicacion_gif());
        ng.setId_gif(idGif);
        gifs.add(ng);
        _gif.setId_gif(idGif);
        idGif++;
        return true;

//        if(!gifs.containsKey(_gif.getId_gif())){
//            gifs.put(_gif.getId_gif(), _gif);
//            return true;
//        }else{
//            return false;
//        }
        /*
        boolean subir = false;
        try{
            em.persist(_gif);
            subir = true;
        }catch (Exception ex){
            logger.log(Level.SEVERE,ex.getMessage(),ex);
        }
        return subir;*/
    }

    /**
     * @brief Funcion para borrar un gif, borrar un gif del mapa
     * @param _gif Gif que se quiere borrar
     * @return Ture si se borra correctamente, False en caso de que el gif no se
     * encuentre dentro del mapa
     */
    @Override
//    @Transactional
    public boolean borrarGif(Gif _gif) {
        boolean result = false;
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == _gif.getId_gif()) {
                gifs.remove(i);
                result = true;
            }
        }
        return result;

//        if(gifs.containsKey(_gif.getId_gif())){
//            gifs.remove(_gif.getId_gif());
//            return true;
//        }else{
//            return false;
//        }
        /*
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
        return borrado;*/
    }

    /**
     * @brief Funcion para modificar el titulo de un gif
     * @param _gif Gif que se quiere modificar el titulo
     * @param _titulo Titulo nuevo que se quiere poner al gif anterior
     */
    @Override
    public void modificarTitulo(Gif _gif, String _titulo) {
        System.out.println("EntraTituloG");
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == _gif.getId_gif()) {
                System.out.println("Lo cambia");
                gifs.get(i).setTitulo_gif(_titulo);
            }
        }

        //gifs.get(_gif.getId_gif()).setTitulo_gif(_titulo);
    }

    /**
     * @brief Función para modificar la categoria (Tag) del gif
     * @param _gif Gif que se quiere modificar el tag
     * @param _tag Tag nuevo que se quiere poner al gif anterior
     */
    @Override
    public void modificarTag(Gif _gif, Tags _tag) {
        System.out.println("EntraTAG");
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == _gif.getId_gif()) {
                System.out.println("Lo cambia");
                gifs.get(i).setTag_gif(_tag);
            }
        }
        //gifs.get(_gif.getId_gif()).setTag_gif(_tag);

        //gifs.get(_gif.getId_gif()).setTag_gif(_tag);
    }

    public boolean guarda(Gif _gif) {
        boolean result = false;
        Gif nc = new Gif(_gif.getId_gif(), _gif.getTitulo_gif(), _gif.getTag_gif(), _gif.getUbicacion_gif());
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == nc.getId_gif()) {
                gifs.set(i, nc);
                result = true;
            }
        }
        return result;
    }

}
