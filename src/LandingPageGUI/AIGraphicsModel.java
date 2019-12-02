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
 * Class: UIGraphicsModel
 *
 * Description:
 *
 * ****************************************
 */
package LandingPageGUI;


import Blackjack.randomTrackSuccess;
import NeuralNetPlay.NNBlackjack;

/**
 * the model for the ai page
 */
public class AIGraphicsModel {

    /**
     * makes a neural net
     */
    private NNBlackjack neuralNetPlayer;

    public AIGraphicsModel() {
    }

    /**
     * tracks the success of the random ai
     * @param numTurns - the number of games the random player should simulate
     * @return - an array containing the current success rate after each game simulated
     */
    public double[] trackRandomSuccess(int numTurns) {
        double[] successRate = randomTrackSuccess.trackSuccess(numTurns);
        return successRate;
    }

    /**
     * tracks the success of the smart ai
     * @param numTurns - the number of turns the net should simulate
     * @return - an array containing the current success rate after each game played
     */
    public double[] trackSmartSuccess(int numTurns) {
        neuralNetPlayer = new NNBlackjack(numTurns);
        double[] successArray = neuralNetPlayer.runGame(numTurns);
        return successArray;
    }
}