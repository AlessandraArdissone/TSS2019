/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez12_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {

    // PARAMETRI DELLA CONNESSIONE AL DB:
    private final static String DRIVER = "org.mariadb.jdbc.Driver";
    private final static String URL = "jdbc:mariadb://localhost:3306/classicmodels";
    private final static String USR = "root";
    private final static String PWD = "ghiglieno";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);   // CARICO IL DRIVER
            Connection cn = DriverManager.getConnection(URL, USR, PWD); // MI CONNETTO AL SQL SERVER MYSQL(MARIADB)
            System.out.println("Connessione effettuata con successo :-)");
            Statement cmd = cn.createStatement(); // CREO UN OGGETTO DI TIPO "ISTRUZIONE"
            Scanner s = new Scanner(System.in);
            System.out.println("Inserisci le iniziali del cliente da cercare:");
            String ricerca = s.nextLine();
            ResultSet risultato = cmd.executeQuery("SELECT customerName FROM customers WHERE customerName LIKE '"
                    + ricerca + "%' ORDER BY customerName");    // ESEGUO UNA QUERY
            while (risultato.next()) {  // CICLO SUI RECORD RESTITUITI DALLA QUERY
                String name = risultato.getString("customerName");
                System.out.println(name);
            }
            // RILASCIO LE RISORSE "CHIUDENDO" TUTTI GLI OGGETTI:
            risultato.close();
            cmd.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver non caricato :-(");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Connessione al DB fallita :-(");
        }
    }
}
