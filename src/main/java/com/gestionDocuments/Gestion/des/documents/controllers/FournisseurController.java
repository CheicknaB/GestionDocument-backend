package com.gestionDocuments.Gestion.des.documents.controllers;

import com.gestionDocuments.Gestion.des.documents.repositories.FournisseurRepository;
import com.gestionDocuments.Gestion.des.documents.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("/find")
    public ResponseEntity<?> listFournisseurs(){
        return new ResponseEntity<>(fournisseurService.listFournisseurs(), HttpStatus.OK);
    }

}
