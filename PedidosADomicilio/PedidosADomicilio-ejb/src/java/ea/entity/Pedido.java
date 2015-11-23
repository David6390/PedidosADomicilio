/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lavitz
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByCantidadmenu", query = "SELECT p FROM Pedido p WHERE p.cantidadmenu = :cantidadmenu"),
    @NamedQuery(name = "Pedido.findByCantidadplato", query = "SELECT p FROM Pedido p WHERE p.cantidadplato = :cantidadplato"),
    @NamedQuery(name = "Pedido.findByPreciototal", query = "SELECT p FROM Pedido p WHERE p.preciototal = :preciototal"),
    @NamedQuery(name = "Pedido.findByGastosenvio", query = "SELECT p FROM Pedido p WHERE p.gastosenvio = :gastosenvio")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_PEDIDO")
    private String idPedido;
    @Column(name = "CANTIDADMENU")
    private Long cantidadmenu;
    @Column(name = "CANTIDADPLATO")
    private Long cantidadplato;
    @Column(name = "PRECIOTOTAL")
    private Long preciototal;
    @Column(name = "GASTOSENVIO")
    private Long gastosenvio;
    @JoinColumn(name = "DNI", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private UsuarioRegistrado dni;
    @JoinColumn(name = "CIF", referencedColumnName = "CIF")
    @ManyToOne(optional = false)
    private Restaurante cif;
    @JoinColumn(name = "ID_PLATO", referencedColumnName = "ID_PLATO")
    @ManyToOne
    private Plato idPlato;
    @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU")
    @ManyToOne
    private Menu idMenu;

    public Pedido() {
    }

    public Pedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Long getCantidadmenu() {
        return cantidadmenu;
    }

    public void setCantidadmenu(Long cantidadmenu) {
        this.cantidadmenu = cantidadmenu;
    }

    public Long getCantidadplato() {
        return cantidadplato;
    }

    public void setCantidadplato(Long cantidadplato) {
        this.cantidadplato = cantidadplato;
    }

    public Long getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(Long preciototal) {
        this.preciototal = preciototal;
    }

    public Long getGastosenvio() {
        return gastosenvio;
    }

    public void setGastosenvio(Long gastosenvio) {
        this.gastosenvio = gastosenvio;
    }

    public UsuarioRegistrado getDni() {
        return dni;
    }

    public void setDni(UsuarioRegistrado dni) {
        this.dni = dni;
    }

    public Restaurante getCif() {
        return cif;
    }

    public void setCif(Restaurante cif) {
        this.cif = cif;
    }

    public Plato getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Plato idPlato) {
        this.idPlato = idPlato;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ea.entity.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
