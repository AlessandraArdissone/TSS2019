/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez12_jdbc_exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tss
 */
public class DbManager {

    // PARAMETRI DELLA CONNESSIONE AL DB:
    private final static String DRIVER = "org.mariadb.jdbc.Driver";
    private final static String URL = "jdbc:mariadb://localhost:3306/classicmodels";
    private final static String USR = "root";
    private final static String PWD = "ghiglieno";

    private DbManager() {
    }

//  public static Connection openConnection() throws ClassNotFoundException, SQLException {
    public static Connection openConnection() {
        try {
            Class.forName(DRIVER);   // CARICO IL DRIVER
            Connection cn = DriverManager.getConnection(URL, USR, PWD); // MI CONNETTO AL SQL SERVER MYSQL(MARIADB)
            System.out.println("Connessione effettuata con successo :-)");
            return cn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connessione al DB fallita :-( " + ex.getMessage() + " " + ex.getClass());
            throw new RuntimeException("Errore nella connessione al DB :-(");
        }
    }

    public static ResultSet executeQuery(Connection cn, String sql) {
        try(Statement cmd = cn.createStatement() ) {    // CREO UN OGGETTO DI TIPO "ISTRUZIONE"
            return cmd.executeQuery(sql);
        } catch (SQLException ex) {
            throw new RuntimeException("Errore nella esecuzione della query " + sql + " :-(");
        } finally {
            System.out.println("Sono nel finally!");
        }
    }

    public static ResultSet searchCustomersByName(Connection cn, String name) {
            return executeQuery(cn, "SELECT customerName FROM customers "
                    + "WHERE customerName LIKE '" + name + "%' "
                    + "ORDER BY customerName");    // ESEGUO UNA QUERY
    }
}
