package test.se.kth.iv1350.pos.model.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.model.dto.ItemDTO;

public class ItemDTOTest {
    private ItemDTO testItemDTO;

    @BeforeEach
    void init() {
        testItemDTO = new ItemDTO("testItem", "this item is used for testing only", 1, 25);
    }

    @AfterEach
    void tearDown() {
        testItemDTO = null;
    }

    @Test
    void testEquals() {
        ItemDTO other = new ItemDTO("testItem", "this item is used for testing only", 1, 25);
        boolean expResult = true;
        boolean result = testItemDTO.equals(other);
        assertEquals(expResult, result, "The itemDTOs containing the same information are not equal");
    }

    @Test
    void testNotEqual() {
        ItemDTO other = new ItemDTO("testItem", "this item is used for testing only", 5, 25);
        boolean expResult = false;
        boolean result = testItemDTO.equals(other);
        assertEquals(expResult, result, "The itemDTOs containing different information are equal");
    }

    @Test
    void testEqualsNull() {
        Object other = null;
        boolean expResult = false;
        boolean result = testItemDTO.equals(other);
        assertEquals(expResult, result, "The itemDTO is equal to a null object");
    }

    @Test
    void testEqualsJavaLangObject() {
        Object other = new Object();
        boolean expResult = false;
        boolean result = testItemDTO.equals(other);
        assertEquals(expResult, result, "The itemDTO is equal to a java.lang.Object");
    }
}
