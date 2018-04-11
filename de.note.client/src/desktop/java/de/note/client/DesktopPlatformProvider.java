package de.note.client;

import de.note.client.PlatformProvider;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class DesktopPlatformProvider implements PlatformProvider {

    @Override
    public String getName() {
        return "Desktop";
    }

	@Override
	public Rectangle2D getBounds() {
		Rectangle2D screen = Screen.getPrimary().getBounds();
		Rectangle2D rect = new Rectangle2D(screen.getMinX() / 2, screen.getMinY() / 2, 100, 100);
		return rect;
	}

}