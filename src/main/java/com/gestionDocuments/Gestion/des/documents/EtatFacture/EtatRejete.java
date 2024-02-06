package com.gestionDocuments.Gestion.des.documents.EtatFacture;

import com.gestionDocuments.Gestion.des.documents.entities.Facture1;

public class EtatRejete extends EtatFacture{
    public EtatRejete(Facture1 facture1) {
        super(facture1);
        System.out.println("ETAT ACTUEL ===> ETAT REJETE \n");
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
        return this.facture;
    }

    @Override
    public Facture1 annuler() {
        return this.facture;
    }

    @Override
    public Facture1 approuver() {
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
