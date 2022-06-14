package lk.ijse.spring.repo;

import lk.ijse.spring.config.JPAConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

   /* @Autowired
    DataSource ds;*/

    @Test
    public void saveCustomer() {
        //System.out.println(ds);
        System.out.println("Testing");
//        Customer customer = new Customer("C006", "Kasun", "Galle", 1000.00);
//        if (repo.existsById(customer.getId())) {
//            throw new RuntimeException("Duplicate Customer ID...");
//        } else {
//            Customer save = repo.save(customer);
//            System.out.println(save);
//        }
    }
}