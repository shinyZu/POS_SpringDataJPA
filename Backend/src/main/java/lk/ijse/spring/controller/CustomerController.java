package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ResponseDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/v2/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<ResponseUtil> getAllCustomers() {
        if (customerService.getAllCustomers() != null) {
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_OK,"All Customers",customerService.getAllCustomers()));
            // return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpServletResponse.SC_OK,"All Customers",customerService.getAllCustomers()));
        } else {
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_OK,"Error",null));
            // return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpServletResponse.SC_OK,"Error",null));
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseUtil> searchCustomer(@PathVariable String id) {
        if (customerService.searchCustomer(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseUtil(HttpServletResponse.SC_OK,"Customer Search with ID",customerService.searchCustomer(id)));
        } else {
            //return ResponseEntity.internalServerError(new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR,"Customer Search with ID",null));
            //return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"No Such Customer",null));
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"No Such Customer...",null));
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<ResponseUtil> saveCustomer(@ModelAttribute CustomerDTO dto) {
        if (customerService.saveCustomer(dto)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseUtil(HttpServletResponse.SC_CREATED,"Customer Saved Successfully..!",null));
        } else {
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_BAD_REQUEST,"Something Went Wrong...",null));
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> updateCustomer(@RequestBody CustomerDTO dto) {
        if (customerService.updateCustomer(dto)) {
           // return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(HttpServletResponse.SC_OK,"Customer Updated Successfully..!",null));
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_OK,"Customer Updated Successfully..!",null));
        } else {
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_BAD_REQUEST,"Something Went Wrong...",null));
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<ResponseUtil> deleteCustomer(@RequestParam String id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_OK,"Customer Deleted Successfully..!",null));
        } else {
            return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_BAD_REQUEST,"Something Went Wrong...",null));
        }
    }

}
