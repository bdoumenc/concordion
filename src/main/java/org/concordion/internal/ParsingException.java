package org.concordion.internal;

public class ParsingException extends RuntimeException {

    private static final long serialVersionUID = 940993549779215305L;
    private final String sourceReference;

    public ParsingException(String message, Throwable cause) {
        this(message, cause, null);
    }

    public ParsingException(String message, Throwable cause, String sourceReference) {
        super(message, cause);
        this.sourceReference = sourceReference;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (sourceReference != null) {
            message += " " + sourceReference;
        }
        return message;
    }
}
