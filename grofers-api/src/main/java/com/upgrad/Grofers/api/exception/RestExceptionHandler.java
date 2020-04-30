package com.upgrad.Grofers.api.exception;


import com.upgrad.Grofers.api.ErrorResponse;
import com.upgrad.Grofers.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * This class contains all the Exception Handlers for all the exceptions implemented in the project.
 * This is a global code for exception handlers and all the controllers implemented in the project can use this global code.
 */
@ControllerAdvice
public class RestExceptionHandler {


    /**
     * @param exc     - SignUpRestrictedException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus BAD_REQUEST.
     */
    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> signUpRestrictedException(SignUpRestrictedException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.BAD_REQUEST
        );
    }

    /**
     * @param exc     - AuthenticationFailedException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus UNAUTHORIZED.
     */
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authenticationFailedException(AuthenticationFailedException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.UNAUTHORIZED
        );
    }

    /**
     * @param exc     - AuthorizationFailedException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus FORBIDDEN.
     */
    @ExceptionHandler(AuthorizationFailedException.class)
    public ResponseEntity<ErrorResponse> authorizationFailedException(AuthorizationFailedException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.FORBIDDEN
        );
    }

    /**
     * @param exc     - AddressNotFoundException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus NOT_FOUND.
     */
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> addressNotFoundException(AddressNotFoundException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.NOT_FOUND
        );
    }

    /**
     * @param exc     - CategoryNotFoundException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus NOT_FOUND.
     */
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> categoryNotFoundException(CategoryNotFoundException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.NOT_FOUND
        );
    }

    /**
     * @param exc     - CustomerNotFoundException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus NOT_FOUND.
     */
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> customerNotFoundException(CustomerNotFoundException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.NOT_FOUND
        );
    }

    /**
     * @param exc     - ItemNotFoundException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus NOT_FOUND.
     */
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> itemNotFoundException(ItemNotFoundException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.NOT_FOUND
        );
    }

    /**
     * @param exc     - StoreNotFoundException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus NOT_FOUND.
     */
    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<ErrorResponse> StoreNotFoundException(StoreNotFoundException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.NOT_FOUND
        );
    }

    /**
     * @param exc     - SaveAddressException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus BAD_REQUEST.
     */
    @ExceptionHandler(SaveAddressException.class)
    public ResponseEntity<ErrorResponse> saveAddressException(SaveAddressException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.BAD_REQUEST
        );
    }

    /**
     * @param exc     - UpdateCustomerException type object containing error code and error message.
     * @param request - The web request object gives access to all the request parameters.
     * @return - ResponseEntity<ErrorResponse> type object displaying error code and error message along with HttpStatus BAD_REQUEST.
     */
    @ExceptionHandler(UpdateCustomerException.class)
    public ResponseEntity<ErrorResponse> updateCustomerException(UpdateCustomerException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.BAD_REQUEST
        );
    }


}
