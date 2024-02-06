package com.gestionDocuments.Gestion.des.documents.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;
    //private String etat;
    private java.util.Date datePaiement;
    private java.util.Date dateCreation;

    @ManyToOne
    private Facture1 facture;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    private Recu recu;
}
