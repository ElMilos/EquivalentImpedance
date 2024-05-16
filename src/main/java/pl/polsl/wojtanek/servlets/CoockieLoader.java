/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.wojtanek.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.wojtanek.Model.ComplexNumber;
import pl.polsl.wojtanek.Model.Pair;

/**
 *
 * Servlet to load a cookie value, convert it to a ComplexNumber,
 * and store it in the session attribute "valueCookie".
 *
 * @author m
 */
@WebServlet(name = "CoockieLoader", urlPatterns = {"/CoockieLoader"})
public class CoockieLoader extends HttpServlet {

    private List<Pair<String, String, String>> resultList = new ArrayList<>();

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
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("valueCookie")) {

                        String cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        double[] convertedValues = convertStringToDouble(cookieValue);
                        ComplexNumber x = new ComplexNumber(convertedValues[0], convertedValues[1]);

                        HttpSession session = request.getSession();
                        session.setAttribute("valueCookie", x);
                        response.setContentType("text/html;charset=UTF-8");
                    }
                }
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
     * Converts a string representation of two double values separated by a space
     * into an array of doubles.
     *
     * @param inputString The input string containing two double values separated by a space
     * @return An array of doubles parsed from the input string
     */
    public static double[] convertStringToDouble(String inputString) {
        double[] doubleValues = new double[2]; // Tablica na dwa double

        String[] parts = inputString.split(" "); // Dzielimy string na części, separator - spacja

        doubleValues[0] = Double.parseDouble(parts[0]); // Parsujemy pierwszą część na double
        doubleValues[1] = Double.parseDouble(parts[1]); // Parsujemy drugą część na double
        return doubleValues; // Zwracamy tablicę z dwoma double

    }
}
