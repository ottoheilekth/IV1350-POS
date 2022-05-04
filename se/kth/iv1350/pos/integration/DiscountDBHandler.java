package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.dto.SaleDTO;

/**
 * This is used as a middle man for communication between the program and an already existing discount database.
 */
public class DiscountDBHandler {
    /**
     * Checks the discount database for discount eligibility. Currently does not apply any discounts.
     * @param customerID The customer's ID.
     * @param saleDTO The DTO of the finished <code>Sale</code>.
     * @return New total price. Same if no discount was applied.
     */
    public float checkForDiscount(int customerID, SaleDTO saleDTO) {
        // A call checking the actual discount database for discount eligibility is made here.
        return saleDTO.getTotalPrice();
    }
}
