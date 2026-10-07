package ma.projet.test;

import java.util.List;
import ma.projet.beans.Assurance;
import ma.projet.beans.Client;
import ma.projet.beans.Contrat;
import ma.projet.services.AssuranceService;
import ma.projet.services.ClientService;
import ma.projet.services.ContratService;

import javax.persistence.Id;

public class Main {

    public static void main(String[] args) {
        // Services déjà présents dans le projet
        AssuranceService assuranceService = new AssuranceService();
        ClientService clientService = new ClientService();
        ContratService contratService = new ContratService();

        // 1. Récupérer toutes les assurances
        System.out.println("LISTE DES ASSURANCES ");
        List<Assurance> assurances = assuranceService.findAll();
        if (assurances == null || assurances.isEmpty()) {
            System.out.println("Aucune assurance trouvée en base de données.");
        } else {
            for (Assurance a : assurances) {
                System.out.println("Assurance [ID: " + a.getId() + ", Type: " + a.getType() + ", Couverture: " + a.getCouverture() + "]");
            }
        }

        // 2. Récupérer tous les clients
        System.out.println("\n LISTE DES CLIENTS");
        List<Client> clients = clientService.findAll();
        if (clients == null || clients.isEmpty()) {
            System.out.println("Aucun client trouvé en base de données.");
        } else {
            for (Client c : clients) {
                System.out.println("Client [ID: " + c.getId() + ", Nom: " + c.getName() + " " + c.getPrenom() + "]");
            }
        }

        // 3. Récupérer tous les contrats
        System.out.println("\n LISTE DES CONTRATS ");
        List<Contrat> contrats = contratService.findAll();
        if (contrats == null || contrats.isEmpty()) {
            System.out.println("Aucun contrat trouvé en base de données.");
        } else {
            for (Contrat ct : contrats) {
                System.out.println("Contrat [ID: " + ct.getId() + ", Client: " + ct.getClient().getName() + ", Assurance: " + ct.getAssurance().getType() + "]");
            }
        }
      AssuranceService A1 = new AssuranceService() ;
      ClientService C1 = new ClientService() ;
      ContratService Co1 = new ContratService() ;


    }
}
