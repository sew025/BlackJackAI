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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * this is the part of the GUI that shows what is going on, we will show how the game progresses and how the game begins
 */
public class SinglePlayerView {
    private SinglePlayerModel theModel;

    //preliminary set up
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

    //cards
    private Rectangle d1 = new Rectangle(30,45,Color.RED);
    private Rectangle d2 = new Rectangle(30,45,Color.RED);
    private Rectangle d3 = new Rectangle(30,45,Color.RED);
    private Rectangle d4 = new Rectangle(30,45,Color.RED);
    private Rectangle d5 = new Rectangle(30,45,Color.RED);
    private Rectangle d6 = new Rectangle(30,45,Color.RED);

    private Rectangle p1 = new Rectangle(30,45,Color.RED);
    private Rectangle p2 = new Rectangle(30,45,Color.RED);
    private Rectangle p3 = new Rectangle(30,45,Color.RED);
    private Rectangle p4 = new Rectangle(30,45,Color.RED);
    private Rectangle p5 = new Rectangle(30,45,Color.RED);
    private Rectangle p6 = new Rectangle(30,45,Color.RED);


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
        dealerGameHalf.setAlignment(Pos.CENTER);

        dealerHand = new HBox();
        dealerHand.setSpacing(2);
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
        deckArea.setAlignment(Pos.CENTER);

        Label instructions = new Label("Click on the deck to deal");

        deck = new Rectangle();
        deck.setHeight(150);
        deck.setWidth(100);
        deck.setFill(Color.RED);
        deck.setStroke(Color.BLACK);

        deckArea.getChildren().addAll(instructions,deck);

        dealerSide.getChildren().addAll(dealerGameHalf,deckArea);

        //making the bottom half
        playerSide = new HBox();
        playerSide.setMinHeight(300);
        playerSide.setMinWidth(400);

        playerGameHalf = new VBox(10);
        playerGameHalf.setMinWidth(400);
        playerGameHalf.setMinHeight(300);
        playerGameHalf.setAlignment(Pos.CENTER);

        playerHand = new HBox();
        playerHand.setSpacing(2);
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
        buttonArea.setAlignment(Pos.CENTER);

        Label move = new Label("Click hit or stand");
        move.setAlignment(Pos.CENTER);

        hitButton  = new Button("Hit");
        hitButton.setMaxHeight(100);
        hitButton.setMaxWidth(100);

        standButton = new Button("Stand");
        standButton.setMaxHeight(100);
        standButton.setMaxWidth(100);

        buttonArea.getChildren().addAll(move,hitButton,standButton);

        playerSide.getChildren().addAll(playerGameHalf,buttonArea);

        //add it all to the scene
        gameRoot.getChildren().add(dealerSide);
        gameRoot.getChildren().add(playerSide);
    }

    public VBox getGameRoot() {
        return gameRoot;
    }

    public HBox getDealerSide() {
        return dealerSide;
    }

    public HBox getPlayerSide() {
        return playerSide;
    }

    public VBox getDealerGameHalf() {
        return dealerGameHalf;
    }

    public VBox getPlayerGameHalf() {
        return playerGameHalf;
    }

    public HBox getDealerHand() {
        return dealerHand;
    }

    public HBox getPlayerHand() {
        return playerHand;
    }

    public HBox getDealerScore() {
        return dealerScore;
    }

    public HBox getPlayerScore() {
        return playerScore;
    }

    public VBox getButtonArea() {
        return buttonArea;
    }

    public Button getHitButton() {
        return hitButton;
    }

    public Button getStandButton() {
        return standButton;
    }

    public VBox getDeckArea() {
        return deckArea;
    }

    public Rectangle getDeck() {
        return deck;
    }

    public Rectangle getD1() {
        return d1;
    }

    public Rectangle getD2() {
        return d2;
    }

    public Rectangle getD3() {
        return d3;
    }

    public Rectangle getD4() {
        return d4;
    }

    public Rectangle getD5() {
        return d5;
    }

    public Rectangle getD6() {
        return d6;
    }

    public Rectangle getP1() {
        return p1;
    }

    public Rectangle getP2() {
        return p2;
    }

    public Rectangle getP3() {
        return p3;
    }

    public Rectangle getP4() {
        return p4;
    }

    public Rectangle getP5() {
        return p5;
    }

    public Rectangle getP6() {
        return p6;
    }
}