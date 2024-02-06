package com.gestionDocuments.Gestion.des.documents.repositories;

import com.gestionDocuments.Gestion.des.documents.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
