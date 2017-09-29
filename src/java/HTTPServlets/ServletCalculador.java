/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTTPServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Sr. Alberto
 */
@WebServlet(name = "ServletCalculador", urlPatterns = {"/ServletCalculador"})
public class ServletCalculador extends HttpServlet {

    String val;
    float num1,num2;
    float resultado;    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param respuesta servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest peticion, HttpServletResponse response)
            throws ServletException, IOException {
        num1 = Integer.parseInt(peticion.getParameter("numero1"));
        num2 = Integer.parseInt(peticion.getParameter("numero2"));
        val = peticion.getParameter("Oper");
        
        switch(val){
            case "Suma":
                resultado = (num1 + num2) ;
                break;
            case "Resta":
                resultado = num1-num2;
                break;
            case "Multiplicacion":
                resultado = num1*num2;
                break;
            case "Division":
                resultado = num1/num2;
                break;
                    
        }
        if (val.equals("Seleccione una Operacion")) {
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println("<html>");
            out.println("<head><title>Respuesta al Formulario del Servlet</title></head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<p><h1><center>Lo setimos, debe elegir una opción viable</center></h1></p>");
            out.println("<form action=\"index.html\" ><input type=\"submit\" value=\"Regresar\" /> </form>");
            out.println("</center>");
            out.println("</body></html>");
            out.close();
        } else {
            
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println("<html>");
            out.println("<head><title>Respuesta al Formulario del Servlet</title></head>");
            out.println("<body>");            
            out.println("<br><br><br>");            
            out.println("<p><h1><center>Resultado: "+resultado+"</center></h1></p>");
            out.println("</body></html>");
            out.close();
        }
    }

}
