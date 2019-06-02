package org.alamsoft.enterprise.bootstrap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdvicer {
	@ExceptionHandler({AuthenticationFailed.class})
    public ResponseEntity<String> handleNotFoundException(AuthenticationFailed e) {
        return error(HttpStatus.UNAUTHORIZED, e);
    }
	
	private ResponseEntity<String> error(HttpStatus status, Exception e) {
        //log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
