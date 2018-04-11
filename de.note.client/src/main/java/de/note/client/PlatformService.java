package de.note.client;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Logger;

import de.note.client.desktop.DesktopPlatformProvider;
import javafx.geometry.Rectangle2D;

public class PlatformService {

	private static final Logger LOG = Logger.getLogger(PlatformService.class.getName());

	private static PlatformService instance;

	public static synchronized PlatformService getInstance() {
		if (instance == null) {
			instance = new PlatformService();
		}
		return instance;
	}

	private final ServiceLoader<PlatformProvider> serviceLoader;
	private PlatformProvider provider;

	private PlatformService() {
		serviceLoader = ServiceLoader.load(PlatformProvider.class);

		if (isDebug()) {
			provider = new DesktopPlatformProvider();
			LOG.info("Debugging: provider set to Desktop!");
		} else {
			Iterator<PlatformProvider> iterator = serviceLoader.iterator();
			while (iterator.hasNext()) {
				if (provider == null) {
					provider = iterator.next();
					LOG.info(String.format("Using PlatformProvider: %s", provider.getClass().getName()));
				} else {
					LOG.info(String.format("This PlatformProvider is ignored: %s",
							iterator.next().getClass().getName()));
				}
			}
			if (provider == null) {
				LOG.severe("No PlatformProvider implementation could be found!");
			}
		}
	}

	private boolean isDebug() {
		// Parameter for debug: -Dde.note.debug=true
		// Auto-sets to Desktop-Version!
		return Boolean.getBoolean("de.note.debug");
	}

	public String getName() {
		return provider == null ? "unknown platform" : provider.getName();
	}

	public Rectangle2D getBounds() {
		return provider == null ? null : provider.getBounds();
	}
}