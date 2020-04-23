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
public class Voto {
    
    @Id  
    @Size(min=6,max=13)
    private String user;
    
    @Id
    private int gif_id;

    private int type;
    
    public Voto() {
        this.user = "usuario";
        this.gif_id = -1;
        this.type=0;
    }

    public Voto(String user, int gif_id,int type) {
        this.user = user;
        this.gif_id = gif_id;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
   
}
