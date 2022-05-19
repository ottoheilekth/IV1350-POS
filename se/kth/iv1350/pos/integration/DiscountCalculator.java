package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.dto.SaleDTO;

/**
 * Defines the ability to calculate a discount based on a customer's ID, the sale, both or neither.
 * The interface is to be implemented by a class that provides the calculation method.
 */
interface DiscountCalculator {
    /**
     * Calculates a discount using none, one or both of the parameters.
     * @param customerID The customer's ID.
     * @param saleDTO The DTO of the finished <code>Sale</code>.
     * @return A multiplier between 0 and 1.
     */
    public float CalculateDiscount(int customerID, SaleDTO saleDTO);
}
