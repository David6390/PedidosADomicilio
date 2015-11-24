/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.Restaurante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lavitz
 */
@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante> {
    @PersistenceContext(unitName = "PedidosADomicilio-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RestauranteFacade() {
        super(Restaurante.class);
    }
    
}
