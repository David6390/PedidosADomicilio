/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.UsuarioRegistrado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lavitz
 */
@Stateless
public class UsuarioRegistradoFacade extends AbstractFacade<UsuarioRegistrado> {
    @PersistenceContext(unitName = "PedidosADomicilio-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRegistradoFacade() {
        super(UsuarioRegistrado.class);
    }
    
    public UsuarioRegistrado usuarioIsRegistrado(String email,String password){
        UsuarioRegistrado usuario;
        List<UsuarioRegistrado> listaUsuarios;
        
        Query q;
        
        q = em.createQuery("select u from USUARIO_REGISTRADO WHERE u.EMAIL = :email and u.PASSWORD = :password");
        q.setParameter("email", email );
        q.setParameter("password",password);
        
        listaUsuarios = q.getResultList();
        
        if (!listaUsuarios.isEmpty()){
            usuario = listaUsuarios.get(0);
        }
        else{
            usuario = null;
        }
        
        return usuario;
                
    }
    
}
