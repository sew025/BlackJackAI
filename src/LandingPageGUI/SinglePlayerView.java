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
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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
    private Label moneyAmount = new Label("Total: $100.00");
    private Button backButton;

    /**
     * set up the original scene of the game without any cards and such, just the deck and the buttons
     * @param theModel - the model of the game
     * @author Jack Otto
     */
    public SinglePlayerView(SinglePlayerModel theModel) {
        this.theModel = theModel;

        //making the game scene
        gameRoot = new VBox(10);
        gameRoot.setMinHeight(600);
        gameRoot.setMinWidth(600);
        gameRoot.setAlignment(Pos.CENTER);

        final Image backgroundImage = new Image("https://cdn10.bigcommerce.com/s-3h3c4/products/1846/images/3146/pool-table-felt-simonis-860-green-7ft__29747.1488904154.500.659.jpg?c=2");
        BackgroundImage jack = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));
        Background background = new Background(jack);
        gameRoot.setBackground(background);

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
        dealerHand.setMinWidth(400);
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
        instructions.setTextFill(Color.WHITE);

        deck = new Rectangle();
        deck.setHeight(150);
        deck.setWidth(100);
        deck.setFill(Color.RED);
        deck.setStroke(Color.BLACK);

        moneyAmount.setTextFill(Color.WHITE);

        deckArea.getChildren().addAll(instructions,deck,moneyAmount);

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
        playerHand.setMinWidth(400);
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

        backButton = new Button("Return to Main Menu");

        Label move = new Label("Click hit or stand");
        move.setAlignment(Pos.CENTER);
        move.setTextFill(Color.WHITE);

        hitButton  = new Button("Hit");
        hitButton.setMaxHeight(100);
        hitButton.setMaxWidth(100);

        standButton = new Button("Stand");
        standButton.setMaxHeight(100);
        standButton.setMaxWidth(100);

        buttonArea.getChildren().addAll(move,hitButton,standButton,backButton);

        playerSide.getChildren().addAll(playerGameHalf,buttonArea);

        //add it all to the scene
        gameRoot.getChildren().add(dealerSide);
        gameRoot.getChildren().add(playerSide);
    }

    public VBox getGameRoot() {
        return gameRoot;
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

    public Button getHitButton() {
        return hitButton;
    }

    public Button getStandButton() {
        return standButton;
    }

    public Rectangle getDeck() {
        return deck;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Label getMoneyAmount() {
        return moneyAmount;
    }
}