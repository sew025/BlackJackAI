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

/**
 * the player class, allows the user to determine what to do in the game
 */
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
        if(getScore()>21&&getPlayerHand().contains(11)){
            aceSwitch();
        }
        else if(getScore()>21){
            return false;
        }
        else if(getScore()==21){
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

    /**
     * method used to switch the value of the ace from a value of 11 to 1 if the player has busted because of the ace
     */
    public void aceSwitch(){
        for (int i = 0; i < getPlayerHand().size(); i++) {
            if(getPlayerHand().get(i)==11){
                getPlayerHand().remove(i);
                getPlayerHand().add(1);
                setPlayerHand(getPlayerHand());
                //System.out.println(toString());
                break;
            }
        }
    }

    /**
     * gets the number of aces within the players hand
     * @return number of aces
     * @author Bea Casey
     */
    public int getNumAces() {
        int total = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i) == 11) {
                total += 1;
            }
        }
        return total;
    }
}