package de.note.server;

import de.root1.simon.Registry;
import de.root1.simon.Simon;

public class NoteServer {
	private LoginInterfaceImpl loginImpl = null;
	private Registry registry = null;

	public NoteServer() throws Exception {
		loginImpl = new LoginInterfaceImpl();
		registry = Simon.createRegistry();
	}

	public synchronized void run() throws Exception {
		registry.start();
		registry.bind("server", loginImpl);
		System.out.println("Server up and running!");

		while (true) {
			wait();
		}
	}

	public static void main(String[] args) throws Exception {
		   new NoteServer().run();

	   }
}
