/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.wojtanek.Model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for performing operations on lists of ComplexNumbers using
 * streams.
 *
 * This class provides functionality to manipulate lists of ComplexNumbers using
 * Java streams.
 *
 * @author Miłosz
 */
public class StreamTest {

    /**
     * Reverses a list of ComplexNumbers based on their real part using streams.
     *
     * @param PartList The list of ComplexNumbers to be reversed.
     * @return A new list of ComplexNumbers sorted in ascending order based on
     * their real parts.
     */

    public List<ComplexNumber> ReverseList(List<ComplexNumber> PartList) {
        return PartList.stream()
                .sorted((p1, p2) -> Double.compare(p1.real(), p2.real()))
                .collect(Collectors.toList());

    }

}
