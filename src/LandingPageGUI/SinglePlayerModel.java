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
import javafx.scene.control.Alert;

/**
 * This is the functional part of the GUI, in the model we will be doing everything that requires the game to run and perform the game of blackjack
 */
public class SinglePlayerModel {

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

    public void generateLossMsg() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("You Busted");
        alert.setHeaderText("Better luck next time");
        alert.setContentText("Click on the deck to play again");
        alert.show();
    }

    public void blackjackMsg() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("You got a natural blackjack");
        alert.setHeaderText("You have won!");
        alert.setContentText("You have 21 on just 2 cards");
        alert.show();
    }
}