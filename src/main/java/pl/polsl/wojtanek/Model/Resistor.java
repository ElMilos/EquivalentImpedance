package pl.polsl.wojtanek.Model;

/**
 * Represents a Resistor in a circuit. Extends the CircuitPart class to define
 * behavior specific to resistors. It calculates the impedance based on the
 * resistance value provided. Inherits methods to handle circuit components from
 * CircuitPart.
 *
 * @author milosz
 */
public class Resistor extends CircutPart {

    /**
     * Calculates the impedance of the resistor based on its resistance value.
     *
     * @param a Array of values representing the resistance.
     * @return ComplexNumber instance representing the impedance (real part:
     * resistance, imaginary part: 0).
     */
    @Override
    public ComplexNumber CountImpedation(double... a) {
        return new ComplexNumber(a[0], 0);
    }
}
