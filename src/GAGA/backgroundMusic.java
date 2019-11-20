package GAGA;

import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;

public class backgroundMusic extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        String path = "~/FinalProject/csci205finalproject/src/GAGA/PokerFace.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }
}
