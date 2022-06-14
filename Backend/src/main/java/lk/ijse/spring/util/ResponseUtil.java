package lk.ijse.spring.util;

import lk.ijse.spring.dto.ResponseDTO;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

public class ResponseUtil {

    public static ArrayList<ResponseDTO> generateResponse(int status, String message) {
        System.out.println(status+" "+message);
        ArrayList<ResponseDTO> response = new ArrayList<>();
        //response.add(new ResponseDTO(status, message));
        return response;
    }

    public static ArrayList<ResponseDTO> generateResponse(int status, String message, Object data) {
        System.out.println(status+" "+message+" "+data);
        ArrayList<ResponseDTO> response = new ArrayList<>();
        response.add(new ResponseDTO(status, message, data));
        return response;
    }
}
