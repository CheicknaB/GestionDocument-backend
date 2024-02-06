package com.gestionDocuments.Gestion.des.documents.EtatFacture;

import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;

public class EtatValide extends EtatFacture{
    public EtatValide(Facture1 facture1) {
        super(facture1);
        System.out.println("ETAT ACTUEL ===> VALIDE \n");
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
        System.out.println("VALIDE =========> ANNULE");
        this.facture.setEtat(EtatFactureEnum.ANNULE);
        this.facture.setEtatFacture(new EtatAnnule(this.facture));
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
