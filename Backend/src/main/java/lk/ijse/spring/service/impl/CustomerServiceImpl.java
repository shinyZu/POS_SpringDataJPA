package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
       /* ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer customer : repo.findAll()) {
            allCustomers.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getSalary()
            ));
        }
        return allCustomers;*/
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (repo.existsById(id)) {
            /*Customer c = repo.findById(id).get();
            return new CustomerDTO(
                    c.getId(),
                    c.getName(),
                    c.getAddress(),
                    c.getSalary()
            );*/
            return mapper.map(repo.findById(id).get(), CustomerDTO.class);
        } else {
//            return null;
            throw new RuntimeException("No Customer with ID "+id);
        }
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Already Exists...");
//            System.out.println("Duplicate Customer ID...");
//            return false;
        } else {
            /*repo.save(new Customer(
                    dto.getId(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getSalary()
            ));*/
            repo.save(mapper.map(dto, Customer.class));
            return true;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Invalid Customer ID...No Such Customer....");
//            System.out.println("Invalid Customer ID...No Such Customer....");
//            return false;
        } else {
            /*repo.save(new Customer(
                    dto.getId(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getSalary()
            ));*/
            repo.save(mapper.map(dto, Customer.class));
            return true;
        }
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Invalid Customer ID...No Such Customer....");
//            System.out.println("Invalid Customer ID...No Such Customer....");
//            return false;
        } else {
            repo.deleteById(id);
            return true;
        }
    }
}
