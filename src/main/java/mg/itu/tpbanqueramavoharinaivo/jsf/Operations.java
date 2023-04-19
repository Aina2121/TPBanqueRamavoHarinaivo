/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueramavoharinaivo.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import mg.itu.tpbanqueramavoharinaivo.ejb.GestionnaireCompte;
import mg.itu.tpbanqueramavoharinaivo.entities.CompteBancaire;

/**
 *
 * @author ramavo
 */
@Named(value = "operations")
@ViewScoped
public class Operations {

     @EJB
  private GestionnaireCompte ejb;

    private CompteBancaire compteBancaire;

    private Long id;


    public Long getId() {
        return id;
    }

    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public void loadOperations() {
        compteBancaire = ejb.findById(id);
    }
    
}
