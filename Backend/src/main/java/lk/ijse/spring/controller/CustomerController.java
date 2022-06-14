package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ResponseDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/v2/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ArrayList<ResponseDTO> getAllCustomers() {
        /*ArrayList<ResponseInfo> response = new ArrayList<>();
        response.add(new ResponseInfo(
                HttpServletResponse.SC_OK,
                "Received All Customers",
                customerService.getAllCustomers()
        ));*/
        // return customerService.getAllCustomers();
        return ResponseUtil.generateResponse(
                HttpServletResponse.SC_OK,
                "Customer Search with ID",
                customerService.getAllCustomers()
        );
    }

    @GetMapping(path = "{id}")
    public ArrayList<ResponseDTO> searchCustomer(@PathVariable String id) {
        /*ArrayList<ResponseInfo> response = new ArrayList<>();
        response.add(new ResponseInfo(
                HttpServletResponse.SC_OK,
                "Customer Search with ID",
                customerService.searchCustomer(id)
        ));
        return response;*/
        //return customerService.searchCustomer(id);
        return ResponseUtil.generateResponse(
                HttpServletResponse.SC_OK,
                "Customer Search with ID",
                customerService.searchCustomer(id)
        );
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ArrayList<ResponseDTO> saveCustomer(@ModelAttribute CustomerDTO dto) {
        if (customerService.saveCustomer(dto)) {
            return ResponseUtil.generateResponse(
                    HttpServletResponse.SC_CREATED,
                    "Customer Saved Successfully..!",
                    ""
            );
        } else {
            return ResponseUtil.generateResponse(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Something Went Wrong....",
                    ""
            );
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ResponseDTO> updateCustomer(@RequestBody CustomerDTO dto) {
        if (customerService.updateCustomer(dto)) {
            return ResponseUtil.generateResponse(
                    HttpServletResponse.SC_OK,
                    "Customer Updated Successfully..!",
                    ""
            );
        } else {
            return ResponseUtil.generateResponse(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Something Went Wrong....",
                    ""
            );
        }
    }

    @DeleteMapping(params = "id")
    public ArrayList<ResponseDTO> deleteCustomer(@RequestParam String id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseUtil.generateResponse(
                    HttpServletResponse.SC_OK,
                    "Customer Deleted Successfully..!",
                    ""
            );
        } else {
            return ResponseUtil.generateResponse(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Something Went Wrong....",
                    ""
            );
        }
    }

}
