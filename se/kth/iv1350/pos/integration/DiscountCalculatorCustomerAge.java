package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.dto.SaleDTO;

/**
 * This class implements the <code>DiscountCalculator</code> interface with a unique 
 * discount calculation method based on the age of the customer.
 */
class DiscountCalculatorCustomerAge implements DiscountCalculator {
    /**
     * Calculates a discount based on the age of the customer.
     * @param customerID The customer's ID.
     * @param saleDTO The DTO of the finished <code>Sale</code>.
     * @return A multiplier between 0 and 1.
     */
    public float CalculateDiscount(int customerID, SaleDTO saleDTO) {
        int firstDigit = customerID;
        while (firstDigit > 10)
            firstDigit /= 10;
        
        if (firstDigit == 1)
            return 0.75f;
        return 1;
    }
}
