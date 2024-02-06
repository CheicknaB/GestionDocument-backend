package com.gestionDocuments.Gestion.des.documents.repositories;

import com.gestionDocuments.Gestion.des.documents.entities.Facture;
import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Facture1, Long> {
    @Query("SELECT f FROM Facture1 f WHERE f.etat = :etat")
    public List<Facture1> findByEtat(EtatFactureEnum etat);

    @Query("SELECT f FROM Facture1 f WHERE f.etat NOT IN :etats")
    public List<Facture1> findByEtatNotIn(List<EtatFactureEnum> etats);

}
