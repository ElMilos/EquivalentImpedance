/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.wojtanek.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a circuit part. This class performs operations on a list
 * of ComplexNumbers representing circuit components.
 *
 * @author Miłosz
 */
public class CircutPart {
    // List to hold the circuit components

    private final List<ComplexNumber> PartList = new ArrayList<>();
    // Represents the total impedance
    private ComplexNumber x = new ComplexNumber();

    /**
     * Method to calculate the impedance of circuit components. Not implemented;
     * returns null.
     *
     * @param a An array of doubles representing circuit component values.
     * @return Null as impedance calculation is not implemented in this method.
     */
    public ComplexNumber CountImpedation(double... a) {
        return null;
    }

    /**
     * Sets the total impedance value.
     *
     * @param x The ComplexNumber representing the total impedance.
     */
    public void SetX(ComplexNumber x) {
        this.x = x;
    }

    /**
     * Adds a ComplexNumber to the list of circuit components.
     *
     * @param CN The ComplexNumber to be added to the circuit components list.
     */
    public void AddToList(ComplexNumber CN) {
        PartList.add(CN);
    }

    /**
     * Calculates the total impedance in series for the circuit components.
     * Clears the list of circuit components after calculation.
     */
    public void InSeries() {
        for (ComplexNumber List : PartList) {
            x = x.add(x, List);
        }

        PartList.clear();
    }

    /**
     * Calculates the total impedance in parallel for the circuit components.
     * Clears the list of circuit components after calculation.
     */
    public void InParallel() {
        ComplexNumber Numerator = new ComplexNumber();
        ComplexNumber Denominator = new ComplexNumber();
        ComplexNumber result = new ComplexNumber();

        Numerator = Numerator.multiply(PartList.get(0), PartList.get(1));
        Denominator = Denominator.add(PartList.get(0), PartList.get(1));
        result = result.divide(Denominator, Numerator);

        x = x.add(x, result);

        PartList.clear();
    }

    /**
     * Performs a calculation for a single component in parallel. Clears the
     * list of circuit components after calculation.
     */
    public void OneInParallel() {

        ComplexNumber Numerator = new ComplexNumber();
        ComplexNumber Denominator = new ComplexNumber();
        ComplexNumber result = new ComplexNumber();

        Numerator = Numerator.multiply(PartList.get(0), x);
        Denominator = Denominator.add(PartList.get(0), x);
        result = result.divide(Denominator, Numerator);

        x = result;

        PartList.clear();
    }

    /**
     * Test method - generates a string representing the reverse order of the
     * collection based on the real part of ComplexNumbers.
     *
     * @return A string representation of the reversed collection based on the
     * real part.
     */
    public String TestStream() {
        StreamTest streamTest = new StreamTest();
        List<ComplexNumber> ListReversed = streamTest.ReverseList(PartList);
        return (" Odwrócona kolekcja względem argumentu realnego rosnąco : " + ListReversed.get(0).real() + " " + ListReversed.get(1).real());

    }

    /**
     * Gets a formatted string representation of the total impedance.
     *
     * @return A string representing the real and imaginary parts of the total
     * impedance.
     */
    public String getString() {
        String a = String.format("%.4f", x.real()) + "  i" + String.format("%.4f", x.imaginary());
        return a;
    }
        /**
     * Gets a formatted string representation of the total impedance.
     *
     * @return A string representing the real and imaginary parts of the total
     * impedance.
     */
    public String getStringNumber() {
        String a = String.format("%.4f", x.real()) + " " + String.format("%.4f", x.imaginary());
        return a;
    }
    /**
     * Retrieves the total impedance value.
     *
     * @return The ComplexNumber representing the total impedance.
     */
    public ComplexNumber getX() {
        return x;
    }

    /**
     * Retrieves the list of circuit components.
     *
     * @return The list of ComplexNumbers representing circuit components.
     */
    public List<ComplexNumber> getList() {
        return PartList;
    }
}
