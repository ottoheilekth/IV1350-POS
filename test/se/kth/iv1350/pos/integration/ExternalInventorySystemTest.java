package test.se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.integration.DatabaseFailureException;
import se.kth.iv1350.pos.integration.ExternalInventorySystem;
import se.kth.iv1350.pos.integration.InvalidItemIdentifierException;

public class ExternalInventorySystemTest {
    private ExternalInventorySystem testExtInvSys;

    @BeforeEach
    void init() {
        testExtInvSys = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        testExtInvSys = null;
    }

    @Test
    void testGetItemDTO() throws Exception {
        try {
            testExtInvSys.getItemDTO(0);
        }
        catch (Exception e) {
            fail("An exception was thrown when it was not supposed to");
        }
    }

    @Test
    void testGetItemDTOTooLargeIdentifier() {
        try {
            testExtInvSys.getItemDTO(6);
            fail("An InvalidItemIdentifierException should have been thrown");
        }
        catch (InvalidItemIdentifierException e) {
            assertTrue(e.getMessage().contains("invalid"), "Wrong exception message, does not contain 'invalid'");
        }
        catch (DatabaseFailureException e) {
            fail("The wrong exception was thrown");
        }
    }

    @Test
    void testGetItemDTONegativeIdentifier() {
        try {
            testExtInvSys.getItemDTO(6);
            fail("An InvalidItemIdentifierException should have been thrown");
        }
        catch (InvalidItemIdentifierException e) {
            assertTrue(e.getMessage().contains("invalid"), "Wrong exception message, does not contain 'invalid'");
        }
        catch (DatabaseFailureException e) {
            fail("The wrong exception was thrown");
        }
    }

    @Test
    void testGetItemDTOIdentifier5() throws DatabaseFailureException {
        try {
            testExtInvSys.getItemDTO(5);
            fail("A DatabaseFailureException should have been thrown");
        }
        catch (DatabaseFailureException e) {
            assertTrue(e.getMessage().contains("server"), "Wrong exception message, does not contain 'server'");
        } 
        catch(InvalidItemIdentifierException e) {
            fail("The wrong exception was thrown");
        }
    }
}
