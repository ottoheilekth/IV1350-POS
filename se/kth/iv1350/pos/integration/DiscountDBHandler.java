package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.dto.SaleDTO;

/**
 * This is used as a middle man for communication between the program and an already existing discount database.
 */
public class DiscountDBHandler {
    private static final DiscountDBHandler HANDLER_INSTANCE = new DiscountDBHandler();

    /**
     * A private constructor to prevent the creation of more instances of this class.
     */
    private DiscountDBHandler() {}

    /**
     * @return The sole instance of this singleton.
     */
    public static DiscountDBHandler getHandler() {
        return HANDLER_INSTANCE;
    }

    /**
     * Checks the discount database for discount eligibility.
     * @param customerID The customer's ID.
     * @param saleDTO The DTO of the finished <code>Sale</code>.
     * @return New total price. Same if no discount was applied.
     */
    public float checkForDiscount(int customerID, SaleDTO saleDTO) {
        float newPrice = saleDTO.getTotalPrice();

        // A call checking the actual discount database for discount eligibility should replace these.
        newPrice *= new DiscountCalculatorCustomerAge().CalculateDiscount(customerID, saleDTO);
        newPrice *= new DiscountCalculatorSalePrice().CalculateDiscount(customerID, saleDTO);

        return newPrice;
    }
}
