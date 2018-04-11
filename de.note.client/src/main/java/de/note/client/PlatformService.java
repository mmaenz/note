package de.note.client;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Logger;

import javafx.geometry.Rectangle2D;

public class PlatformService {

	private static final Logger LOG = Logger.getLogger(PlatformService.class.getName());
	private final ServiceLoader<PlatformProvider> serviceLoader;
	private PlatformProvider provider;
	private static PlatformService instance;
	private DebugOptions debugOptions;
	
	public static synchronized PlatformService getInstance() throws Exception {
		if (instance == null) {
			instance = new PlatformService();
		}
		return instance;
	}

	private PlatformService() throws Exception {
		debugOptions = new DebugOptions();
		serviceLoader = ServiceLoader.load(PlatformProvider.class);
		
		if (debugOptions.isDebug()) {
			provider = (PlatformProvider) Class.forName(debugOptions.getPlatformProvider()).newInstance();
			LOG.info(String.format("Debugging: provider set to %s!", debugOptions.getPlatformProvider()));
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

	public String getName() {
		return provider == null ? "unknown platform" : provider.getName();
	}

	public Rectangle2D getBounds() {
		return provider == null ? null : provider.getBounds();
	}
}