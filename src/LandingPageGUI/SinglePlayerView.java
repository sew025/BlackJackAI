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
 * Class: SinglePlayerView
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * this is the part of the GUI that shows what is going on, we will show how the game progresses and how the game begins
 */
public class SinglePlayerView {
    private SinglePlayerModel theModel;
    private VBox gameRoot;
    private HBox dealerSide;
    private HBox playerSide;
    private VBox dealerGameHalf;
    private VBox playerGameHalf;
    private HBox dealerHand;
    private HBox playerHand;
    private HBox dealerScore;
    private HBox playerScore;
    private VBox buttonArea;
    private Button hitButton;
    private Button standButton;
    private VBox deckArea;
    private Rectangle deck;

    public SinglePlayerView(SinglePlayerModel theModel) {
        this.theModel = theModel;

        //making the game scene
        gameRoot = new VBox(10);
        gameRoot.setMinHeight(600);
        gameRoot.setMinWidth(600);
        gameRoot.setAlignment(Pos.CENTER);

        //making the top half
        dealerSide = new HBox();
        dealerSide.setMinHeight(300);
        dealerSide.setMinWidth(600);

        dealerGameHalf = new VBox(10);
        dealerGameHalf.setMinWidth(400);
        dealerGameHalf.setMinHeight(300);

        dealerHand = new HBox(10);
        dealerHand.setSpacing(5);
        dealerHand.setMinWidth(200);
        dealerHand.setMinHeight(150);

        dealerScore = new HBox(10);
        dealerScore.setMinHeight(50);
        dealerScore.setMinWidth(100);

        dealerGameHalf.getChildren().addAll(dealerHand,dealerScore);

        //making the deck area
        deckArea = new VBox(10);
        deckArea.setMinWidth(200);
        deckArea.setMinHeight(300);

        deck = new Rectangle();
        deck.setHeight(150);
        deck.setWidth(100);
        deck.setFill(Color.RED);

        deckArea.getChildren().add(deck);

        dealerSide.getChildren().addAll(dealerGameHalf,deckArea);

        //making the bottom half
        playerSide = new HBox();
        playerSide.setMinHeight(300);
        playerSide.setMinWidth(400);

        playerGameHalf = new VBox(10);
        playerGameHalf.setMinWidth(400);
        playerGameHalf.setMinHeight(300);

        playerHand = new HBox(10);
        playerHand.setSpacing(5);
        playerHand.setMinWidth(200);
        playerHand.setMinHeight(150);

        playerScore = new HBox(10);
        playerScore.setMinHeight(50);
        playerScore.setMinWidth(100);

        playerGameHalf.getChildren().addAll(playerHand,playerScore);

        //making the button area
        buttonArea = new VBox(10);
        buttonArea.setMinHeight(300);
        buttonArea.setMinWidth(200);

        hitButton  = new Button("Hit");
        hitButton.setMaxHeight(100);
        hitButton.setMaxWidth(100);

        standButton = new Button("Stand");
        standButton.setMaxHeight(100);
        standButton.setMaxWidth(100);

        buttonArea.getChildren().addAll(hitButton,standButton);

        playerSide.getChildren().addAll(playerGameHalf,buttonArea);

        //add it all to the scene
        gameRoot.getChildren().add(dealerSide);
        gameRoot.getChildren().add(playerSide);
    }
}