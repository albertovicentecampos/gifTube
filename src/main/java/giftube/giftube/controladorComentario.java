/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author Pacalor
 */

@Named("ctrlCom")
@ViewScoped
public class controladorComentario implements Serializable {
    
    @Inject
    private comentarioDAOMap comment;
    
    @Inject
    private GifDAOjpa gDAO;
    
    @Inject
    private Preferencias prefer;
    
    
    private static final Logger logger = Logger.getLogger(controladorComentario.class.getName());
    private List<Comentario> comentarios;
    
    @Size(min=3,message = "La longitud del comentario debe  ser mayor 2 caracteres")
    private String comentario;
    
    private String nombre;
    private String url;
    private String user;
    private int gif;
    private boolean already;
    private Gif ver;
    Comentario c;
    
    public controladorComentario() {
        this.comentarios=new ArrayList<>();
        this.comentario="";
        this.gif=0;
        this.nombre="prueba";
        this.url="https://media.giphy.com/media/W79wfYWCTWidO/source.gif";
        this.user="error";
    }
    
    @PostConstruct
    private void init() {
        user=prefer.getActualUsuarioid();
    }

    public void recupera(){
        logger.info("carga url");
        url="https://media.giphy.com/media/W79wfYWCTWidO/source.gif";
        comentarios=comment.buscaTodos(gif);
        ver=gDAO.buscarGif(gif);
        url=ver.getUbicacion_gif();
        nombre=ver.getTitulo_gif();
        already=comment.alreadyComent(user, gif);
    }
    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public String crea(){
        logger.info(comentario);
        c=new Comentario(user,gif,comentario, 0);
        comment.add(c);
        return "verGif?zelda="+gif+"&faces-redirect=true";
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        
        this.url = url;
    }

    public int getGif() {
        return gif;
    }

    public void setGif(int gif) {
        this.gif = gif;
    }

    public boolean isAlready() {
        return already && prefer.usuarioVacio();
    }

    public void setAlready(boolean already) {
        this.already = already;
    }
    
}
