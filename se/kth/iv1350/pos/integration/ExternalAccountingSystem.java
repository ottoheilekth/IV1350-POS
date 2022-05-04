package se.kth.iv1350.pos.integration;

/**
 * This is used as a middle man for communication between the program and an already existing external accounting system.
 */
public class ExternalAccountingSystem {
    /**
     * Updates the external accounting system with amount paid and change returned.
     * @param amountPaid Amount paid by the customer.
     * @param change Amount returned to the customer.
     */
    public void updateAccountingSystem(float amountPaid, float change) {
        // A call updating the actual external accounting system is to be made here.
    }
}
