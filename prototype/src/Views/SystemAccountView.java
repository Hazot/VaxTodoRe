package Views;

import Entities.VolunteerAccount;

/**
 * The system account view defining the looks and prints for the system account
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class SystemAccountView {
    /**
     * Prints the main menu of the application for the employee account
     */
    public void printEmployeeMainMenu() {
        System.out.println("\nMENU PRINCIPAL EMPLOYÉ");
        System.out.println("======================================================");
        System.out.println("[1]: Gestion de rendez-vous");
        System.out.println("[2]: Accès au formulaire");
        System.out.println("[3]: Gestion des visiteurs");
        System.out.println("[4]: Gestion des bénévoles");
        System.out.println("[0]: Quitter l'application");
    }

    /**
     * Prints the system header
     */
    public void printHeader() {
        System.out.println(" __     __         _____         _                 ");
        System.out.println(" \\ \\   / /_ ___  _|_   _|__   __| | ___ _ _ __ ___ ");
        System.out.println("  \\ \\ / / _` \\ \\/ / | |/ _ \\ / _` |/ _ (_) '__/ _ \\");
        System.out.println("   \\ V / (_| |>  <  | | (_) | (_| | (_) || | |  __/");
        System.out.println("    \\_/ \\__,_/_/\\_\\ |_|\\___/ \\__,_|\\___(_)_|  \\___|");
        System.out.println("                                                   ");
    }

    /**
     * Prints the main menu of the application for the volunteer account
     */
    public void printVolunteerMainMenu() {
        System.out.println("\nMENU PRINCIPAL BÉNÉVOLE");
        System.out.println("======================================================");
        System.out.println("[1]: Gestion des rendez-vous");
        System.out.println("[2]: Gestion des visiteurs");
        System.out.println("[0]: Quitter l'application");
    }

    /**
     *
     */
    public void printVolunteerGestionMainMenu() {
        System.out.println("\nMENU GESTION BÉNÉVOLE");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher la liste des bénévoles");
        System.out.println("[2]: Gestion des comptes bénévoles");
        System.out.println("[0]: Revenir au menu précédant");
    }

    /**
     * Prints the menu for managing volunteer accounts
     */
    public void printMenuDelMod() {
        System.out.println("[1] Supprimer un compte benevole");
        System.out.println("[2] Modifier un compte benevole");
        System.out.println("[3] Ajouter un compte benevole");
        System.out.println("[0] Retour au menu précédant");
    }

    /**
     * Prints the information of a volunteer account
     *
     * @param volunteer volunteer account pretty print information
     */
    public void printVolunteers(VolunteerAccount volunteer) {
        System.out.println(volunteer);
    }

    /**
     * Prompts the user to enter a volunteer account id to delete
     */
    public void printAskAccountIdToDelete() {
        System.out.println("Entrez le numero d'identification de compte a supprimer");
    }

    /**
     * Prints the confirmation that the volunteer account has been deleted
     */
    public void printAccountHasBeenDeleted() {
        System.out.println("Le compte bénévole a été supprimer.");
    }

    /**
     * Prompts the user to enter first name
     */
    public void printAskEnterFName() {
        System.out.print("Entrez le prenom du benevoles (50 characteres max): ");
    }

    /**
     * Prompts the user to enter last name
     */
    public void printAskEnterLName() {
        System.out.println("Entrez le nom du benevole (50 characteres max): ");
    }

    /**
     * Prompts the user to enter date of birth
     */
    public void printAskBirthDate() {
        System.out.println("Entrez le date de naissance du benevole \"yyyy-MM-dd\": ");
    }

    /**
     * Prompts the user to enter en email
     */
    public void printAskEmail() {
        System.out.println("Entrez l'address courriel du benevole: ");
    }

    /**
     * Prompts the user to enter a phone number
     */
    public void printAskPhoneNumber() {
        System.out.println("Entrez le numero de telephone du benevole (10 chiffres max): ");
    }

    /**
     * Prompts the user to enter the street information part of the address of a volunteer
     */
    public void printAskStreetInfo() {
        System.out.println("Entrez l'adresse du benevole (100 characteres max): ");
    }

    /**
     * Prompts the user to enter a postal code of a volunteer
     */
    public void printAskPostalCode() {
        System.out.println("Entrez le code postal du benevole (6 characteres max): ");
    }

    /**
     * Prompts the user to enter a city of a volunteer
     */
    public void printAskCity() {
        System.out.println("Entrez le ville du benevole (50 characteres max): ");
    }

    /**
     * Prompts the user to enter a volunteer account id to modify
     */
    public void printAskAccountIdToModify() {
        System.out.println("Entrez le numero d'identification de compte bénévole à modifier");
    }

    /**
     * Prints the menu for choosing the account information to modify
     */
    public void printMenuSelectModification() {
        System.out.println("\nCHOISISSEZ LE TYPE DE CATEGORIE A CHANGER");
        System.out.println("[1] Modifier le prenom");
        System.out.println("[2] Modifier le nom");
        System.out.println("[3] Modifier la date de naissance");
        System.out.println("[4] Modifier le numero de telephone");
        System.out.println("[5] Modifier l'adresse courriel");
        System.out.println("[6] Modifier l'adresse");
        System.out.println("[7] Modifier le code postal");
        System.out.println("[8] Modifier la ville");
        System.out.println("[9] Modifier le code d'identification");
        System.out.println("[10] Modifier le mot de passe");
        System.out.println("[0] Retour au menu précédant");
    }

    /**
     * Prompts the user to enter a username for a volunteer account
     */
    public void printAskEnterUsername() {
        System.out.println("Entrez le nom d'utilisateur de compte du benevole (9 chiffres)");
    }

    /**
     * Prompts the user to enter a password of a volunteer account
     */
    public void printAskEnterPassword() {
        System.out.println("Entrez le mot de passe du compte du benevole (8 characteres minimum, 1 majuscule, 1 charactere special):");
    }

    /**
     * Prompts the user to enter a username to login
     */
    public void printEnterLoginUsernameMsg() {
        System.out.println("Veuillez entrer le username:");
    }

    /**
     * Prompts the user to enter a password to login
     */
    public void printEnterLoginPasswordMsg() {
        System.out.println("Veuillez entrer le password:");
    }

    /**
     * Prints the user to try again to login
     */
    public void printLoginTryAgain() {
        System.out.println("Veuillez réessayer.");
    }

    /**
     * Prints an error about the invalid password entered
     */
    public void printPasswordInvalid() {
        System.out.println("Le mot de passe est invalide!");
    }

    /**
     * Prints the account creation of the user
     */
    public void printAccountCreated() {
        System.out.println("Le compte est créé!");
    }

    public void printVolunteerAccountNotFound() {
        System.out.println("Le bénévole n'a pas été trouvé!");
    }
}
