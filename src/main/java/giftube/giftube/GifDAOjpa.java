/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.Gif;
import giftube.giftube.Gif.Tags;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 *
 * @author Alberto
 */
@ApplicationScoped
@Transactional

public class GifDAOjpa implements Serializable {

    private final Logger logger = Logger.getLogger(GifDAOjpa.class.getName());

//    @PersistenceContext
//    private EntityManager em;
    //Map<String, List<Gif>> mapa_gifs;
    
    private Gif gif;
    private List<Gif> gifs = null;
    private int idGif = 1;

    public GifDAOjpa() {
        if (gifs == null) {
            //this.mapa_gifs = new HashMap<>();
            gif = new Gif();
            gifs = new ArrayList<>();
            gifs.add(new Gif("USUARIO1", idGif++, "Titulo1", Tags.AMOR, "null.gif"));
            gifs.add(new Gif("USUARIO1", idGif++, "Titulo2", Tags.AMOR, "null.gif"));

        }
    }

    public Gif buscarGif(Gif _gif) {

        for (Gif g : gifs) {
            if (g.getId_gif() == _gif.getId_gif()) {
                gif = new Gif(g.getUsuario_gif(), g.getId_gif(), g.getTitulo_gif(), g.getTag_gif(), g.getUbicacion_gif());
            }
        }

        return gif;

//        if (mapa_gifs.containsKey(_gif.getUsuario_gif())) {
//            gifs = mapa_gifs.get(_gif.getUsuario_gif());
//        } else {
//            gifs = new ArrayList<>();
//        }
//
//        for (Gif g : gifs) {
//            if (g.getId_gif() == _gif.getId_gif()) {
//                gif = new Gif(g.getUsuario_gif(), g.getId_gif(), g.getTitulo_gif(), g.getTag_gif(), g.getUbicacion_gif());
//            }
//        }
//        return gif;
        //return gifs.get(_gif.getId_gif());
        //return em.find(Gif.class, _gif.getId_gif());
    }

    public Gif buscarGif(int _gif) {
        Gif encontrado = null;

        for (Gif g : gifs) {
            if (g.getId_gif() == _gif) {
                encontrado = new Gif(g.getUsuario_gif(), g.getId_gif(), g.getTitulo_gif(), g.getTag_gif(), g.getUbicacion_gif());
            }
        }
        return encontrado;

        //return gifs.get(_gif.getId_gif());
        //return em.find(Gif.class, _gif.getId_gif());
    }

    public List<Gif> todos() {
        return gifs;
    }

    public List<Gif> buscaTodos(String usuario) {

        List<Gif> lista_usuario_gifs = new ArrayList<>();
        for (Gif g : gifs) {
            if (g.getUsuario_gif().equals(usuario)) {
                lista_usuario_gifs.add(g);
            }
        }

        return lista_usuario_gifs;

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

    public boolean subirGif(Gif _gif) {

//        
//        if (mapa_gifs.containsKey(_gif.getUsuario_gif())) {
//            gifs = mapa_gifs.get(_gif.getUsuario_gif());
//            gifs.add(_gif);
//            mapa_gifs.put(_gif.getUsuario_gif(), gifs);
//            subir = true; 
//        } else {
//            gifs = new ArrayList<>();
//        }
        Gif ng = new Gif(_gif.getUsuario_gif(), _gif.getId_gif(), _gif.getTitulo_gif(), _gif.getTag_gif(), _gif.getUbicacion_gif());
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

//    @Transactional
    public boolean borrarGif(Gif _gif) {

        boolean result = false;
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == _gif.getId_gif() && gifs.get(i).getUsuario_gif() == _gif.getUsuario_gif()) {
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

    public void modificarTitulo(Gif _gif, String _titulo) {

        System.out.println("EntraTituloG");
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == _gif.getId_gif()) {
                System.out.println("Lo cambia");
                gifs.get(i).setTitulo_gif(_titulo);
            }
        }

//        if (mapa_gifs.containsKey(_gif.getUsuario_gif())) {
//            System.out.println("EntraTituloG");
//            gifs = mapa_gifs.get(_gif.getUsuario_gif());
//        } else {
//            gifs = new ArrayList<>();
//        }
//
//        for (int i = 0; i < gifs.size(); i++) {
//            if (gifs.get(i).getId_gif() == _gif.getId_gif()) {
//                System.out.println("Lo cambia");
//                gifs.get(i).setTitulo_gif(_titulo);
//
//            }
//        }
        //gifs.get(_gif.getId_gif()).setTitulo_gif(_titulo);
    }

    public void modificarTag(Gif _gif, Tags _tag) {

        System.out.println("EntraTAG");
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == _gif.getId_gif()) {
                System.out.println("Lo cambia");
                gifs.get(i).setTag_gif(_tag);
            }
        }

//        if (mapa_gifs.containsKey(_gif.getUsuario_gif())) {
//            System.out.println("EntraTAG");
//            gifs = mapa_gifs.get(_gif.getUsuario_gif());
//        } else {
//            gifs = new ArrayList<>();
//        }
//
//        for (int i = 0; i < gifs.size(); i++) {
//            if (gifs.get(i).getId_gif() == _gif.getId_gif()) {
//                System.out.println("Lo cambia");
//                gifs.get(i).setTag_gif(_tag);
//
//            }
//        }
        //gifs.get(_gif.getId_gif()).setTag_gif(_tag);
        //gifs.get(_gif.getId_gif()).setTag_gif(_tag);
    }

    public boolean guarda(Gif _gif) {
        boolean result = false;
        Gif nc = new Gif(_gif.getUsuario_gif(),_gif.getId_gif(), _gif.getTitulo_gif(), _gif.getTag_gif(), _gif.getUbicacion_gif());
        for (int i = 0; i < gifs.size(); i++) {
            if (gifs.get(i).getId_gif() == nc.getId_gif()) {
                gifs.set(i, nc);
                result = true;
            }
        }
        return result;

    }

}
