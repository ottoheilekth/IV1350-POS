package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.dto.ItemDTO;
import se.kth.iv1350.pos.model.dto.SaleDTO;

/**
 * This is used as a middle man for communication between the program and an already 
 * existing external inventory system.
 */
public class ExternalInventorySystem {
    /**
     * Creates and returns an item DTO if the given item identifier is stored in the external 
     * inventory system.
     * @param itemIdentifier A unique number identifying a unique type of item.
     * @return An <code>ItemDTO</code> for the type of item with given identifier.
     * @throws InvalidItemIdentifierException
     */
    public ItemDTO getItemDTO(int itemIdentifier) throws InvalidItemIdentifierException {
        int maxItemIdentifier = 5; // Needs to be adjusted to work with the real system.
        if(itemIdentifier < 0 || itemIdentifier > maxItemIdentifier)
            throw new InvalidItemIdentifierException("The entered item identifier is invalid");
        
        

        // A placeholder for a call to the external inventory system.
        return new ItemDTO("item" + Integer.toString(itemIdentifier), "this is a description", 
        itemIdentifier + 1, 25);
    }

    /**
     * Updates the external inventory system with what items have been bought.
     * @param saleDTO The DTO of the finished <code>Sale</code>.
     */
    public void updateInventorySystem(SaleDTO saleDTO) {
        // A call updating the actual external inventory system is to be made here.
    }
}
