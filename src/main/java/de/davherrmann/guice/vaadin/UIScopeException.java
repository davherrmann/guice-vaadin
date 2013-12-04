package de.davherrmann.guice.vaadin;

public class UIScopeException extends RuntimeException {
	private static final long serialVersionUID = 2967651754787552884L;

	protected UIScopeException() {
		super();
	}

	protected UIScopeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	protected UIScopeException(String message, Throwable cause) {
		super(message, cause);
	}

	protected UIScopeException(String message) {
		super(message);
	}

	protected UIScopeException(Throwable cause) {
		super(cause);
	}

}