/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/12/19
 * Time: 11:16 PM
 *
 * Project: csci205finalproject
 * Package: Blackjack
 * Class: Player
 *
 * Description:
 *
 * ****************************************
 */
package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    /**
     * contains the cards within the dealers hand
     */
    private ArrayList<Integer> playerHand;

    /**
     * holds the current score of the dealers hand
     */
    private int score;

    /**
     * constructor to build the players starting hand
     * @param playerHand - the original two cards the player begins with
     * @param score - the starting score of the player based on the cards passed in
     */
    public Player(ArrayList<Integer> playerHand, int score) {
        this.playerHand = playerHand;
        this.score = score;
    }

    public ArrayList<Integer> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(ArrayList<Integer> playerHand) {
        this.playerHand = playerHand;
    }

    /**
     * adds up the values of the cards in the hand
     * @return - the total value of the hand
     */
    public int getScore() {
        int temp = 0;
        for (Integer i: getPlayerHand()) {
            temp += i;
        }
        return temp;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player hand: " + getPlayerHand() + " With a score: " + getScore();
    }

    /**
     * determines whether the player will continue playing (Hit/True) or will be stopping (Stand/False)
     * @return boolean value true or false
     */
    public boolean makeMove(){
        if(getScore()>21){
            return false;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to (H)it or (S)tand?");
        String choice = in.nextLine();
        if(choice.equalsIgnoreCase("H")){
            return true;
        }
        else{
            return false;
        }
    }
}