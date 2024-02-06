package com.gestionDocuments.Gestion.des.documents;


import com.gestionDocuments.Gestion.des.documents.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  GestionDesDocumentsApplication {


	public static void main(String[] args) {
		SpringApplication.run(GestionDesDocumentsApplication.class, args);

		/*Facture facture = new Facture();

		System.out.println("\t\t\t : "+facture.getEtat());
		facture.getEtatFacture().enAttente();
		System.out.println("\t\t\t : "+facture.getEtat());
		//facture.getEtatFacture().rejeter();
		facture.getEtatFacture().approuver();
		System.out.println("\t\t\t : "+facture.getEtat());
		facture.getEtatFacture().payer();
		System.out.println("\t\t\t : "+facture.getEtat());
		//facture.getEtatFacture().annuler();
		facture.getEtatFacture().valider();
		System.out.println("\t\t\t : "+facture.getEtat());
		facture.getEtatFacture().annuler();
		System.out.println("\t\t\t : "+facture.getEtat());
		 */

	}
}
