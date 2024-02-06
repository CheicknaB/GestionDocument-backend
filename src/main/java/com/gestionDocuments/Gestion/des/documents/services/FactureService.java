package com.gestionDocuments.Gestion.des.documents.services;

import com.gestionDocuments.Gestion.des.documents.entities.Facture;
import com.gestionDocuments.Gestion.des.documents.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {
    @Autowired
    private DocumentRepository documentRepository;

    /*public Facture saveFacture(Facture document){
        return documentRepository.save(document);
    }
    public List<Facture> listDocuments(){
        return  documentRepository.findAll();
    }*/
}
