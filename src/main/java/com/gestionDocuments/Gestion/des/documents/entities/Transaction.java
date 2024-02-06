package com.gestionDocuments.Gestion.des.documents.entities;

import com.gestionDocuments.Gestion.des.documents.enums.StatutTransaction;
import com.gestionDocuments.Gestion.des.documents.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TypeTransaction typeTransaction;
    private double montant;
    private Date date;
    private String description;
    private String image;
    private StatutTransaction statutTransaction;
    @OneToOne
    private Utilisateur source; // Peut être un Utilisateur ou un Fournisseur
    @OneToOne
    private Utilisateur destination; // Peut être un Utilisateur ou un Fournisseur
}
