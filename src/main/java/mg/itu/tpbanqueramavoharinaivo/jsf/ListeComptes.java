/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueramavoharinaivo.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpbanqueramavoharinaivo.ejb.GestionnaireCompte;
import mg.itu.tpbanqueramavoharinaivo.entities.CompteBancaire;
import mg.itu.tpbanqueramavoharinaivo.jsf.util.Util;

/**
 *
 * @author ramavo
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {
 private List<CompteBancaire> comptes;

    @EJB
    GestionnaireCompte ejb;
    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getComptes() {
        if(comptes == null) 
            comptes = ejb.getAllComptes();
        return comptes;
    }
    
    public String supprimerCompte(CompteBancaire compteBancaire) {
        ejb.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }
}
