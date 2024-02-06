package com.gestionDocuments.Gestion.des.documents.controllers;

import com.gestionDocuments.Gestion.des.documents.entities.Facture;
import com.gestionDocuments.Gestion.des.documents.entities.Facture1;
import com.gestionDocuments.Gestion.des.documents.entities.Paiement;
import com.gestionDocuments.Gestion.des.documents.enums.EtatFactureEnum;
import com.gestionDocuments.Gestion.des.documents.services.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/documents")
@Slf4j
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/save")
    @ResponseBody
    public Facture1 save(@RequestBody Facture1 document){
        return documentService.save(document);
    }

    @PostMapping("/addPayment")
    @ResponseBody
    public ResponseEntity<?> addPayment(@RequestParam("factureId") Long factureId, @RequestBody Paiement paiement){
        return documentService.addPayment(factureId, paiement);
    }
    @GetMapping("/{id}/etat/{nouvelEtat}")
    public ResponseEntity<?> updateEtatFacture(@PathVariable Long id, @PathVariable String nouvelEtat) {
        log.info(" ===============  updateEtatFacture    ============");

        ResponseEntity<?> doc = documentService.getFactureById(id);

        Object docBody = doc.getBody();

        if (docBody != null && docBody instanceof Facture1) {
            Facture1 facture = (Facture1) docBody;
            return documentService.updateEtatFacture(facture, nouvelEtat);
        } else {
            return null;
        }
    }

    @GetMapping("/find")
    public ResponseEntity<?> listDocuments(){
        return documentService.listDocuments();
    }
    @GetMapping("/find/{id}")
    public  ResponseEntity<?> getFactureById(@PathVariable Long id){
        return documentService.getFactureById(id);
    }

    @GetMapping("/find/paiements/{id}")
    public ResponseEntity<?> getPaimentsByFacture(@PathVariable Long id){
        Facture1 facture1 = (Facture1)documentService.getFactureById(id).getBody();
        return documentService.getPaimentsByFacture(facture1);
    }

    @GetMapping("/find/etat/{etat}")
    public ResponseEntity<?> getFacturesByEtat(@PathVariable String etat){
            EtatFactureEnum etatFact = EtatFactureEnum.valueOf(etat);
            return  documentService.getFactureByEtat(etatFact);
    }

    @GetMapping("/find/etat/not-in")
    public ResponseEntity<?> getFacturesByEtatNotIn(@RequestParam List<String> etatsExclus) {

        return documentService.getFacturesByEtatNotIn(convertirChainesEnEtats(etatsExclus));
    }

    private List<EtatFactureEnum> convertirChainesEnEtats(List<String> chaines) {
        List<EtatFactureEnum> etats = new ArrayList<>();
        for (String chaine : chaines) {
            try {
                EtatFactureEnum etat = EtatFactureEnum.valueOf(chaine);
                etats.add(etat);
            } catch (IllegalArgumentException e) {

            }
        }
        return etats;
    }



}
