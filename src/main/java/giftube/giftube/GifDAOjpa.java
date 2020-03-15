/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Alberto
 */
public class GifDAOjpa implements GifDAO {

    private Map<Integer, Gif> gifs = null;

    public GifDAOjpa() {
        gifs = new HashMap<>();
    }

    /**
     * @brief Funcion para buscar un gif en el mapa gifs
     * @param _gif gif a buscar
     * @return Devuelve el gif que ibamos buscando. Si este no lo encuentra el
     * valor es null
     */
    @Override
    public Gif buscarGif(Gif _gif) {
        return gifs.get(_gif.getId_gif());
    }

    /**
     * @brief Función para obtener la lista de todos los gifs disponibles que
     * hay almacenados en el mapa
     * @return Deuelve la lista con todos los gifs
     */
    @Override
    public List<Gif> buscaTodos() {
        return gifs.values().stream().collect(Collectors.toList());
    }

    /**
     * @brief Funcion para subir un gif, añadir un gif al mapa
     * @param _gif Gif que se quiere subir
     * @return True si se sube correctamente, False en caso de que el gif esté ya en el mapa
     */
    @Override
    public boolean subirGif(Gif _gif) {
        if (!gifs.containsKey(_gif.getId_gif())) {
            gifs.put(_gif.getId_gif(), _gif);
            return true;
        }
        return false;
    }

    /**
     * @brief Funcion para borrar un gif, borrar un gif del mapa
     * @param _gif Gif que se quiere borrar 
     * @return Ture si se borra correctamente, False en caso de que el gif no se encuentre dentro del mapa
     */
    @Override
    public boolean borrarGif(Gif _gif) {
        if (gifs.containsKey(_gif.getId_gif())) {
            gifs.remove(_gif.getId_gif());
            return true;
        } else {
            return false;
        }
    }

    /**
     * @brief Funcion para modificar el titulo de un gif
     * @param _gif Gif que se quiere modificar el titulo
     * @param _titulo Titulo nuevo que se quiere poner al gif anterior
     */
    @Override
    public void modificarTitulo(Gif _gif, String _titulo) {
        gifs.get(_gif.getId_gif()).setTitulo_gif(_titulo);
    }

    /**
     * @brief Función para modificar la categoria (Tag) del gif
     * @param _gif Gif que se quiere modificar el tag
     * @param _tag Tag nuevo que se quiere poner al gif anterior
     */
    @Override
    public void modificarTag(Gif _gif, Tags _tag) {
       gifs.get(_gif.getId_gif()).setTag_gif(_tag);
    }

}
