package de.note.client;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NoteClient extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		PlatformService platformService = PlatformService.getInstance();
		Rectangle2D visualBounds = platformService.getBounds();
		double width = visualBounds.getWidth();
		double height = visualBounds.getHeight();

		Label label = new Label("Click the button to find out your platform.");
		label.setTranslateY(30);

		Button button = new Button("Hello Platform");
		button.setOnAction(e -> label.setText(String.format("Running on %s!", platformService.getName())));

		Rectangle rectangle = new Rectangle(width - 20, height - 20);
		rectangle.setFill(Color.LIGHTBLUE);
		rectangle.setArcHeight(6);
		rectangle.setArcWidth(6);

		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(rectangle, button, label);

		Scene scene = new Scene(stackPane, visualBounds.getWidth(), visualBounds.getHeight());

		stage.setScene(scene);
		stage.show();
	}
}