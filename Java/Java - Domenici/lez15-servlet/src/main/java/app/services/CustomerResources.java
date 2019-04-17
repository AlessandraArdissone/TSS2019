/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.business.CustomerStore;
import app.models.Customer;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author tss
 */
@Path("/customers")
public class CustomerResources {
    
    @Inject
    CustomerStore manager;
    
    @GET
    public List<Customer> all(){
        return manager.findAll();
    }
    
    @GET
    @Path("{id}")
    public Customer find(@PathParam("id") int id){
        return manager.find(id);
    }
    
    @GET
    @Path("search")
    public List<Customer> searchByName(@QueryParam("name") String name){
        return manager.searchCustomer(name);
    }
}
