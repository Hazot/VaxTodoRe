package Views;

/**
 * The utility view for general print methods
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class UtilView {

    /**
     * Print to ask the user for a number
     */
    public void printEnterNumber() {
        System.out.println("\nVeuillez entrer un numéro: ");
    }

    /**
     * Print to show an invalid choice
     */
    public void printInvalidChoiceMsg() {
        System.out.println("Choix invalide. Veuillez réessayer.");
    }

    /**
     * Print to show an invalid choice that is not a number
     */
    public void printInvalidChoiceNumberMsg() {
        System.out.println("Entrée non valide. Veuillez entrer un numéro.");
    }

    /**
     * Print to show that the program is exiting
     */
    public void printExitMsg() {
        System.out.println("Goodbye!");
    }
}
