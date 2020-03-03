/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author XeXu
 */
@Named
@ViewScoped
public class CounterView implements Serializable {

    private int number;

    public int getNumber() {
        return number;
    }

    public void increment() {
        number++;
    }
}
