package javanbwebtemplate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javanbwebtemplate.logic.PersonLogic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonServlet", urlPatterns = {"/PersonServlet"})
public class PersonServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, 
                                    HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String salary = request.getParameter("salary");
            
            
            PersonLogic logic = new PersonLogic("jdbc:mysql://localhost/cardexdb?"
                    + "user=root&password=12345&"
                    + "autoReconnect=true&useSSL=false");
            int rows = logic.insertPerson(name, 
                    Integer.parseInt(age), 
                    Integer.parseInt(salary));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>New Person Server</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>New Person Server</h1>");
            out.println("<br>");
            out.println("<p>bienvenidos al server</p>");
            out.println("name: " + name);
            out.println("<br>");
            out.println("age: " + age);
            out.println("<br>");
            out.println("salary: " + salary);
            out.println("<br>");
            out.println("rows: " + rows);
            out.println("</body>");
            out.println("</html>");
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
