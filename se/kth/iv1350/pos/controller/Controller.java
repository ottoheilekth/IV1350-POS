package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.DiscountDBHandler;
import se.kth.iv1350.pos.integration.ExternalAccountingSystem;
import se.kth.iv1350.pos.integration.ExternalInventorySystem;
import se.kth.iv1350.pos.integration.InvalidItemIdentifierException;
import se.kth.iv1350.pos.integration.InsufficientPaymentException;
import se.kth.iv1350.pos.integration.ReceiptPrinter;
import se.kth.iv1350.pos.integration.Register;
import se.kth.iv1350.pos.model.dto.ItemDTO;
import se.kth.iv1350.pos.model.Sale;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller {
    private ExternalAccountingSystem extAccSys;
    private ExternalInventorySystem extInvSys;
    private DiscountDBHandler discountDBHandler;
    private Register register;
    private ReceiptPrinter receiptPrinter;
    private Sale sale;
    private float amountPaid;

    /**
     * Creates a new instance.
     */
    public Controller() {
        extAccSys = new ExternalAccountingSystem();
        extInvSys = new ExternalInventorySystem();
        discountDBHandler = new DiscountDBHandler();
        register = new Register();
        receiptPrinter = new ReceiptPrinter();
        amountPaid = 0;
    }
    
    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * Retrieves an <code>itemDTO</code> from the <code>ExternalInventorySystem</code> and adds it
     * to the sale.
     * @param itemIdentifier A unique number identifying a unique type of item.
     * @param itemQuantity Number of said items added to the sale.
     * @throws InvalidItemIdentifierException
     */
    public void enterItem(int itemIdentifier, int itemQuantity) throws InvalidItemIdentifierException {
        ItemDTO itemDTO = extInvSys.getItemDTO(itemIdentifier);
        sale.addItem(itemDTO, itemQuantity);
    }

    /**
     * Ends the ongoing sale.
     * @return Total price (including VAT).
     */
    public float endSale() {
        return sale.createSaleDTO();
    }

    /**
     * Signals a discount request.
     * @param customerID The customer's ID.
     * @return New total price. Same if no discount was applied.
     */
    public float discountRequest(int customerID) {
        return sale.checkForDiscount(customerID, discountDBHandler);
    }

    /**
     * Registers a cash payment from the customer.
     * @param amountPaid Amount paid by the customer.
     * @return Change produced by the payment.
     * @throws InsufficientPaymentException
     */
    public float enterCashPayment(float amountPaid) throws InsufficientPaymentException {
        float change;

        this.amountPaid += amountPaid;
        change = this.amountPaid - sale.getSaleDTO().getTotalPrice();
        if (change < 0)
            throw new InsufficientPaymentException("The supplied payment was not enough to cover the entire sale");

        extAccSys.updateAccountingSystem(amountPaid, change);
        extInvSys.updateInventorySystem(sale.getSaleDTO());

        sale.setPayment(amountPaid, change);
        register.increaseRegister(amountPaid, change);

        return change;
    }

    /**
     * Prints a receipt.
     */
    public void printReceipt() {
        sale.printReceipt(receiptPrinter);        
    }
}
