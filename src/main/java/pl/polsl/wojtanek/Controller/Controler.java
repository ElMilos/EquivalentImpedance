package pl.polsl.wojtanek.Controller;

import java.util.Scanner;

import pl.polsl.wojtanek.View.View;

import pl.polsl.wojtanek.Model.CircutPart;
import pl.polsl.wojtanek.Model.Coil;
import pl.polsl.wojtanek.Model.Condensator;
import pl.polsl.wojtanek.Model.FormatChecker;
import pl.polsl.wojtanek.Model.Resistor;

import pl.polsl.wojtanek.Model.WrongDataException;

/**
 * Controller class responsible for managing the program's logic and handling
 * user interactions. Manages data retrieval, element selection within the
 * circuit, and impedance calculations.
 *
 * @author Miłosz
 */
@Deprecated
public class Controler {

    
    View View = new View();
    CircutPart CP = new CircutPart();
    Scanner scanner = new Scanner(System.in);

    private double Frequency = 1;

    /**
     * Method to check arguments when the program starts. If there are no
     * arguments or more than one, prompts the user for the frequency.
     * Otherwise, sets the frequency from the argument and proceeds to get the
     * type of connection.
     *
     * @param args Arguments passed when the program is executed.
     */
    public void CheckForArg(String[] args) {

        GetConnection();

    }

    /**
     * Method to get the frequency from the user.
     */
    private void GetFrequency() {

        Frequency = scanner.nextDouble();

        GetConnection();
    }

    /**
     * Method to retrieve the type of connection from the user.
     */
    private void GetConnection() {

        while (true) {

            View.Show("Wybierz rodzaj polaczenia:  1-Szeregowe  2-Rownolegle");
            View.Show("3-X Po kolei szeregowo   4-Zakoncz prace programu");
            int TypeOfConnection = (int) scanner.nextDouble();
            // pytanie o połączenie
            switch (TypeOfConnection) {
                case 1:
                    ChooseElement(1);
                    break;
                case 2:
                    ChooseElement(2);
                    break;
//                case 3:
//                    View.Show("Ile elementów z Kolei?");
//                    ChooseElement(scanner.nextInt(), 1);
//                    break;
                default:
                    break;
            }

            System.exit(0);
        }
    }

    /**
     * Method allowing the user to choose circuit elements.
     *
     * @param a Number of elements to select.
     */
    private void ChooseElement(int... a) {

        for (int x = 0; x < a[0]; x++) {
            View.Show("Wybierz element ukladu:  1-Rezystor   2-Kondensator   3-Cewka");
            int TypeOfElement = (int) scanner.nextDouble();

            switch (TypeOfElement) {
                case 1: {

                    View.Show("Podaj natezenie:");

                    double Resistance = scanner.nextDouble();
                    Resistor R = new Resistor();

//                    try {
//                        FormatChecker fc = new FormatChecker();
//                        fc.CheckFormat(Resistance);
//
//                  } catch (WrongDataException e) {
//                        View.InputError(e);
//                        return;
//                   }
                    CP.AddToList(R.CountImpedation(Resistance, 0));

                }
                case 2: {
                    View.Show("Podaj pojemność kondensatora");
                    double PK = scanner.nextDouble();
                    Condensator K = new Condensator();
                    CP.AddToList(K.CountImpedation(Frequency, PK));
                }

                case 3: {
                    View.Show("Podaj Indukcyjność cewki");
                    double I = scanner.nextDouble();
                    Coil C = new Coil();
                    CP.AddToList(C.CountImpedation(Frequency, I));
                }

            }

        }
        if (a.length == 1) {
            CountImpe(a[0]);
        } else {
            CountImpe(a[1]);
        }
    }

    /**
     * Method to calculate the circuit's impedance.
     *
     * @param a Type of connection for impedance calculation.
     */
    private void CountImpe(int a) {
        if (a == 2) {
            View.Show(CP.TestStream());

            CP.InParallel();

        } else {
            CP.InSeries();
        }
        View.Show("Twoja aktualna impedancja zastepcza to =" + CP.getString());
    }
}
