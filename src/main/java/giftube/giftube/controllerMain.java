/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jesus
 */
@Named("ctrlMain")
@ViewScoped
public class controllerMain implements Serializable {
    @Inject
    private HttpServletRequest request;
    @Inject
    Preferencias preferencias;
    private static final Logger logger = Logger.getLogger(controllerMain.class.getName());
    @Inject
    private FileUploadView gifs;
    
    public controllerMain() {
    }
    

}
