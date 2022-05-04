package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Receipt;

/**
 * This class handles calls to a receipt printer for printing of receipts.
 */
public class ReceiptPrinter {
    /**
     * Print a receipt.
     * @param receipt The <code>Receipt</code> containing information about what to be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt); // Placeholder for integration with physical printer.
    }
}
