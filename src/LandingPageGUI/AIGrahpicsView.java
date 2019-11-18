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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

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


    public AIGrahpicsView(AIGraphicsModel theModel){
        this.theModel = theModel;

        AIRoot = new VBox(10);
        AIRoot.setMinWidth(1000);
        AIRoot.setMinHeight(1000);
        AIRoot.setAlignment(Pos.TOP_CENTER);
        titleLabel = new Label("Simulate the game of BlackJack using AI!");
        titleLabel.setFont(Font.font("Veranda", FontWeight.BOLD, 30));
        titleLabel.setTextAlignment(TextAlignment.CENTER);

        ObservableList<String> AIOptions =
                FXCollections.observableArrayList(
                        "Random Guess AI",
                        "Other AI"
                );

        optionsBox = new ComboBox(AIOptions);
        optionsBox.getSelectionModel().select(0);

        optionsPane = new FlowPane(Orientation.HORIZONTAL);
        optionsPane.setHgap(10);
        optionsPane.setAlignment(Pos.TOP_CENTER);

        optionsLabel = new Label("Choose one of the following AI's to simulate the game with");
        optionsPane.getChildren().addAll(optionsLabel, optionsBox);

        nTurns = new TextField();
        nTurns.setMaxWidth(60);
        nTurnsLabel = new Label("How many hands would you like to simulate?");
        nTurnsLabel.setLabelFor(nTurns);

        goButton = new Button("Go!");

        AIRoot.getChildren().addAll(titleLabel, optionsPane, nTurnsLabel, nTurns, goButton);
    }

    public LineChart generateSuccessChart(int[] successRateArray, String title) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Turn Number");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("AI Success Rate (Number of Wins/Total Hands Played)");

        successChart = new LineChart<>(xAxis, yAxis);
        successChart.setTitle(title);
        XYChart.Series<Integer, Integer> dataSeries = new XYChart.Series<>();

        for (int index = 0; index < successRateArray.length; index++) {
            dataSeries.getData().add(new XYChart.Data<>(index, successRateArray[index]));
        }

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
}