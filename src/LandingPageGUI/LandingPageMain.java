package LandingPageGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LandingPageMain extends Application {
    /** The Model */
    private LandingPageModel theModel;
    /** The View */
    private LandingPageView theView;
    /** The Controller */
    private LandingPageController theController;


    /**
     * Opens the main page of the GUI where the user will choose whether they
     * want to play the single player game or they want to use an AI and generate
     * some results about its performance
     *
     * @author Matt McGauley
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Calls the Model and the View to be set up here
     * @throws Exception
     */
    public void init() throws Exception {
        super.init();
        theModel = new LandingPageModel();
        theView = new LandingPageView(theModel);
    }


    /**
     * Setting the scene for the opening page of the GUI. Once the AI's/Game GUI
     * have been finished, the other scene's for their actions will be
     * added here and this will change to the appropriate scene when their
     * buttons are clicked. For now it just shows the opening page
     *
     * @author Matt McGauley
     * @param primaryStage  The Stage for the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        theController = new LandingPageController(theModel, theView);

        Scene openingScene = new Scene(theView.getTheRoot());

        primaryStage.setTitle("Welcome to BlackJack!");
        primaryStage.setScene(openingScene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
