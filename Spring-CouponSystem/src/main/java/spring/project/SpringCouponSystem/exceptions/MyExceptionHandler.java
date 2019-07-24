package spring.project.SpringCouponSystem.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler( Throwable.class )
	public ResponseEntity<Object> handleThrowable( Throwable t) {
		
		ApiError apiError =
		new ApiError("Something wrong happened... Please contact the admin.",
				HttpStatus.INTERNAL_SERVER_ERROR,ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<Object>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@ExceptionHandler( UniqueValueException.class )
	public ResponseEntity<Object> handleCouponSystemException( UniqueValueException e) {
		
		ApiError apiError =
		new ApiError(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR,ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<Object>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
