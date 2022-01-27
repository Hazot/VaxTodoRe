package Views;

import Entities.Appointment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The appointment view defining the looks and prints of the appointment menu
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class AppointmentView {
    /**
     * Prints the main appointment menu
     */
    public void printAppointmentMenu() {
        System.out.println("\nMENU RENDEZ-VOUS");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher le calendrier");
        System.out.println("[2]: Ajouter un nouveau rendez-vous");
        System.out.println("[3]: Afficher rendez-vous existant");
        System.out.println("[4]: Envoyer notification de rappel");
        System.out.println("[0]: Retour au menu précédant");
    }

    /**
     * Prints the appointment menu display options
     */
    public void printAppointmentOptions() {
        System.out.println("\nMENU RENDEZ-VOUS CHOIX");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher tous les rendez-vous");
        System.out.println("[2]: Afficher rendez-vous existant a une date specifique");
        System.out.println("[0]: Retour au menu précédant");
    }

    /**
     * Prompts the user to enter username
     */
    public void printAskEnterFName() {
        System.out.print("Entrez le prenom du visiteur (50 char max): ");
    }

    /**
     * Prompts the user to enter a last name
     */
    public void printAskEnterLName() {
        System.out.print("Entrez le nom du visiteur (50 char max): ");
    }

    /**
     * Prompts the user to enter a date
     */
    public void printAskEnterDate() {
        System.out.print("Entrez la date sous le format \"YYYY-MM-DD\": ");
    }

    /**
     * Prompts the user to enter a time
     */
    public void printAskEnterTime() {
        System.out.print("Entrez l'heure de la visite sous le format \"HH:mm\": ");
    }

    /**
     * Prompts the user to enter a dose type
     */
    public void printAskEnterDoseType() {
        System.out.print("Entrez le type de dose (1 ou 2): ");
    }

    /**
     * Prints an appointment
     *
     * @param appointment a specific appointment to show
     */
    public void printAppointment(Appointment appointment) {System.out.println(appointment); }

    /**
     * Prompts the user to enter a date and hour
     */
    public void printAskDateSelection() {
        System.out.print("Entrez la date et l'heure de la consultation sous le format \"YYYY-MM-DD HH:mm\": ");
    }

    /**
     * Prints a too many rdv in page error
     */
    public void printTooManyAppointmentsMsg() {
        System.out.println("Il y a déjà plus de 15 rendez-vous pour cette date et plage horaire!");
    }

    /**
     * Prompts the user to enter information again because of an error
     */
    public void printAskEnterInfoAgain() {
        System.out.println("Veuillez entrer à nouveau les informations.");
    }

    /**
     * Prints the confirmation that the reminders have been sent
     */
    public void printNotificationReminder() {
        System.out.println("-------------------------------");
        System.out.println("Notification de rappel envoyer!");
        System.out.println("-------------------------------");
    }

    /**
     * Prompts the user to enter the date and hour for the appointment
     */
    public void printAskDateNoHourSelection() {
        System.out.print("Entrez la date et de la consultation sous le format \"YYYY-MM-DD\": ");
    }

    /**
     * Prints an appointment available
     *
     * @param appointment takes an appointment to pretty print
     */
    public void printAvailableAppointment(String appointment) {
        System.out.println(appointment);
    }

    /**
     * Prints a message to announce that the available hours of consultation will follow
     */
    public void printShowDateAvailabilities() {
        System.out.println("Voici les heures disponibles a la date choisi: ");
    }

    /**
     * Prints a message to announce that the available days will follow
     */
    public void printNext5AvailableDays() {
        System.out.println("Voici les 5 prochaines journées disponibles:");
    }

    /**
     * Prompts the user with a menu to ask them if he wants more availabilities
     */
    public void printShowNext5Availabilities() {
        System.out.println("\nMENU JOURS DISPONIBLES:");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher les 5 prochaines journées disponibles");
        System.out.println("[0]: Retour au menu précédant");
    }

    /**
     * Prints 5 available dates from the filtered dates
     *
     * @param dates ArrayList of dates to print
     */
    public void printDates(ArrayList<Date> dates) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        for (Date date : dates) {
            System.out.println(dateFormatter.format(date));
        }
    }

    /**
     * Prints the calendar option menu used to interact with the user
     */
    public void printCalendarOptions() {
        System.out.println("\nMENU CALENDRIER CHOIX");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher les 5 prochains rendez-vous disponible");
        System.out.println("[2]: Afficher rendez-vous disponible a une date specifique");
        System.out.println("[0]: Retour au menu précédant");
    }

    /**
     * Prints the appointment menu for the volunteer user
     */
    public void printAppointmentMenuVolunteer() {
        System.out.println("\nMENU RENDEZ-VOUS");
        System.out.println("======================================================");
        System.out.println("[1]: Afficher le calendrier");
        System.out.println("[2]: Ajouter un nouveau rendez-vous");
        System.out.println("[3]: Afficher rendez-vous existant");
        System.out.println("[0]: Retour au menu précédant");
    }

    public void printInvalidDateFormat() {
        System.out.println("Format de date invalide!");
    }
}
