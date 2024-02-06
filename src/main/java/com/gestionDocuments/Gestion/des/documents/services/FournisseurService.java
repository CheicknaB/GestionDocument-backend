package com.gestionDocuments.Gestion.des.documents.services;

import com.gestionDocuments.Gestion.des.documents.entities.Fournisseur;
import com.gestionDocuments.Gestion.des.documents.entities.Utilisateur;
import com.gestionDocuments.Gestion.des.documents.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> listFournisseurs(){
        return fournisseurRepository.findAll();
    }

}
