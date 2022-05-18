package se.kth.iv1350.pos.integration;

/**
 * This is a custom exception class containing a single exception for when a
 * database can not be reached.
 */
public class DatabaseFailureException extends Exception {
    /**
     * Creates an instance of a custom exception for when a database is not
     * reachable.
     * @param errorMessage The message to display when the exception is thrown.
     */
    public DatabaseFailureException(String errorMessage) {
        super(errorMessage);
    }
}
