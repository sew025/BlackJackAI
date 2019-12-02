package Blackjack;

import java.util.ArrayList;

/**
 * makes a random type of user than makes all of its decisions on whether to hit or stand based on a random number generator
 */
public class randomPlayer {
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
    public randomPlayer(ArrayList<Integer> playerHand, int score) {
        //System.out.println("I'm Random!");
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
     * randomly determines whether the player will continue playing (Hit/True) or will be stopping (Stand/False)
     * @return boolean value true or false
     */
    public boolean makeMove(){
        double choice = Math.random();
        if(getScore()>21&&getPlayerHand().contains(11)){
            aceSwitch();
        }
        else if(getScore()>21){
            return false;
        }
        else if(getScore()==21){
            return false;
        }
        if(choice < 0.5){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * switch the ace from a score of 11 to 1
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
}
