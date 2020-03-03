/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RatingView {
     
    private Integer rating1;   
    private static final Logger logger = Logger.getLogger(RatingView.class.getName());

    public RatingView() {//en el constructor debe llamar a la base de datos para cargar numero de estrellas
        this.rating1 = 3;
    }
     
    public void onrate(){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:");
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
    }
 
    public Integer getRating1() {
        return rating1;
    }
 
    public void setRating1(Integer rating1) {
        this.rating1 = rating1;
    }
    
    
    public void copy(){
        logger.info("he copiado?");
    }

}