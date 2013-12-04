package de.davherrmann.guice.vaadin;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;
import com.vaadin.util.CurrentInstance;

public abstract class ScopedUIProvider extends UIProvider {

	private static final long serialVersionUID = -3066618633572632506L;
	private static Logger log = LoggerFactory.getLogger(ScopedUIProvider.class);
	private final UIKeyProvider uiKeyProvider;
	private final Map<String, Provider<UI>> uiProMap;

	@Inject
	protected ScopedUIProvider(Map<String, Provider<UI>> uiProMap,
			UIKeyProvider uiKeyProvider) {
		super();
		this.uiKeyProvider = uiKeyProvider;
		this.uiProMap = uiProMap;
	}

	@Override
	public UI createInstance(UICreateEvent event) {
		return createInstance(event.getUIClass());
	}

	public UI createInstance(Class<? extends UI> uiClass) {
		UIKey uiKey = uiKeyProvider.get();
		// hold the key while UI is created
		CurrentInstance.set(UIKey.class, uiKey);
		// and set up the scope
		UIScope.getCurrent().startScope(uiKey);

		// create the UI
		Provider<UI> uiProvider = uiProMap.get(uiClass.getName());
		if (uiProvider == null) {
			throw new UIProviderException(
					"No UI provider has been specified for "
							+ uiClass.getName() + " in uiProMap");
		}
		ScopedUI ui = (ScopedUI) uiProvider.get();
		ui.setInstanceKey(uiKey);
		log.debug("returning instance of " + ui.getClass().getName()
				+ " with key " + uiKey);
		return ui;
	}
	
}
