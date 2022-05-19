package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.dto.SaleDTO;

/**
 * This class implements the <code>DiscountCalculator</code> interface with a unique 
 * discount calculation method based on the total price of the sale.
 */
class DiscountCalculatorSalePrice implements DiscountCalculator {
    /**
     * Calculates a discount based on the total price of the sale.
     * @param customerID The customer's ID.
     * @param saleDTO The DTO of the finished <code>Sale</code>.
     * @return A multiplier between 0 and 1.
     */
    public float CalculateDiscount(int customerID, SaleDTO saleDTO) {
        if (saleDTO.getTotalPrice() > 50)
            return 0.8f;
        return 1;
    }
}
