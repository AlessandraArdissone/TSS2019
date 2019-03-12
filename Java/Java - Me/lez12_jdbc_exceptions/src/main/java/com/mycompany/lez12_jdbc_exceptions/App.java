/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez12_jdbc_exceptions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
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
    }
}
