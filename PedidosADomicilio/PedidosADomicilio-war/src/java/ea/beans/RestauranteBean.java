/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import ea.ejb.MenuFacade;
import ea.ejb.RestauranteFacade;
import ea.entity.Menu;
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
    
    @EJB
    private MenuFacade menuFacade;
    
    private List<Menu> menus;
    private Restaurante restauranteSeleccionado;
    private List<Restaurante> restaurantes;
    private String cif;
    private String password;
    private String nombre;
    private String direccion;
    private String codpostal = "Código Postal"; 
    private String ciudad;
    private String telefono;
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

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
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

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
        restaurantes = this.restauranteFacade.buscarPorCP(codpostal);        
        return "VistaListaRest.xhtml";
    }

    /*public List<Restaurante> listaRestaurantesBuscados(){
        restaurantes = restauranteFacade.buscarPorCP(codpostal);
        return restaurantes;
    }*/
    
    public String mostrarMenusPlatos(Restaurante restauranteSeleccionado){
        this.restauranteSeleccionado = restauranteSeleccionado;
        return "VistaMenusPlatos.xhtml";       
    }
    
    public List <Menu> listamenus(){
        menus = menuFacade.findByRestaurante(restauranteSeleccionado.getCif());
        return menus;
    }
    
    public String goToVolver(){
        return "VistaListarRest.xhtml";
    }
}
