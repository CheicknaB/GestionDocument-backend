package com.gestionDocuments.Gestion.des.documents.repositories;

import com.gestionDocuments.Gestion.des.documents.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
