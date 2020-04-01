/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jesus
 */
@Named("ctrlMain")
@ViewScoped
public class controllerMain implements Serializable {
    @Inject
    private HttpServletRequest request;
    @Inject
    Preferencias preferencias;
    private static final Logger logger = Logger.getLogger(controllerMain.class.getName());
    @Inject
    private GifDAOjpa gifsDAO;
    
    List<Gif> gifs;

    private Gif gif;
    
    public controllerMain() {
    }
    
    @PostConstruct
    private void init() {
        gif = new Gif();
        gifs = gifsDAO.todos();
    }

    public List<Gif> getGifs() {
        gif.getUbicacion_gif();
        return gifs;
    }

    public Gif getGif() {
        return gif;
    }

    public void setGif(Gif gif) {
        this.gif = gif;
    }
    
    public void recupera() {
        logger.info("Buscando Gif " + gif.getTitulo_gif());
        gif = gifsDAO.buscarGif(gif);
        preferencias.setGifcargado(gif.getId_gif());
    }
    
    public void recupera(Gif _gif) {
        logger.info("Buscando Gif " + gif.getTitulo_gif());
        gif = gifsDAO.buscarGif(_gif);
        preferencias.setGifcargado(gif.getId_gif());

    }

    public String crea() {
        logger.info("Guardando Gif");
        gifsDAO.subirGif(gif);
        return "main1?faces-redirect=true&id=" + gif.getId_gif();
    }

    public void reset() {
        gif.setId_gif(0);
    }

    public void borra(Gif _gif) {
        logger.info("Borrando Gif");
        gifsDAO.borrarGif(_gif);
    }
    public String buscaT(){
    
        return "main1?faces-redirect=true";
    }
}
