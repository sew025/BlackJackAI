/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/18/19
 * Time: 11:22 AM
 *
 * Project: csci205finalproject
 * Package: LandingPageGUI
 * Class: SinglePlayerModel
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

import Blackjack.Cards;
import Blackjack.Dealer;
import Blackjack.Money;
import Blackjack.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * This is the functional part of the GUI, in the model we will be doing everything that requires the game to run and perform the game of blackjack
 */
public class SinglePlayerModel {
    /**
     * determines what card enumeration to use given the integer value of the card
     * @param num - the number value of the card
     * @return - a card enumeration
     * @author Jack Otto
     */
    public Blackjack.Cards determineCard(int num){
        Cards ans = null;
        switch (num){
            case 2:
                ans = Cards.TWO;
                break;
            case 3:
                ans = Cards.THREE;
                break;
            case 4:
                ans = Cards.FOUR;
                break;
            case 5:
                ans = Cards.FIVE;
                break;
            case 6:
                ans = Cards.SIX;
                break;
            case 7:
                ans = Cards.SEVEN;
                break;
            case 8:
                ans = Cards.EIGHT;
                break;
            case 9:
                ans = Cards.NINE;
                break;
            case 10:
                int rand = (int) (Math.random() * 4)+1;
                switch (rand){
                    case 1:
                        ans = Cards.TEN;
                        break;
                    case 2:
                        ans = Cards.JACK;
                        break;
                    case 3:
                        ans = Cards.QUEEN;
                        break;
                    case 4:
                        ans = Cards.KING;
                        break;
                }
                break;
            case 11:
                ans = Cards.ACE;
                break;
            case 1:
                ans = Cards.ACE;
                break;
        }
        return ans;
    }

    public boolean goodData(Optional<String> input, double total){
        double money = Double.parseDouble(input.get());
        if(money>total){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * determine who has won the game
     * @param player - the player object with a hand and a score
     * @param dealer - the dealer object with a hand and a score
     * @author Jack Otto
     */
    public void determineWinner(Player player, Dealer dealer, double amount, Money total){
        if(player.getScore()>21){
            generateLossMsg();
        }
        else if(dealer.getScore()>21){
            dealerBust();
            total.addFunds(amount*2);
        }
        else if(player.getScore()>dealer.getScore()){
            playerHigher();
            total.addFunds(amount*2);
        }
        else if(player.getScore()<dealer.getScore()){
            dealerHigher();
        }
        else{
            pushMsg();
            total.addFunds(amount);
        }
    }

    /**
     * Function meaning the player busted
     * @author Jack Otto
     */
    public void generateLossMsg() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("You Busted");
        alert.setHeaderText("Better luck next time");
        alert.setContentText("Click on the deck to play again");
        alert.show();
    }
    /**
     * Function meaning the player has a natural
     * @author Jack Otto
     */
    public void blackjackMsg() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("You got a natural blackjack");
        alert.setHeaderText("You have won!");
        alert.setContentText("You have 21 on just 2 cards");
        alert.show();
    }
    /**
     * Function meaning the dealer busted
     * @author Jack Otto
     */
    public void dealerBust() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dealer Busted");
        alert.setHeaderText("You have won!");
        alert.setContentText("The dealer has gone over 21");
        alert.show();
    }
    /**
     * Function meaning the dealer has a natural
     * @author Jack Otto
     */
    public void dealerBlackjack() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dealer has a natural blackjack");
        alert.setHeaderText("You have lost");
        alert.setContentText("The dealer has 21 on just 2 cards");
        alert.show();
    }
    /**
     * Function meaning the player has a higher score
     * @author Jack Otto
     */
    public void playerHigher() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Game winning message");
        alert.setHeaderText("You have won!");
        alert.setContentText("You scored higher than the dealer");
        alert.show();
    }
    /**
     * Function meaning the dealer has a higher score
     * @author Jack Otto
     */
    public void dealerHigher() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Game losing message");
        alert.setHeaderText("You have lost");
        alert.setContentText("The dealer scored higher than you");
        alert.show();
    }
    /**
     * Function meaning the player and dealer have the same score
     * @author Jack Otto
     */
    public void pushMsg() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Game ending message");
        alert.setHeaderText("It's a tie");
        alert.setContentText("You and the dealer have the same score");
        alert.show();
    }
}