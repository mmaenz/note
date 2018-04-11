package de.note.server;

import de.note.core.LoginFailedException;
import de.note.core.LoginInterface;
import de.note.core.SessionInterface;
import de.root1.simon.annotation.SimonRemote;

@SimonRemote(value={LoginInterface.class})
public class LoginInterfaceImpl implements LoginInterface {

   public SessionInterface login(String user, String pass) throws LoginFailedException {
        if (user.equals("myAuthorizedUser") && pass.equals("myAuthorizedPass")) {
            return new SessionInterfaceImpl();
        }
        throw new LoginFailedException("Login for user " + user + " failed. Invalid password?");
   }
}
