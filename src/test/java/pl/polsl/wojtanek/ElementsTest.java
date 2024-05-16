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
import pl.polsl.wojtanek.Model.CircutPart;
import pl.polsl.wojtanek.Model.Coil;
import pl.polsl.wojtanek.Model.Condensator;
import pl.polsl.wojtanek.Model.Resistor;

/**
 * Unit tests for the elements (Resistor, Condensator, Coil) classes.
 *
 * This class contains test cases for different methods of the elements classes.
 *
 * @author milosz
 */
public class ElementsTest {

    /**
     *
     */
    public ElementsTest() {
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
     * Tests the Resistor class.
     *
     * @param a Value for resistor
     * @param b Expected impedance value
     */
    @ParameterizedTest
    @CsvSource({"2.5,2.5", "-1,-1", "9,9"})
    public void TestResistor(double a, double b) {
        CircutPart CP = new CircutPart();
        Resistor R = new Resistor();
        CP.AddToList(R.CountImpedation(a, 0));

        assertEquals(CP.getList().get(0).real(), b, "impedation of reststor");
    }

    /**
     * Tests the Condensator class.
     *
     * @param a First value for condensator
     * @param b Second value for condensator
     * @param c Expected imaginary part of the impedance value
     */
    @ParameterizedTest
    @CsvSource({"1, 1 ,0.15915494309189535", "-1,-1,0.15915494309189535"})
    public void TestCondensator(double a, double b, double c) {
        CircutPart CP = new CircutPart();
        Condensator K = new Condensator();
        CP.AddToList(K.CountImpedation(a, b));

        assertEquals(CP.getList().get(0).imaginary(), c, "impedation of reststor");
    }

    /**
     * Tests the Coil class.
     *
     * @param a First value for coil
     * @param b Second value for coil
     * @param c Expected imaginary part of the impedance value
     */
    @ParameterizedTest
    @CsvSource({"1, 1 ,6.283185307179586", "-1,-1,6.283185307179586"})
    public void TestCoil(double a, double b, double c) {
        CircutPart CP = new CircutPart();
        Coil C = new Coil();
        CP.AddToList(C.CountImpedation(a, b));

        assertEquals(CP.getList().get(0).imaginary(), c, "impedation of reststor");
    }
}
