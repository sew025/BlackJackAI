/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/12/19
 * Time: 3:25 PM
 *
 * Project: csci205finalproject
 * Package: Blackjack
 * Class: Deck
 *
 * Description:
 *
 * ****************************************
 */
package Blackjack;

import java.util.ArrayList;

/**
 * Creates a deck of cards in numerical order, that can later be shuffled for use in blackjack
 */
public class Deck {
    /**
     * The list holding all of the cards within the deck
     */
    public ArrayList<Integer> deck;

    /**
     * Build the deck, initially made with a deck that is in numerical order, in order to begin playing with a fair game
     * must call the shuffle function
     */
    public Deck() {
        this.deck = makeDeck();
    }

    /**
     * creates a deck of cards containing the values (1,2,3...) of the cards
     * @return a list of the cards in numerical order
     */
    public static ArrayList<Integer> makeDeck(){
        ArrayList<Integer> tempDeck = new ArrayList<>();
        for (Cards card : Cards.values()){
            int i = 0;
            while(i<4){
                tempDeck.add(card.getValue());
                i++;
            }
        }
        return tempDeck;
    }

    /**
     * shuffles the deck of cards so that they are now in random order and can be dealt and played with by the users of the game
     */
    public void shuffle(){
        int totalCards = 52;
        ArrayList<Integer> shuffled = new ArrayList<>();
        while(totalCards>0){
            int randNum = (int) (Math.random() * totalCards);
            shuffled.add(getDeck().get(randNum));
            getDeck().remove(randNum);
            totalCards--;
        }
        setDeck(shuffled);
    }

    public ArrayList<Integer> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Integer> deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return "Current deck is: "+ getDeck();
    }
}