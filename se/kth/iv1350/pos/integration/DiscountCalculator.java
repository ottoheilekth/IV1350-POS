package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.dto.SaleDTO;

interface DiscountCalculator {
    public float CalculateDiscount(int customerID, SaleDTO saleDTO);
}
