package Blackjack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class to test the functionality of the money class, including the remove and add funds functions
 */
class MoneyTest {

    Money money;

    @BeforeEach
    void setUp() {
        money = new Money();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * test the remove funds function by ensuring that the expected value once you take ten dollars out is equal to the actual score
     */
    @Test
    void removeFunds() {
        money.removeFunds(10);
        assertEquals(90,money.getAmount());
    }

    /**
     * test the add funds function by ensuring that the expected value once you put ten dollars in is equal to the actual score
     */
    @Test
    void addFunds() {
        money.addFunds(10);
        assertEquals(110,money.getAmount());
    }
}