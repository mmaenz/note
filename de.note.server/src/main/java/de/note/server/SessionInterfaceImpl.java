package de.note.server;

import de.note.core.SessionInterface;
import de.root1.simon.annotation.SimonRemote;

@SimonRemote(value={SessionInterface.class})
public class SessionInterfaceImpl implements SessionInterface {

    public void sessionMethodA() {
        System.out.println("invoked sessionMethodA()");
    }

    public void sessionMethodB() {
        System.out.println("invoked sessionMethodB()");
    }

    public void sessionMethodC() {
        System.out.println("invoked sessionMethodC()");
    }

}
