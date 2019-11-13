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

    @Test
    void makeDeck() {
        ArrayList<Integer> temp = Deck.makeDeck();
        assertEquals(deck.getDeck(),temp);
    }

    @Test
    void shuffle() {
        ArrayList<Integer> temp = Deck.makeDeck();
        deck.shuffle();
        assertNotEquals(deck.getDeck(),temp);
    }
}