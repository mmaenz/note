package de.note.client;

import javafx.geometry.Rectangle2D;

public interface PlatformProvider {
    String getName();
    Rectangle2D getBounds();
}
