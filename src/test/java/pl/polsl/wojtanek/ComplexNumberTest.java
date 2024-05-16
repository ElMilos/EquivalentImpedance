/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.wojtanek;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.wojtanek.Model.ComplexNumber;

/**
 * Unit tests for the ComplexNumber class.
 *
 * This class contains test cases for different methods of the ComplexNumber
 * class.
 *
 * @author milosz
 */
public class ComplexNumberTest {

    /**
     *
     */
    public ComplexNumberTest() {
    }

    /**
     *
     */
    @BeforeAll
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     *
     */
    @BeforeEach
    public void setUp() {
    }

    /**
     *
     */
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     * Tests the add method of the ComplexNumber class.
     *
     * @param a Real part of first ComplexNumber
     * @param b Imaginary part of first ComplexNumber
     * @param c Real part of second ComplexNumber
     * @param d Imaginary part of second ComplexNumber
     * @param e Real part of expected output ComplexNumber after add operation
     * @param f Imaginary part of expected output ComplexNumber after add
     * operation
     */
    @ParameterizedTest
    @CsvSource({"2.5, 2.0, 4.0 , 5.0, 6.5, 7.0", "0.5, 2.0, -2.0 , 2.0, 2.5, 0.0"})
    public void TestAdd(double a, double b, double c, double d, double e, double f) {
        ComplexNumber x = new ComplexNumber(a, b);
        ComplexNumber y = new ComplexNumber(c, d);

        ComplexNumber output = new ComplexNumber(e, f);

        ComplexNumber wynik = new ComplexNumber().add(x, y);

        assertEquals(wynik.real() + wynik.imaginary(), output.real() + output.imaginary(), "Not added correctly");
    }

    /**
     * Tests the multiply method of the ComplexNumber class.
     *
     * @param a Real part of first ComplexNumber
     * @param b Imaginary part of first ComplexNumber
     * @param c Real part of second ComplexNumber
     * @param d Imaginary part of second ComplexNumber
     * @param e Real part of expected output ComplexNumber after multiply
     * operation
     * @param f Imaginary part of expected output ComplexNumber after multiply
     * operation
     */
    @ParameterizedTest
    @CsvSource({"2.0, 2.0, 2.0 , 2.0, 0.0, 8.0", "2.5, 2.0, 1.0 , -1.0, 4.5, -0.5"})
    public void TestMultiplay(double a, double b, double c, double d, double e, double f) {
        ComplexNumber x = new ComplexNumber(a, b);
        ComplexNumber y = new ComplexNumber(c, d);

        ComplexNumber output = new ComplexNumber(e, f);

        ComplexNumber wynik = new ComplexNumber().multiply(x, y);

        assertEquals(wynik.real() + wynik.imaginary(), output.real() + output.imaginary(), "Not mulitplyed correctly");
    }

    /**
     * Tests the divide method of the ComplexNumber class.
     *
     * @param a Real part of first ComplexNumber
     * @param b Imaginary part of first ComplexNumber
     * @param c Real part of second ComplexNumber
     * @param d Imaginary part of second ComplexNumber
     * @param e Real part of expected output ComplexNumber after divide
     * operation
     * @param f Imaginary part of expected output ComplexNumber after divide
     * operation
     */
    @ParameterizedTest
    @CsvSource({"2.0, 2.0, 2.0 , 2.0, 0.9999999999999998, 0.0"})
    public void TestDivide(double a, double b, double c, double d, double e, double f) {
        ComplexNumber x = new ComplexNumber(a, b);
        ComplexNumber y = new ComplexNumber(c, d);

        ComplexNumber output = new ComplexNumber(e, f);

        ComplexNumber wynik = new ComplexNumber().divide(x, y);

        assertEquals(wynik.real() + wynik.imaginary(), output.real() + output.imaginary(), "Not divided correctly");
    }
}
