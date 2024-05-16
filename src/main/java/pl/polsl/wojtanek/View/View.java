package pl.polsl.wojtanek.View;

import javax.swing.JOptionPane;
import pl.polsl.wojtanek.Model.CircutPart;

/**
 * Represents the View class for the circuit application. Provides methods for
 * displaying information and error messages.
 *
 * This class interacts with the user interface for presenting data.
 *
 * @author Miłosz
 */
@Deprecated
public class View {

    /**
     * Displays the given text message.
     *
     * @param message The text message to be displayed.
     */
    public void Show(String message) {
        JOptionPane.showMessageDialog(null,  message);
    }
    

    /**
     * Prints an error message related to input exceptions.
     *
     * @param e The exception containing the error message.
     */
    public void InputError(Exception e) {
        JOptionPane.showMessageDialog(null, "Wykryto błąd: " + e.getMessage());
    }
}
