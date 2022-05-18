package test.se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.controller.Controller;

public class ControllerTest {
    private Controller testContr;

    @BeforeEach
    public void init() {
        testContr = new Controller();
        testContr.startSale();
    }

    @AfterEach
    public void tearDown() {
        testContr = null;
    }

    @Test
    public void testEnterItem() {
        int itemIdentifier = 0;
        int itemQuantity = 1;
        
        try {
            testContr.enterItem(itemIdentifier, itemQuantity);
        }
        catch (Exception e) {
            fail("An exception was thrown when it was not supposed to");
        }
    }

    @Test
    public void testEnterItemZeroQuantity() {
        int itemIdentifier = 0;
        int itemQuantity = 0;

        try {
            testContr.enterItem(itemIdentifier, itemQuantity);
            fail("An IllegalArgumentException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    public void testEnterItemNegativeQuantity() {
        int itemIdentifier = 0;
        int itemQuantity = -1;

        try {
            testContr.enterItem(itemIdentifier, itemQuantity);
            fail("An IllegalArgumentException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    public void testEnterItemInvalidIdentifier() {
        int itemIdentifier = -1;
        int itemQuantity = 1;

        try {
            testContr.enterItem(itemIdentifier, itemQuantity);
            fail("An InvalidItemIdentifierException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    public void testEnterItemHardcodedDBFailure() {
        int itemIdentifier = 5;
        int itemQuantity = 1;

        try {
            testContr.enterItem(itemIdentifier, itemQuantity);
            fail("A DatabaseFailureException should have been thrown");
        } catch (Exception e) {}
    }
    
    @Test
    public void testEndSale() throws Exception {
        float expResult = 8.75f;

        testContr.enterItem(0, 1);
        testContr.enterItem(2, 2);

        assertEquals(testContr.endSale(), expResult,
                    "The total price did not match the excpected total price");
    }

    @Test
    public void testEndSaleNoItems() throws Exception {
        float expResult = 0;

        assertEquals(testContr.endSale(), expResult, "The total price was not 0 with 0 items");
    }

    @Test
    public void testDiscountRequest() throws Exception {
        float expResult = 1.25f;

        testContr.enterItem(0, 1);
        testContr.endSale();

        assertEquals(testContr.discountRequest(0), expResult, 
                   "The new price did not match the expected new price");
    }

    @Test
    public void testEnterCashPayment() throws Exception {
        testContr.enterItem(0, 1);
        testContr.endSale();

        try {
            testContr.enterCashPayment(2);
        }
        catch (Exception e) {
            fail("An exception was thrown when it was not supposed to");
        }
    }

    @Test
    public void testEnterCashPaymentInsufficientAmount() throws Exception {
        testContr.enterItem(0, 1);
        testContr.endSale();

        try {
            testContr.enterCashPayment(1);
            fail("An InsufficientPaymentException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    public void testEnterCashPaymentNegativeAmount() throws Exception {
        testContr.enterItem(0, 1);
        testContr.endSale();

        try {
            testContr.enterCashPayment(-1);
            fail("An InsufficientPaymentException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    public void testEnterCashPaymentNoItemsBought() throws Exception {
        testContr.endSale();

        try {
            testContr.enterCashPayment(1);
        }
        catch (Exception e) {
            fail("An exception was thrown when it was not supposed to");
        }
    }
}
