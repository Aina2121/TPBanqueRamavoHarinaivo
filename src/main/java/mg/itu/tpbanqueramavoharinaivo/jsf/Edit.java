/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueramavoharinaivo.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.itu.tpbanqueramavoharinaivo.ejb.GestionnaireCompte;
import mg.itu.tpbanqueramavoharinaivo.entities.CompteBancaire;
import mg.itu.tpbanqueramavoharinaivo.jsf.util.Util;

/**
 *
 * @author ramavo
 */
@Named(value = "edit")
@ViewScoped
public class Edit implements Serializable {

     @EJB
    private GestionnaireCompte ejb;

    private CompteBancaire compte;

    private Long id;

    /**
     * Creates a new instance of Edit
     */
    public Edit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }


    public void loadCompte() {
        compte = ejb.findById(id);
    }

    public String edit(){
         boolean erreur = false;
        if (compte.getSolde() < 0) {
            Util.messageErreur("Solde négatif!", "Solde négatif !", "formEdit:solde");
            erreur = true;
        }
        if (erreur) {
            return null;
        }
       ejb.update(compte);
       Util.addFlashInfoMessage("Changement enregistré sur le compte de " + compte.getNom());
       return "listeComptes?faces-redirect=true"; 
    }
    
}
