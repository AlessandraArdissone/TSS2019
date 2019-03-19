/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebServlet("/datiJava")
public class Messages extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // http://localhost:8080/lez14_servlet/hello?id=1
        System.out.println("Ho ricevuto una richiesta.");
        System.out.println(req.getParameter("id"));

        try(Connection cn = DbManager.openConnection()) {

            System.out.println("Inserisci le iniziali del cliente da cercare:");
            Scanner s = new Scanner(System.in);

            String ricerca = s.nextLine();

            try (ResultSet rs = DbManager.searchCustomersByName(cn, ricerca)) {
                System.out.println("Clienti trovati:");
                while (rs.next()) {
                    // CICLO SUI RECORD RESTITUITI DALLA QUERY
                    String name = rs.getString("customerName");
                    System.out.println(name);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Esecuzione della query fallita :-( " + ex.getMessage() + " " + ex.getClass());
        } catch (Exception ex) {
            System.out.println("Qualquadra non cosa :-( " + ex.getMessage() + " " + ex.getClass());
        }

        PrintWriter wr = resp.getWriter();
        //wr.println("<h1> Hello from servlet! :-)</h1>");
        wr.println("[\n"
                + "    {\n"
                + "        \"cognome\": \"Rossi\",\n"
                + "        \"nome\": \"Luigi\",\n"
                + "        \"email\": \"l.rossi@email.it\",\n"
                + "        \"citta\": \"torino\"\n"
                + "    }\n]");
    }
}
