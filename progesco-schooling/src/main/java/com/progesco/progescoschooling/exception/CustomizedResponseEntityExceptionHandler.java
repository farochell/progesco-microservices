/**
 * 
 */
package com.progesco.progescoschooling.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author emile.camara
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	   public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
			ExceptionResponse exceptionResponse =   new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	   
			return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   @ExceptionHandler(EducationalRegistrationNotFoundException.class)
	   public final ResponseEntity<Object> handleEducationalRegistrationNotFoundException(EducationalRegistrationNotFoundException ex, WebRequest request){
			ExceptionResponse exceptionResponse =   new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	   
			return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(CourseRegistrationNotFoundException.class)
	   public final ResponseEntity<Object> handleCourseRegistrationNotFoundException(CourseRegistrationNotFoundException ex, WebRequest request){
			ExceptionResponse exceptionResponse =   new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	   
			return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	   }
	   
	   @Override
	   protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation failed", ex.getBindingResult().toString());
	        
	        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		}
}
