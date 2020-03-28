/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.Gif.Tags;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author Alberto
 */
@Entity()
public class Gif_usuario {

    @Id
    private int id_gif;

    @Id
    @Size(min = 6, max = 13)
    private String usuario_gif;

    @Size(min = 2, max = 20, message = "La longitud del titulo ${ValidatedValue} debe estar entre {min} y {max} caracteres")
    private String titulo_gif; ///< TITULO de cada gif

    private Tags tag_gif; ///< TAG de cada gif. Se puede entender como la categoria que puede tener el gif

    private String ubicacion_gif; ///< UBICACION del gif donde se encuentra

    public Gif_usuario() {
        this.id_gif = 0;
        this.usuario_gif = "";
        this.titulo_gif = "";
        this.ubicacion_gif = "";
    }

    public Gif_usuario(int id_gif, String usuario_gif, String titulo_gif, Gif.Tags tag_gif, String ubicacion_gif) {
        this.id_gif = id_gif;
        this.usuario_gif = usuario_gif;
        this.titulo_gif = titulo_gif;
        this.tag_gif = tag_gif;
        this.ubicacion_gif = ubicacion_gif;
    }

    public int getId_gif() {
        return id_gif;
    }

    public void setId_gif(int id_gif) {
        this.id_gif = id_gif;
    }

    public String getUsuario_gif() {
        return usuario_gif;
    }

    public void setUsuario_gif(String usuario_gif) {
        this.usuario_gif = usuario_gif;
    }

    public String getTitulo_gif() {
        return titulo_gif;
    }

    public void setTitulo_gif(String titulo_gif) {
        this.titulo_gif = titulo_gif;
    }

    public Tags getTag_gif() {
        return tag_gif;
    }

    public void setTag_gif(Tags tag_gif) {
        this.tag_gif = tag_gif;
    }

    public String getUbicacion_gif() {
        return ubicacion_gif;
    }

    public void setUbicacion_gif(String ubicacion_gif) {
        this.ubicacion_gif = ubicacion_gif;
    }
    
}
