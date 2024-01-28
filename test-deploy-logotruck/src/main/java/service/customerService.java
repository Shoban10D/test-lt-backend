package service;
import Dto.customerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import testpack.customer;

import java.util.List;

@ApplicationScoped
public class customerService {
    public List<customer> getCustomerByname(){
        String customerName = "Daniel";
        List<customer> listAll = customer.find("customerName = ?1",customerName).list();
        return listAll;
    }

    @Transactional
    public void postCustomerData(customerDTO customerData){
        customer customerEntity = new customer();
        customerEntity.customerName = customerData.getCustomerName();
        customerEntity.persist();
    }

}
