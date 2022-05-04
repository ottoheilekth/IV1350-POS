package se.kth.iv1350.pos.integration;

/**
 * This is a custom exception class containing a single exception for when an
 * item is entered with an invalid identifier.
 */
public class InvalidItemIdentifierException extends Exception {
    /**
     * Creates an instance of a custom exception for when an item identifier
     * is invalid.
     * @param errorMessage The message to display when the exception is thrown.
     */
    public InvalidItemIdentifierException(String errorMessage) {
        super(errorMessage);
    }
}
