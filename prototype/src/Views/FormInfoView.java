package Views;

import Entities.FormInfo;

/**
 * The form information view defining the looks and prints of the forms menu
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class FormInfoView {
    /**
     * Prints the main form menu
     */
    public void printFormOptions() {
        System.out.println("\nMENU FORMULAIRE ");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher les formulaires");
        System.out.println("[2]: Imprimer les formulaires");
        System.out.println("[3]: Ajouter un formulaire");
        System.out.println("[0]: Retour au menu précédant");
    }

    /**
     * Prints the number of the form
     *
     * @param i integer number
     */
    public void printFormNumber(int i) {
        System.out.println("FORM #" + i);
    }

    /**
     * Prints the form information (pretty)
     *
     * @param formInfo form information
     */
    public void printForm(FormInfo formInfo) {
        System.out.print(formInfo);
    }

    /**
     * Prints a nice line between the forms for a better look
     */
    public void printFormSeperator() {
        System.out.println("------------------------------------------------------");
    }

    /**
     * Prints the printing confirmation message
     */
    public void printPrintingConfirmation() {
        System.out.println("Les formulaires ont été imprimés avec succès!");
    }

    /**
     * Prompts the user to enter a visit date
     */
    public void printAskVisitDate() {
        System.out.print("Entrez la date de visite sous le format \"yyyy-MM-dd\": ");
    }

    /**
     * Prompts the user to enter if the visitor has received first dose
     */
    public void printAskHasReceivedFirstDose() {
        System.out.print("Le visiteur a-t-il deja été vacciné? (oui/non): ");
    }

    /**
     * Prompts the user to enter if the visitor has contracted covid
     */
    public void printAskHasContractedCovid() {
        System.out.print("Le visiteur a-t-il deja contracté le covid? (oui/non): ");
    }

    /**
     * Prompts the user to enter if the visitor has covid symptoms
     */
    public void printAskHasCovidSymptoms() {
        System.out.print("Le visiteur a-t-il des symptomes de covid? (oui/non): ");
    }

    /**
     * Prompts the user to enter if the visitor has allergies
     */
    public void printAskHasAllergies() {
        System.out.print("Le visiteur a-t-il des allergies? (oui/non):");
    }

    /**
     * Prints the vaccine choice menu
     */
    public void printAskVaccineChoice() {
        System.out.println("[1]: Moderna");
        System.out.println("[2]: Pfizer");
        System.out.println("[3]: AstraZeneca");
        System.out.println("[4]: Janssen");
        System.out.print("Entrez le numéro du vaccin choisi par le visiteur(1, 2, 3 ou 4): ");
    }

    /**
     * Prompts the user to enter if the visitor got vaccinated
     */
    public void printAskWasVaccineAdministered() {
        System.out.print("Est-ce que le vaccin a été administré? (oui/non): ");
    }

    /**
     * Prints the vaccine choice menu for the administered one
     */
    public void printAskAdministeredVaccineName() {
        System.out.println("[1]: Moderna");
        System.out.println("[2]: Pfizer");
        System.out.println("[3]: AstraZeneca");
        System.out.println("[4]: Janssen");
        System.out.print("Entrez le numéro du vaccin administré (1, 2, 3 ou 4):");
    }

    /**
     * Prompts the user to enter the vaccine code
     */
    public void printAskVaccineCode() {
        System.out.print("Entrez le code du vaccin (24 char max): ");
    }

    /**
     * Prompts the user to enter visitor id
     */
    public void askVisitorId() {
        System.out.print("Entrez le numero de compte du visiteur (12 char): ");
    }

    /**
     * Prompts the user to enter the visitor first name
     */
    public void askVisitorFName() {
        System.out.print("Entrez le prenom du visiteur (50 char max): ");
    }

    /**
     * Prompts the user to enter the visitor last name
     */
    public void askVisitorLName() {
        System.out.print("Entrez le nom du visiteur (50 char max): ");
    }

    /**
     * Prompts the user to enter the visitor's birth date
     */
    public void askVisitorBirthDate() {
        System.out.print("Entrez la date de naissance du visiteur \"yyyy-MM-dd\": ");
    }

    /**
     * Prompts the user to enter the visitor's health insurance number
     */
    public void askVisitorHealthInsuranceNum() {
        System.out.print("Entrez le numero d'assurance maladie du visiteur: ");
    }

    public void showFormulaireAdded() {
        System.out.println("Formulaire ajouté!");
    }
}
