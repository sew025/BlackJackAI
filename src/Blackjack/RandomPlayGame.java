/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: Sami Wurm
 *
 *
 * Final Project
 *
 * @author Sami Wurm
 *
 *
 * *****************************************
 */

package Blackjack;

import java.util.ArrayList;

/**
 * class that plays our blackjack function for the user but makes ever decision randomly between hit or stand
 */
public class RandomPlayGame {

    /**
     * boolean value that is used for when the random wins or loses
     */
    private static boolean won;

    /**
     * the running program to create a single consul version game of randomized blackjack
     */
    public static void main(String[] args) {
            blackjack();
        }

    /**
     * function to play the blackjack game with random decisions
     */
    public static void blackjack(){

            //initialize deck
            Deck deck = getDeck();

            //make the first two hands
            ArrayList<Integer> pHand = new ArrayList<>();
            ArrayList<Integer> dHand = new ArrayList<>();

            //add cards to hands
            addCards(deck, pHand, dHand);

            //initialize starting scores
            int startPScore = deck.getDeck().get(0) + deck.getDeck().get(2);;
            int startDScore = deck.getDeck().get(1) + deck.getDeck().get(3);

            //remove cards from deck that have already been dealt
            removeCards(deck);

            //make the player and dealer passing their hands to them and showing their hand and score
            randomPlayer randomPlayer = new randomPlayer(pHand,startPScore);
            Dealer dealer = new Dealer(dHand,startDScore);

            //run one turn
            runTurn(deck, randomPlayer);

            //check who won
            checkWin(deck, randomPlayer, dealer);
    }

    /**
     * initialize deck of cards
     * @return deck of cards
     */
    private static Deck getDeck() {
        //make and shuffle the deck
        won = false;
        Deck deck = new Deck();
        deck.shuffle();
        return deck;
    }

    /**
     * Run one turn of black jack
     * @param deck
     * @param randomPlayer
     */
    private static void runTurn(Deck deck, randomPlayer randomPlayer) {
        //run a turn
        while(randomPlayer.makeMove()){
            randomPlayer.getPlayerHand().add(deck.getDeck().get(0));
            deck.getDeck().remove(0);
        }
    }

    /**
     * Check who won the hand (if anyone won yet)- the player or the dealer
     * @param deck
     * @param randomPlayer
     * @param dealer
     */
    private static void checkWin(Deck deck, randomPlayer randomPlayer, Dealer dealer) {
        if (randomPlayer.getScore()>21){
            won = false;
        }
        else{
            while(dealer.makeMove()){
                dealer.getDealerHand().add(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }

            if(dealer.getScore()>21){
                won = true;
            }
            else{
                if(randomPlayer.getScore()>dealer.getScore()){
                    won = true;
                }
                else if(dealer.getScore()>randomPlayer.getScore()){
                    won = false;
                }
                else{
                    won = false;
                }
            }
        }
    }

    /**
     * Removes cards that have been used from deck
     * @param deck
     */
    private static void removeCards(Deck deck) {
        deck.getDeck().remove(0);
        deck.getDeck().remove(1);
        deck.getDeck().remove(2);
        deck.getDeck().remove(3);
    }

    /**
     * Adds cards to player hand and dealer hand
     *
     * @param deck
     * @param pHand
     * @param dHand
     */
    private static void addCards(Deck deck, ArrayList<Integer> pHand, ArrayList<Integer> dHand) {
        pHand.add(deck.getDeck().get(0));
        dHand.add(deck.getDeck().get(1));
        pHand.add(deck.getDeck().get(2));
        dHand.add(deck.getDeck().get(3));
    }

    /**
     * returns the value of won boolean
     * @return - true or false
     */
    public static boolean isWon() {
        return won;
    }

}

