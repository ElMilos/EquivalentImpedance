/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.wojtanek.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.wojtanek.Model.CircutPart;
import pl.polsl.wojtanek.Model.Coil;
import pl.polsl.wojtanek.Model.ComplexNumber;
import pl.polsl.wojtanek.Model.Condensator;
import pl.polsl.wojtanek.Model.ConnectionDB;
import pl.polsl.wojtanek.Model.FormatChecker;
import pl.polsl.wojtanek.Model.Pair;
import pl.polsl.wojtanek.Model.Resistor;
import pl.polsl.wojtanek.Model.WrongDataException;

/**
 * Servlet to handle calculations related to circuit components' impedance.
 * It retrieves input values, performs validations, calculates impedance, and updates the interface.
 *
 * @author Miłosz
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
/**
* new circut part
 */

    CircutPart CP = new CircutPart();
    /**
* new list of parts
 */
    private List<Pair<String, String, String>> resultList = new ArrayList<>();
    

    private int ListCount=0;

ConnectionDB CDB = new ConnectionDB();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

             
        

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            // Pobieranie danych
            String Connection = request.getParameter("Connection");
            String FirstComponent = request.getParameter("FirstComponent");
            String SecondComponent = request.getParameter("SecondComponent");
            String Frequency = request.getParameter("Frequency:");
            String FirstNumber = request.getParameter("FirstNumber");
            String SecondNumber = request.getParameter("SecondNumber");          
            HttpSession session = request.getSession();   
            
ComplexNumber VC = (ComplexNumber) session.getAttribute("valueCookie");
if (VC != null) {
    // Wykonaj odpowiednie operacje z valueCookie
    CP.SetX(VC);
}
List<Pair<String, String, String>> impedanceList = (List<Pair<String, String, String>>) session.getAttribute("impedanceList");
if (impedanceList != null) {
    // Wykonaj odpowiednie operacje na impedanceList
    resultList = impedanceList;
}            
            try {
                FormatChecker fc = new FormatChecker();
                fc.CheckEmpty(Connection);
                fc.CheckEmpty(FirstComponent);
                fc.CheckFormat(Frequency);
                fc.CheckFormat(FirstNumber);
                if (Connection.equals("Rownolegle")) {
                    fc.CheckEmpty(SecondComponent);
                    fc.CheckFormat(SecondNumber);
                }
            } catch (WrongDataException e) {
                out.println("<h1>Blad: " + e + "</h1>");
            }
            
     
            ComplexNumber CN = new ComplexNumber();
            if ((Connection.equals("RownolgleCC")) && (CN.eaquals(CP.getX()))) {

                out.println("Nie ma odwodu poczatkowego dla operacji CC");

            } else {
                CountAction(Connection, FirstComponent, SecondComponent, Frequency, FirstNumber, SecondNumber);
                out.println("Twoja impedancja:" + CP.getString());
                out.println("<br><a href='javascript:window.history.back()'>Powrót</a>");

              
                session.setAttribute("impedanceList", resultList);
                session.setAttribute("valueCookie", CP.getX());


            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    /**
     * Performs actions when the Count button is pressed. Retrieves input values,
     * validates format, calculates impedance, and updates the interface.
     *
     * @param Values An array of strings containing input values.
     */
    private void CountAction(String... Values) {

       
        double Freq = Double.parseDouble(Values[3]);

        if (!Values[0].equals("Rownolegle")) {

            double Value = Double.parseDouble(Values[4]);
            CheckComponent1(Values[1], Values[0], Value, Freq);

        } else {

            double Value1 = Double.parseDouble(Values[4]);
            double Value2 = Double.parseDouble(Values[5]);

            CheckComponent1(Values[1], Values[0], Value1, Freq);
            CheckComponent1(Values[2], Values[0], Value2, Freq);

        }


        CountImpe(Values[0]);
    
    }
    /**
     * Checks circuit components and calculates impedance based on the selected
     * component type.
     *
     * @param x The selected component type.
     * @param conn The connection type.
     * @param a Array of double values representing the component parameters.
     */
    void CheckComponent1(String x, String conn, double... a) {

        if (!x.isBlank()) {

            switch (x) {
                case "Rezystor": {
                    Resistor R = new Resistor();
                    CP.AddToList(R.CountImpedation(a[0], 0));
                    break;

                }
                case "Kondensator": {
                    Condensator K = new Condensator();
                    CP.AddToList(K.CountImpedation(a[1], a[0]));
                    break;

                }
                case "Cewka": {
                    Coil C = new Coil();
                    CP.AddToList(C.CountImpedation(a[1], a[0]));
                    break;

                }

            }
            saveToList(conn, x, a[0]);
        }

    }
    /**
     * Calculates the total impedance based on the current mode (Series,
     * Parallel, or One in Parallel).
     *
     * @param Mode The selected mode of the circuit.
     */
    private void CountImpe(String Mode) {

        switch (Mode) {
            case "Szeregowo":
                CP.InSeries();
                break;
            case "Rownolegle":
                CP.InParallel();
                break;
            default:
                CP.OneInParallel();

                break;
        }
    }
    /**
     * Saves circuit parameters and impedance values to the result list.
     *
     * @param conn The connection type.
     * @param mode The selected mode of the circuit.
     * @param Value The component value.
     */
    private void saveToList(String conn, String mode, Double Value) {

        resultList.add(new Pair<>(conn, mode, Double.toString(Value)));
        ListCount++;
        
        CDB.SaveToDB(conn, mode, resultList,ListCount);
        

        }
    }


