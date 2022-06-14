package lk.ijse.spring.util;

import lk.ijse.spring.dto.ResponseDTO;

import java.util.ArrayList;

public class ResponseUtil {

    public static ArrayList<ResponseDTO> generateResponse(int status, String message, Object data) {
        ArrayList<ResponseDTO> response = new ArrayList<>();
        response.add(new ResponseDTO(status, message, data));
        return response;
    }
}
