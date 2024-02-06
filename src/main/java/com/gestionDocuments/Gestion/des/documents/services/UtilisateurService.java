package com.gestionDocuments.Gestion.des.documents.services;

import com.gestionDocuments.Gestion.des.documents.entities.Role;
import com.gestionDocuments.Gestion.des.documents.entities.Utilisateur;
import com.gestionDocuments.Gestion.des.documents.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestionDocuments.Gestion.des.documents.repositories.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Utilisateur save(Utilisateur utilisateur){
        return userRepository.save(utilisateur);
    }

    public Optional<Utilisateur> getUtilisateur(Long id){
        return userRepository.findById(id);
    }

    public List<Utilisateur> listUsers(){
        return userRepository.findAll();
    }

    public List<Role> listRoles(){
        return roleRepository.findAll();
    }
}
