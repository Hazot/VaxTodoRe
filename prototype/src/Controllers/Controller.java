package Controllers;

import Views.UtilView;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The main controller that does general things for the other controllers
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class Controller {
    /**
     * Utility view to print general things
     */
    public static final UtilView utilView = new UtilView();

    /**
     * Ask for input and waits for the input of the user and returns it
     *
     * @return int number as the input
     */
    public int getSelectionInput() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(choice < 0) {
            try {
                utilView.printEnterNumber();
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0) {
                    utilView.printInvalidChoiceMsg();
                }
            }
            catch (NumberFormatException e) {
                utilView.printInvalidChoiceNumberMsg();
            }

        }
        return choice;
    }

    /**
     * Generates a random id
     *
     * @param idLength length of the number to generate
     * @return random int that is used as an id
     */
    public String generateRandomDigitId(int idLength) {
        String id = "";

        for (int i = 0; i < idLength; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            id += Integer.toString(randomNum);
        }

        return id;
    }
}
