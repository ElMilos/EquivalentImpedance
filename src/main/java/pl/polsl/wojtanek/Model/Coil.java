/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.wojtanek.Model;
/**
 * Represents a coil component in an electrical circuit inheriting from CircuitPart.
 * Calculates the impedance of the coil based on provided parameters.
 * 
 * This class extends the CircuitPart class and overrides the method to calculate impedance.
 * It represents a coil component in an electrical circuit and calculates the impedance
 * based on the given parameters.
 * 
 * @author milosz
 */
public class Coil extends CircutPart
{    /**
     * Calculates the impedance of the coil based on provided parameters.
     * 
     * @param a Array of parameters used to calculate impedance.
     *          a[0] represents the value of the coil.
     *          a[1] represents the frequency.
     * @return The impedance calculated for the coil.
     */
        @Override
    public ComplexNumber CountImpedation(double... a)
    {
        double x =a[0];
        double omega = 2*Math.PI*a[1];
        return new ComplexNumber(0,(x*omega) );
     }
}
