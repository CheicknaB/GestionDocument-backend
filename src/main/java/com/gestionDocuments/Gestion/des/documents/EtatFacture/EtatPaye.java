package com.gestionDocuments.Gestion.des.documents.EtatFacture;

import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;

public class EtatPaye extends EtatFacture{
    public EtatPaye(Facture1 facture1) {
        super(facture1);
        System.out.println("ETAT ACTUEL ===> ETAT PAYE \n");
    }

    @Override
    public Facture1 soumettre() {
        return this.facture;
    }

    @Override
    public Facture1 enAttente() {
        this.facture.setEtat(EtatFactureEnum.VALIDE);
        this.facture.setEtatFacture(new EtatValide(this.facture));
        System.out.println("PAYE =========> VALIDE");
        return this.facture;
    }

    @Override
    public Facture1 valider() {
        this.facture.setEtat(EtatFactureEnum.VALIDE);
        this.facture.setEtatFacture(new EtatValide(this.facture));
        System.out.println("PAYE =========> VALIDE");
        return this.facture;
    }

    @Override
    public Facture1 rejeter() {
        return this.facture;
    }

    @Override
    public Facture1 annuler() {
        this.facture.setEtat(EtatFactureEnum.ANNULE);
        this.facture.setEtatFacture(new EtatAnnule(this.facture));
        System.out.println("PAYE =========> ANNULE");
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
