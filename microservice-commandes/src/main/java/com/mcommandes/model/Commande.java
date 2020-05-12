package com.mcommandes.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="commande")
public class Commande {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "productId", nullable = false)
    private Integer productId;
    @Column(name = "dateCommande", nullable = false)
    private Date dateCommande;
    @Column(name = "quantite", nullable = false)
    private Integer quantite;
    @Column(name = "commandePayee", nullable = false)
    private Boolean commandePayee;

    public Commande() {
    }

//    public Commande(int id, Integer productId, Date dateCommande, Integer quantite, Boolean commandePayee) {
//        this.id = id;
//        this.productId = productId;
//        this.dateCommande = dateCommande;
//        this.quantite = quantite;
//        this.commandePayee = commandePayee;
//    }

    public int getId() {
        return id;
    }

    public Commande(Integer productId, Date dateCommande, Integer quantite, Boolean commandePayee) {
		super();
		this.productId = productId;
		this.dateCommande = dateCommande;
		this.quantite = quantite;
		this.commandePayee = commandePayee;
	}

	public void setId(int id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Boolean getCommandePayee() {
        return commandePayee;
    }

    public void setCommandePayee(Boolean commandePayee) {
        this.commandePayee = commandePayee;
    }

    @Override
    public String toString() {
        return "commande{" +
                "id=" + id +
                ", productId=" + productId +
                ", dateCommande=" + dateCommande +
                ", quantite=" + quantite +
                ", commandePayee=" + commandePayee +
                '}';
    }
}
