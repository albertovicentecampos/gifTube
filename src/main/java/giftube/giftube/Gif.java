/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.GifDAO.Tags;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Alberto
 */



@Named
@RequestScoped
public class Gif {
    private int id_gif; ///< ID para identificar el gif (unico para cada gif)
    private String titulo_gif; ///< TITULO de cada gif
    private Tags tag_gif; ///< TAG de cada gif. Se puede entender como la categoria que puede tener el gif

    public Gif(int id, String titulo, Tags tag){
        this.id_gif=id;
        this.titulo_gif=titulo;
        this.tag_gif=tag;
    }
    
    /**
     * @return the id_gif
     */
    public int getId_gif() {
        return id_gif;
    }

    /**
     * @param id_gif the id_gif to set
     */
    public void setId_gif(int id_gif) {
        this.id_gif = id_gif;
    }

    /**
     * @return the titulo_gif
     */
    public String getTitulo_gif() {
        return titulo_gif;
    }

    /**
     * @param titulo_gif the titulo_gif to set
     */
    public void setTitulo_gif(String titulo_gif) {
        this.titulo_gif = titulo_gif;
    }

    /**
     * @return the tag_gif
     */
    public Tags getTag_gif() {
        return tag_gif;
    }

    /**
     * @param tag_gif the tag_gif to set
     */
    public void setTag_gif(Tags tag_gif) {
        this.tag_gif = tag_gif;
    }
    
    
}
