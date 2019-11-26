/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/18/19
 * Time: 11:23 AM
 *
 * Project: csci205finalproject
 * Package: LandingPageGUI
 * Class: SinglePlayerController
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

import Blackjack.Dealer;
import Blackjack.Deck;
import Blackjack.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * controlling portion of the GUI, this is the part that reacts to what happens when the player hits controls on the screen
 */
public class SinglePlayerController {
    /**
     * the model
     */
    private SinglePlayerModel theModel;
    /**
     * the view
     */
    private SinglePlayerView theView;
    /**
     * make a player
     */
    private Player player;
    /**
     * make a dealer
     */
    private Dealer dealer;

    public SinglePlayerController(SinglePlayerModel theModel, SinglePlayerView theView) {
        this.theModel = theModel;
        this.theView = theView;

        theView.getDeck().setOnMouseClicked(mouseEvent -> {
            Deck deck = new Deck();
            deck.shuffle();
            //make the first two hands
            ArrayList<Integer> pHand = new ArrayList<>();
            ArrayList<Integer> dHand = new ArrayList<>();

            pHand.add(deck.getDeck().get(0));
            dHand.add(deck.getDeck().get(1));
            pHand.add(deck.getDeck().get(2));
            dHand.add(deck.getDeck().get(3));

            int startPScore = deck.getDeck().get(0) + deck.getDeck().get(2);
            int startDScore = deck.getDeck().get(1) + deck.getDeck().get(3);


            deck.getDeck().remove(0);
            deck.getDeck().remove(1);
            deck.getDeck().remove(2);
            deck.getDeck().remove(3);

            //make the player and dealer passing their hands to them and showing their hand and score
            player = new Player(pHand,startPScore);
            dealer = new Dealer(dHand,startDScore);

            Label dealerFirst = new Label(Integer.toString(dealer.getDealerHand().get(0)));
            Label dealerSecond = new Label(Integer.toString(dealer.getDealerHand().get(1)));
            //theView.getD1()
            theView.getDealerHand().getChildren().addAll(theView.getD1(),theView.getD2());
        });
    }
}