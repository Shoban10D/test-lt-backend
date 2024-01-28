package org.test;

import Dto.customerDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.customerService;
import testpack.customer;

import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Inject()
    customerService customerServ;

    @GET
    public List<customer> hello() {
        List<customer> listAll = customer.findAll().list();
        return listAll;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void customerData(customerDTO customerData){
        customerServ.postCustomerData(customerData);
    }
}
