package test.se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.model.dto.ItemDTO;
import se.kth.iv1350.pos.integration.DiscountDBHandler;
import se.kth.iv1350.pos.model.Sale;

public class SaleTest {
    private Sale testSale;

    @BeforeEach
    void init() {
        testSale = new Sale();
    }

    @AfterEach
    void tearDown() {
        testSale = null;
    }

    @Test
    void testAddItem() {
        ItemDTO testItemDTO = new ItemDTO("testItem", "used only for testing", 5, 12);

        try {
            testSale.addItem(testItemDTO, 1);
        }
         catch (Exception e) {
            fail("An exception was thrown when it was not supposed to");
         }
    }

    @Test
    void testAddItemZeroQuantity() {
        ItemDTO testItemDTO = new ItemDTO("testItem", "used only for testing", 5, 12);

        try {
            testSale.addItem(testItemDTO, 0);
            fail("An IllegalArgumentException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    void testAddItemNegativeQuantity() {
        ItemDTO testItemDTO = new ItemDTO("testItem", "used only for testing", 5, 12);

        try {
            testSale.addItem(testItemDTO, -1);
            fail("An IllegalArgumentException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    void testCreateSaleDTO() {
        ItemDTO testItemDTO = new ItemDTO("testItem", "used only for testing", 5, 12);
        float expResult = 5.6f;

        testSale.addItem(testItemDTO, 1);
        
        assertEquals(expResult, testSale.createSaleDTO(), 
                    "The total price did not match the excpected total price");
    }

    @Test
    void testCreateSaleDTONoItems() {
        float expResult = 0;

        assertEquals(expResult, testSale.createSaleDTO(), "The total price was not 0 with 0 items");
    }

    @Test
    void testCheckForDiscount() {
        DiscountDBHandler testDiscountDBHandler = new DiscountDBHandler();
        ItemDTO testItemDTO = new ItemDTO("testItem", "used only for testing", 5, 12);
        float expResult = 5.6f;

        testSale.addItem(testItemDTO, 1);
        testSale.createSaleDTO();

        assertEquals(expResult, testSale.checkForDiscount(0, testDiscountDBHandler), 
                    "The discounted price did not match the expected discounted price");
    }
}
