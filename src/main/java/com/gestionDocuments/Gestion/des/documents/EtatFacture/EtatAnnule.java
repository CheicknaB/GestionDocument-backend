package com.gestionDocuments.Gestion.des.documents.EtatFacture;

import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;

public class EtatAnnule extends EtatFacture{
    public EtatAnnule(Facture1 facture1) {
        super(facture1);
        System.out.println("ETAT ACTUEL ===> ANNULE \n");
    }

    @Override
    public Facture1 soumettre() {
        this.facture.setEtat(EtatFactureEnum.SOUMIS);
        this.facture.setEtatFacture(new EtatSoumis(this.facture));
        System.out.println("ANNULE =========> ¨SOUMIS");
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
