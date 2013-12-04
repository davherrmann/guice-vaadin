package de.davherrmann.guice.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class ScopedUI extends UI {
	private static final long serialVersionUID = -6553717584135372748L;
	
    private UIKey instanceKey;
    private UIScope uiScope;

	@Override
	protected void init(VaadinRequest request) {

	}

	public void setInstanceKey(UIKey instanceKey) {
		this.instanceKey = instanceKey;
	}

	public UIKey getInstanceKey() {
		return instanceKey;
	}

	@Override
	public void detach() {
		if (uiScope != null) {
			uiScope.releaseScope(this.getInstanceKey());
		}
		super.detach();
	}
}
