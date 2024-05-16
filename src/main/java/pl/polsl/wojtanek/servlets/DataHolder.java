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
import java.util.List;
import pl.polsl.wojtanek.Model.Pair;

/**
 *
 * Servlet to retrieve and process a list of Pair<String,String, String> from the session.
 * It displays the content of the list as HTML.
 *
 * @author m
 */
@WebServlet(name = "DataHolder", urlPatterns = {"/DataHolder"})
public class DataHolder extends HttpServlet {

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
        
        
         HttpSession session = request.getSession();
        List<Pair<String,String, String>> resultList = (List<Pair<String,String, String>>) session.getAttribute("impedanceList");
     
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            if (resultList != null) {
            // Tutaj możesz wykonać operacje na resultList
            for (Pair<String,String, String> pair : resultList) {
                String conn = pair.getFirst();
                String mode = pair.getSecond();
                String value = pair.getThird();

                // Tutaj możesz wykorzystać wartości z resultList
                out.println("<br>Typ: "+conn+" Element: " + mode + ", Wartość: " + value);
            }
        } else {
            // Jeśli resultList jest pusta lub nie istnieje, obsłuż tę sytuację
            out.println("Lista wyników jest pusta lub nie istnieje");
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

}
