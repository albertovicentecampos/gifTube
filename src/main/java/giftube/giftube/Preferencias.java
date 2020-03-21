/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jesus
 */
@Named(value = "prefs")
@SessionScoped
public class Preferencias implements Serializable {
    @Inject
    private HttpServletRequest request; //Lo pongo por si acaso.
    
    public Preferencias() {};
    
    private String ActualUsuarioid = "";
    private String gifcargado = "";

    public String getActualUsuarioid() {
        return ActualUsuarioid;
    }

    public void setActualUsuarioid(String ActualUsuarioid) {
        this.ActualUsuarioid = ActualUsuarioid;
    }

    public String getGifcargado() {
        return gifcargado;
    }

    public void setGifcargado(String gifcargado) {
        this.gifcargado = gifcargado;
    }
    
    public String VerGif(String IdGif){
        gifcargado=IdGif;
        return "verGif.jsf";
        
    }
}
