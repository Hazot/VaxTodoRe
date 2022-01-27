package Views;

import Entities.VaccinationProfile;
import Entities.VisitorAccount;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The visitor account view defining the looks and prints for the visitor menu
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class VisitorAccountView {

    /**
     * Prints the main visitor menu
     */
    public void printVisitorMainMenu() {
        System.out.println("\nMENU VISITEUR");
        System.out.println("======================================================");
        System.out.println("[1]: Ajouter un nouveau visiteur");
        System.out.println("[2]: Afficher visiteur existant");
        System.out.println("[3]: Gestion comptes visiteurs");
        System.out.println("[4]: Gestion profil vaccinal visiteur");
        System.out.println("[0]: Retour au menu précédant");
    }

    /**
     * Prints the menu for managing visitor accounts
     */
    public void printMenuDelMod() {
        System.out.println("\nMENU MODIFICATION VISITEUR");
        System.out.println("[1] Supprimer un compte visiteur");
        System.out.println("[2] Modifier un compte visiteur");
        System.out.println("[0] Retour au menu précédant");
    }

    /**
     * Prints the menu for choosing the visitor account information to modify
     */
    public void printMenuSelectModifyVisitor() {
        System.out.println("\nCHOISISSEZ LE TYPE DE CATEGORIE A CHANGER");
        System.out.println("[1] Modifier le prenom");
        System.out.println("[2] Modifier le nom");
        System.out.println("[3] Modifier la date de naissance");
        System.out.println("[4] Modifier le numero de telephone");
        System.out.println("[5] Modifier l'adresse courriel'");
        System.out.println("[6] Modifier l'adresse");
        System.out.println("[7] Modifier le code postal");
        System.out.println("[8] Modifier la ville");
        System.out.println("[0] Retour au menu précédant");
    }

    /**
     * Prints the menu for choosing what to change about the vaccin information on the profile
     */
    public void printMenuSelectModifyVaccin() {
        System.out.println("\nCHOISISSEZ LE TYPE DE CATÉGORIE À CHANGER");
        System.out.println("[1] Modifier la date de vaccination");
        System.out.println("[2] Modifier le type de dose");
        System.out.println("[3] Modifier le nom du vaccin");
        System.out.println("[4] Modifier le code du vaccin");
        System.out.println("[0] Retour au menu précédant");
    }

    /**
     * Prints the management menu for the vaccination profile
     */
    public void printMenuVaccinationProfile() {
        System.out.println("\nMENU PROFIL DE VACCINATION");
        System.out.println("[1] afficher le profil vaccinal");
        System.out.println("[2] Modifier un des vaccins");
        System.out.println("[3] Envoyer un rapport de vaccination");
        System.out.println("[0] Retour au menu précédant");
    }

    /**
     * Prints the information of a visitor account
     *
     * @param visitor visitor account pretty print information
     */
    public void printVisitors(VisitorAccount visitor) {System.out.println(visitor); }

    /**
     * Prompts the user to enter first name of a visitor
     */
    public void printAskEnterFName() {
        System.out.print("Entrez le prenom du visiteur (50 characteres max): ");
    }

    /**
     * Prompts the user to enter last name of a visitor
     */
    public void printAskEnterLName() {
        System.out.println("Entrez le nom du visiteur (50 characteres max): ");
    }

    /**
     * Prompts the user to enter date of birth of a visitor
     */
    public void printAskBirthDate() {
        System.out.println("Entrez le date de naissance du visiteur \"yyyy-MM-dd\": ");
    }

    /**
     * Prompts the user to enter a email of a visitor
     */
    public void printAskEmail() {
        System.out.println("Entrez l'address courriel du visiteur: ");
    }

    /**
     * Prompts the user to enter a phone number of a visitor
     */
    public void printAskPhoneNumber() {
        System.out.println("Entrez le numero de telephone du visiteur (10 chiffres max): ");
    }

    /**
     * Prompts the user to enter the street information part of the address of a visitor
     */
    public void printAskStreetInfo() {
        System.out.println("Entrez l'adresse du visiteur (100 characteres max): ");
    }

    /**
     * Prompts the user to enter a postal code of a visitor
     */
    public void printAskPostalCode() {
        System.out.println("Entrez le code postal du visiteur (6 characteres max \"A1A2B2\"): ");
    }

    /**
     * Prompts the user to enter a city of a visitor
     */
    public void printAskCity() {
        System.out.println("Entrez le ville du visiteur (50 characteres max): ");
    }

    /**
     * Prompts the user to enter a visitor account id to delete
     */
    public void printAskAccountIdToDelete() {
        System.out.println("Entrez le numero d'identification de compte a supprimer");
    }

    /**
     * Prompts the user to enter a visitor account id to modify
     */
    public void printAskAccountIdToModify() {
        System.out.println("Entrez le numero d'identification de compte a modifier");
    }

    /**
     * Prints the confirmation that the visitor account has been deleted
     */
    public void printAccountHasBeenDeleted() {
        System.out.println("Le compte visiteur a ete supprimer.");
    }

    /**
     * Prints an error message about the id of a visitor
     */
    public void printInvalidVisitorId() {
        System.out.println("Le id du compte visiteur entré est invalide!");
    }

    /**
     * Prints the vaccination profiles of a visitor
     * @param vaccinationProfiles vaccination profile of a visitor
     */
    public void printVaccinationProfiles(ArrayList<VaccinationProfile> vaccinationProfiles) {
        for (int i = 0; i < vaccinationProfiles.size(); i++) {
            System.out.println("--------------------------------------");
            System.out.println("VACCIN NUMÉRO [" + i + "]:");
            System.out.println(vaccinationProfiles.get(i));
        }
    }

    /**
     * Prompts the user to enter a vaccine code
     */
    public void printAskEnterVaccinNum() {
        System.out.println("Entrer le numero de vaccin (Le numero ce trouve dans l'affichage du profil vaccinal): ");
    }

    /**
     * Prints an error code about the invalid vaccine code
     */
    public void printInvalidVaccinNum() {
        System.out.println("Le numero de vaccin est invalid!");
    }

    /**
     * Prompts the user to enter a new date for the vaccination
     */
    public void printAskNewVaccineDate() {
        System.out.print("Entrer la nouvelle date de vaccination (\"YYYY-MM-DD\"): ");
    }

    /**
     * Prints an error about the invalid date entered
     */
    public void printInvalidDateFormat() {
        System.out.println("La date entrée est invalide!");
    }

    /**
     * Prompts the user to enter a valid dose type
     */
    public void printAskNewDoseType() {
        System.out.print("Entrer le nouveau type de dose (1 ou 2): ");
    }

    /**
     * Prints the error about the invalid dose type
     */
    public void printInvalidDoseType() {
        System.out.println("Le type de dose entré est invalide!");
    }

    /**
     * Prints the menu for the choice of the new vaccine name to set
     */
    public void printAskNewVaccineName() {
        System.out.println("[1]: Moderna");
        System.out.println("[2]: Pfizer");
        System.out.println("[3]: AstraZeneca");
        System.out.println("[4]: Janssen");
        System.out.println("\nEntrez le numéro du vaccin (1, 2, 3 ou 4):");
    }

    /**
     * Prompts the user to enter a new vaccine code
     */
    public void printAskNewVaccineCode() {
        System.out.println("Entrez le nouveau code du vaccin (24 char. max): ");
    }

    /**
     * Prints an error about the invalid vaccine code entered
     */
    public void printInvalidVaccineCode() {
        System.out.println("Le code du vaccin est invalide!");
    }

    /**
     * Prompts the user to enter a visitor account id
     */
    public void printAskAccountIdProfile() {
        System.out.println("Entrez le numéro d'identification du visiteur:");
    }

    /**
     * Prints the visitor menu of the volunteers
     */
    public void printVisitorMenuVolunteer() {
        System.out.println("\nMENU VISITEUR");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher visiteur existant");
        System.out.println("[0]: Retour au menu précédant");
    }

    /**
     * Prints the visitor's report
     * 
     * @param visitorAccount visitor account to take the profile
     */
    public void printVaccinationReport(VisitorAccount visitorAccount) {
        System.out.println("Rapport de vaccination envoyé!");
        System.out.println("Rapport de vaccination produit:");
        System.out.println("- Nom: " + visitorAccount.getInfo().getFirstName() + " " + visitorAccount.getInfo().getLastName());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormatter.format(new Date());  // today's date
        System.out.println("- Date: " + dateStr);

        for (VaccinationProfile profile : visitorAccount.getVaccinationProfiles()) {
            System.out.println("Vaccin:");
            System.out.println("    - Dose: " + profile.getDoseType());
            System.out.println("    - Vaccin: " + profile.getVaccineName());
            System.out.println("    - Date: " + dateFormatter.format(profile.getVaccinationDate()));
        }

        System.out.println("Code QR: ##################################################");
    }

    public void printAccountCreated() {
        System.out.println("Le compte est créé!");
    }
}
