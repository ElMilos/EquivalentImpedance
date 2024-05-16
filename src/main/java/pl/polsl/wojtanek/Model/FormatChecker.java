/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.wojtanek.Model;

/**
 * Utility class to check the format of a numerical value.
 *
 * This class provides a method to verify the format of a numerical value. It
 * throws a WrongDataException if the provided value is equal to zero.
 *
 * @author milosz
 */
public class FormatChecker {

    /**
     * Checks the format of a numerical value and throws an exception if it's
     * zero.
     *
     * @param a The numerical value to be checked for its format.
     * @throws WrongDataException If the provided value is equal to zero.
     */
    public void CheckFormat(String a) throws WrongDataException {
        if (a.isBlank()) {
            throw new WrongDataException("Pole jest puste");
        }
        try {
            double liczba = Double.parseDouble(a);

        } catch (NumberFormatException e) {
            throw new WrongDataException("Nie podano liczby");

        }

    }
        /**
         * Checks the format of a numerical value and throws an exception if
         * it's zero.
         *
         * @param a The numerical value to be checked for its format.
         * @throws WrongDataException If the provided value is equal to null.
         */
    public void CheckEmpty(String a) throws WrongDataException {
        if (a == null) {
            throw new WrongDataException("Nie wybrano komponentu lub polaczenia");
        }
    }
}
