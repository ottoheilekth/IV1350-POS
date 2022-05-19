package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.model.dto.ItemDTO;
import se.kth.iv1350.pos.model.dto.SaleDTO;
import se.kth.iv1350.pos.integration.DiscountDBHandler;
import se.kth.iv1350.pos.integration.ReceiptPrinter;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private Receipt receipt;
    private ArrayList<Item> items;
    private SaleDTO saleDTO;
    private float runningTotal;
    private List<TotalRevenueObserver> totalRevenueObservers;

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale() {
        saleTime = LocalTime.now();
        receipt = new Receipt();
        items = new ArrayList<Item>();
        totalRevenueObservers = new ArrayList<>();
    }

    /**
     * @return A DTO containing information about the <code>Sale</code>.
     */
    public SaleDTO getSaleDTO() {
        return saleDTO;
    }

    /**
     * Adds an item to the sale. If the type of item is already registered in the current sale 
     * the quantity is increased.
     * @param itemDTO A DTO containing information about the type of item added to the sale.
     * @param quantity Number of said items added to the sale.
     * @return The running total of the current sale.
     */
    public float addItem(ItemDTO itemDTO, int quantity) {
        Item currItem = new Item(itemDTO, quantity);
        int indexOfCurrItem = items.indexOf(currItem);

        if (quantity <= 0)
            throw new IllegalArgumentException("'" + quantity + "' is not a valid quantity");

        if (indexOfCurrItem != -1)
            items.get(indexOfCurrItem).increaseQuantity(quantity);
        else
            items.add(currItem);

        runningTotal += itemDTO.getPrice() * quantity * (1 + (itemDTO.getRateOfVat() / 100f));
        return runningTotal;
    }

    /**
     * Creates a DTO of the current sale.
     * @return Total price for the bought items.
     */
    public float createSaleDTO() {
        saleDTO = new SaleDTO(items, runningTotal);
        receipt.setSale(saleDTO, saleTime);
        return runningTotal;
    }

    /**
     * Checks the discount database if a discount is applicable.
     * @param customerID The customer's ID.
     * @param discountDBHandler The handler of the discount database.
     * @return A new total price, the same if no discount was applied.
     */
    public float checkForDiscount(int customerID, DiscountDBHandler discountDBHandler) {
        float newTotalPrice = (float) Math.round(discountDBHandler.checkForDiscount(customerID, saleDTO) * 100) / 100;
        saleDTO.updateTotalPrice(newTotalPrice);
        return newTotalPrice;
    }

    /**
     * Sets the amount paid and the change returned on the receipt.
     * @param amount Amount paid by the customer.
     * @param change Amount returned to the customer.
     */
    public void setPayment(float amount, float change) {
        receipt.setPayment(amount, change);
    }

    /**
     * Tells the receipt printer that a receipt should be printed.
     * @param receiptPrinter Information to be printed on the receipt.
     */
    public void printReceipt(ReceiptPrinter receiptPrinter) {
        receiptPrinter.printReceipt(receipt);
        notifyObservers();
    }

    /**
     * Notifies all stored observers.
     */
    private void notifyObservers() {
        for (TotalRevenueObserver obs : totalRevenueObservers)
            obs.UpdateTotalRevenue(saleDTO.getTotalPrice());
    }

    /**
     * Adds an observer to the stored list of observers.
     * @param obs The observer to add.
     */
    public void addTotalRevenueObserver(TotalRevenueObserver obs) {
        totalRevenueObservers.add(obs);
    }
}
