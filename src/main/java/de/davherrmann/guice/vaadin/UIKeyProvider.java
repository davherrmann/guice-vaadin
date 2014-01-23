package de.davherrmann.guice.vaadin;

import javax.inject.Provider;

public class UIKeyProvider implements Provider<UIKey> {
	private static int counter = 0;

	public UIKey get() {
		counter++;
		return new UIKey(counter);
	}
}