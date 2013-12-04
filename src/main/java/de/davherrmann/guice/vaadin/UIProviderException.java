package de.davherrmann.guice.vaadin;

public class UIProviderException extends RuntimeException {
	private static final long serialVersionUID = -7573169577750839492L;

	protected UIProviderException() {
		super();
	}

	protected UIProviderException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	protected UIProviderException(String message, Throwable cause) {
		super(message, cause);
	}

	protected UIProviderException(String message) {
		super(message);
	}

	protected UIProviderException(Throwable cause) {
		super(cause);
	}

}