/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Matt McGauley
 * Section: 11am
 * Date: 11/17/19
 * Time: 21:14
 *
 * Project: csci205FinalProject
 * Package: LandingPageGUI
 * Class: UIGrahpicsView
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.io.File;

public class AIGrahpicsView {
    /**
     * The model
     */
    private AIGraphicsModel theModel;
    /**
     * The root
     */
    private VBox AIRoot;
    /**
     * A title for the AI graphics page
     */
    private Label titleLabel;
    /**
     * A combo box so that the user can choose which AI they would like to use
     */
    private ComboBox optionsBox;
    /**
     * An area for the chart to display the results from the AI
     */
    private FlowPane optionsPane;
    /**
     * A label for the dropdown menu
     */
    private Label optionsLabel;
    /**
     * The line chart that will display the AI's success rate as it plays more and more hands
     */
    private LineChart successChart;
    /**
     * A text field where the user specifies how many turns to simulate
     */
    private TextField nTurns;
    /**
     * A label to tell the user to specify how many turns they'd like to simulate in the game
     */
    private Label nTurnsLabel;
    /**
     * A button to start running the AI and displaying the graph once you have all of the info about what they want to simulate
     */
    private Button goButton;
    /**
     * A button to go back to the main menu
     */
    private Button backButton;



    public AIGrahpicsView(AIGraphicsModel theModel){
        this.theModel = theModel;

        AIRoot = new VBox(10);
        AIRoot.setMinWidth(675);
        AIRoot.setMinHeight(675);
        AIRoot.setAlignment(Pos.TOP_CENTER);
        titleLabel = new Label("Simulate the game of BlackJack using AI!");
        titleLabel.setFont(Font.font("Veranda", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.WHITE);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setHeight(5);
        dropShadow.setRadius(2);
        dropShadow.setColor(Color.DARKBLUE);
        titleLabel.setEffect(dropShadow);

        titleLabel.setTextAlignment(TextAlignment.CENTER);

        final Image backgroundImage = new Image("https://i1.sndcdn.com/artworks-000050413857-dct4es-t500x500.jpg?671e660");
        BackgroundImage jack = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));
        Background background = new Background(jack);
        AIRoot.setBackground(background);

        ObservableList<String> AIOptions =
                FXCollections.observableArrayList(
                        "Random Guess AI",
                        "Smart Guess AI"
                );

        optionsBox = new ComboBox(AIOptions);
        optionsBox.getSelectionModel().select(0);

        optionsPane = new FlowPane(Orientation.HORIZONTAL);
        optionsPane.setHgap(10);
        optionsPane.setAlignment(Pos.TOP_CENTER);

        optionsLabel = new Label("Choose one of the following AI's to simulate the game with");
        optionsLabel.setTextFill(Color.WHITE);
        optionsPane.getChildren().addAll(optionsLabel, optionsBox);

        nTurns = new TextField();
        nTurns.setMaxWidth(60);
        nTurnsLabel = new Label("How many hands would you like to simulate?");
        nTurnsLabel.setTextFill(Color.WHITE);
        nTurnsLabel.setLabelFor(nTurns);

        goButton = new Button("Go!");

        backButton = new Button("Return to Main Menu");
        backButton.setAlignment(Pos.BOTTOM_RIGHT);

        AIRoot.getChildren().addAll(titleLabel, optionsPane, nTurnsLabel, nTurns, goButton, backButton);
    }

    public LineChart generateSuccessChart(double[] successRateArray, String title) {
        NumberAxis xAxis = new NumberAxis(0, successRateArray.length,1 );
        xAxis.setLabel("Turn Number");
        xAxis.tickLabelFillProperty().set(Color.WHITE);
        xAxis.setTickUnit(50);
        NumberAxis yAxis = new NumberAxis(0, 1, 0.01);
        yAxis.setLabel("                    AI Success Rate" + "\n" +
                "(Number of Wins/Total Hands Played)");
        yAxis.tickLabelFillProperty().set(Color.WHITE);


        successChart = new LineChart<>(xAxis, yAxis);
        successChart.setTitle(title);
        XYChart.Series<Integer, Double> dataSeries = new XYChart.Series<>();

        for (int index = 0; index < successRateArray.length; index++) {
            dataSeries.getData().add(new XYChart.Data<>(index, successRateArray[index]));
        }

        successChart.getData().add(dataSeries);
        successChart.setLegendVisible(false);
        return successChart;
    }


    public VBox getAIRoot() {
        return AIRoot;
    }

    public ComboBox getOptionsBox() {
        return optionsBox;
    }

    public LineChart getSuccessChart() {
        return successChart;
    }

    public TextField getnTurns() {
        return nTurns;
    }

    public Button getGoButton() {
        return goButton;
    }

    public Button getBackButton() {
        return backButton;
    }
}