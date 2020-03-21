/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.GifDAO.Tags;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author Alberto
 */


@Entity()
public class Gif{
    @Id
    @Min(1)
    @Max(300)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_gif; ///< ID para identificar el gif (unico para cada gif)
    
    @Size (min = 2, max= 20, message = "La longitud del titulo ${ValidatedValue} debe estar entre {min} y {max} caracteres")
    private String titulo_gif; ///< TITULO de cada gif
    private Tags tag_gif; ///< TAG de cada gif. Se puede entender como la categoria que puede tener el gif
    private String ubicacion_gif; ///< UBICACION del gif donde se encuentra
    
    public Gif(){
        id_gif = 0;
        titulo_gif = "";
        ubicacion_gif = "";
    }
    
    public Gif(int id, String titulo, Tags tag,String  ubicacion ){
        this.id_gif=id;
        this.titulo_gif=titulo;
        this.tag_gif=tag;
        this.ubicacion_gif = ubicacion;
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

    /**
     * 
     * @return 
     */
    public String getUbicacion_gif() {
        return ubicacion_gif;
    }

    /**
     * @param ubicacion_gif the ubicacion_gif to set
     */
    public void setUbicacion_gif(String ubicacion_gif) {
        this.ubicacion_gif = ubicacion_gif;
    }
    
    
    
    
    
}
