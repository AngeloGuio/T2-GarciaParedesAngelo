package pe.edu.cibertec.T2_GarciaParedesAngelo.exception;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import pe.edu.cibertec.T2_GarciaParedesAngelo.model.dto.MensajeErrorDto;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public MensajeErrorDto resourceNotFoundException(
            ResourceNotFoundException ex,
            WebRequest request
    ){
        return MensajeErrorDto.builder()
                .mensaje(ex.getMessage())
                .codigoEstado(HttpStatus.NOT_FOUND.value())
                .fechaError(new Date())
                .descripcion(request.getDescription(true)).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error de validación: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error: " + ex.getMessage());
    }

}
