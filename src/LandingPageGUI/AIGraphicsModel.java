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


import NeuralNetPlay.NNTrackSuccess;

public class AIGraphicsModel {

    private NNTrackSuccess neuralNetPlayer;

    public AIGraphicsModel() {
    }

    public double[] trackRandomSuccess(int numTurns) {
        double[] successRate = new double[0];
        return successRate;
    }

    public double[] trackSmartSuccess(int numTurns) {
        neuralNetPlayer = new NNTrackSuccess();
        double[] successArray = neuralNetPlayer.getTotal(numTurns);
        return successArray;
    }
}