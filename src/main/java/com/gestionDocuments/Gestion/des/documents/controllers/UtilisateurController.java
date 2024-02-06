package com.gestionDocuments.Gestion.des.documents.controllers;

import com.gestionDocuments.Gestion.des.documents.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.gestionDocuments.Gestion.des.documents.services.UtilisateurService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService   ;

    @PostMapping("/save")
    @ResponseBody
    public Utilisateur save(@RequestBody Utilisateur utilisateur){
        return utilisateurService.save(utilisateur);
    }


    @GetMapping("/find/user")
    public ResponseEntity<?> getUtilisateur(@PathVariable(name ="userId", required = true) Long userId){
        return new ResponseEntity<>(utilisateurService.getUtilisateur(userId), HttpStatus.OK);
    }


    @GetMapping("/find")
    public ResponseEntity<?> listUser(){
        return new ResponseEntity<>(utilisateurService.listUsers(), HttpStatus.OK);
    }


    @GetMapping("/roles")
    public ResponseEntity<?> listRoles(){
        return new ResponseEntity<>(utilisateurService.listRoles(), HttpStatus.OK);
    }
}
