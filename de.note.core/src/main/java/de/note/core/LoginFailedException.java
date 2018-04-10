package de.note.core;

public class LoginFailedException extends Exception {
	private static final long serialVersionUID = 5667348348506973129L;

	public LoginFailedException(String msg) {
        super(msg);
    }

}
