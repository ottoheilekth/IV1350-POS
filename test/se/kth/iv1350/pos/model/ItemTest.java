package test.se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.model.dto.ItemDTO;
import se.kth.iv1350.pos.model.Item;

public class ItemTest {
    private ItemDTO testItemDTO;
    private Item testItem;

    @BeforeEach
    void init () {
        testItemDTO = new ItemDTO("testItem", "this item is only for testing", 
        1, 25);
        testItem = new Item(testItemDTO, 1);
    }

    @AfterEach
    void tearDown() {
        testItemDTO = null;
        testItem = null;
    }

    @Test
    void testEquals() {
        Item other = new Item(testItemDTO, 5);
        boolean expResult = true;
        boolean result = testItem.equals(other);
        assertEquals(expResult, result, "The items containing the same ItemDTO are not equal");
    }

    @Test
    void testNotEqual() {
        Item other = new Item(new ItemDTO("other", "used for testing only", 2, 12), 1);
        boolean expResult = false;
        boolean result = testItem.equals(other);
        assertEquals(expResult, result, "The items containing different ItemDTOs are equal");
    }

    @Test
    void testEqualsNull() {
        Object other = null;
        boolean expResult = false;
        boolean result = testItem.equals(other);
        assertEquals(expResult, result, "The item is equal to a null object");
    }

    @Test
    void testEqualsJavaLangObject() {
        Object other = new Object();
        boolean expResult = false;
        boolean result = testItem.equals(other);
        assertEquals(expResult, result, "The item is equal to a java.lang.Object");
    }

    @Test
    void testUpdateQuantity() {
        try {
            testItem.increaseQuantity(1);
        }
        catch (Exception e) {
            fail("An exception was thrown when it was not supposed to");
        }
    }

    @Test
    void testUpdateZeroQuantity() {
        try {
            testItem.increaseQuantity(0);
            fail("An IllegalArgumentException should have been thrown");
        } catch (Exception e) {}
    }

    @Test
    void testUpdateNegativeQuantity() {
        try {
            testItem.increaseQuantity(-1);
            fail("An IllegalArgumentException should have been thrown");
        } catch (Exception e) {}
    }
}
