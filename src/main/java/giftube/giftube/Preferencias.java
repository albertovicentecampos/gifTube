/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
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
    private int gifcargado = 0;
    
    private ArrayList<Gif> buscados;
    
    private Cliente c;

    private Gif g; 

    public Gif getG() {
        return g;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }
    
    
    public String gifEdicion(Gif _g){
        g = _g;
        return "edita_gif?faces-redirect=true";
    }

    public String getActualUsuarioid() {
        return ActualUsuarioid;
    }

    public void setActualUsuarioid(String ActualUsuarioid) {
        this.ActualUsuarioid = ActualUsuarioid;
    }

    public int getGifcargado() {
        return gifcargado;
    }

    public void setGifcargado(int gifcargado) {
        this.gifcargado = gifcargado;
    }
    
    public String SeleccionarGif(int IdGif){
        gifcargado=IdGif;
        return "verGif.jsf";

        
    }
    
    public boolean usuarioVacio(){
        return !ActualUsuarioid.equals("");
    }

    public boolean usuario(){
        return ActualUsuarioid.equals("");
    }

    public String loggout(){
        ActualUsuarioid="";
        return "main1?faces-redirect=true";
    }
    
     public String logout() throws ServletException {
        try{
            request.logout();
            request.getSession().invalidate();
        }catch(Exception e){
        
        }
        return "main1?faces-redirect=true";
    }

    public ArrayList<Gif> getBuscados() {
        return buscados;
    }

    public void setBuscados(ArrayList<Gif> buscados) {
        this.buscados = buscados;
    }
    
}
