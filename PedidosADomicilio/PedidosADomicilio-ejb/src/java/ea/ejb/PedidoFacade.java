/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author lavitz
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {
    @PersistenceContext(unitName = "PedidosADomicilio-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    public List menusMasPedidos(){
        
        List lista = em.createNativeQuery("Select m.DESCRIPCION,count(p.ID_MENU)"
                + " as numero from pedido p join menu m on p.ID_MENU=m.ID_MENU group"
                + " by p.ID_MENU, m.DESCRIPCION order by numero desc").getResultList();
                
        return lista;
    }

    public List restaurantesPopulares() {
    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        List lista = em.createNativeQuery("Select r.NOMBRE,count(p.CIF) as "
                + "numero from pedido p join restaurante r on p.CIF=r.CIF "
                + "group by r.NOMBRE order by numero desc").getResultList();
                
        return lista;
    }
    
}
