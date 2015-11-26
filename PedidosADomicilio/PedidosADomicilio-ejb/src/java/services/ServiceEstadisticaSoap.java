/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ea.ejb.PedidoFacade;
import ea.ejb.UsuarioRegistradoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author David
 */
@Singleton
@LocalBean
public class ServiceEstadisticaSoap {
    @EJB
    private UsuarioRegistradoFacade usuarioRegistradoFacade;
    @EJB
    private PedidoFacade pedidoFacade;
    
    //Devuelve el numero de usuarios del sistema.
    public int getNumUsuarios(){
        int num=-1;
        num = usuarioRegistradoFacade.count();
        return num;
    }
    
    
    public String[] getTopFiveMenus(){
        
        List lista = pedidoFacade.menusMasPedidos();
        
        String[] definitiva;
        definitiva = new String[10];
        for(int i=0;i<5;i++){
            if(i+1>lista.size()){
                break;
            }
            Object[] temp =  (Object[]) lista.get(i);
            int e = i*2;
            definitiva[e]= (String)temp[0];
            definitiva[e+1]= Integer.toString((Integer)temp[1]);
        }
        return definitiva;
    }
}
