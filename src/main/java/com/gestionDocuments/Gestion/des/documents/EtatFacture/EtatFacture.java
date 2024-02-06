package com.gestionDocuments.Gestion.des.documents.EtatFacture;

import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public abstract class EtatFacture {
    protected Facture1 facture ;
    public EtatFacture(Facture1 facture1){
        this.facture = facture1;
    }

    public abstract Facture1 soumettre();
    public abstract Facture1 enAttente();
    public abstract Facture1 valider();
    public abstract Facture1 rejeter();
    public abstract Facture1 annuler();
    public abstract Facture1 approuver();
    public abstract Facture1 payer();
    public abstract Facture1 traiter();
}
