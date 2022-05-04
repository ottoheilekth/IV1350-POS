package se.kth.iv1350.pos.integration;

/**
 * This is a custom exception class containing a single exception for when a 
 * customer has payed an insufficient amount.
 */
public class InsufficientPaymentException extends Exception {
    /**
     * Creates an instance of a custom exception for when a customer has payed
     * an insufficient amount.
     * @param errorMessage The message to display when the exception is thrown.
     */
    public InsufficientPaymentException(String errorMessage) {
        super(errorMessage);
    }
}
