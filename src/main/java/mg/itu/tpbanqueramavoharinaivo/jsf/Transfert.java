/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueramavoharinaivo.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.tpbanqueramavoharinaivo.ejb.GestionnaireCompte;
import mg.itu.tpbanqueramavoharinaivo.entities.CompteBancaire;

/**
 *
 * @author ramavo
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {
 @EJB
    private GestionnaireCompte ejb;

    private Long idSource;

    private Long idDestination;

    private int montant;

    /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }


    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String transferer(){
        CompteBancaire source = ejb.findById(idSource);
        CompteBancaire destination = ejb.findById(idDestination);
        ejb.transferer(source, destination, montant);
        return "listeComptes?faces-redirect=true";
    }
    
}
