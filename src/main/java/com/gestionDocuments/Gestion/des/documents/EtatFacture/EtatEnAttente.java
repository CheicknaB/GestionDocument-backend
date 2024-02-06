package com.gestionDocuments.Gestion.des.documents.EtatFacture;

import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;

public class EtatEnAttente extends EtatFacture{
    public EtatEnAttente(Facture1 facture1) {
        super(facture1);
        System.out.println("ETAT ACTUEL ===> EN_ATTENTE \n");
    }

    @Override
    public Facture1 soumettre() {
        return this.facture;

    }

    @Override
    public Facture1 enAttente() {
        return this.facture;
    }

    @Override
    public Facture1 valider() {
        return this.facture;
    }

    @Override
    public Facture1 rejeter() {
        this.facture.setEtat(EtatFactureEnum.REJETE);
        this.facture.setEtatFacture(new EtatRejete(facture));
        System.out.println("ATTENTE =========> REJETE");
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
        System.out.println("ATTENTE =========> APPROUVE");
        return this.facture;
    }

    @Override
    public Facture1 payer() {
        return this.facture;
    }

    @Override
    public Facture1 traiter() {
        return this.facture;
    }
}
