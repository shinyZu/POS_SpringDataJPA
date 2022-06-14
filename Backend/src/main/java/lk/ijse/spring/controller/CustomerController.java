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
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/v2/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /*@Autowired
    DataSource ds;
*/
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllCustomers() {
       /* ArrayList<ResponseDTO> responseInfo = ResponseUtil.generateResponse(
                HttpStatus.OK,
                "Customer Search with ID",
                customerService.getAllCustomers()
        );*/
        if (customerService.getAllCustomers() != null) {
            // return ResponseEntity.ok(responseInfo);
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpServletResponse.SC_OK,"All Customers",customerService.getAllCustomers()));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpServletResponse.SC_OK,"Error",null));
        }

        // return  ResponseEntity.status(HttpStatus.OK).body(responseInfo);
        /*return new ResponseEntity.(ResponseUtil.generateResponse(
                HttpStatus.OK,
                "Customer Search with ID",
                customerService.getAllCustomers()
        ), HttpStatus.OK);*/
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseDTO> searchCustomer(@PathVariable String id) {
        /*ArrayList<ResponseDTO> responseInfo = ResponseUtil.generateResponse(
                HttpStatus.OK,
                "Customer Search with ID",
                customerService.searchCustomer(id)
        );
        return new ResponseEntity(responseInfo,HttpStatus.OK);*/

        CustomerDTO dto = customerService.searchCustomer(id);
        if (dto != null) {
//            ResponseDTO responseInfo = new ResponseDTO(HttpStatus.OK,"Customer Search with ID",customerService.searchCustomer(id));
//            System.out.println(responseInfo);
//            return ResponseEntity.ok(responseInfo);
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpServletResponse.SC_OK,"Customer Search with ID",customerService.searchCustomer(id)));
        } else {
            //return ResponseEntity.internalServerError(new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR,"Customer Search with ID",null));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"No Such Customer",null));
        }
    }

    /*@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ArrayList<ResponseDTO> saveCustomer(@ModelAttribute CustomerDTO dto) {
        if (customerService.saveCustomer(dto)) {
            return ResponseUtil.generateResponse(
                    HttpStatus.CREATED,
                    "Customer Saved Successfully..!",
                    ""
            );
        } else {
            return ResponseUtil.generateResponse(
                    HttpStatus.BAD_REQUEST,
                    "Something Went Wrong....",
                    ""
            );
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ResponseDTO> updateCustomer(@RequestBody CustomerDTO dto) {
        if (customerService.updateCustomer(dto)) {
            return ResponseUtil.generateResponse(
                    HttpStatus.OK,
                    "Customer Updated Successfully..!",
                    ""
            );
        } else {
            return ResponseUtil.generateResponse(
                    HttpStatus.BAD_REQUEST,
                    "Something Went Wrong....",
                    ""
            );
        }
    }

    @DeleteMapping(params = "id")
    public ArrayList<ResponseDTO> deleteCustomer(@RequestParam String id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseUtil.generateResponse(
                    HttpStatus.OK,
                    "Customer Deleted Successfully..!",
                    ""
            );
        } else {
            return ResponseUtil.generateResponse(
                    HttpStatus.BAD_REQUEST,
                    "Something Went Wrong....",
                    ""
            );
        }
    }*/

}
