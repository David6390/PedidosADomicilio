/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import services.ServiceEstadisticaSoap;

/**
 *
 * @author David
 */
@WebService(serviceName = "ServicioEstadisticaSOAP")
public class ServicioEstadisticaSOAP {
    @EJB
    private ServiceEstadisticaSoap ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getNumUsuarios")
    public int getNumUsuarios() {
        return ejbRef.getNumUsuarios();
    }

    @WebMethod(operationName = "getTopFiveMenus")
    public String[] getTopFiveMenus() {
        return ejbRef.getTopFiveMenus();
    }
    
}
