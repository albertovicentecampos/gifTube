/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author XeXu
 */
@Named
@RequestScoped
public class SearchView {

    private String text1;


    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }


}
