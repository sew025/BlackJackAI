package Blackjack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class to test the functionality of the player class, by testing if the getScore and switchAce methods work
 */
class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        ArrayList<Integer> hand = new ArrayList<>();
        hand.add(11);
        hand.add(4);
        player = new Player(hand,15);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * tests the get score function by checking if the expected score of a hand in black jack is equal to the return or the function
     */
    @Test
    void getScore() {
        player.getPlayerHand().add(3);
        assertEquals(18,player.getScore());
    }

    /**
     * tests the ace switch function by having a temporary hand and the player checking that they are the same
     * then calling the ace switch on the player to show that the players ace became a 1
     */
    @Test
    void aceSwitch() {
        ArrayList<Integer> hand = new ArrayList<>();
        hand.add(11);
        hand.add(4);
        hand.add(7);
        player.getPlayerHand().add(7);
        assertEquals(hand,player.getPlayerHand());
        player.aceSwitch();
        assertNotEquals(hand,player.getPlayerHand());
    }
}