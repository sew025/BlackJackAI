package Blackjack;

import javax.swing.*;

/**
 * create an enumeration that holds all of the cards titles and the value of each individual card
 */
public enum Cards {
    ACE(11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);

    private int value;

    /**
     * Create a singular card with the given value
     * @param value - the value of the given card
     */
    Cards(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Using a setter for the enum because the value of the ace may change depending on the score of the hand
     * @param value - the value of the card
     */
    public void setValue(int value) {
        this.value = value;
    }
}
