/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business;

import app.models.Customer;
import java.sql.Connection;
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
@Named("db")
@Stateless
public class CustomerStore {

    public List<Customer> searchCustomer(String search) {

        try(Connection cn = DSManager.connection();) {  
            List<Customer> result = new ArrayList<>();
            try (Statement cmd = cn.createStatement(); 
                 ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                    + " from customers "
                    + " where customerName like '" + search + "%' order by customerName")) {
                while (query.next()) {
                    result.add(new Customer(query.getInt("customerNumber"),
                            query.getString("customerName")));
                }
            }

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
    }

    public List<Customer> findAll() {
        try(Connection cn = DSManager.connection();) {
            List<Customer> result = new ArrayList<>();
            try (Statement cmd = cn.createStatement(); 
                 ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                    + " from customers order by customerName")) {
                while (query.next()) {
                    result.add(new Customer(query.getInt("customerNumber"),
                            query.getString("customerName")));
                }
            }

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
    }

    public Customer find(int id) {
        try(Connection cn = DSManager.connection();) { 
            Customer result = null;
            try (Statement cmd = cn.createStatement(); 
                 ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                    + " from customers "
                    + " where customerNumber = " + id)) {
                if (query.next()) {
                    result=new Customer(query.getInt("customerNumber"),
                            query.getString("customerName"));
                }
            }

            return result;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManger error");
        }
    }
}
