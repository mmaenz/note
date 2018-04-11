package de.note.client.android;

import de.note.client.PlatformProvider;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class AndroidPlatformProvider implements PlatformProvider {

    @Override
    public String getName() {
        return "Android";
    }

	@Override
	public Rectangle2D getBounds() {
		return Screen.getPrimary().getVisualBounds();
	}

}