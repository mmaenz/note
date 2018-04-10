package de.note.client;
import java.net.UnknownHostException;

import de.note.core.LoginFailedException;
import de.note.core.LoginInterface;
import de.note.core.SessionInterface;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import de.root1.simon.exceptions.SimonRemoteException;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class NoteClient extends Application {
    
	public boolean initServer() throws Exception {
		Lookup nameLookup = Simon.createNameLookup("127.0.0.1", 22222);
        LoginInterface server = (LoginInterface) nameLookup.lookup("server");
        try {
            // use the serverobject as it would exist on your local machine
            SessionInterface session = server.login("myAuthorizedUser", "myAuthorizedPass");

            session.sessionMethodA();
            session.sessionMethodB();
            session.sessionMethodC();

        } catch (SimonRemoteException ex) {
            ex.printStackTrace();
            return false;
        } catch (LoginFailedException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
	}
	
	@Override
    public void start(Stage stage) throws Exception {
        initServer();
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(new StackPane(new Label("Hello World!")),
                bounds.getWidth(), bounds.getHeight());
        stage.setScene(scene);
        stage.show();
    }
}