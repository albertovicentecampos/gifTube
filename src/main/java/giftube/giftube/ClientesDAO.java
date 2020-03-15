/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.Date;
import java.util.List;

/**
 *
 * @author miguel
 */
public interface ClientesDAO {
    public Cliente buscaCliente(Cliente cliente);
    public List<Cliente> buscaTodos();
    public boolean altaCliente(Cliente cliente);
    public boolean borraCliente(Cliente cliente);
    public void modificaNombre(Cliente cliente, String nombre);
    public void modificaApellidos(Cliente cliente, String apellidos);
    public void modificaFechaNacimiento(Cliente cliente, Date fecha);
    public enum Genero{ HOMBRE, MUJER, OTRO };
    public void modificaGenero(Cliente cliente, Genero genero);
}