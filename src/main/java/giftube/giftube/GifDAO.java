/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.Gif;
import java.util.List;

/**
 *
 * @author Alberto
 */
public interface GifDAO {
    public enum Tags {ARTE, CINE, AMOR, ANIMALES, CIENCIAS, DEPORTES, SIMBOLOS, RELIGION, TERROR, ANIMACION, ENTRETENIMIENTO, TRISTEZA};
    public Gif buscarGif(Gif _gif);
    public List<Gif> buscaTodos();
    public boolean subirGif(Gif _gif);
    public boolean borrarGif(Gif _gif);
    public void modificarTitulo(Gif _gif, String _titulo);
    public void modificarTag(Gif _gif, Tags _tag);  
}
