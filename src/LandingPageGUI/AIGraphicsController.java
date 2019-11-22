/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Matt McGauley
 * Section: 11am
 * Date: 11/17/19
 * Time: 21:15
 *
 * Project: csci205FinalProject
 * Package: LandingPageGUI
 * Class: UIGraphicsController
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Alert;


public class AIGraphicsController {
    /** The Model */
    private AIGrahpicsView AIView;
    /** The View */
    private AIGraphicsModel AIModel;

    public AIGraphicsController(AIGraphicsModel AIModel, AIGrahpicsView AIView) {
        this.AIModel = AIModel;
        this.AIView = AIView;

        BooleanBinding goButtonBinding = Bindings.createBooleanBinding(() -> AIView.getnTurns().getText().isEmpty(), AIView.getnTurns().textProperty());
        AIView.getGoButton().disableProperty().bind(goButtonBinding);

        AIView.getGoButton().setOnAction(actionEvent -> {
            AIView.getAIRoot().getChildren().remove(AIView.getSuccessChart());
            if (AIView.getOptionsBox().getValue().equals("Random Guess AI")) {
                try {
                    int[] randomArray = AIModel.trackRandomSuccess(Integer.parseInt(AIView.getnTurns().getText()));
                    AIView.getAIRoot().getChildren().add(AIView.generateSuccessChart(randomArray, "Success Rate for the Random Guess AI"));
                } catch (NumberFormatException nFE) {
                    generateErrorMessage();
                }
            } else if (AIView.getOptionsBox().getValue().equals("Smart Guess AI")) {
                try {
                    int[] smartArray = AIModel.trackSmartSuccess(Integer.parseInt(AIView.getnTurns().getText()));
                    AIView.getAIRoot().getChildren().add(AIView.generateSuccessChart(smartArray, "Success Rate for the Smart Guess AI"));
                } catch (NumberFormatException nFE) {
                    generateErrorMessage();
                }
            }
        });
    }

    private void generateErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect input!");
        alert.setHeaderText("Incorrect input specified!");
        alert.setContentText("Invalid option for number of turns. Please enter a valid numerical choice.");
        alert.show();
    }
}