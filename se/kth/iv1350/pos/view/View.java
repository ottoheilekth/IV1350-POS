package se.kth.iv1350.pos.view;

import static java.lang.System.out;
import se.kth.iv1350.pos.controller.Controller;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Perform a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() {
        out.println("A new sale has been started.");
        contr.startSale();
        out.println();

        try {
            out.println("1 item0 has been entered to the system.");
            contr.enterItem(0, 1);
            out.println();
            out.println("2 item1 has been entered to the system.");
            contr.enterItem(1, 2);
        }
        catch(Exception e) {
            out.println(e.getMessage() + ".");
        }
        out.println();

        out.println("The sale has ended.");
        out.println("Total price: " + contr.endSale() + " SEK");
        out.println();

        out.println("The customer has issued a discount request.");
        out.println("New total price: " + contr.discountRequest(20020304) + " SEK");
        out.println();

        try {
            out.println("The customer has payed 100 SEK.");
            out.println("Change: " + contr.enterCashPayment(100) + " SEK");
        }
        catch (Exception e) {
            out.println(e.getMessage() + ".");
        }
        out.println();

        contr.printReceipt();
    }
}
