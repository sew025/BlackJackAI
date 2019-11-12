/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/12/19
 * Time: 3:05 PM
 *
 * Project: csci205finalproject
 * Package: Blackjack
 * Class: Dealer
 *
 * Description:
 *
 * ****************************************
 */
package Blackjack;

import java.util.ArrayList;

/**
 * Dealer class, designed to simulate the actions of a dealer for the game blackjack
 */
public class Dealer {
    /**
     * contains the cards within the dealers hand
     */
    private ArrayList<Integer> dealerHand;

    /**
     * holds the current score of the dealers hand
     */
    private int score;

    /**
     * the number specified for the dealer stand at
     */
    private final int STOP_NUM = 17;

    /**
     * constructor to build the dealers starting hand
     * @param dealerHand - the original two cards the dealer begins with
     * @param score - the starting score of the dealer based on the cards passed in
     */
    public Dealer(ArrayList<Integer> dealerHand, int score) {
        this.dealerHand = dealerHand;
        this.score = score;
    }

    public ArrayList<Integer> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(ArrayList<Integer> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Hand: " + getDealerHand() + " With a score: " + getScore();
    }

    /**
     * determines whether the dealer will continue playing (Hit/True) or will be stopping (Stand/False)
     * @return boolean value true or false
     */
    public boolean makeMove(){
        if (getScore()<STOP_NUM){
            return true;
        }
        else{
            return false;
        }
    }
}