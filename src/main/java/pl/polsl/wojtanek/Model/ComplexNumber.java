package pl.polsl.wojtanek.Model;

/**
 * Represents a complex number with real and imaginary parts. Provides
 * operations for basic arithmetic on complex numbers.
 *
 * This class maintains two private instance variables, x and y, representing
 * the real and imaginary parts, respectively. The class includes methods to
 * access these values and perform arithmetic operations such as addition,
 * multiplication, division, and calculation of the complex conjugate.
 *
 * @author Milosz
 */
public class ComplexNumber {
    // These are the instance variables. Each ComplexNumber object holds
    // two double values, known as x and y. They are private, so they are
    // not accessible from outside this class. Instead, they are available
    // through the real() and imaginary() methods below.

    private double x, y;

    /**
     * Default constructor initializing the complex number to 0 + 0i.
     */
    public ComplexNumber() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Parameterized constructor initializing the complex number with given real
     * and imaginary parts.
     *
     * @param real The real part of the complex number.
     * @param imaginary The imaginary part of the complex number.
     */
    public ComplexNumber(double real, double imaginary) {
        this.x = real;
        this.y = imaginary;
    }

    /**
     * Retrieves the real part of the complex number.
     *
     * @return The real part of the complex number.
     */
    public double real() {
        return x;
    }

    /**
     * Retrieves the imaginary part of the complex number.
     *
     * @return The imaginary part of the complex number.
     */
    public double imaginary() {
        return y;
    }

    /**
     * Performs addition of two complex numbers.
     *
     * @param a The first complex number.
     * @param b The second complex number.
     * @return The result of adding the two complex numbers.
     */
    public ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.x + b.x, a.y + b.y);
    }

    /**
     * Performs multiplication of two complex numbers.
     *
     * @param a The first complex number.
     * @param b The second complex number.
     * @return The result of multiplying the two complex numbers.
     */
    public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.x * b.x - a.y * b.y, a.x * b.y + a.y * b.x);
    }

    /**
     * Divides one complex number by another.
     *
     * @param a The first complex number.
     * @param b The second complex number.
     * @return The resultant complex number (a / b).
     */
    public ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        ComplexNumber output = multiply(a, b.conjugate());
        double div = Math.pow(a.mod(), 2);
        return new ComplexNumber(output.x / div, output.y / div);
    }

    /**
     * Calculates the complex conjugate of the current complex number.
     *
     * @return The complex conjugate of the current complex number.
     */
    private ComplexNumber conjugate() {
        return new ComplexNumber(this.x, -this.y);
    }

    /**
     * Calculates the modulus of the complex number.
     *
     * @return The modulus of the complex number.
     */
    private double mod() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Checks if two complex numbers are equal.
     *
     * @param a The first complex number.
     * @param b The second complex number.
     * @return True if the complex numbers are equal; otherwise, false.
     */
    public boolean eaquals(ComplexNumber a, ComplexNumber b) {
        if (a.x == b.x && a.y == b.y) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a complex number is zero.
     *
     * @param a The complex number to check.
     * @return True if the complex number is zero; otherwise, false.
     */
    public boolean eaquals(ComplexNumber a) {
        if (a.x == 0 && a.y == 0) {
            return true;
        }
        return false;
    }
    /**
     * @return string of complex number
     */
    public String ChangeToString() {
    return x + " " + y;
}
}
