package Blackjack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    Money money;

    @BeforeEach
    void setUp() {
        money = new Money();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void removeFunds() {
        money.removeFunds(10);
        assertEquals(90,money.getAmount());
    }

    @Test
    void addFunds() {
        money.addFunds(10);
        assertEquals(110,money.getAmount());
    }
}