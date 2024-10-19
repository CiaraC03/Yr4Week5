package ie.atu.week5.customerapp;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus
    public String handleErrorException(MethodArgumentNotValidException ex){
        return "Error occured" + ex.getBindingResult().getFieldError().getDefaultMessage();
    }
}
