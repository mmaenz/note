package de.note.core;

public interface LoginInterface {

	public SessionInterface login(String user, String pass) throws LoginFailedException;

}
