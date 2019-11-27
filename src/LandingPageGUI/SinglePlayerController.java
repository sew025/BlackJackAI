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

import Blackjack.Cards;
import Blackjack.Dealer;
import Blackjack.Deck;
import Blackjack.Player;

import java.awt.*;
import java.util.ArrayList;

import DeckOfCards.GetCard;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

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
    /**
     * the game deck
     */
    private Deck deck = new Deck();


    public SinglePlayerController(SinglePlayerModel theModel, SinglePlayerView theView) {
        this.theModel = theModel;
        this.theView = theView;

        theView.getDeck().setOnMouseClicked(mouseEvent -> {
            deck = new Deck();
            deck.shuffle();
            theView.getPlayerHand().getChildren().clear();
            theView.getDealerHand().getChildren().clear();
            theView.getPlayerScore().getChildren().clear();
            theView.getDealerScore().getChildren().clear();

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

            //originally only set up the player half
            Label playerScore = new Label("Score: " + Integer.toString(player.getScore()));
            theView.getPlayerScore().getChildren().add(playerScore);

            Rectangle p1 = GetCard.getAppropriateCard(theModel.determineCard(player.getPlayerHand().get(0)));
            Rectangle p2 = GetCard.getAppropriateCard(theModel.determineCard(player.getPlayerHand().get(1)));
            theView.getPlayerHand().getChildren().addAll(p1,p2);

            //set up dealer side with blank cards
            Label dealerScore = new Label("Score: -----");
            theView.getDealerScore().getChildren().add(dealerScore);

            Rectangle blank1 = GetCard.createFaceDownCard();
            Rectangle blank2 = GetCard.createFaceDownCard();
            theView.getDealerHand().getChildren().addAll(blank1,blank2);

            //if player has blackjack they win
            if(player.getScore()==21){
                theModel.blackjackMsg();
            }
        });

        theView.getHitButton().setOnAction(actionEvent -> {
            //all the functional set up
            int tempNum = deck.getDeck().get(0);
            deck.getDeck().remove(0);
            player.getPlayerHand().add(tempNum);

            Rectangle tempRec = GetCard.getAppropriateCard(theModel.determineCard(tempNum));
            theView.getPlayerHand().getChildren().add(tempRec);

            theView.getPlayerScore().getChildren().clear();
            Label playerScore = new Label("Score: " + Integer.toString(player.getScore()));
            theView.getPlayerScore().getChildren().add(playerScore);

            //check and see if the player lost
            if(player.getScore()>21){
                if (player.getPlayerHand().contains(11)){
                    theView.getPlayerHand().getChildren().clear();
                    player.aceSwitch();
                    for (int i = 0; i < player.getPlayerHand().size(); i++) {
                        Rectangle newRec = GetCard.getAppropriateCard(theModel.determineCard(player.getPlayerHand().get(i)));
                        theView.getPlayerHand().getChildren().add(newRec);
                    }
                    theView.getPlayerScore().getChildren().clear();
                    Label updatedScore = new Label("Score: " + Integer.toString(player.getScore()));
                    theView.getPlayerScore().getChildren().add(updatedScore);
                }
                else{
                    theModel.generateLossMsg();
                }
            }
            else if(player.getScore()==21){
                //set up the dealer
                theView.getDealerScore().getChildren().clear();
                theView.getDealerHand().getChildren().clear();

                Label dealerScore = new Label("Score: " + Integer.toString(dealer.getScore()));
                theView.getDealerScore().getChildren().add(dealerScore);

                Rectangle d1 = GetCard.getAppropriateCard(theModel.determineCard(dealer.getDealerHand().get(0)));
                Rectangle d2 = GetCard.getAppropriateCard(theModel.determineCard(dealer.getDealerHand().get(1)));
                theView.getDealerHand().getChildren().addAll(d1,d2);

                if(dealer.getScore()==21){
                    theModel.dealerBlackjack();
                }

                while(dealer.onlyHitOrStand()){
                    int nextNum = deck.getDeck().get(0);
                    deck.getDeck().remove(0);
                    dealer.getDealerHand().add(nextNum);

                    Rectangle tempRect = GetCard.getAppropriateCard(theModel.determineCard(nextNum));
                    theView.getDealerHand().getChildren().add(tempRect);

                    theView.getDealerScore().getChildren().clear();
                    Label dScore = new Label("Score: " + Integer.toString(dealer.getScore()));
                    theView.getDealerScore().getChildren().add(dScore);

                    if(dealer.getScore()>21){
                        if(dealer.getDealerHand().contains(11)){
                            theView.getDealerHand().getChildren().clear();
                            dealer.aceSwitch();
                            for (int i = 0; i < dealer.getDealerHand().size(); i++) {
                                Rectangle newRec = GetCard.getAppropriateCard(theModel.determineCard(dealer.getDealerHand().get(i)));
                                theView.getDealerHand().getChildren().add(newRec);
                            }
                            theView.getDealerScore().getChildren().clear();
                            Label updatedScore = new Label("Score: " + Integer.toString(dealer.getScore()));
                            theView.getDealerScore().getChildren().add(updatedScore);
                        }
                        else{
                            break;
                        }
                    }
                }
                theModel.determineWinner(player,dealer);
            }
        });

        theView.getStandButton().setOnAction(actionEvent -> {
            //set up the dealer
            theView.getDealerScore().getChildren().clear();
            theView.getDealerHand().getChildren().clear();

            Label dealerScore = new Label("Score: " + Integer.toString(dealer.getScore()));
            theView.getDealerScore().getChildren().add(dealerScore);

            Rectangle d1 = GetCard.getAppropriateCard(theModel.determineCard(dealer.getDealerHand().get(0)));
            Rectangle d2 = GetCard.getAppropriateCard(theModel.determineCard(dealer.getDealerHand().get(1)));
            theView.getDealerHand().getChildren().addAll(d1,d2);

            if(dealer.getScore()==21){
                theModel.dealerBlackjack();
            }

            while(dealer.onlyHitOrStand()){
                int tempNum = deck.getDeck().get(0);
                deck.getDeck().remove(0);
                dealer.getDealerHand().add(tempNum);

                Rectangle tempRect = GetCard.getAppropriateCard(theModel.determineCard(tempNum));
                theView.getDealerHand().getChildren().add(tempRect);

                theView.getDealerScore().getChildren().clear();
                Label dScore = new Label("Score: " + Integer.toString(dealer.getScore()));
                theView.getDealerScore().getChildren().add(dScore);

                if(dealer.getScore()>21){
                    if(dealer.getDealerHand().contains(11)){
                        theView.getDealerHand().getChildren().clear();
                        dealer.aceSwitch();
                        for (int i = 0; i < dealer.getDealerHand().size(); i++) {
                            Rectangle newRec = GetCard.getAppropriateCard(theModel.determineCard(dealer.getDealerHand().get(i)));
                            theView.getDealerHand().getChildren().add(newRec);
                        }
                        theView.getDealerScore().getChildren().clear();
                        Label updatedScore = new Label("Score: " + Integer.toString(dealer.getScore()));
                        theView.getDealerScore().getChildren().add(updatedScore);
                    }
                    else{
                        break;
                    }
                }
            }
            theModel.determineWinner(player,dealer);
        });
    }

}