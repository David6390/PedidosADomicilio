/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import ea.ejb.RestauranteFacade;
import ea.entity.Restaurante;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MJ
 */
@ManagedBean
@RequestScoped
public class RestauranteBean {
    
    @EJB
    private RestauranteFacade restauranteFacade;
    
    private Restaurante restauranteSeleccionado;
    private List<Restaurante> listaRestaurantes;
    private String cif;
    private String password;
    private String nombre;
    private String direccion;
    private Integer codpostal;
    private String ciudad;
    private Long telefono;
    private String email;
    private String latitud;
    private String longitud;
    
    public RestauranteBean() {
    }

    public Restaurante getRestauranteSeleccionado() {
        return restauranteSeleccionado;
    }

    public void setRestauranteSeleccionado(Restaurante restauranteSeleccionado) {
        this.restauranteSeleccionado = restauranteSeleccionado;
    }

    public List<Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public void setListaRestaurantes(List<Restaurante> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
    public String doBuscar() {        
        //listaRestaurantes = this.restauranteFacade.buscarRestaurante(codpostal);        
        return "listarRestaurantes.xhtml";
    }

    public List<Restaurante> listaRestaurantesBuscados(){
        List<Restaurante> restaurantes = listaRestaurantes;
        return restaurantes;
    }
    
    public String mostrarmostrarRealizarPedido(Restaurante restauranteSeleccionado){
        this.restauranteSeleccionado = restauranteSeleccionado;
        return "realizarPedido.xhtml";       
    }
}
