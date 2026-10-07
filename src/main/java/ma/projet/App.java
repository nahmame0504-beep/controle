package ma.projet;

import ma.projet.beans.Assurance;
import ma.projet.beans.Client;
import ma.projet.beans.Contrat;
import ma.projet.services.AssuranceService;
import ma.projet.services.ClientService;
import ma.projet.services.ContratService;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("--- DÉMARRAGE DE L'APPLICATION ---");

        // Initialisation des services
        ClientService clientService = new ClientService();
        AssuranceService assuranceService = new AssuranceService();
        ContratService contratService = new ContratService();

        // ==========================================
        // 1. CRÉATION (INSERTION) EN BASE DE DONNÉES
        // ==========================================
        System.out.println("\n[1] Création des Clients...");
        Client c1 = new Client("Dupont", "Jean", "jean.dupont@email.com", "0600000001");
        Client c2 = new Client("Martin", "Sophie", "sophie.m@email.com", "0600000002");
        clientService.create(c1);
        clientService.create(c2);

        System.out.println("\n[2] Création des Assurances...");
        Assurance a1 = new Assurance("Auto", 500.0, "Tous risques");
        Assurance a2 = new Assurance("Santé", 300.0, "Mutuelle de base");
        assuranceService.create(a1);
        assuranceService.create(a2);

        System.out.println("\n[3] Création des Contrats...");
        long unAnEnMillisecondes = 31536000000L;
        // Contrat 1: Jean (Auto)
        Contrat contrat1 = new Contrat(new Date(), new Date(System.currentTimeMillis() + unAnEnMillisecondes), c1, a1);
        // Contrat 2: Jean (Santé)
        Contrat contrat2 = new Contrat(new Date(), new Date(System.currentTimeMillis() + unAnEnMillisecondes), c1, a2);
        // Contrat 3: Sophie (Santé)
        Contrat contrat3 = new Contrat(new Date(), new Date(System.currentTimeMillis() + unAnEnMillisecondes), c2, a2);
        
        contratService.create(contrat1);
        contratService.create(contrat2);
        contratService.create(contrat3);

        // ==========================================
        // 2. LECTURE & AFFICHAGE (READ)
        // ==========================================
        System.out.println("\n[4] Liste de tous les contrats enregistrés :");
        List<Contrat> contrats = contratService.findAll();
        for (Contrat c : contrats) {
            System.out.println(" - Contrat N°" + c.getId() + " | Client: " + c.getClient().getName() + 
                               " | Type d'assurance: " + c.getAssurance().getType());
        }

        // ==========================================
        // 3. MISE À JOUR (UPDATE)
        // ==========================================
        System.out.println("\n[5] Mise à jour du téléphone de Jean Dupont...");
        Client clientAModifier = clientService.findById(c1.getId());
        if (clientAModifier != null) {
            clientAModifier.setTelephone("0777777777"); // Nouveau numéro
            clientService.update(clientAModifier);
            System.out.println("Téléphone mis à jour avec succès : " + clientAModifier.getTelephone());
        }

        // ==========================================
        // 4. RECHERCHE SPÉCIFIQUE (FIND BY ID)
        // ==========================================
        System.out.println("\n[6] Affichage des contrats spécifiques au client N°" + c1.getId() + " (" + c1.getName() + ") :");
        Client jean = clientService.findById(c1.getId());
        if (jean != null && jean.getContrats() != null) {
            for (Contrat c : jean.getContrats()) {
                System.out.println(" -> " + c.getAssurance().getType() + " (Montant: " + c.getAssurance().getMontant() + ")");
            }
        }

        System.out.println("\n--- FIN DU PROGRAMME ---");
    }
}
