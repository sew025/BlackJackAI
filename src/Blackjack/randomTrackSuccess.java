package Blackjack;

/**
 * track the success of the random player
 */
public class randomTrackSuccess {

    /**
     * array holding the current success rate (# of wins/# of games played)
     */
    private static double[] successes;

    /**
     * the number of games won
     */
    private static double success;

    /**
     * the total number of games played
     */
    private static double count;

    /**
     * runs the random game a certain number of times and then adds new success rate to the success array based on
     * if they have won or lost
     * @param numHands - the number times to play the game
     * @return - the array holding the total game count with wins and losses
     */
    public static double[] trackSuccess(int numHands) {
        successes = new double[numHands];
        count = 0;
        success = 0;
        for(int i = 0; i < numHands;i++){
            RandomPlayGame rando = new RandomPlayGame();
            rando.blackjack();
            if (rando.isWon()) {
                success+=1;
                count+=1;
                double rate = (success/count) * 100;
                successes[i] = rate;
            }
            else{
                count+=1;
                double rate = (success/count) * 100;
                successes[i] = rate;
            }
        }
        return successes;
    }
}
