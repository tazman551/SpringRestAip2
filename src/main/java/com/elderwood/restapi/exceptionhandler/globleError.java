package com.elderwood.restapi.exceptionhandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globleError {

     @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(Map.of("error", ex.getMessage()));
    }
    
    @ExceptionHandler(JDBCConnectionException.class)
     @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleJDBCConnectionException(JDBCConnectionException ex) {
        // Log the exception for debugging
        ex.printStackTrace();

        // Return a user-friendly error message
        return "Database connection error. Please try again later.";
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleServiceException(SQLIntegrityConstraintViolationException ex) {
        return new ResponseEntity<>("SQL issue", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("SQL issue", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public String handleServiceException(ServiceException ex) {
        //ErrorResponse error = new ErrorResponseException(null);
        return "Database not started. Start MySQL database" + HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @ExceptionHandler(HibernateException.class)
    public String handleHibernateException(HibernateException ex) {
        //ErrorResponse error = new ErrorResponseException(null);
        return "Database not started. Start MySQL database" + HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
