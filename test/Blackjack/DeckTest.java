package Blackjack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class to test the functionality of the decks methods, including making a deck along with shuffling a deck
 */
class DeckTest {

    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * testing that a deck was made in the right numerical order
     */
    @Test
    void makeDeck() {
        ArrayList<Integer> temp = Deck.makeDeck();
        assertEquals(deck.getDeck(),temp);
    }

    /**
     * testing that once you shuffle the deck, it is not in the same order as the original numerical order deck
     */
    @Test
    void shuffle() {
        ArrayList<Integer> temp = Deck.makeDeck();
        deck.shuffle();
        assertNotEquals(deck.getDeck(),temp);
    }
}