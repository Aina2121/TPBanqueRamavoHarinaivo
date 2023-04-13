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
import mg.itu.tpbanqueramavoharinaivo.jsf.util.Util;

/**
 *
 * @author 26134
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    @EJB
    private GestionnaireCompte ejb;

    private String nom;

    private int solde;

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String action() {
        boolean erreur = false;
        if (solde < 0) {
            Util.messageErreur("Solde au moins 0!", "Solde au moins 0 !", "formAjout:solde");
            erreur = true;
        }
        if (erreur) {
            return null;
        }
        CompteBancaire c = new CompteBancaire(nom, solde);
        ejb.creerCompte(c);
        Util.addFlashInfoMessage("Compte créé avec succès");

        return "listeComptes?faces-redirect=true";
    }
    
}
