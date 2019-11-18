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
 * Class: Controller
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class LandingPageController {
    /** The Model */
    private LandingPageView theView;
    /** The View */
    private LandingPageModel theModel;

    public LandingPageController(LandingPageModel theModel, LandingPageView theView) {
        this.theView = theView;
        this.theModel = theModel;
    }
}