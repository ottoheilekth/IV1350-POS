package se.kth.iv1350.pos.model.dto;

/**
 * A Data Transfer Object for the <code>Item</code> class. Contains information about a physical 
 * item found in the store.
 */
public class ItemDTO {
    private String name, description;
    private float price;
    private int rateOfVat;

    /**
     * Private default constructor to prevent accidental creation of an empty instance.
     */
    private ItemDTO() {}

    /**
     * Creates a new instance and saves name, description, price and VAT rate.
     * @param name The item's name.
     * @param description The item's description.
     * @param price The item's price.
     * @param rateOfVat The item's VAT rate.
     */
    public ItemDTO(String name, String description, float price, int rateOfVat) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rateOfVat = rateOfVat;
    }

    /**
     * @return The name of this <code>ItemDTO</code>.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The description of this <code>ItemDTO</code>.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The price of this <code>ItemDTO</code>.
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return The VAT rate of this <code>ItemDTO</code>.
     */
    public int getRateOfVat() {
        return rateOfVat;
    }

    /**
     * Two <code>ItemDTO</code>s are considered equal if they represent the same type of item.
     * @param other The <code>ItemDTO</code> to compare with this item.
     * @return <code>true</code> if the specified <code>ItemDTO</code> is equal to this, 
     * <code>false</code> if it is not.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ItemDTO))
            return false;
        
        ItemDTO otherItemDTO = (ItemDTO) other;
        return name.equals(otherItemDTO.name) && description.equals(otherItemDTO.description) &&
            price == otherItemDTO.price && rateOfVat == otherItemDTO.rateOfVat;
    }
}
