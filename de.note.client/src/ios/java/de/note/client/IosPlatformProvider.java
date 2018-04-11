package de.note.client;

import de.note.client.PlatformProvider;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class IosPlatformProvider implements PlatformProvider {

    @Override
    public String getName() {
        return "IOS";
    }

	@Override
	public Rectangle2D getBounds() {
		return Screen.getPrimary().getVisualBounds();
	}

}