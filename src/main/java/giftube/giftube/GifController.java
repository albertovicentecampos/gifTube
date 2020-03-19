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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Alberto
 */

@Named(value = "gifCtrl")
@ViewScoped
public class GifController implements Serializable {
    
    private final Logger logger  = Logger.getLogger(GifController.class.getName());
    
    @Inject 
    private GifDAO gifDAO;
   
    public GifController(){
        
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    
    
}
