/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author Pacalor
 */
@Entity
public class Comentario {
    @Id  
    @Size(min=6,max=13)
    private String user;
    
    @Id
    private int gif_id;
    
    @Size(min=2,message = "La longitud del comentario debe  ser mayor {max} caracteres")
    private String comentario;

    public Comentario() {
        this.user = "";
        this.gif_id = -1;
        this.comentario = "";
    }

    public Comentario(int id_user, int gif_id, String comentario) {
        this.user = user;
        this.gif_id = gif_id;
        this.comentario = comentario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getGif_id() {
        return gif_id;
    }

    public void setGif_id(int gif_id) {
        this.gif_id = gif_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return user + ":  " + comentario + "}";
    }
    
    
}
