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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pacalor
 */

@Named("ctrlCom")
@ViewScoped
public class controladorComentario implements Serializable {
    
    @Inject
    private comentarioDAO comment;
    
    private static final Logger logger = Logger.getLogger(controladorComentario.class.getName());
    private List<String> comentarios;
    public controladorComentario() {
    }
    
    @PostConstruct
    private void init() {

    }
}
