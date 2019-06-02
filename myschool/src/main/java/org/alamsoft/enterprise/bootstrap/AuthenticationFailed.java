package org.alamsoft.enterprise.bootstrap;

//@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthenticationFailed extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public AuthenticationFailed(String message) {
    	super(message);
    }
}
