package com.gestionDocuments.Gestion.des.documents.services;

import com.gestionDocuments.Gestion.des.documents.EtatFacture.*;
import com.gestionDocuments.Gestion.des.documents.entities.Facture;
import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.entities.Paiement;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;
import com.gestionDocuments.Gestion.des.documents.repositories.DocumentRepository;
import com.gestionDocuments.Gestion.des.documents.repositories.FactureRepository;
import com.gestionDocuments.Gestion.des.documents.repositories.PaiementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private PaiementRepository paiementRepository;

    @Value("${app.upload-dir}")
    private String uploadDir;

    public Facture1 save(Facture1 document){
        /*try {
            // Enregistrer le fichier
            this.enregistrerFichier(document.getFile(), document.getFile().getOriginalFilename());
            // Attribuer le nom du fichier à la facture
            document.setFilePath(document.getFile().getOriginalFilename());
            // Enregistrer la facture dans la base de données
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        document.setEtat(EtatFactureEnum.SOUMIS);
        document.setDateCreation(new Date());
        document.setEtatFacture(new EtatSoumis(document));
        return documentRepository.save(document);
    }
    public ResponseEntity<?> listDocuments(){
        return new ResponseEntity<>(documentRepository.findAll(), HttpStatus.OK);
    }

    /*public void enregistrerFichier(MultipartFile fichier, String nomFichier) throws IOException {
        byte[] bytes = fichier.getBytes();
        Path path = Paths.get(uploadDir + "/" + nomFichier);
        Files.write(path, bytes);
    }*/

    public ResponseEntity<?> updateEtatFacture(Facture1 facture, String nouvelEtat){
        switch (nouvelEtat) {
            case "EN_ATTENTE":
                facture = facture.getEtatFacture().enAttente();
                break;
            case "REJETE":
                facture = facture.getEtatFacture().rejeter();
                log.info("CB getEtatFacture " + facture.getEtatFacture());
                break;
            case "PAYE":
                facture = facture.getEtatFacture().payer();
                break;
            case "VALIDE":
                facture = facture.getEtatFacture().valider();
                break;
            case "ANNULE":
                facture = facture.getEtatFacture().annuler();
                break;
            case "APPROUVE":
                facture = facture.getEtatFacture().approuver();
                break;
            case "SOUMIS":
                facture = facture.getEtatFacture().soumettre();
                break;
            default:
                facture = facture.getEtatFacture().soumettre();
                break;
        }

        facture = documentRepository.save(facture);
        return new ResponseEntity<>(facture, HttpStatus.OK) ;
    }

    public ResponseEntity<?> getFactureById(Long id){
        Facture1 facture1 = documentRepository.findById(id).orElse(null);

        switch (facture1.getEtat()) {
            case SOUMIS:
                log.info(" je vais setter ");
                facture1.setEtatFacture(new EtatSoumis(facture1));
                log.info("la valeur dEtatFacture est : "+facture1.getEtatFacture());
                break;
            case EN_ATTENTE:
                facture1.setEtatFacture(new EtatEnAttente(facture1));
                break;
            case VALIDE:
                facture1.setEtatFacture(new EtatValide(facture1));
                break;
            case REJETE:
                System.out.println("swith cheickna");
                facture1.setEtatFacture( new EtatRejete(facture1));
                break;
            case PAYE:
                facture1.setEtatFacture( new EtatPaye(facture1));
                break;
            case ANNULE:
                facture1.setEtatFacture(new EtatAnnule(facture1));
                break;
            case APPROUVE:
                facture1.setEtatFacture( new EtatApprouve(facture1));
                break;
            default:
                facture1.setEtatFacture( new EtatSoumis(facture1));
                break;
        }

        return new ResponseEntity<>(facture1, HttpStatus.OK);

    }

    public ResponseEntity<?> getFactureByEtat(EtatFactureEnum etat){
        return new ResponseEntity<>(documentRepository.findByEtat(etat), HttpStatus.OK) ;
    }

    public ResponseEntity<?> getPaimentsByFacture(Facture1 facture1){
        return new ResponseEntity<>(paiementRepository.findByFacture(facture1), HttpStatus.OK) ;
    }
    public ResponseEntity<?> addPayment(Long factureId, Paiement paiement) {

        Facture1 facture = documentRepository.findById(factureId).orElse(null);

        paiement.setFacture(facture);
        paiement.setDatePaiement(new Date());
        paiement.setDateCreation(new Date());

        Paiement paiementSaved = new Paiement();

        if (facture != null) {
             paiementSaved = paiementRepository.save(paiement);
        }
        return new ResponseEntity<>(paiementSaved, HttpStatus.OK);
    }


    public ResponseEntity<?> getFacturesByEtatNotIn(List<EtatFactureEnum> etats){
        return new ResponseEntity<>(documentRepository.findByEtatNotIn(etats), HttpStatus.OK) ;
    }
}
