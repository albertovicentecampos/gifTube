/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pacalor
 */
@Named("ctrlURL")
@ViewScoped
public class controladorUrl implements Serializable{
    
    @Inject
    private urlDAO enlaces;

    private String url;
    private String nombre;
    public controladorUrl() {
    }
    
    @PostConstruct
    private void init(){
        url="";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void recupera(){
        url= enlaces.busca(nombre);
    }
}
