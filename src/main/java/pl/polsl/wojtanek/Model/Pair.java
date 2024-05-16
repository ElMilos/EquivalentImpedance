/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.wojtanek.Model;
/**
 * A generic class representing a triplet of elements.
 *
 * @param <A> the type of the first element
 * @param <B> the type of the second element
 * @param <C> the type of the third element
 */
public class Pair<A, B, C> {

    private final A first;
    private final B second;
    private final C third;
    /**
     * Constructs a new triplet of elements.
     *
     * @param first  the first element of the triplet
     * @param second the second element of the triplet
     * @param third  the third element of the triplet
     */
    public Pair(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Retrieves the first element of the triplet.
     *
     * @return the first element
     */
    public A getFirst() {
        return first;
    }

    /**
     * Retrieves the second element of the triplet.
     *
     * @return the second element
     */
    public B getSecond() {
        return second;
    }

    /**
     * Retrieves the third element of the triplet.
     *
     * @return the third element
     */
    public C getThird() {
        return third;
    }
}
