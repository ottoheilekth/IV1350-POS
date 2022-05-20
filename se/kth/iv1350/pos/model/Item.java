package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.model.dto.ItemDTO;

/**
 * Represents a unique type of item. Information about said item is found in the DTO. Quantity of 
 * said item is stored here.
 */
public class Item {
    private ItemDTO itemDTO;
    private int quantity;

    /**
     * Private default constructor to prevent accidental creation of an empty instance.
     */
    private Item() {}

    /**
     * Creates a new instance storing .
     * @param itemDTO A DTO containing information about this <code>Item</code>.
     */
    public Item(ItemDTO itemDTO, int quantity) {
        this.itemDTO = itemDTO;
        this.quantity = quantity;
    }

    /**
     * @return The DTO of this <code>Item</code>.
     */
    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    /**
     * @return The quantity of this <code>Item</code>.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Two <code>Item</code>s are considered equal if they represent the same type of item, 
     * regardless of quantity.
     * @param other The <code>Item</code> to compare with this item.
     * @return <code>true</code> if the specified item is equal to this item, 
     * <code>false</code> if it is not.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Item))
            return false;
        
        Item otherItem = (Item) other;
        return itemDTO.equals(otherItem.itemDTO);
    }

    /**
     * Updates the quantity of the current item by a given amount.
     * @param amount Amount of which to increase the quantity by.
     * @throws IllegalArgumentException When <code>amount</code> is less than or equal to zero.
     */
    public void increaseQuantity(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be greater than 0");

        quantity += amount;
    }
}
