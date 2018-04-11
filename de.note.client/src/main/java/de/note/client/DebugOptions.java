package de.note.client;

public class DebugOptions {
	private String platformProvider;
	private boolean debug;
	
	public DebugOptions() {
		debug = Boolean.getBoolean("de.note.debug");
		platformProvider = System.getProperty("de.note.platformProvider");
	}

	public boolean isDebug() {
		return debug;
	}
	
	public String getPlatformProvider() {
		return platformProvider;
	}
}
