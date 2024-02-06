package com.gestionDocuments.Gestion.des.documents.entities;

import com.gestionDocuments.Gestion.des.documents.EtatFacture.EtatFacture;
import com.gestionDocuments.Gestion.des.documents.EtatFacture.EtatSoumis;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private MultipartFile file;

    private String filePath;

    private String numeroFacture;
    private double montantTotal;

    @Enumerated(EnumType.STRING)
    private EtatFactureEnum etat;

    @OneToOne
    @Transient
    private EtatFacture etatFacture;

    private java.util.Date dateEmission;
    private java.util.Date dateCreation;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Fournisseur fournisseur;


    public Facture(){
        this.etat = EtatFactureEnum.SOUMIS;
        this.dateCreation = new Date();
       // this.etatFacture = new EtatSoumis(this);
    }

    public void traiter(){
        this.etatFacture.traiter();
    }
}
