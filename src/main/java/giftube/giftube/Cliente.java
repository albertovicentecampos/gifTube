/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.Date;
import static giftube.giftube.ClientesDAO.Genero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author miguel
 */
public class Cliente {
    @NotEmpty
    @Size(min=6,max=13)
    private String usuario; ///< usuario único por cliente, nos sirve para identificar al cliente
    
    @Size(min=8,max=12)
    @NotEmpty
    private String password;///< contraseña del cliente
    
    @Size(max=20)
    @NotEmpty
    private String nombre;///< nombre del cliente
    
    @Size(max=30)
    @NotEmpty
    private String apellidos;///< apellidos del cliente
    
    @Past
    private Date fechaNacimiento;///< fecha de nacimiento del cliente
    
    @Size(max=200)
    private String biografia;///< biografia de la cuenta del cliente
    
    private Genero genero;///< genero del cliente
    
    
    public Cliente(String usuario, String password, String nombre, String apellidos) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = null;
        this.biografia = null;
        this.genero = null;
        this.fechaNacimiento = null;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}
