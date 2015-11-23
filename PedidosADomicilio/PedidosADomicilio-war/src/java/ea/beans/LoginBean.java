/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.beans;

import ea.ejb.UsuarioRegistradoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author lavitz
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    @EJB
    private UsuarioRegistradoFacade usuarioRegistradoFacade;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public UsuarioRegistradoFacade getUsuarioRegistradoFacade() {
        return usuarioRegistradoFacade;
    }

    public void setUsuarioRegistradoFacade(UsuarioRegistradoFacade usuarioRegistradoFacade) {
        this.usuarioRegistradoFacade = usuarioRegistradoFacade;
    }
    
    
    
}
