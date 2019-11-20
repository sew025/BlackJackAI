/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Matt McGauley
 * Section: 11am
 * Date: 11/17/19
 * Time: 13:27
 *
 * Project: csci205FinalProject
 * Package: LandingPageGUI
 * Class: View
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


/**
* Creates the landing page. It will have a ~~cool~~ background image and it will have
 * some buttons for the user to choose whether they want to play against a computer or
 * have the AI play for them
 */
public class LandingPageView {
    /**
     * The Model
     */
    private LandingPageModel theModel;
    /**
     * The root
     */
    private VBox mainRoot;
    /**
     * A label for the root
     */
    private Label titleLabel;
    /**
     * A pane to ask the user what they want to do
     */
    private FlowPane thePane;
    /**
     * A label to add to the pane displaying what options the user has
     */
    private Label paneLabel;
    /**
     * A button to play the single player game
     */
    private Button playSinglePlayerGame;
    /**
     * A button to use the AI
     */
    private Button playWithAI;

    /**
     * Create the view for our Landing Page
     * @param theModel  The model for our MVC
     */
    public LandingPageView(LandingPageModel theModel) {
        this.theModel = theModel;

        mainRoot = new VBox(10);
        mainRoot.setMinHeight(400);
        mainRoot.setMinWidth(600);
        mainRoot.setAlignment(Pos.TOP_CENTER);

        Image backgroundImage = new Image("https://www.stationcasinosoffers.com/wp-content/uploads/2018/08/blackjack-table-nub-thumb.jpg");
        BackgroundImage blackjackBackground = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));
        Background background = new Background(blackjackBackground);
        mainRoot.setBackground(background);

        titleLabel = new Label("Welcome to BlackJack!");
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setTextAlignment(TextAlignment.CENTER);

        thePane = new FlowPane(Orientation.HORIZONTAL);
        thePane.setHgap(10);
        paneLabel = new Label("Choose one of the following options to play the game:");
        thePane.getChildren().addAll(paneLabel);

        playSinglePlayerGame = new Button("Play BlackJack against a computer");
        playWithAI = new Button("Simulate the game using Artificial Intelligence");

        mainRoot.getChildren().addAll(titleLabel, playSinglePlayerGame, playWithAI);
    }

    public VBox getMainRoot() {
        return mainRoot;
    }

    public Button getPlaySinglePlayerGame() {
        return playSinglePlayerGame;
    }

    public Button getPlayWithAI() {
        return playWithAI;
    }
}