/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;


import javax.validation.constraints.Size;

/**
 *
 * @author Pacalor
 */
public class Comentario {
    //@Id  
    @Size(min=6,max=13)
    private String user;
    
    //@Id
    private int gif_id;
    
    @Size(min=3,message = "La longitud del comentario debe ser mayor a 2 caracteres")
    private String comentario;

    private int voto;
    
    public Comentario() {
        this.user = "usuario";
        this.gif_id = -1;
        this.comentario = "prueba de texto, este gif es genial aajajaja me reí muchisimo cuando lo leí y pinté los comentarios =D";
        this.voto=0;
    }

    public Comentario(String user, int gif_id, String comentario, int voto) {
        this.user = user;
        this.gif_id = gif_id;
        this.comentario = comentario;
        this.voto = voto;
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
        return user + ":  " + comentario ;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

}
