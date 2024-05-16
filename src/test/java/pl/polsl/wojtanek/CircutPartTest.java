/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.wojtanek;



import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.wojtanek.Model.CircutPart;
import pl.polsl.wojtanek.Model.ComplexNumber;

/**
 *
 * @author m
 */
public class CircutPartTest {

    private CircutPart circutPart;

    /**
     *
     */
    @BeforeEach
    public void setUp() {
        circutPart = new CircutPart();
    }

    /**
     * Tests the AddToList method of the CircutPart class.
     *
     * @param a Real part of the ComplexNumber to add
     * @param b Imaginary part of the ComplexNumber to add
     */
//    @ParameterizedTest
//    @CsvSource({"2.0, 2.0, 2.0, 2.0", "-2.0, 3.5,-2.0, 3.5", " 2, 3.5 , 2 , 3.5"})
//    public void testAddToList(double a, double b,double c,double d) {
//        a=2;
//        b=2;
//        circutPart.AddToList(new ComplexNumber(a, b));
//        
//    //    //Nie wiem dlaczego piszę że oczekuje 0 skoro watość zapisana w pamięci podczas debuga była poprawna
//        assertEquals(circutPart.getX().real() , c );
//    }

    /**
     * Tests the InSeries method of the CircutPart class.
     *
     * @param a Real part of first ComplexNumber
     * @param b Imaginary part of first ComplexNumber
     * @param c Real part of second ComplexNumber
     * @param d Imaginary part of second ComplexNumber
     * @param e Real part of expected output ComplexNumber after InSeries
     * operation
     * @param f Imaginary part of expected output ComplexNumber after InSeries
     * operation
     */
    @ParameterizedTest
    @CsvSource({"2.0, 2.0, 3.0, 4.0, 5.0, 6.0", "-2.0, 3.5, 4.0, 5.0, 3.0, 7.5"})
    public void testInSeries(double a, double b, double c, double d, double e, double f) {

        circutPart.AddToList(new ComplexNumber(a, b));
        circutPart.AddToList(new ComplexNumber(c, d));
        ComplexNumber output = new ComplexNumber(e, f);

        circutPart.InSeries();
        assertEquals(circutPart.getX().real() + circutPart.getX().imaginary(), output.real() + output.imaginary(), "Not added in series correctly");
    }

    /**
     * Tests the InParallel method of the CircutPart class.
     *
     * @param a Real part of first ComplexNumber
     * @param b Imaginary part of first ComplexNumber
     * @param c Real part of second ComplexNumber
     * @param d Imaginary part of second ComplexNumber
     * @param e Real part of expected output ComplexNumber after InParallel
     * operation
     * @param f Imaginary part of expected output ComplexNumber after InParallel
     * operation
     */
    @ParameterizedTest
    @CsvSource({"5, 0, 5, 0, 2.5, 0", "-2.0, 3.5, 4.0, 5.0, -0.22295081967213118, -2.947540983606558"})
    public void testInParallel(double a, double b, double c, double d, double e, double f) {

        ComplexNumber output = new ComplexNumber(e, f);
        circutPart.AddToList(new ComplexNumber(a, b));
        circutPart.AddToList(new ComplexNumber(c, d));
        circutPart.InParallel();

        assertEquals(circutPart.getX().real(), output.real(), "Not added in parrel correctly");
        assertEquals(circutPart.getX().imaginary(), output.imaginary(), "Not added in parrel correctly");

    }

    /**
     * Tests the TestStream method of the CircutPart class.
     *
     * @param a Real part of first ComplexNumber
     * @param b Imaginary part of first ComplexNumber
     * @param c Real part of second ComplexNumber
     * @param d Imaginary part of second ComplexNumber
     * @param e Real part of expected output ComplexNumber after TestStream
     * operation
     * @param f Imaginary part of expected output ComplexNumber after TestStream
     * operation
     */
    @ParameterizedTest
    @CsvSource({"1, 0, 4, 0, 1, 4", "-2.0, 3.5, 4.0, 5.0, -2.0, 4.0"})
    public void testTestStream(double a, double b, double c, double d, double e, double f) {

        circutPart.AddToList(new ComplexNumber(a, b));
        circutPart.AddToList(new ComplexNumber(c, d));

        assertEquals(" Odwrócona kolekcja względem argumentu realnego rosnąco : " + e + "" + " " + f, circutPart.TestStream());
    }

}
