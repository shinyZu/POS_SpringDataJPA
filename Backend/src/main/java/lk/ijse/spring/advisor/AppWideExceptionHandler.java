package lk.ijse.spring.advisor;

import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseUtil> exceptionHandler(Exception e){
       // return new ResponseUtil(500,e.getMessage(),null);
        return ResponseEntity.ok(new ResponseUtil(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage(),null));
    }
}
