package pl.polsl.wojtanek.Model;

import javax.swing.JOptionPane;

/**
 * Custom exception class for representing errors related to incorrect data format.
 * 
 * This exception is thrown to indicate issues with the format of input data.
 * 
 * @author Miłosz
 */
public class WrongDataException extends Exception {
    /**
     * Constructs a new WrongDataException with a default error message.
     */
    public WrongDataException() {
        super("Wykryto błąd");
    }

    /**
     * Constructs a new WrongDataException with a specific error message.
     * 
     * @param message The error message describing the issue.
     */
    public WrongDataException(String message) {
        super( message);
    }
}