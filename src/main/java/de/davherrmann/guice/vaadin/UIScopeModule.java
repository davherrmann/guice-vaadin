package de.davherrmann.guice.vaadin;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class UIScopeModule extends AbstractModule {

	@Override
	protected void configure() {
		UIScope uiScope = new UIScope();

		bindScope(UIScoped.class, uiScope);
		bind(UIScope.class).annotatedWith(Names.named("uiScope")).toInstance(
				uiScope);
		System.out.println("bound UI scope");
	}
}
