package se.kth.iv1350.pos.model.dto;

import java.util.ArrayList;
import se.kth.iv1350.pos.model.Item;

/**
 * A Data Transfer Object for the <code>Sale</code> class. Contains information about a sale.
 */
public class SaleDTO {
    private ArrayList<Item> items;
    private float totalPrice;
    private float discountMultiplier;

    /**
     * Private default constructor to prevent accidental creation of an empty instance.
     */
    private SaleDTO() {}

    /**
     * Creates an instance and saves what items were bought and the total price of the sale.
     * @param items An array list of bought items.
     * @param totalPrice Total price of the sale.
     */
    public SaleDTO(ArrayList<Item> items, float totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    /**
     * @return An array list of bought items.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @return Total price of the sale.
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * @return Multiplier for discount.
     */
    public float getDiscountMultiplier() {
        return discountMultiplier;
    }

    /**
     * Updates the total price with a given new total and sets the discount multiplier.
     * @param newTotal New total price.
     */
    public void updateTotalPrice(float newTotal) {
        discountMultiplier = (float) (newTotal / totalPrice);
        totalPrice = newTotal;
    }
}
