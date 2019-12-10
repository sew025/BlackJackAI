package LandingPageGUI;

//Today my son asked me, “Can I have a bookmark?”

//I burst into tears; he’s 11 years old and he still doesn’t know that my name is Brian!!

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;


/**
 * the class to run the actual game, including all three scene roots
 */
public class LandingPageMain extends Application {
    /**
     * The Model for the landing page
     */
    private LandingPageModel theModel;
    /**
     * The View for the landing page
     */
    private LandingPageView theView;
    /**
     * The Controller for the landing page
     */
    private LandingPageController theController;
    /**
     * The Model for the AI Graphics portion
     */
    private AIGraphicsModel AIModel;
    /**
     * The View for the AI Graphics portion
     */
    private AIGrahpicsView AIView;
    /**
     * The Controller for the AI Graphics potion
     */
    private AIGraphicsController AIController;
    /**
     * the model for the single player portion
     */
    private SinglePlayerModel singleModel;
    /**
     * the view for the single player portion
     */
    private SinglePlayerView singleView;
    /**
     * the controller for the single player portion
     */
    private SinglePlayerController singleController;


    /**
     * Opens the main page of the GUI where the user will choose whether they
     * want to play the single player game or they want to use an AI and generate
     * some results about its performance
     *
     * @param args
     * @author Matt McGauley
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Calls the Model and the View to be set up here
     *
     * @throws Exception
     */
    public void init() throws Exception {
        super.init();
        theModel = new LandingPageModel();
        theView = new LandingPageView(theModel);
        AIModel = new AIGraphicsModel();
        AIView = new AIGrahpicsView(AIModel);
        singleModel = new SinglePlayerModel();
        singleView = new SinglePlayerView(singleModel);
    }


    /**
     * Setting the scene for the opening page of the GUI. Once the AI's/Game GUI
     * have been finished, the other scene's for their actions will be
     * added here and this will change to the appropriate scene when their
     * buttons are clicked. For now it just shows the opening page
     *
     * @param primaryStage The Stage for the GUI
     * @author Matt McGauley
     */
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        theController = new LandingPageController(theModel, theView);
        AIController = new AIGraphicsController(AIModel, AIView);
        singleController = new SinglePlayerController(singleModel,singleView);

//        File musicFile = new File("/src/LandingPageGUI/PokerFace.mp3");
//        final Media media = new Media(musicFile.toURI().toURL().toExternalForm());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();

        Scene openingScene = new Scene(theView.getMainRoot());
        Scene AIResultsScene = new Scene(AIView.getAIRoot());
        AIResultsScene.getStylesheets().add(getClass().getResource("AIChartStyle.css").toExternalForm());
        Scene gameScene = new Scene(singleView.getGameRoot());

        theView.getPlayWithAI().setOnAction(actionEvent -> {
            primaryStage.setScene(AIResultsScene);
        });
        AIView.getBackButton().setOnAction(actionEvent -> {
            primaryStage.setScene(openingScene);
        });
        theView.getPlaySinglePlayerGame().setOnAction(actionEvent -> {
            primaryStage.setScene(gameScene);
        });
        singleView.getBackButton().setOnAction(actionEvent -> {
            primaryStage.setScene(openingScene);
        });

        primaryStage.setTitle("Welcome to BlackJack!");
        primaryStage.setScene(openingScene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}
