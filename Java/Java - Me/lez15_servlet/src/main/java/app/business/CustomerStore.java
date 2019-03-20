/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business;

import app.models.Customer;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author tss
 */
// dentro nome posso dare parametri
// serve solo per le JSP
@Named("db") // per JSP!
// si fa diventara un EJB (Enterprise Java Bean)
// per classi che fanno le query al 99% risolvono i problemi
// dichiararle come Staless e vengono gestite dal Web Application Server (Payara)
@Stateless // Enterprise Java Bean
public class CustomerStore {
/*
    // PARAMETRI DELLA CONNESSIONE AL DB:
    private final static String DRIVER = "org.mariadb.jdbc.Driver";
    private final static String URL = "jdbc:mariadb://localhost:3306/classicmodels";
    private final static String USR = "root";
    private final static String PWD = "ghiglieno";
*/
    public List<Customer> searchCustomer(String search) {
        try(Connection cn = DSManager.connection();) {
        /*
            Class.forName(DRIVER);   // CARICO IL DRIVER
            Connection cn = DriverManager.getConnection(URL, USR, PWD); // MI CONNETTO AL SQL SERVER MYSQL(MARIADB)
        */
            System.out.println("Connessione effettuata con successo :-)");

            List<Customer> result = new ArrayList<>();
            
            try (Statement cmd = cn.createStatement(); // CREO UN OGGETTO DI TIPO "ISTRUZIONE"
                    ResultSet query = cmd.executeQuery("SELECT * FROM customers WHERE customerName LIKE '"
                        + search + "%' ORDER BY customerName");) {    // ESEGUO UNA QUERY

                System.out.println("-----------------------Clienti trovati-----------------------");
            
                while (query.next()) {  // CICLO SUI RECORD RESTITUITI DALLA QUERY
                    String name = query.getString("customerName");
                    System.out.println(name);
                    result.add(new Customer(query.getInt("customerNumber"), query.getString("customerName"), query.getString("city"), query.getString("country")));
                }
            }
        /*    
            // RILASCIO LE RISORSE "CHIUDENDO" TUTTI GLI OGGETTI:
            query.close();
            cmd.close();
            cn.close();
        */    
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManager error");
/*
            System.out.println(ex.getMessage());
            System.out.println("Connessione al DB fallita :-(");
            throw new RuntimeException("Connessione al DB fallita :-(");
*/
        }
    }

    public List<Customer> findAll() {
        try(Connection cn = DSManager.connection();) {
            System.out.println("Connessione effettuata con successo :-)");

            List<Customer> result = new ArrayList<>();
            
            try (Statement cmd = cn.createStatement(); // CREO UN OGGETTO DI TIPO "ISTRUZIONE"
                    ResultSet query = cmd.executeQuery("SELECT customerNumber, customerName FROM customers ORDER BY customerName");) {    // ESEGUO UNA QUERY

                System.out.println("-----------------------Clienti trovati-----------------------");
            
                while (query.next()) {  // CICLO SUI RECORD RESTITUITI DALLA QUERY
                    String name = query.getString("customerName");
                    System.out.println(name);
                    result.add(new Customer(query.getInt("customerNumber"), query.getString("customerName")));
                }
            }

            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManager error");
        }
    }

public Customer find(int id) {
        try (Connection cn = DSManager.connection();) { // gestione di connesione la fa DSManager
            // prepara lista vuota
            Customer result=null;

            // try con resources
            try (Statement cmd = cn.createStatement();
                    ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                            + " from customers "
                            + " where customerNumber = " + id )) {
                // per ogni record creo oggetto Customer
                // alla fine abbiamo una lista di oggetti
                if (query.next()) {
                    result=new Customer(query.getInt("customerNumber"),
                            query.getString("customerName"));
                }
            }
            
            return result;
        // gestione eccezione 
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManager error");
        }
    }
}
