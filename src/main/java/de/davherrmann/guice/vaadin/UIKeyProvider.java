package de.davherrmann.guice.vaadin;

import javax.inject.Provider;

public class UIKeyProvider implements Provider<UIKey> {
	private static int counter = 0;

	public UIKey get() {
		return new UIKey(counter);
	}
}