package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();
    CustomerDTO searchCustomer(String id);
    boolean saveCustomer(CustomerDTO dto);
    boolean updateCustomer(CustomerDTO dto);
    boolean deleteCustomer(String id);
}
