/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez12.jdbc;

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

    public static void main(String[] args) {

        try(Connection cn = DbManager.openConnection();) {
            
            System.out.println("Connessione effettuata con successo!!!");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Inserisci le iniziali del cliente da cercare..");

            String ricerca = scanner.nextLine();

            try (ResultSet risultato = DbManager.searchCustomersByName(cn, ricerca)) {
                System.out.println("--------- Clienti trovati --------------------");
                while (risultato.next()) {
                    System.out.println(risultato.getString("customerNames"));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Scusa ma qualcosa è andato storto nell'esecuzione della query..");
        } catch (Exception ex) {
            System.out.println("Qualcosa è andato storto.. " + ex.getMessage() + " tipo errore: " + ex.getClass());
        }

    }
}
