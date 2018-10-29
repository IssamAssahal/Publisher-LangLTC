package pl.com.lang.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import pl.com.lang.support.exception.BadParamException;
import pl.com.lang.support.exception.DuplicateException;
import pl.com.lang.support.exception.ErrorMessage;
import pl.com.lang.support.exception.NotFoundException;

/**
 * <b>API Exception Handler</b><br>
 * Handler API request exception here
 * 
 * @author Issam As-sahal ISA
 */
@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<ErrorMessage> resourceNotFoundException(Exception e) {
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				e.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ DuplicateException.class })
	public ResponseEntity<ErrorMessage> resourceDuplicateException(Exception e) {
		ErrorMessage error = new ErrorMessage(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name(), e.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.CONFLICT);
	}

	@ExceptionHandler({ BadParamException.class })
	public ResponseEntity<ErrorMessage> badParamException(Exception e) {
		ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				e.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
}
