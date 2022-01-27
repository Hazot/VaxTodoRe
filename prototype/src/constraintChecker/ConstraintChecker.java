package constraintChecker;

/**
 * Class for methods that check the constraints on entity attributes
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class ConstraintChecker {

    /**
     * Checks if the entry has a valid amount of character
     *
     * @param entry input of the user
     * @param charSize character limit corresponding to the type of entry
     * @return boolean about if the entry is valid or not
     */
    public static boolean isUsernameLimitValid(int entry, int charSize) {
        String integer = Integer.toString(entry);
        if (integer.length() == charSize) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the entry has a valid amount of character
     *
     * @param entry input of the user
     * @param charLimit character limit corresponding to the type of entry
     * @return boolean about if the entry is valid or not
     */
    public static boolean isCharLimitValid(String entry, int charLimit) {
        if (entry.length() > charLimit) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the date entered is a valid date
     *
     * @param dateStr date in string format
     * @return boolean about if the date entered if valid
     */
    public static boolean isDateFormatValid(String dateStr) {
        if (dateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the time entered is a valid time
     *
     * @param timeStr time in string format
     * @return boolean about if the time entered is a valid date
     */
    public static boolean isTimeFormatValid(String timeStr) {
        if (timeStr.matches("([0-9]{2}:[0-9]{2})")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the dose type is a valid dose type
     *
     * @param doseType integer dose type
     * @return boolean about if the dose type is a valid dose type
     */
    public static boolean isDoseTypeValid(String doseType) {
        if (doseType.matches("([1-2]{1})")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the answer is "oui" ou "non"
     *
     * @param answer String answer
     * @return boolean about if the answer is a valid response
     */
    public static boolean isOuiNonAnswerValid(String answer) {
        if (answer.matches("^oui$") || answer.matches("^non$")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if vaccine choice is a valid vaccine name
     *
     * @param choice string vaccine name user entry
     * @return boolean about if the entry is valid
     */
    public static boolean isVaccineChoiceValid(String choice) {
        if (choice.matches("([1-4]{1})")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the password is a valid password
     *
     * @param password password entered by a user
     * @return boolean about if the entry is valid
     */
    public static boolean isPasswordValid(String password) {
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}$")) {
            return true;
        }
        return false;
    }
}
