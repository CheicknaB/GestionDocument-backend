package com.gestionDocuments.Gestion.des.documents.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionDocuments.Gestion.des.documents.EtatFacture.*;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture1  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    private String filePath;

    private String numeroFacture;
    private double montantTotal;
    private double reste;

    @Enumerated(EnumType.STRING)
    private EtatFactureEnum etat;

    @Transient
    @JsonIgnore
    private EtatFacture etatFacture;

    private java.util.Date dateEmission;
    private java.util.Date dateCreation;

   //@OneToMany(mappedBy = "facture")
   //private List<Paiement> paiements;


    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Fournisseur fournisseur;


    /*public Facture1(){
        this.etat = EtatFactureEnum.SOUMIS;
        this.dateCreation = new Date();
        this.etatFacture = new EtatSoumis(this);
    }*/

    public void setEtat(EtatFactureEnum etat) {
        System.out.println(" setter Etat "+etat);
        this.etat = etat;
        this.dateCreation = new Date();
        switch (etat) {
            case SOUMIS:
                this.etatFacture = new EtatSoumis(this);
                break;
            case EN_ATTENTE:
                this.etatFacture = new EtatEnAttente(this);
                break;
            case VALIDE:
                this.etatFacture = new EtatValide(this);
                break;
            case REJETE:
                this.etatFacture = new EtatRejete(this);
                break;
            case PAYE:
                this.etatFacture = new EtatPaye(this);
                break;
            case ANNULE:
                this.etatFacture = new EtatAnnule(this);
                break;
            case APPROUVE:
                this.etatFacture = new EtatApprouve(this);
                break;
            default:
                this.etatFacture = new EtatSoumis(this);
                break;
        }
    }

    public void traiter(){
        this.etatFacture.traiter();
    }
}
