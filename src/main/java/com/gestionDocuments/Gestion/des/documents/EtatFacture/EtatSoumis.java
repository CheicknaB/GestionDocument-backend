package com.gestionDocuments.Gestion.des.documents.EtatFacture;

import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;

public class EtatSoumis extends EtatFacture{
    public EtatSoumis(Facture1 facture1) {
        super(facture1);
        System.out.println("ETAT ACTUEL ===> SOUMIS \n");
    }

    @Override
    public Facture1 soumettre() {
        return this.facture;
    }

    @Override
    public Facture1 enAttente() {
        this.facture.setEtat(EtatFactureEnum.EN_ATTENTE);
        this.facture.setEtatFacture(new EtatEnAttente(facture));
        System.out.println("Soumis --- > En attente");
        return this.facture;
    }

    @Override
    public Facture1 valider() {
        this.facture.setEtat(EtatFactureEnum.VALIDE);
        this.facture.setEtatFacture(new EtatValide(facture));
        System.out.println("Soumis --- > VALIDE ===> voici etat actuel mis à jour :  "+facture.getEtat());
        return this.facture;
    }

    @Override
    public Facture1 rejeter() {
        this.facture.setEtat(EtatFactureEnum.REJETE);
        this.facture.setEtatFacture(new EtatRejete(facture));
        System.out.println("Soumis --- > rejeté");
        return this.facture;
    }

    @Override
    public Facture1 annuler() {
        return this.facture;
    }

    @Override
    public Facture1 approuver() {
        this.facture.setEtat(EtatFactureEnum.APPROUVE);
        this.facture.setEtatFacture(new EtatApprouve(facture));
        System.out.println("Soumis --- > approuvé");
        return this.facture;
    }

    @Override
    public Facture1 payer() {
        System.out.println(" ====== SOUMIS -----> PAYE -----> NON PERMIS");
        return this.facture;
    }

    @Override
    public Facture1 traiter() {
        System.out.println(" =========== Facture soumise avec succès ============ ");
        return this.facture;
    }
}
