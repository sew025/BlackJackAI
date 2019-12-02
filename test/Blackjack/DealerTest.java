package Blackjack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class to test the functionality of the dealer class, by testing if the getScore, makeMove, and switchAce methods work
 */
class DealerTest {

    Dealer dealer;

    @BeforeEach
    void setUp() {
        ArrayList<Integer> hand = new ArrayList<>();
        hand.add(11);
        hand.add(4);
        dealer = new Dealer(hand,15);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * testing the get score, making sure the expected value is equal to the output of the function
     */
    @Test
    void getScore() {
        dealer.getDealerHand().add(3);
        assertEquals(18,dealer.getScore());
    }

    /**
     * testing the make move function for the dealer, ensuring that it stands when it hits the magic number
     */
    @Test
    void makeMove() {
        assertEquals(true, dealer.makeMove());
        dealer.getDealerHand().add(3);
        assertEquals(false,dealer.makeMove());
    }

    /**
     * testing the ace switch function that makes sure when the dealer goes over 21 but has an ace the score drops 10 points
     */
    @Test
    void aceSwitch() {
        ArrayList<Integer> hand = new ArrayList<>();
        hand.add(11);
        hand.add(4);
        hand.add(10);
        dealer.getDealerHand().add(10);
        assertEquals(hand,dealer.getDealerHand());
        dealer.makeMove();
        assertNotEquals(hand,dealer.getDealerHand());
    }
}