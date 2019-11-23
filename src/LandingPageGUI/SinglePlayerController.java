/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 11/18/19
 * Time: 11:23 AM
 *
 * Project: csci205finalproject
 * Package: LandingPageGUI
 * Class: SinglePlayerController
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;

/**
 * controlling portion of the GUI, this is the part that reacts to what happens when the player hits controls on the screen
 */
public class SinglePlayerController {
    /**
     * the model
     */
    private SinglePlayerModel theModel;
    /**
     * the view
     */
    private SinglePlayerView theView;

    public SinglePlayerController(SinglePlayerModel theModel, SinglePlayerView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }
}