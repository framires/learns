package br.com.ramires.learn.basics.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class ExceptionHandler , all exception
 * 
 * @author feliperamires
 *
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * All throuble HttpClient is addressed here
     * 
     * @param ex
     * @param request
     * @return {@link ErrorResponseDTO}
     * @author feliperamires
     * @date 26,Out 2020
     */
    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity<Object> handleConflict(HttpClientErrorException ex, WebRequest request) {
	// instance a return object
	ErrorResponseDTO errorResponse = new ErrorResponseDTO();

	HttpStatus status;
	// Check the exception type and prepare the response object
	if (ex instanceof HttpClientErrorException) {
	    errorResponse.setStatusCode(ex.getStatusCode().value());
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setBody(ex.getStatusText());
	    status = ex.getStatusCode();
	} else {
	    errorResponse.setStatusCode(500);
	    errorResponse.setMessage("Internal Server Error");
	    status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	logger.error(errorResponse.getMessage(), ex);
	return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), status, request);
    }

    /**
     * (JPA Validation) All throuble ConstraintViolationException is addressed here
     * 
     * @param ex
     * @param request
     * @return {@link ErrorResponseDTO}
     * @author feliperamires
     * @date 26,Out 2020
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {

	ErrorResponseDTO errorResponse = new ErrorResponseDTO();

	HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	// Check the exception type and prepare the response object
	if (ex instanceof ConstraintViolationException) {
	    errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setBody(ex.getCause().toString());
	} else {
	    errorResponse.setStatusCode(500);
	    errorResponse.setMessage("Internal Server Error");
	}
	logger.error(errorResponse.getMessage(), ex);
	return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), status, request);
    }

}
