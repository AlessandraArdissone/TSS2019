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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class DbManager {

    private final static String DRIVER = "org.mariadb.jdbc.Driver";
    private final static String URL = "jdbc:mariadb://localhost:3306/classicmodels";
    private final static String USR = "tss";
    private final static String PWD = "ghiglieno";

    private DbManager() {
    }

    public static Connection openConnection() {
        Connection cn;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USR, PWD);
            return cn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connessione al DB fallita..,");
            throw new RuntimeException("errore nella connessione al DB...");
        }
    }

    public static ResultSet executeQuery(Connection cn, String sql) {
        try (Statement cmd = cn.createStatement()){
            return cmd.executeQuery(sql);
        } catch (SQLException ex) {
            throw new RuntimeException("errore nella esecuzione della query");
        } finally {
            System.out.println("sono nel finally...");
        }
    }
    
    
    public static ResultSet searchCustomersByName(Connection cn, String name){
        return executeQuery(cn,
                    "select * from customers "
                    + "where customerName like '" + name + "%'  order by customerName");
    }
}
