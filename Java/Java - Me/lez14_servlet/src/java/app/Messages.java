/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebServlet("/hello")
public class Messages extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // http://localhost:8080/lez14_servlet/hello?id=1
        System.out.println("Ho ricevuto una richiesta.");
        System.out.println(req.getParameter("id"));
        
        PrintWriter wr = resp.getWriter();
        wr.println("<h1> Hello from servlet! :-)</h1>");
    }
}
