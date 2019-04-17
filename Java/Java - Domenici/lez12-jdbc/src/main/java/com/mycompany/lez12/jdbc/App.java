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

    private final static String DRIVER = "org.mariadb.jdbc.Driver";
    private final static String URL = "jdbc:mariadb://localhost:3306/classicmodels";
    private final static String USR = "tss";
    private final static String PWD = "ghiglieno";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER);

            Connection cn = DriverManager.getConnection(URL, USR, PWD);

            System.out.println("Connessione effettuata con successo!!!");
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Inserisci le iniziali del cliente da cercare..");
            
            String ricerca = scanner.nextLine();
            
            Statement cmd = cn.createStatement();
            
            ResultSet risultato = cmd.executeQuery("select * from customers "
                    + "where customerName like '" + ricerca + "%'  order by customerName");
            
            System.out.println("--------- Clienti trovati --------------------");
            while(risultato.next()){
                System.out.println(risultato.getString("customerName"));
            }
            
            risultato.close();
            
            cmd.close();
            
            cn.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Scusa ma qualcosa è andato storto nel caricamento del driver!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Scusa ma qualcosa è andato storto nella connessione al db!!!");
        }

    }
}
